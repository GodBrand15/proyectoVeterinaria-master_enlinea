package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.registroService;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.registroDTo;
import com.example.veterinariaf.repositorio.mascotaRepo;
import com.example.veterinariaf.repositorio.registroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class registroIMPL implements registroService {

    private final registroRepo repo;
    private  final mascotaRepo repos;

    @Autowired
    public registroIMPL(registroRepo repo, mascotaRepo repos) {
        this.repo = repo;
        this.repos = repos;
    }


    @Override
    public List<registro> listarRegistro() {
        return (List<registro>) this.repo.findAll();
    }

    @Override
    public List<registroDTo> ListaConcodigoMascota() {

        List<Object[]> resultado=this.repo.ListaConcodigoMascota();
        List<registroDTo> registroDToList=new ArrayList<>();

        for (Object[] resultados: resultado){
            registroDToList.add(new registroDTo(
                    (int) resultados[0],
                    (String)resultados[1],
                    (String)resultados[2],
                    (String)resultados[3],
                    (String) resultados[4],
                    (String) resultados[5],
                    (String) resultados[6],
                    (String) resultados[7],
                    (String) resultados[8],
                    (String) resultados[9],
                    (String) resultados[10],
                    (Date) resultados[11],
                    (String) resultados[12],
                    (int) resultados[13]
            ));
        }
        return registroDToList;
    }

    @Override
    public registro crearRegistro(registro registros) {
        mascota buscarMAscota=registros.getMascotas();

        if (buscarMAscota != null){
            Optional<mascota> optionalMascotas=this.repos.findById(buscarMAscota.getCodmasco());
            if (optionalMascotas.isPresent()){
                registros.setMascotas(optionalMascotas.get());
                return this.repo.save(registros);
            }else {
                return null;
            }

        }else {
            System.out.println("la mascota no se ah encontrado");
        }
        return null;
    }

    @Override
    public List<registro> findBymascotascod_masco(int cod_mascota) {
        return this.repo.findBymascotascod_mascotas(cod_mascota);
    }

    @Override
    public registro buscarRegistros(int codRegistro) {
        return this.repo.findById(codRegistro).get();
    }

    @Override
    public registro modificarRegistro(int codmascota, registro registros) {
        List<registro> buscarMascota=this.repo.findBymascotascod_mascotas(codmascota);

        if (!buscarMascota.isEmpty()){
            registro registroExistente= buscarMascota.get(0);

            registroExistente.setEstadoCardioMuscular(registros.getEstadoCardioMuscular());
            registroExistente.setEstadoDigestivo(registros.getEstadoDigestivo());
            registroExistente.setEstadoGenitario(registros.getEstadoGenitario());
            registroExistente.setEstadoLocomocion(registros.getEstadoLocomocion());
            registroExistente.setEstadomMusculoEsqueletico(registros.getEstadomMusculoEsqueletico());
            registroExistente.setEstadoOjos(registros.getEstadoOjos());
            registroExistente.setEstadoPielyanex(registros.getEstadoPielyanex());
            registroExistente.setEstadoRespiratorio(registros.getEstadoRespiratorio());
            registroExistente.setFechaIng(registros.getFechaIng());
            registroExistente.setObservaciones(registros.getObservaciones());
            registroExistente.setEstadoModuloslinfaticos(registros.getEstadoModuloslinfaticos());
            registroExistente.setEstadoSistemaNervioso(registros.getEstadoSistemaNervioso());

            registro registroModificado= this.repo.save(registroExistente);

            if (registroModificado != null){
                System.out.println("se ha modificado con exito");
            }else{
                System.out.println("no se ha modificado nada");
            }


        }
        return null;
    }


}
