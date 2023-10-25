package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.ecografia;

import java.util.List;

public interface ecografiaService {

    public List<ecografia> listarecografia();

    public  ecografia crearEcografia(ecografia ecografias);

    public ecografia buscarXnombre(String nombre);
}
