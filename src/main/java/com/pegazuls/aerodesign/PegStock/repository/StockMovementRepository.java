package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary;
import com.pegazuls.aerodesign.PegStock.model.entities.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

        @Query("SELECT new com.pegazuls.aerodesign.PegStock.model.dto.monthly_summary.DTOMonthlySummary(" +
                "YEAR(sm.movementDate), MONTH(sm.movementDate), " +
                "SUM(CASE WHEN sm.type = 'CONSUMPTION' THEN sm.quantity ELSE 0 END), " +
                "SUM(CASE WHEN sm.type = 'ADDITION' THEN sm.quantity ELSE 0 END)) " +
                "FROM StockMovement sm " +
                "GROUP BY YEAR(sm.movementDate), MONTH(sm.movementDate) " +
                "ORDER BY YEAR(sm.movementDate) DESC, MONTH(sm.movementDate) DESC")


    List<DTOMonthlySummary> getMonthlySummary();
}
