package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingDetails;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOBorrowingList;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOCreateBorrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.service.BorrowingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/borrowing")
@Tag(name = "Emprestimo", description = "Controller para o gerenciamento dos emprestimos do sistema PegStock")
public class BorrowingController {

    @Autowired
    private BorrowingService service;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Listar todos os emprestimos", description = "Retorna uma lista de DTOs dos emprestimos cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de emprestimos retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Nenhum emprestimo cadastrado.")
    })
    public ResponseEntity<List<DTOBorrowingList>> listBorrowings(){
        List<Borrowing> borrowings = service.findAll();

        List<DTOBorrowingList> dtoBorrowings = borrowings.stream().map(DTOBorrowingList::new).toList();
        return borrowings.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(dtoBorrowings);
    }

    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Buscar emprestimo por ID", description = "Retorna os detalhes de um emprestimo específico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Emprestimo encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Emprestimo não encontrado.")
    })
    public ResponseEntity<DTOBorrowingList> getBorrowingById(@PathVariable Long id){
        Borrowing borrowing = service.findById(id);
        return borrowing == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(new DTOBorrowingList(borrowing));
    }

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Deletar emprestimo por ID", description = "Remove um emprestimo do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Emprestimo deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Emprestimo não encontrado.")
    })
    public ResponseEntity<?> deleteBorrow(@PathVariable Long id){
        boolean deleted = service.delete(id);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/expired")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Listar emprestimos expirados", description = "Retorna uma lista de emprestimos que estão expirados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de emprestimos expirados retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Nenhum emprestimo expirado encontrado.")
    })
    public  ResponseEntity<List<DTOBorrowingList>> getExpiredBorrowings(){
        var expiredBorrowings = service.getExpiredBorrowings(LocalDate.now());
        return expiredBorrowings.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(expiredBorrowings);
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Criar novo emprestimo", description = "Cria um novo emprestimo e retorna o emprestimo criado com o status 201.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Emprestimo criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados enviados.")
    })
    public ResponseEntity<Borrowing> createBorrowing(@RequestBody DTOCreateBorrowing borrowing,
                                                     UriComponentsBuilder uriBuilder) {

        Borrowing borrowingCreated = service.create(borrowing.materialCod(), borrowing.toBorrowing());
        var uri = uriBuilder.path("/borrowing/{id}").buildAndExpand(borrowingCreated.getCod()).toUri();
        return ResponseEntity.created(uri).body(borrowingCreated);
    }

    @PutMapping("/devolution/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Devolver emprestimo", description = "Marca um emprestimo como devolvido e atualiza a quantidade do material.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Emprestimo devolvido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Emprestimo não encontrado ou já devolvido.")
    })
    public ResponseEntity<Borrowing> devolution(@PathVariable Long id){
        Borrowing borrowing = service.devolution(id);
        return borrowing == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(borrowing);
    }

    @PutMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Atualizar emprestimo", description = "Atualiza a data de expiração de um emprestimo existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Emprestimo atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Emprestimo não encontrado.")
    })
    public ResponseEntity<Borrowing> updateBorrowing(@RequestBody DTOBorrowingDetails expirationDate, @PathVariable Long id){
        Borrowing borrowing = new Borrowing(expirationDate);
        Borrowing borrowing1 = service.update(id, borrowing);
        return borrowing1 == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(borrowing1);
    }
}
