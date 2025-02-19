package com.pegazuls.aerodesign.PegStock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegazuls.aerodesign.PegStock.model.entities.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
