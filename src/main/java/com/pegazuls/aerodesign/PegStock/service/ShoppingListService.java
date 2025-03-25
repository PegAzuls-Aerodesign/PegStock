package com.pegazuls.aerodesign.PegStock.service;

import com.pegazuls.aerodesign.PegStock.infra.validation.shopping_list.ValidationCreateSL;
import com.pegazuls.aerodesign.PegStock.model.dto.shopping_list.DTOShoppingDetails;
import com.pegazuls.aerodesign.PegStock.model.dto.shopping_list.DTOShoppingSummary;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import com.pegazuls.aerodesign.PegStock.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repository;

    @Autowired
    private List<ValidationCreateSL> validations;

    @Transactional
    public ShoppingList create(ShoppingList shoppingList) {
        validations.forEach(v -> v.validate(shoppingList));
        shoppingList.setTotalValue(shoppingList.getPrice() * shoppingList.getQuantity());
        shoppingList.setDate(LocalDate.now());
        return repository.save(shoppingList);
    }

    public List<ShoppingList> findAll() {

        return repository.findAll();
    }

    public List<DTOShoppingDetails> findByName(String productName){
        List<ShoppingList> products = repository.findByProductName(productName);
        return products.stream().map(DTOShoppingDetails::new).toList();
    }

    public ShoppingList findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public boolean delete(Long id){
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Transactional
    public ShoppingList update(Long id, ShoppingList shoppingList){
        validations.forEach(v -> v.validate(shoppingList));
        ShoppingList product = repository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        product.setProductName(shoppingList.getProductName());
        product.setQuantity(shoppingList.getQuantity());
        product.setPrice(shoppingList.getPrice());
        product.setSupplier(shoppingList.getSupplier());
        product.setLink(shoppingList.getLink());
        product.setDescription(shoppingList.getDescription());
        product.setTotalValue(shoppingList.getPrice() * shoppingList.getQuantity());
        return product;
    }

    public DTOShoppingSummary findMostExpensive(){
        ShoppingList product = repository.findFirstByOrderByPriceDesc();
        return new DTOShoppingSummary(product);
    }

    public void generateShoppingListCSV(){
        List<ShoppingList> products = repository.findAll();
        String fileName = "shoppingList.csv";
        String fileHeader = "Produto; Quantidade; Preco; Fornecedor; Link; Descricao; Valor total\n";
        StringBuilder fileContent = new StringBuilder(fileHeader);
        for (ShoppingList product : products) {
            fileContent.append(product.getProductName()).append(";")
                    .append(product.getQuantity()).append(";")
                    .append(product.getPrice()).append(";")
                    .append(product.getSupplier()).append(";")
                    .append(product.getLink()).append(";")
                    .append(product.getDescription()).append(";")
                    .append(product.getTotalValue()).append("\n");
        }
        try {
            Files.writeString(Paths.get(fileName), fileContent.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
