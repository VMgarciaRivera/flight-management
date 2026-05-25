package com.VMgarciaRivera.flight_management.modelo;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotBlank
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;
    @NotBlank
    private String clave;
    @NotBlank
    private String nombre;
    @NotBlank
    @Email
    private String email;
}
