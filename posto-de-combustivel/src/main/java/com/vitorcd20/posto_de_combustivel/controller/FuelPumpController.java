package com.vitorcd20.posto_de_combustivel.controller;

import com.vitorcd20.posto_de_combustivel.infrastructure.entities.FuelPumps;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.TypesOfFuel;
import com.vitorcd20.posto_de_combustivel.service.FuelPumpService;
import com.vitorcd20.posto_de_combustivel.service.TypesOfFuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fuelPumps")
public class FuelPumpController {

    private final FuelPumpService fuelPumpService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody FuelPumps fuelPumps) {
        fuelPumpService.create(fuelPumps);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<FuelPumps>> getFuelPumps(){
        return ResponseEntity.ok(fuelPumpService.getFuelPumps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelPumps> getFuelPumpsById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(fuelPumpService.getFuelPumpById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelPumps(@PathVariable(name = "id") Integer id){
        fuelPumpService.deleteFuelPump(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateFuelPump(@RequestParam(name = "id") Integer id,
                                               @RequestBody FuelPumps fuelPumps) {
        fuelPumpService.updateFuelPump(id, fuelPumps);
        return ResponseEntity.ok().build();
    }
}
