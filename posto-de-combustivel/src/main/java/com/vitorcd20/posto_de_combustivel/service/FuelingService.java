package com.vitorcd20.posto_de_combustivel.service;

import com.vitorcd20.posto_de_combustivel.infrastructure.entities.FuelPumps;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.Fueling;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.repositories.FuelPumpsRepository;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.repositories.FuelingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelingService {

    private final FuelingRepository fuelingRepository;
    private final FuelPumpService fuelPumpService;

    public void fueling (Integer idFuelPump, Long liters) {
        FuelPumps fuelPumps = fuelPumpService.getFuelPumpById(idFuelPump);
        BigDecimal totalValue = fuelPumps.getTypesOfFuel().getPricePerLiter().multiply(BigDecimal.valueOf(liters));

        Fueling fueling = Fueling.builder()
                .fuelingDate(LocalDate.now())
                .fuelPumps(fuelPumps)
                .totalValue(totalValue)
                .fuelQuantity(liters)
                .build();

        fuelingRepository.save(fueling);
    }

   public List<Fueling> getFueling(){
      return fuelingRepository.findAll();
   }

}
