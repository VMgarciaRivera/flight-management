package com.VMgarciaRivera.flight_management.servicio;

import com.VMgarciaRivera.flight_management.dao.VueloRepository;
import com.VMgarciaRivera.flight_management.modelo.Vuelo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VueloServiceImp implements VueloService {

    private final VueloRepository vueloRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Vuelo> findById(UUID id) {
        return vueloRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Vuelo> findAll() {
        return vueloRepository.findAll();
    }

    @Transactional
    @Override
    public Vuelo save(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    @Transactional
    @Override
    public void deleteById(UUID id) {
        vueloRepository.deleteById(id);
    }
}
