package com.vitorcd20.posto_de_combustivel.controller;

import com.vitorcd20.posto_de_combustivel.infrastructure.entities.Fueling;
import com.vitorcd20.posto_de_combustivel.service.FuelingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fueling")
public class FuelingController {

    private final FuelingService fuelingService;

    @PostMapping
    public ResponseEntity<Void> fueling(@RequestParam("fuel_quantity") Long liters,
                                        @RequestParam("id_pump") Integer idPump) {
        fuelingService.fueling(idPump, liters);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Fueling>> getFueling(){
        return ResponseEntity.ok(fuelingService.getFueling());
    }
}
