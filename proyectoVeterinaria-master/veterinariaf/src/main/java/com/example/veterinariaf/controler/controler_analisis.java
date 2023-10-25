package com.example.veterinariaf.controler;

import com.example.veterinariaf.Service.ServiceIMPL.analisisIMPL;
import com.example.veterinariaf.Service.ServiceIMPL.registroIMPL;
import com.example.veterinariaf.entity.analisis;
import com.example.veterinariaf.entity.analisisDTO;
import com.example.veterinariaf.entity.registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("analisis")
@CrossOrigin(origins = {"*"})
public class controler_analisis {

    private final analisisIMPL impl;

    private final registroIMPL implr;

    @Autowired

    public controler_analisis(analisisIMPL impl, registroIMPL implr) {
        this.impl = impl;
        this.implr = implr;
    }


    @GetMapping("listarAnalisis")
    public ResponseEntity<List<analisisDTO>> listarAnalisis() {
        List<analisisDTO> listarAnalisis = this.impl.listarAnalisis();
        return ResponseEntity.ok(listarAnalisis);
    }

    @GetMapping("buscarAnalisis/{codRegistro}")
    public  ResponseEntity<analisis>buscarAnalisis(@PathVariable int codRegistro){
        analisis buscarAnalisis=this.impl.buscarAnalisisPorRegistro(codRegistro).get(0);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(buscarAnalisis);
    }
    @PostMapping("crearAnalisis/{codRegistro}")
    public ResponseEntity<analisis> crearAnalisis(@RequestBody analisis analisa, @PathVariable int codRegistro) {
        registro buscarregistro = this.implr.buscarRegistros(codRegistro);
        if (buscarregistro != null) {
            analisa.setRegistro(buscarregistro);
        } else {
            System.out.println("el registro no existe");
        }

        analisis nuevoAnalisis = this.impl.crearAnalisis(analisa);
        if (nuevoAnalisis != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAnalisis);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


    @PutMapping("modificarAnalisis/{codRegistro}")
    public ResponseEntity<String>modificarAnalisis(@RequestBody analisis analisa,@PathVariable int codRegistro){
        List<analisis> buscarAnalisis= this.impl.buscarAnalisisPorRegistro(codRegistro);

        if (buscarAnalisis!=null){
            analisis analisisExistente=buscarAnalisis.get(0);
            analisisExistente.setActitud(analisa.getActitud());
            analisisExistente.setCondicorporal(analisa.getCondicorporal());
            analisisExistente.setEstadoconjutival(analisa.getEstadoconjutival());
            analisisExistente.setEstadomucoso(analisa.getEstadomucoso());
            analisisExistente.setEstadohidratacion(analisa.getEstadohidratacion());
            analisisExistente.setOral(analisa.getOral());
            analisisExistente.setRectal(analisa.getRectal());
            analisisExistente.setVulvarpropulcal(analisa.getVulvarpropulcal());

            analisis analisisModificado=this.impl.modificarAnalisis(analisa,codRegistro);

            if (analisisModificado !=null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("analisis no modificado");
            }else {
                return ResponseEntity.status(HttpStatus.CREATED).body("modificacion exitosa");
            }
        }
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("registro no existente");

    }
}