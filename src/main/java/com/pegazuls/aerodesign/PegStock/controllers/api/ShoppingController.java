package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.shopping_list.DTOShoppingDetails;
import com.pegazuls.aerodesign.PegStock.model.dto.shopping_list.DTOShoppingSummary;
import com.pegazuls.aerodesign.PegStock.model.entities.ShoppingList;
import com.pegazuls.aerodesign.PegStock.service.ShoppingListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/shopping")
@Tag(name = "Lista de compras", description = "Controller para gerenciar os itens da lista de compras")
public class ShoppingController {

    @Autowired
    private ShoppingListService shoppingService;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Listar todas os itens da lista de compras", description = "Retorna uma lista das listas de compras.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de compras retornada com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhuma lista de compras encontrada.")
    })
    public ResponseEntity<List<DTOShoppingDetails>> findAll(){
        List<ShoppingList> shoppingLists = shoppingService.findAll();
        if (shoppingLists.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<DTOShoppingDetails> dtoShoppingDetails = shoppingLists.stream().map(DTOShoppingDetails::new).toList();
        return ResponseEntity.ok(dtoShoppingDetails);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Buscar item da lista de compras por ID", description = "Retorna os detalhes de um item específico da lista de compras.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Item da lista de compras encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Item da lista de compras não encontrado.")
    })
    public ResponseEntity<ShoppingList> findById(@PathVariable Long id){
        ShoppingList shoppingList = shoppingService.findById(id);
        return shoppingList == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(shoppingList);
    }

    @GetMapping("/name/{productName}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Buscar itens da lista de compras por nome do produto", description = "Retorna uma lista de itens da lista de compras que correspondem ao nome do produto.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Itens da lista de compras encontrados com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum item da lista de compras encontrado com o nome fornecido.")
    })
    public ResponseEntity<List<DTOShoppingDetails>> findByName(@PathVariable String productName){
        List<DTOShoppingDetails> shoppingList = shoppingService.findByName(productName);
        return shoppingList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(shoppingList);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Criar novo item na lista de compras", description = "Cria um novo item na lista de compras e retorna o item criado com o status 201.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Item da lista de compras criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Erro ao criar o item da lista de compras.")
    })
    public ResponseEntity<ShoppingList> create(@RequestBody DTOShoppingDetails dtoShoppingList, UriComponentsBuilder uriBuilder){
        ShoppingList shoppingList = new ShoppingList(dtoShoppingList);
        ShoppingList shoppingListCreated = shoppingService.create(shoppingList);
        URI uri = uriBuilder.path("/shopping/{id}").buildAndExpand(shoppingListCreated.getCod()).toUri();
        return ResponseEntity.created(uri).body(shoppingListCreated);
    }

    @PutMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Atualizar item da lista de compras", description = "Atualiza um item existente na lista de compras e retorna o item atualizado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Item da lista de compras atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Item da lista de compras não encontrado.")
    })
    public ResponseEntity<ShoppingList> update(@RequestBody DTOShoppingDetails dtoShoppingList, @PathVariable Long id){
        ShoppingList shoppingList = new ShoppingList(dtoShoppingList);
        ShoppingList updated = shoppingService.update(id, shoppingList);
        return updated != null ? ResponseEntity.ok(shoppingList) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Deletar item da lista de compras", description = "Deleta um item existente na lista de compras.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Item da lista de compras deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Item da lista de compras não encontrado.")
    })
    public ResponseEntity<?> delete(@PathVariable Long id){
        boolean deleted = shoppingService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/most_expensive")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Buscar item mais caro da lista de compras", description = "Retorna o item mais caro da lista de compras.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Item mais caro da lista de compras encontrado com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum item encontrado na lista de compras.")
    })
    public ResponseEntity<DTOShoppingDetails> getMostExpensive(){
        DTOShoppingDetails shoppingList = shoppingService.findMostExpensive();
        return shoppingList == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(shoppingList);
    }
}
