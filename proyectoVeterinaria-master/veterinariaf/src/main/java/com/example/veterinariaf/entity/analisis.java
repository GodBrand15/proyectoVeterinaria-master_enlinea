package com.example.veterinariaf.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "analisis")
public class analisis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codAnalisis;
    @Column(nullable = false,length = 200)
    private String  rectal;
    @Column(nullable = false,length = 200)
    private String  vulvarpropulcal;
    @Column(nullable = false,length = 200)
    private String  actitud;
    @Column(nullable = false,length = 200)
    private String  condicorporal;
    @Column(nullable = false,length = 200)
    private String  estadohidratacion;
    @Column(nullable = false,length = 200)
    private String  oral;
    @Column(nullable = false,length = 200)
    private String  estadomucoso;
    @Column(nullable = false,length = 200)
    private String estadoconjutival;

    @ManyToOne
    @JoinColumn(name = "codregistro")
    @JsonBackReference
    private registro registro;


    public analisis(int codAnalisis, String rectal, String vulvarpropulcal, String actitud, String condicorporal, String estadohidratacion, String oral, String estadomucoso, String estadoconjutival) {
        this.codAnalisis = codAnalisis;
        this.rectal = rectal;
        this.vulvarpropulcal = vulvarpropulcal;
        this.actitud = actitud;
        this.condicorporal = condicorporal;
        this.estadohidratacion = estadohidratacion;
        this.oral = oral;
        this.estadomucoso = estadomucoso;
        this.estadoconjutival = estadoconjutival;
    }

    public analisis() {
    }

    public int getCodAnalisis() {
        return codAnalisis;
    }

    public void setCodAnalisis(int codAnalisis) {
        this.codAnalisis = codAnalisis;
    }

    public String getRectal() {
        return rectal;
    }

    public void setRectal(String rectal) {
        this.rectal = rectal;
    }

    public String getVulvarpropulcal() {
        return vulvarpropulcal;
    }

    public void setVulvarpropulcal(String vulvarpropulcal) {
        this.vulvarpropulcal = vulvarpropulcal;
    }

    public String getActitud() {
        return actitud;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public String getCondicorporal() {
        return condicorporal;
    }

    public void setCondicorporal(String condicorporal) {
        this.condicorporal = condicorporal;
    }

    public String getEstadohidratacion() {
        return estadohidratacion;
    }

    public void setEstadohidratacion(String estadohidratacion) {
        this.estadohidratacion = estadohidratacion;
    }

    public String getOral() {
        return oral;
    }

    public void setOral(String oral) {
        this.oral = oral;
    }

    public String getEstadomucoso() {
        return estadomucoso;
    }

    public void setEstadomucoso(String estadomucoso) {
        this.estadomucoso = estadomucoso;
    }

    public String getEstadoconjutival() {
        return estadoconjutival;
    }

    public void setEstadoconjutival(String estadoconjutival) {
        this.estadoconjutival = estadoconjutival;
    }

    public registro getRegistro() {
        return registro;
    }

    public void setRegistro(registro registro) {
        this.registro = registro;
    }


}
