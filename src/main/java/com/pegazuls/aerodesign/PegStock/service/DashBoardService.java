package com.pegazuls.aerodesign.PegStock.service;

import com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary;
import com.pegazuls.aerodesign.PegStock.repository.StockMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashBoardService {

    @Autowired
    private StockMovementRepository stockMovementRepository;

    public List<DTOMonthlySummary> getMonthlyStockSummary() {
        return stockMovementRepository.getMonthlySummary();
    }
}
