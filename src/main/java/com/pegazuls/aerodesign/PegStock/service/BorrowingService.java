package com.pegazuls.aerodesign.PegStock.service;

import com.pegazuls.aerodesign.PegStock.model.dto.DTOBorrowingDetails;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.repository.BorrowingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private MaterialService materialService;


    @Transactional
    public Borrowing create(Long materialCod, Borrowing borrowing){
        Material material = materialService.findById(materialCod);
        borrowing.setMaterial(material);
        material.getBorrowing().add(borrowing);
        return borrowingRepository.save(borrowing);
    }

    public Borrowing findById(Long cod){
        return borrowingRepository.findById(cod).orElseThrow();
    }

    public List<Borrowing> findAll(){
        return borrowingRepository.findAll();
    }

    @Transactional
    public void delete(Long cod) {
        Borrowing borrowing = borrowingRepository.findById(cod).orElseThrow();
        Material material = borrowing.getMaterial();

        if (material != null) {
            material.getBorrowing().remove(borrowing); // Remove da lista do Material
        }

        borrowingRepository.delete(borrowing);
    }

    @Transactional
    public void update(Long cod, Borrowing borrowing){
        Borrowing borrowing1 = borrowingRepository.findById(cod).orElseThrow();
        borrowing1.setExpirationDate(borrowing.getExpirationDate());
    }
}
