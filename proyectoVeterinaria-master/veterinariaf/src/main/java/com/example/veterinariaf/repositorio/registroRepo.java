package com.example.veterinariaf.repositorio;

import com.example.veterinariaf.entity.registro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface registroRepo extends CrudRepository<registro,Integer> {

    @Query(value = "select * from registro where codmascota=?",nativeQuery = true)
    List<registro> findBymascotascod_mascotas(@Param("codmascota")int codmascota);


    @Query(value = "SELECT cod_registro, estado_cardio_muscular,estado_digestivo,estado_respiratorio,estado_genitario,estado_locomocion,estado_moduloslinfaticos,estadom_musculo_esqueletico,estado_ojos,estado_pielyanex,estado_sistema_nervioso,fecha_ing,observaciones,codmascota  FROM Registro r JOIN Mascota m ON r.codmascota = m.codmasco",nativeQuery = true)
    List<Object[]> ListaConcodigoMascota();
}
