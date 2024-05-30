package com.upc.guevaracueva.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MascotaDTO {
    private Long IdMascota;
    private String Direccion;
    private Date FechaDenacimiento;
    private String Tamanio;
    private String Status;
}
