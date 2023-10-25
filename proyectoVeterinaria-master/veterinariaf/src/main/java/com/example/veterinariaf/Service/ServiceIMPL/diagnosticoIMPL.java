package com.example.veterinariaf.Service.ServiceIMPL;

import com.example.veterinariaf.Service.diagnosticoService;
import com.example.veterinariaf.entity.diagnostico;
import com.example.veterinariaf.entity.diagnosticoDTO;
import com.example.veterinariaf.entity.registro;
import com.example.veterinariaf.repositorio.diagnosticoRepo;
import com.example.veterinariaf.repositorio.registroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class diagnosticoIMPL implements diagnosticoService {

    private final diagnosticoRepo repo;
    private final registroRepo repoR;

    @Autowired
    public diagnosticoIMPL(diagnosticoRepo repo , registroRepo repoR){
        this.repo=repo;
        this.repoR=repoR;

}
    @Override
    public List<diagnostico> listarDiagnostico() {
        return (List<diagnostico>) this.repo.findAll();
    }

    @Override
    public List<diagnosticoDTO> listaDiagnosticoConmasco() {
        List<Object[]> resultado= this.repo.listaDiagnosticoConmasco();
        List<diagnosticoDTO> diagnosticoDTOList= new ArrayList<>();
        for (Object[] resultados : resultado){
            diagnosticoDTOList.add(new diagnosticoDTO(
                    (int) resultados[0],
                    (String) resultados[1],
                    (String) resultados[2],
                    (String) resultados[3]
            ));
        }
        return diagnosticoDTOList;
    }

    @Override
    public diagnostico crearDiagnostico(int codRegistro, diagnostico diagnosticos) {
        registro buscarRegistro= diagnosticos.getRegistro();

        if (buscarRegistro!=null){
         Optional<registro> buscandoregistro=this.repoR.findById(buscarRegistro.getCodRegistro());

         if (buscandoregistro.isPresent()){
             diagnosticos.setRegistro(buscandoregistro.get());
             return this.repo.save(diagnosticos);
         }else {
             System.out.println("diagnotico anulado");
         }
        }else {
            System.out.println("non se encontro registro");
        }
        return null;
    }

    @Override
    public diagnostico modificarDiagnostico(int nDiagnostico, diagnostico diagnosticos) {
        Optional<diagnostico> buscaDiagnostico=this.repo.findById(nDiagnostico);

        if (!buscaDiagnostico.isEmpty()){
            diagnostico diagnosticoExistente=buscaDiagnostico.get();

            diagnosticoExistente.setDescripccion(diagnosticos.getDescripccion());
            diagnosticoExistente.setEstado(diagnosticos.getEstado());

            diagnostico diagnosticoModificado=this.repo.save(diagnosticoExistente);

            if (diagnosticoModificado!=null){
                System.out.println("se ah modificado  con exito");
            }
        }else {
            System.out.println("no se encontro  diagnostico");
        }

        return null;
    }

    @Override
    public diagnostico buscarDiagnostico(int nDiagnostico) {
        return this.repo.findById(nDiagnostico).get();
    }




}
