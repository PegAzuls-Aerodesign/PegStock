package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService service;

    @GetMapping
    public ResponseEntity<List<Borrowing>> listBorrowings(){
        List<Borrowing> borrowings = service.findAll();
        return borrowings.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(borrowings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable Long id){
        Borrowing borrowing = service.findById(id);
        return borrowing == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(borrowing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBorrow(@PathVariable Long id){
        boolean deleted = service.delete(id);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }


}
