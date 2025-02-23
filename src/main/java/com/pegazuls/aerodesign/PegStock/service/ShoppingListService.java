package com.pegazuls.aerodesign.PegStock.service;

import com.pegazuls.aerodesign.PegStock.infra.validation.ValidationCreateSL;
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
import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repository;

    @Autowired
    private List<ValidationCreateSL> validations;

    @Transactional
    public void create(ShoppingList shoppingList) {
        validations.forEach(v -> v.validate(shoppingList));
        repository.save(shoppingList);
    }

    public List<DTOShoppingDetails> findAll() {
        List<ShoppingList> products = repository.findAll();

        return products.stream()
                .map(DTOShoppingDetails::new)
                .toList();
    }

    public DTOShoppingDetails findByName(String productName){
        ShoppingList product = repository.findByProductName(productName);
        return new DTOShoppingDetails(product);
    }

    public DTOShoppingDetails findById(Long id){
        ShoppingList product = repository.findById(id).orElseThrow();
        return new DTOShoppingDetails(product);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public void update(Long id, ShoppingList shoppingList){
        validations.forEach(v -> v.validate(shoppingList));
        ShoppingList product = repository.findById(id).orElseThrow();
        product.setProductName(shoppingList.getProductName());
        product.setQuantity(shoppingList.getQuantity());
        product.setPrice(shoppingList.getPrice());
        product.setSupplier(shoppingList.getSupplier());
        product.setLink(shoppingList.getLink());
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
