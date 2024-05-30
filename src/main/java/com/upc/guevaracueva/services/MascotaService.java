package com.upc.guevaracueva.services;

import com.upc.guevaracueva.entities.Mascota;
import com.upc.guevaracueva.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public Mascota save(Mascota mascota) {
       return mascotaRepository.save(mascota);
    }

    public List<Mascota> list() {
        return mascotaRepository.findAll();
    }

    public Mascota actualizarmascota(Mascota mascota) throws Exception {
        mascotaRepository.findById(mascota.getIdMascota()).orElseThrow(() -> new Exception("No se encontró entidad"));
        return mascotaRepository.save(mascota);
    }

    public Mascota borrarmascota(Long codigo) throws Exception{
        Mascota department = mascotaRepository.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
        mascotaRepository.delete(department);
        return department;
    }

    public Mascota searchId(Long id){
        return mascotaRepository.findById(id).orElse(null);
    }


}
