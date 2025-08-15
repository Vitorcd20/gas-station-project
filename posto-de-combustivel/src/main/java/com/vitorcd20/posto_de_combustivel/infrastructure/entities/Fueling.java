package com.vitorcd20.posto_de_combustivel.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fueling")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fueling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "fuel_pump_id")
    private FuelPumps fuelPumps;
    @Column(name = "fueling_date")
    private LocalDate fuelingDate;
    @Column(name = "total_value")
    private BigDecimal totalValue;
    @Column(name = "fuel_quantity")
    private Long fuelQuantity;

}
