package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.mascota;

import java.util.List;

public interface mascotaService {

    public List<mascota> listarMascotas();

    public mascota crearMascota( mascota mascotas);

    public mascota modificarMascota(mascota mascotas);

    public mascota buscarMascota(int codmasco);

    public void eliminarMascota(int codmasco);
}
