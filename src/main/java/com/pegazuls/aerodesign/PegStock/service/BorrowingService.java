package com.pegazuls.aerodesign.PegStock.service;

import com.pegazuls.aerodesign.PegStock.infra.validation.borrowing.ValidationBorrowing;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingList;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.repository.BorrowingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private List<ValidationBorrowing> validation;


    @Transactional
    public Borrowing create(Long materialCod, Borrowing borrowing){
        validation.forEach(v -> v.validate(borrowing));
        Material material = materialService.findById(materialCod);
        borrowing.setMaterial(material);
        material.getBorrowing().add(borrowing);
        material.setQuantity(material.getQuantity() - borrowing.getQuantity());
        return borrowingRepository.save(borrowing);
    }

    public Borrowing devolution(Long cod) {
        Borrowing borrowing = borrowingRepository.findById(cod).orElseThrow();
        Material material = borrowing.getMaterial();
        material.setQuantity(material.getQuantity() + borrowing.getQuantity());
        borrowing.setReturned(true);
        materialService.update(material, material.getCod());
        return borrowingRepository.save(borrowing);
    }


    public Borrowing findById(Long cod){
        return borrowingRepository.findById(cod).orElse(null);
    }

    public List<Borrowing> findAll(){
        return borrowingRepository.findAll();
    }

    @Transactional
    public boolean delete(Long cod) {
        Borrowing borrowing = borrowingRepository.findById(cod).orElse(null);

        if(borrowing == null){
            return false;
        }

        Material material = borrowing.getMaterial();

        if (material != null) {
            material.getBorrowing().remove(borrowing); // Remove da lista do Material
        }

        borrowingRepository.delete(borrowing);
        return true;
    }

    @Transactional
    public void update(Long cod, Borrowing borrowing){
        validation.forEach(v -> v.validate(borrowing));
        Borrowing borrowing1 = borrowingRepository.findById(cod).orElseThrow();
        borrowing1.setExpirationDate(borrowing.getExpirationDate());
    }

    public List<DTOBorrowingList> getExpiredBorrowings(LocalDate date){
        List<Borrowing> expiredBorrowings = borrowingRepository.findByExpirationDateBeforeAndReturnedFalse(date);
        return expiredBorrowings.stream().map(DTOBorrowingList::new).toList();
    }
}
