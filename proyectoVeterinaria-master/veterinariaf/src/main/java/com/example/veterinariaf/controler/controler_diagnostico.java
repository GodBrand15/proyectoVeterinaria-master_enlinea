package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.diagnosticoIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.registroIMPL;
import com.example.veterinariaf.entity.diagnostico;
import com.example.veterinariaf.entity.diagnosticoDTO;
import com.example.veterinariaf.entity.registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("diagnostico")
@CrossOrigin(origins = {"*"})
public class controler_diagnostico {


    private final diagnosticoIMPL impl;
    private final registroIMPL implr;

    @Autowired

    public controler_diagnostico(diagnosticoIMPL impl,registroIMPL implr){
        this.impl=impl;
        this.implr=implr;
    }


    @GetMapping("listarDiagnosticos")
    public ResponseEntity<List<diagnosticoDTO>> listarDiagnosticos(){
        List<diagnosticoDTO> listarDiagnosticos=this.impl.listaDiagnosticoConmasco();
        return ResponseEntity.ok(listarDiagnosticos);
    }


    @PostMapping(value = "crearDiagnostico/{codRegistro}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<diagnostico> crearDiagnostico(@RequestBody diagnostico diagnosticos,@PathVariable int codRegistro) {

        registro buscarregistro=this.implr.buscarRegistros(codRegistro);

        if (buscarregistro!= null){
            diagnosticos.setRegistro(buscarregistro);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        diagnostico nuevoDiagnostico=this.impl.crearDiagnostico(codRegistro,diagnosticos);

        if (nuevoDiagnostico != null){
            ResponseEntity.status(HttpStatus.CREATED).body(nuevoDiagnostico);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDiagnostico);
    }

    @PutMapping("modificarDiagnostico/{nDiagnostico}")
    public  ResponseEntity<String>modificarDiagnostico(@PathVariable int nDiagnostico,@RequestBody diagnostico diagnosticos){

               diagnostico  buscandoDiagnostico=this.impl.buscarDiagnostico(nDiagnostico);
         if (buscandoDiagnostico!=null){

             diagnostico diagnosticoexistente= buscandoDiagnostico;

             diagnosticoexistente.setDescripccion(diagnosticos.getDescripccion());

             diagnosticoexistente.setEstado(diagnosticos.getEstado());

             diagnostico diagnosticoModificado= this.impl.modificarDiagnostico(nDiagnostico ,diagnosticoexistente);
             if (diagnosticoModificado != null){
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al modificar");
             }else {
                 return ResponseEntity.status(HttpStatus.CREATED).body("Modificacion exitosa");
             }
         }else {
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body("diagnostico no encontrqado");
         }
    }




   @GetMapping("buscarDiagnostico/{nDiagnotico}")
        public  ResponseEntity<diagnostico> buscarDiagnostico(@PathVariable int nDiagnotico){
        diagnostico buscarDiagnotico= this.impl.buscarDiagnostico(nDiagnotico);

        if (buscarDiagnotico!=null ){
            return ResponseEntity.status(HttpStatus.CREATED).body(buscarDiagnotico);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

   }







}
