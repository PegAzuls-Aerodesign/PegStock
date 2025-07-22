package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary;
import com.pegazuls.aerodesign.PegStock.service.DashBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    @Tag(name = "Dashboard", description = "Controller para coletar dados do gráfico")
    @Operation(summary = "Obter resumo mensal de estoque",
               description = "Retorna um resumo mensal dos movimentos de estoque, incluindo consumo e adição.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Resumo mensal de estoque retornado com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum resumo mensal de estoque encontrado.")
    })
    public ResponseEntity<List<DTOMonthlySummary>> getMonthlySummary(){
        List<DTOMonthlySummary> monthlySummary = dashBoardService.getMonthlyStockSummary();
        if (monthlySummary.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(monthlySummary);
    }
}
