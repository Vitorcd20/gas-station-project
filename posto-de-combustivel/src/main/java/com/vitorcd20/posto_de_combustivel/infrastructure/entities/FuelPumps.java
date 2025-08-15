package com.vitorcd20.posto_de_combustivel.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fuel_pumps")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuelPumps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "fuel_id")
    private TypesOfFuel typesOfFuel;

}
