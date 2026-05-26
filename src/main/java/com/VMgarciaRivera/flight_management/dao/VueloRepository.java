package com.VMgarciaRivera.flight_management.dao;

import com.VMgarciaRivera.flight_management.modelo.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, UUID> {

}
