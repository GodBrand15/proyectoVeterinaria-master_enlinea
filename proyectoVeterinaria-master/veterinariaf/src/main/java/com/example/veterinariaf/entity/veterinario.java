package com.example.veterinariaf.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "veterinario")
public class veterinario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int cod_veterinario;
        private String nombreCompleto;

        private int cedula;
        private String especialidad;

        private String telefono;





        public veterinario(int cod_veterinario, String nombreCompleto, int cedula, String especialidad, String telefono) {
            this.cod_veterinario = cod_veterinario;
            this.nombreCompleto = nombreCompleto;
            this.cedula = cedula;
            this.especialidad = especialidad;
            this.telefono = telefono;
        }

        public veterinario() {
        }

        public int getCod_veterinario() {
            return cod_veterinario;
        }

        public void setCod_veterinario(int cod_veterinario) {
            this.cod_veterinario = cod_veterinario;
        }

        public String getNombreCompleto() {
            return nombreCompleto;
        }

        public void setNombreCompleto(String nombreCompleto) {
            this.nombreCompleto = nombreCompleto;
        }

        public int getCedula() {
            return cedula;
        }

        public void setCedula(int cedula) {
            this.cedula = cedula;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }
}
