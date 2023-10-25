package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.laboratorioService;
import com.example.veterinariaf.entity.Laboratorio;
import com.example.veterinariaf.repositorio.laboratorioRepo;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class laboratorioIMPL implements laboratorioService {


    private final laboratorioRepo repo;

    @Autowired
    public laboratorioIMPL(laboratorioRepo repo){
        this.repo=repo;
    }

    @Override
    public List<Laboratorio> listarLaboratorio() {
        return (List<Laboratorio>) this.repo.findAll();
    }

    @Override
    public Laboratorio crearLaboratorio(Laboratorio laboratorio) {

        return this.repo.save(laboratorio);
    }

    @Override
    public Laboratorio buscarLabiratorio(int id_labora) {
        return this.repo.findById(id_labora).get();
    }

    @Override
    public Laboratorio buscarXnombre(String nombre_prueba) {
        Laboratorio buscarLAboratorio=this.repo.buscarXnombre(nombre_prueba);

        if(nombre_prueba!=null){
            return buscarLAboratorio;
        }else {
            throw new RuntimeException("prueba no encontrada");
        }
    }
}
