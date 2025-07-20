package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary;
import com.pegazuls.aerodesign.PegStock.model.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    @Query("SELECT new com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary(" +
            "  FUNCTION('YEAR', sm.movementDate), " +
            "  FUNCTION('MONTH', sm.movementDate), " +
            "  SUM(CASE WHEN sm.type = 'CONSUMPTION' THEN sm.quantity ELSE 0 END), " +
            "  SUM(CASE WHEN sm.type = 'ADDITION' THEN sm.quantity ELSE 0 END)" +
            ") " +
            "FROM StockMovement sm " + // Use o nome da sua classe de entidade aqui
            "GROUP BY FUNCTION('YEAR', sm.movementDate), FUNCTION('MONTH', sm.movementDate) " +
            "ORDER BY FUNCTION('YEAR', sm.movementDate), FUNCTION('MONTH', sm.movementDate)")
    List<DTOMonthlySummary> getMonthlySummary();
}
