package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.vacunasService;
import com.example.veterinariaf.entity.vacunas;
import com.example.veterinariaf.repositorio.vacunasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class vacunasIMPL implements vacunasService {

    private final vacunasRepo repo;

    @Autowired

    public vacunasIMPL(vacunasRepo repo){
        this.repo=repo;
    }
    @Override
    public List<vacunas> listarVacunas() {
        return (List<vacunas>) this.repo.findAll();
    }

    @Override
    public vacunas crearVacuna(vacunas vacunas) {
        return this.repo.save(vacunas);
    }

    @Override
    public vacunas modificarVacuna(int idVacuna, vacunas vacuna) {
        return null;
    }
}
