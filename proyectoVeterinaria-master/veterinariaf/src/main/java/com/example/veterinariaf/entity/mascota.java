package com.example.veterinariaf.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "mascota")
public class mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codmasco")
    private int codmasco;
    @Column(nullable = false,length = 250)
    private String nombre;
    @Column(nullable = false,length = 250)
    private String color;
    @Column(nullable = false,length = 250)
    private String especie;
    @Column(nullable = false,length = 250)
    private String raza;
    @Column(nullable = false)
    private Date fechanaci;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    @JsonBackReference
    private propietario propietario;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "mascota",cascade = CascadeType.ALL)
    @JsonManagedReference
    private antecedentes antecedente;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "mascotas",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<registro> registro1;


    public mascota(int codmasco, String nombre, String color, String especie, String raza, Date fechanaci, com.example.veterinariaf.entity.propietario propietario) {
        this.codmasco = codmasco;
        this.nombre = nombre;
        this.color = color;
        this.especie = especie;
        this.raza = raza;
        this.fechanaci = fechanaci;
        this.propietario = propietario;
    }

    public mascota() {
    }

    public int getCodmasco() {
        return codmasco;
    }

    public void setCodmasco(int codmasco) {
        this.codmasco = codmasco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(Date fechanaci) {
        this.fechanaci = fechanaci;
    }

    public com.example.veterinariaf.entity.propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(com.example.veterinariaf.entity.propietario propietario) {
        this.propietario = propietario;
    }

    public antecedentes getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(antecedentes antecedente) {
        this.antecedente = antecedente;
    }

    public List<registro> getRegistro1() {
        return registro1;
    }

    public void setRegistro1(List<registro> registro1) {
        this.registro1 = registro1;
    }
}

