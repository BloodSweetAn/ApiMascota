package com.upc.guevaracueva.controllers;
import com.upc.guevaracueva.dtos.MascotaDTO;
import org.modelmapper.ModelMapper;
import com.upc.guevaracueva.entities.Mascota;
import com.upc.guevaracueva.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @PostMapping("/mascota")
    public ResponseEntity<MascotaDTO> saveMascota(@RequestBody MascotaDTO mascotaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Mascota mascota = modelMapper.map(mascotaDTO, Mascota.class);
        try {
            mascotaService.save(mascota);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido guardar el departamento");
        }
        mascotaDTO = modelMapper.map(mascota, MascotaDTO.class);
        return new ResponseEntity<>(mascotaDTO, HttpStatus.OK);
    }

    private MascotaDTO ConverToList(Mascota list) {
        ModelMapper modelMapper = new ModelMapper();
        MascotaDTO mascotaDTO = modelMapper.map(list , MascotaDTO.class);
        return mascotaDTO;
    }


    @GetMapping("/mascotas")
    public ResponseEntity<List<MascotaDTO>> list() {
        List<Mascota> l;
        l = mascotaService.list();
        List<MascotaDTO> mascotaDTOS = l.stream().map(this::ConverToList).toList();
        return new ResponseEntity<>(mascotaDTOS , HttpStatus.OK);
    }

}
