package com.VMgarciaRivera.flight_management.modelo;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String cedula;
    private String clave;
    private String nombre;
    private String email;
}
