package com.vitorcd20.posto_de_combustivel.service;

import com.vitorcd20.posto_de_combustivel.infrastructure.entities.FuelPumps;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.TypesOfFuel;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.repositories.FuelPumpsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelPumpService {

    private final FuelPumpsRepository fuelPumpsRepository;

    public void create(FuelPumps fuelPumps) {
        fuelPumpsRepository.save(fuelPumps);
    }

    public FuelPumps getFuelPumpById(Integer id) {
       return fuelPumpsRepository.findById(id).orElseThrow(() -> new NullPointerException("Fuel pump not found by id" + id));
    }
    public List<FuelPumps> getFuelPumps(){
        return fuelPumpsRepository.findAll();
    }

    @Transactional
    public  void deleteFuelPump(Integer id) {
        fuelPumpsRepository.deleteById(id);
    }

    public   void updateFuelPump(FuelPumps fuelPumps) {

        if (fuelPumps.getId() == null) {
            throw new IllegalArgumentException("Fuel pump ID cannot be null for update");
        }

        FuelPumps existingPump = fuelPumpsRepository.findById(fuelPumps.getId()).orElseThrow(() -> new EntityNotFoundException("Fuel pump not found with id " + fuelPumps.getId()));

        existingPump.setName(fuelPumps.getName());
        existingPump.setTypesOfFuel(fuelPumps.getTypesOfFuel());

        fuelPumpsRepository.save(fuelPumps);
    }
}
