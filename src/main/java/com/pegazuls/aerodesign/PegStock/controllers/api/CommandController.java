package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.commands.AddCommand;
import com.pegazuls.aerodesign.PegStock.commands.BorrowCommand;
import com.pegazuls.aerodesign.PegStock.commands.ConsumeCommand;
import com.pegazuls.aerodesign.PegStock.commands.CommandInvoker;
import com.pegazuls.aerodesign.PegStock.model.dto.borrowing.DTOCreateBorrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Borrowing;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/command")
@Tag(name = "Comandos", description = "Controller para execução de comandos de material (adicionar, consumir, emprestar)")
public class CommandController {

    @Autowired private AddCommand addCommand;
    @Autowired private ConsumeCommand consumeCommand;
    @Autowired private BorrowCommand borrowCommand;
    @Autowired private MaterialService materialService;
    @Autowired private CommandInvoker commandInvoker;

    @PostMapping("/add")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Adicionar quantidade ao material", description = "Adiciona uma quantidade ao estoque do material.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Quantidade adicionada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Material não encontrado.")
    })
    public ResponseEntity<?> addMaterial(@RequestParam Long materialCod, @RequestParam int quantity) {
        Material material = materialService.findById(materialCod);
        if (material == null) return ResponseEntity.notFound().build();

        addCommand.setParameters(material, quantity);
        commandInvoker.execute(addCommand);

        return ResponseEntity.ok("Quantidade adicionada com sucesso.");
    }

    @PostMapping("/consume")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Consumir material", description = "Consome uma quantidade do material em estoque.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Material consumido com sucesso."),
            @ApiResponse(responseCode = "404", description = "Material não encontrado.")
    })
    public ResponseEntity<?> consumeMaterial(@RequestParam Long materialCod, @RequestParam int quantity) {
        Material material = materialService.findById(materialCod);
        if (material == null) return ResponseEntity.notFound().build();

        consumeCommand.setParameters(material, quantity);
        commandInvoker.execute(consumeCommand);

        return ResponseEntity.ok("Material consumido com sucesso.");
    }

    @PostMapping("/borrow")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Emprestar material", description = "Registra um empréstimo do material.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Material emprestado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Material não encontrado."),
            @ApiResponse(responseCode = "400", description = "Erro ao registrar empréstimo.")
    })
    public ResponseEntity<?> borrowMaterial(@RequestBody DTOCreateBorrowing dto) {
        Material material = materialService.findById(dto.materialCod());
        if (material == null) return ResponseEntity.notFound().build();

        Borrowing borrowing = dto.toBorrowing();
        borrowCommand.setParameters(material, borrowing);
        commandInvoker.execute(borrowCommand);

        return ResponseEntity.ok("Material emprestado com sucesso.");
    }
}
