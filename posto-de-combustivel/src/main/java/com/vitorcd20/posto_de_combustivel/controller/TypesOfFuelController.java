package com.vitorcd20.posto_de_combustivel.controller;


import com.vitorcd20.posto_de_combustivel.infrastructure.entities.Fueling;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.TypesOfFuel;
import com.vitorcd20.posto_de_combustivel.service.TypesOfFuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/typesOfFuel")
public class TypesOfFuelController {

    private final TypesOfFuelService typesOfFuelService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TypesOfFuel typesOfFuel) {
        typesOfFuelService.create(typesOfFuel);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<TypesOfFuel>> getTypesOfFuel(){
        return ResponseEntity.ok(typesOfFuelService.getTypesOfFuel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypesOfFuel> getTypesOfFuelById(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(typesOfFuelService.getTypesOfFuelById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypesOfFuel(@PathVariable(name = "id") Integer id){
        typesOfFuelService.deleteTypesOfFuel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateFuelType(@RequestParam(name = "id") Integer id,
                                                   @RequestBody TypesOfFuel typesOfFuel) {
        typesOfFuelService.updateTypesOfFuel(id, typesOfFuel);
        return ResponseEntity.ok().build();
    }

}
