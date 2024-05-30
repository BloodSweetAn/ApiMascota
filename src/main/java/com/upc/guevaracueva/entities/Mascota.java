package com.upc.guevaracueva.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private LocalDate fechaDenacimiento;
    @Column(nullable = false)
    private String tamanio;
    @Column(nullable = false)
    private String status;
}
