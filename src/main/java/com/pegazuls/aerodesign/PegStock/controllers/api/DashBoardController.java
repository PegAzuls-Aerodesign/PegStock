package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary;
import com.pegazuls.aerodesign.PegStock.service.DashBoardService;
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

    @GetMapping("/monthly-stock-summary")
    public ResponseEntity<List<DTOMonthlySummary>> getMonthlySummary(){
        List<DTOMonthlySummary> monthlySummary = dashBoardService.getMonthlyStockSummary();
        if (monthlySummary.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(monthlySummary);
    }
}
