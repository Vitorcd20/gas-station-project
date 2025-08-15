package com.vitorcd20.posto_de_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "types_of_fuel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypesOfFuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price_per_liter")
    private BigDecimal pricePerLiter;

}
