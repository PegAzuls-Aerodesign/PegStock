package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingDetails;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingList;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOCreateBorrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService service;

    @GetMapping
    public ResponseEntity<List<DTOBorrowingList>> listBorrowings(){
        List<Borrowing> borrowings = service.findAll();

        List<DTOBorrowingList> dtoBorrowings = borrowings.stream().map(DTOBorrowingList::new).toList();
        return borrowings.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(dtoBorrowings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOBorrowingList> getBorrowingById(@PathVariable Long id){
        Borrowing borrowing = service.findById(id);
        return borrowing == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(new DTOBorrowingList(borrowing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBorrow(@PathVariable Long id){
        boolean deleted = service.delete(id);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/expired")
    public  ResponseEntity<List<DTOBorrowingList>> getExpiredBorrowings(){
        var expiredBorrowings = service.getExpiredBorrowings(LocalDate.now());
        return expiredBorrowings.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(expiredBorrowings);
    }

    @PostMapping
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody DTOCreateBorrowing borrowing,
                                                     UriComponentsBuilder uriBuilder) {

        Borrowing borrowingCreated = service.create(borrowing.materialCod(), borrowing.toBorrowing());
        var uri = uriBuilder.path("/borrowing/{id}").buildAndExpand(borrowingCreated.getCod()).toUri();
        return ResponseEntity.created(uri).body(borrowingCreated);
    }

    @PutMapping("/devolution/{id}")
    public ResponseEntity<Borrowing> devolution(@PathVariable Long id){
        Borrowing borrowing = service.devolution(id);
        return borrowing == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(borrowing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> updateBorrowing(@RequestBody DTOBorrowingDetails expirationDate, @PathVariable Long id){
        Borrowing borrowing = new Borrowing(expirationDate);
        Borrowing borrowing1 = service.update(id, borrowing);
        return borrowing1 == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(borrowing1);
    }
}
