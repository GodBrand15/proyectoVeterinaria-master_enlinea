package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.analisis;
import com.example.veterinariaf.entity.analisisDTO;

import java.util.List;

public interface analisisService {


    public List<analisisDTO> listarAnalisis();

    public analisis crearAnalisis(analisis analisa);

    public analisis modificarAnalisis(analisis analisa, int codregistro);

    public List<analisis> buscarAnalisisPorRegistro(int codregistro);
}
