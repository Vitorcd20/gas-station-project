package com.vitorcd20.posto_de_combustivel.infrastructure.entities.repositories;

import com.vitorcd20.posto_de_combustivel.infrastructure.entities.Fueling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelingRepository extends JpaRepository <Fueling, Integer> {
}
