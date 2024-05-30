package com.upc.guevaracueva.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MascotaDTO {
    private Long idMascota;
    private String direccion;
    private LocalDate fechaDenacimiento;
    private String tamanio;
    private String status;
}
