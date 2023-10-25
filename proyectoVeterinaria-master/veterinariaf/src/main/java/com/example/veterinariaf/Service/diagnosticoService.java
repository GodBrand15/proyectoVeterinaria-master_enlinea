package com.example.veterinariaf.Service;

import com.example.veterinariaf.entity.diagnostico;
import com.example.veterinariaf.entity.diagnosticoDTO;

import java.util.List;

public interface diagnosticoService {

    public List<diagnostico> listarDiagnostico();

    public List<diagnosticoDTO> listaDiagnosticoConmasco();

    public diagnostico crearDiagnostico(int codRegistro, diagnostico diagnosticos);

    public diagnostico modificarDiagnostico(int nDiagnostico,diagnostico diagnosticos);

    public diagnostico buscarDiagnostico(int nDiagnostico);


}
