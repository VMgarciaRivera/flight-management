package com.VMgarciaRivera.flight_management.dao;

import org.springframework.data.repository.CrudRepository;
import com.VMgarciaRivera.flight_management.modelo.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioCrud extends CrudRepository<Usuario, String> {

}
