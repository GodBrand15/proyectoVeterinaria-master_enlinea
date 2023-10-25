package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.analisis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface analisisRepo extends CrudRepository<analisis,Integer> {

@Query(value = "select cod_analisis,actitud,condicorporal,estadoconjutival,estadohidratacion,estadomucoso,oral,rectal,vulvarpropulcal,codregistro from Analisis a JOIN Registro r ON a.codregistro = r.cod_registro",nativeQuery = true)
    List<Object[]> listarAnalisisConRegistro();

@Query(value = "select * from analisis where codregistro =?",nativeQuery = true)
    List<analisis> buscarAnalisisPorRegistro(@Param("codregistro") int codregistro);

}
