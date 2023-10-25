package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.laboratorioIMPL;
import com.example.veterinariaf.entity.Laboratorio;
import com.example.veterinariaf.entity.propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laboratorio")
@CrossOrigin(origins = {"*"})
public class controler_Laboratorio {

    private final laboratorioIMPL impl;

    @Autowired

    public controler_Laboratorio(laboratorioIMPL impl){
        this.impl=impl;
    }


    @GetMapping("listarLaboratorio")
    public ResponseEntity<List<Laboratorio>> listarLaboratorio() {
        List<Laboratorio> listarLaboratorio = this.impl.listarLaboratorio();
        return ResponseEntity.ok(listarLaboratorio);
    }


    @PostMapping("crearLaboratorio")
    public ResponseEntity<String>crearLaboratorio(@RequestBody Laboratorio laboratorio){
            Laboratorio nuevoLabora=this.impl.crearLaboratorio(laboratorio);
            return ResponseEntity.status(HttpStatus.CREATED).body("la prueba de Laboratorio a sido creado");
        }

        @GetMapping("buscarXnombre/{nombre_prueba}")
    public ResponseEntity<Laboratorio> buscarXnombre(@PathVariable String nombre_prueba){

        Laboratorio buscarNOmbre=this.impl.buscarXnombre(nombre_prueba);

        if (buscarNOmbre!=null){
            return ResponseEntity.ok(buscarNOmbre);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        }
}
