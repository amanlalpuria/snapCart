package com.mps.snapCart.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "liquor_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Liquor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private String sku;
    private Integer quantity;
    private Integer threshold;
    private LocalDate expiryDate;
    private Double price;
    private String location;


}
