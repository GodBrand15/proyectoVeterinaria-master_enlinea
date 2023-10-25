package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.diagnostico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface diagnosticoRepo extends CrudRepository<diagnostico,Integer> {

    @Query(value = "select d.n_diagnostico,m.nombre as nombe_mascota,d.descripccion,d.estado from diagnostico d \n" +
            "join registro r on \n" +
            "d.id_registro= r.cod_registro\n" +
            "join  mascota m on r.codmascota = m.codmasco;\n",nativeQuery = true)
    List<Object[]> listaDiagnosticoConmasco();
}
