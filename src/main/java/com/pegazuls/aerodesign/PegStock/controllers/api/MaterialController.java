package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.material.DTOMaterial;
import com.pegazuls.aerodesign.PegStock.model.dto.material.DTOMaterialMostConsumer;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<DTOMaterial>> getMaterials() {
        List<Material> materials = materialService.findAll();
        List<DTOMaterial> dtoMaterials = materials.stream().map(DTOMaterial::new).toList();
        return dtoMaterials.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtoMaterials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialByCod(@PathVariable Long id) {
        Material material = materialService.findById(id);
        return material == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(material);
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material, UriComponentsBuilder uriBuilder) {
        Material materialCreated = materialService.create(material);
        URI uri = uriBuilder.path("/material/{id}").buildAndExpand(materialCreated.getCod()).toUri();

        return ResponseEntity.created(uri).body(materialCreated);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@RequestBody Material material, @PathVariable Long id) {
        Material material1 = materialService.update(material, id);
        return ResponseEntity.ok(material1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterial(@PathVariable Long id) {
        boolean deletd = materialService.delete(id);
        return deletd ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/most_consumed")
    public ResponseEntity<DTOMaterialMostConsumer> getMostConsumed() {
        DTOMaterialMostConsumer material = materialService.getMostConsumer();
        return material == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(material);
    }
}
