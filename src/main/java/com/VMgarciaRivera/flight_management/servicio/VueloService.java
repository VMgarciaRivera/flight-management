package com.VMgarciaRivera.flight_management.servicio;

import com.VMgarciaRivera.flight_management.modelo.Vuelo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VueloService {
    Optional<Vuelo> findById(UUID id);
    List<Vuelo> findAll();
    Vuelo save(Vuelo vuelo);
    void deleteById(UUID id);
}
