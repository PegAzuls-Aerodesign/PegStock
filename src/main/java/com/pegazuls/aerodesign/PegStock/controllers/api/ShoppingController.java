package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.shopping_list.DTOShoppingDetails;
import com.pegazuls.aerodesign.PegStock.model.dto.shopping_list.DTOShoppingSummary;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import com.pegazuls.aerodesign.PegStock.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingListService shoppingService;

    @GetMapping
    public ResponseEntity<List<DTOShoppingDetails>> findAll(){
        List<ShoppingList> shoppingLists = shoppingService.findAll();
        if (shoppingLists.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<DTOShoppingDetails> dtoShoppingDetails = shoppingLists.stream().map(DTOShoppingDetails::new).toList();
        return ResponseEntity.ok(dtoShoppingDetails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> findById(@PathVariable Long id){
        ShoppingList shoppingList = shoppingService.findById(id);
        return shoppingList == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(shoppingList);
    }

    @GetMapping("/name/{productName}")
    public ResponseEntity<List<DTOShoppingDetails>> findByName(@PathVariable String productName){
        List<DTOShoppingDetails> shoppingList = shoppingService.findByName(productName);
        return shoppingList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(shoppingList);
    }

    @PostMapping
    public ResponseEntity<ShoppingList> create(@RequestBody ShoppingList shoppingList, UriComponentsBuilder uriBuilder){
        ShoppingList shoppingListCreated = shoppingService.create(shoppingList);
        URI uri = uriBuilder.path("/shopping/{id}").buildAndExpand(shoppingListCreated.getCod()).toUri();
        return ResponseEntity.created(uri).body(shoppingListCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingList> update(@RequestBody ShoppingList shoppingList, @PathVariable Long id){
        ShoppingList updated = shoppingService.update(id, shoppingList);
        return updated != null ? ResponseEntity.ok(shoppingList) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        boolean deleted = shoppingService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/most_expensive")
    public ResponseEntity<DTOShoppingSummary> getMostExpensive(){
        DTOShoppingSummary shoppingList = shoppingService.findMostExpensive();
        return shoppingList == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(shoppingList);
    }
}
