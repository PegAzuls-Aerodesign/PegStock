package com.pegazuls.aerodesign.PegStock.model.entities;

import com.pegazuls.aerodesign.PegStock.model.dto.material.DTOMaterial;
import com.pegazuls.aerodesign.PegStock.model.enums.Box;
import com.pegazuls.aerodesign.PegStock.model.enums.Category;
import com.pegazuls.aerodesign.PegStock.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table
@Entity(name = "tb_material")
@Getter
@Setter
@AllArgsConstructor
public class Material {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cod;

   private String name;

   private String brand;
   
   private String description;

   private int quantity;

   private int consumerQuantity;

   @Enumerated(EnumType.STRING)
   private Category category;

   @Enumerated(EnumType.STRING)
   private Box box;

   private LocalDate expirationDate; // data de validade

   private LocalDate createdDate; // data de fabricação

   private LocalDate registerDate; // data de registro no sistema

   @Column(nullable = true)
   private LocalDate lastAddDate; // data da última adição

   @Column(nullable = true)
   private LocalDate lastConsumptionDate; // data do último consumo

   @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private List<Borrowing> borrowing;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "tb_material_status",
            joinColumns = @JoinColumn(name = "material_id")
    )
    @Column(name = "status")
   private List<Status> status;


   public Material() {
      this.registerDate = LocalDate.now();
   }

    public Material(DTOMaterial dtoMaterial) {
        this.cod = dtoMaterial.cod();
        this.name = dtoMaterial.name();
        this.description = dtoMaterial.description();
        this.brand = dtoMaterial.brand();
        this.quantity = dtoMaterial.quantity();
        this.category = dtoMaterial.category();
        this.box = dtoMaterial.box();
        this.expirationDate = dtoMaterial.expirationDate();
        this.createdDate = LocalDate.now(); // Assuming createdDate is set to the current date
    }

    @Override
   public String toString() {
      return name;
   }



}
