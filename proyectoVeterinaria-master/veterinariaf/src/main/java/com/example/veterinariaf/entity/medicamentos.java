package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicamentos")
public class medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int codMedi;
    @Column(nullable = false,length = 100)
    private String nombreMedi;
    @Column(nullable = false,length = 200)
    private String tipoMedicamento;

    @ManyToMany(mappedBy = "ListMedicamentos")
    @JsonBackReference
    private List<diagnostico> diagnosticoList;

    public medicamentos(int codMedi, String nombreMedi, String tipoMedicamento) {
        this.codMedi = codMedi;
        this.nombreMedi = nombreMedi;
        this.tipoMedicamento = tipoMedicamento;
    }

    public medicamentos() {
    }


    public int getCodMedi() {
        return codMedi;
    }

    public void setCodMedi(int codMedi) {
        this.codMedi = codMedi;
    }

    public String getNombreMedi() {
        return nombreMedi;
    }

    public void setNombreMedi(String nombreMedi) {
        this.nombreMedi = nombreMedi;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public List<diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }


}
