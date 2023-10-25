package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.citaEcograIMPL;
import com.example.veterinariaf.entity.citaEcografiaDTo;
import com.example.veterinariaf.entity.cita_ecografia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("citaEcografia")
@CrossOrigin(origins = {"*"})
public class controler_cita_ecografia {

    private final citaEcograIMPL impl;

    @Autowired

    public controler_cita_ecografia(citaEcograIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarEcografias")
    public ResponseEntity<List<citaEcografiaDTo>> listarcitaEcogra(){
        List<citaEcografiaDTo> listarCitas=this.impl.listarCitaEcogra();
        return ResponseEntity.ok(listarCitas);
    }


    @PostMapping("crearCitaEcogra/{nombre}/{nombreE}/{nombreV}")
    public ResponseEntity<String>crearCitaEcografia(
            @RequestBody cita_ecografia citaEcografia,
            @PathVariable String nombre,
            @PathVariable String nombreE,
            @PathVariable String nombreV){

        cita_ecografia citaNueva=this.impl.crearCitaEcogra(citaEcografia,nombre,nombreE,nombreV);

        if (citaNueva!=null){
            return  ResponseEntity.status(HttpStatus.CREATED).body(" su cita a ecografia a sido creada");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error al crear");
        }

    }
}
