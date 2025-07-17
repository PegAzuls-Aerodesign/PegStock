package com.pegazuls.aerodesign.PegStock.repository;

import com.pegazuls.aerodesign.PegStock.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
