package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.mascotaIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.registroIMPL;
import com.example.veterinariaf.entity.mascota;
import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.registroDTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registro")
@CrossOrigin({"*"})
public class controler_registro {


    private registroIMPL impl;

    private mascotaIMPL implm;

    @Autowired
    public controler_registro(registroIMPL impl, mascotaIMPL implm){
        this.impl=impl;
        this.implm=implm;
    }




    @GetMapping("listaRegistro")
    public ResponseEntity<List<registroDTo>> obtenerRegistrosDTO() {
        List<registroDTo> registrosDTO = this.impl.ListaConcodigoMascota();
        return ResponseEntity.ok(registrosDTO);
    }

    @PostMapping("crearRegistro/{codmascota}")
    public ResponseEntity<registro>crearRegistro(@RequestBody registro registros, @PathVariable int codmascota){

        mascota buscandoMascota=this.implm.buscarMascota(codmascota);

        if (buscandoMascota != null){
            registros.setMascotas(buscandoMascota);
        }else {
            System.out.println("la mascota no se ha encontrado");
        }
        registro nuevoRegistro =this.impl.crearRegistro(registros);

        if (nuevoRegistro !=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
        }
        return null;

    }


    @GetMapping("buscarRegistro/{codmascota}")
    public ResponseEntity<List<registro>>buscarRegistro(@PathVariable int codmascota){
        List<registro> buscarmascota=this.impl.findBymascotascod_masco(codmascota);
        if (!buscarmascota.isEmpty()){
            return ResponseEntity.ok(buscarmascota);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }



    }



    @GetMapping("buscar/{codRegistro}")
    public ResponseEntity<registro> buscar(@PathVariable int codRegistro){
        registro buscarregistro=this.impl.buscarRegistros(codRegistro);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buscarregistro);
    }


    @PutMapping("modificarRegistro/{codmascota}")

    public ResponseEntity<String> modificarRegistro(@RequestBody registro registros,@PathVariable int codmascota){

        List<registro> buscarMascota=this.impl.findBymascotascod_masco(codmascota);

        if (buscarMascota!=null){
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

            registro registroModificado= this.impl.modificarRegistro(codmascota,registros);

            if (registroModificado != null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("el registro no ha sido modificado");
            }else {
                return ResponseEntity.status(HttpStatus.CREATED).body("modificacion Exitosa");
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la mascota no existe");
        }
    }
}
