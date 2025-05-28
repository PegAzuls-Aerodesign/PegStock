package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.material.DTOMaterial;
import com.pegazuls.aerodesign.PegStock.model.dto.material.DTOMaterialExpirationDate;
import com.pegazuls.aerodesign.PegStock.model.dto.material.DTOMaterialMostConsumer;
import com.pegazuls.aerodesign.PegStock.model.entities.Material;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/material")
@Tag(name = "Material", description = "Controller para gerenciamento de materiais")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping
    @Operation(summary = "Listar todos os materiais", description = "Retorna uma lista de DTOs dos materiais cadastrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de materiais retornada com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum material encontrado.")
    })
    public ResponseEntity<List<DTOMaterial>> getMaterials() {
        List<Material> materials = materialService.findAll();
        List<DTOMaterial> dtoMaterials = materials.stream().map(DTOMaterial::new).toList();
        return dtoMaterials.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(dtoMaterials);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar material por ID", description = "Retorna uma descrição destalhada de um material específico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Material encontrado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Material não encontrado.")
    })
    public ResponseEntity<Material> getMaterialByCod(@PathVariable Long id) {
        Material material = materialService.findById(id);
        return material == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(material);
    }

    @PostMapping
    @Operation(summary = "Criar novo material", description = "Cria um novo material e retorna o material criado com o status 201.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Material criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida. Verifique os dados enviados.")
    })
    public ResponseEntity<Material> createMaterial(@RequestBody Material material, UriComponentsBuilder uriBuilder) {
        Material materialCreated = materialService.create(material);
        URI uri = uriBuilder.path("/material/{id}").buildAndExpand(materialCreated.getCod()).toUri();

        return ResponseEntity.created(uri).body(materialCreated);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar material", description = "Atualiza um material existente e retorna o material atualizado.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Material atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Material não encontrado.")
    })
    public ResponseEntity<Material> updateMaterial(@RequestBody Material material, @PathVariable Long id) {
        Material material1 = materialService.update(material, id);
        return material1 == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(material1);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar material", description = "Deleta um material existente")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Material deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Material não encontrado.")
    })
    public ResponseEntity<?> deleteMaterial(@PathVariable Long id) {
        boolean deletd = materialService.delete(id);
        return deletd ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/most_consumed")
    @Operation(summary = "Material mais consumido", description = "Retorna o material mais consumido. (Utilizar no resumo de controle de bens)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Material mais consumido retornado com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum material encontrado.")
    })
    public ResponseEntity<DTOMaterialMostConsumer> getMostConsumed() {
        DTOMaterialMostConsumer material = materialService.getMostConsumer();
        return material == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(material);
    }

    @GetMapping("/most_available")
    @Operation(summary = "Material mais disponível", description = "Retorna o material com maior disponibilidade no estoque. (Utilizar no resumo de controle de bens)")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Material mais disponível retornado com sucesso."),
            @ApiResponse(responseCode = "204", description = "Nenhum material encontrado.")
    })
    public ResponseEntity<DTOMaterialMostConsumer> getMostAvailable() {
        DTOMaterialMostConsumer material = materialService.mostAvailable();
        return material == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(material);
    }

    @GetMapping("/nearest_expiration")
    @Operation(summary = "Material com data de validade mais próxima", description = "Retorna o material com a data de validade mais próxima. (Utilizar no resumo de controle de bens)")
    public ResponseEntity<DTOMaterialExpirationDate> getNearestExpiration() {
        DTOMaterialExpirationDate material = materialService.nearestExpiration();
        return material == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(material);
    }

    @GetMapping("/box")
    @Operation(summary = "Contar materiais por armario", description = "Retorna a quantidade de materiais em um armario. (utilizar para pegar a contagem na pagina inicial)")
    public ResponseEntity<?> getMaterialByBox(@RequestParam("Armário") Box box) {
        int count = materialService.countByBox(box);
        Map<Box, Integer> map = Map.of(box, count);
        return ResponseEntity.ok(map);
    }
}
