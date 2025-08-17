package com.vitorcd20.posto_de_combustivel.service;


import com.vitorcd20.posto_de_combustivel.infrastructure.entities.TypesOfFuel;
import com.vitorcd20.posto_de_combustivel.infrastructure.entities.repositories.TypesOfFuelRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypesOfFuelService {

    private final TypesOfFuelRepository typesOfFuelRepository;

    public void create(TypesOfFuel typesOfFuel) {
        typesOfFuelRepository.save(typesOfFuel);
    }

    public TypesOfFuel getTypesOfFuelById(Integer id) {
        return typesOfFuelRepository.findById(id).orElseThrow(() -> new NullPointerException("type of fuel not found by id" + id));
    }

    public List<TypesOfFuel> getTypesOfFuel(){
        return typesOfFuelRepository.findAll();
    }

    @Transactional
    public   void deleteTypesOfFuel(Integer id) {
        typesOfFuelRepository.deleteById(id);
    }

    public   void updateTypesOfFuel(Integer id, TypesOfFuel typesOfFuel) {

        if (typesOfFuel.getId() == null) {
            throw new IllegalArgumentException("type of fuel ID cannot be null for update");
        }

        TypesOfFuel existingTypesOfFuel = typesOfFuelRepository.findById(typesOfFuel.getId()).orElseThrow(() -> new
                EntityNotFoundException("type of fuel not found with id " + typesOfFuel.getId()));

        existingTypesOfFuel.setId(existingTypesOfFuel.getId());
        typesOfFuelRepository.save(existingTypesOfFuel);
    }
}
