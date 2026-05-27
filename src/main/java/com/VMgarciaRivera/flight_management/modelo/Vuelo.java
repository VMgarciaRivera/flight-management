package com.VMgarciaRivera.flight_management.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, columnDefinition = "UUID", nullable = false)
    private UUID id;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "fecha_llegada", nullable = false)
    private LocalDateTime fechaLlegada;

    @NotBlank
    @Column(name = "agencia_viajes")
    private String agenciaViajes;

    @NotBlank
    private String aerolinea;

    @NotBlank
    private String numero;

    @NotBlank
    private String estado;

    @NotNull
    @Positive
    @Column(precision = 14, scale = 2)
    private BigDecimal valor;

    @NotBlank
    private String cliente;

    @NotBlank
    private String puesto;

    @NotBlank
    private String avion;

    @NotBlank
    @Column(name = "aeropuerto_salida")
    private String aeropuertoSalida;

    @NotBlank
    @Column(name = "aeropuerto_llegada")
    private String aeropuertoLlegada;

    @NotBlank
    private String piloto;
}