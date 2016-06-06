/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Persona {
    private String perRut;
    private String perNombre;
    private String perApellidoPaterno;
    private String perApellidoMaterno;

    public Persona() {
    }

    public Persona(String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno) {
        this.perRut = perRut;
        this.perNombre = perNombre;
        this.perApellidoPaterno = perApellidoPaterno;
        this.perApellidoMaterno = perApellidoMaterno;
    }

    public Persona(String perRut) {
        this.perRut = perRut;
    }
    
    public String getPerRut() {
        return perRut;
    }

    public void setPerRut(String perRut) {
        this.perRut = perRut;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellidoPaterno() {
        return perApellidoPaterno;
    }

    public void setPerApellidoPaterno(String perApellidoPaterno) {
        this.perApellidoPaterno = perApellidoPaterno;
    }

    public String getPerApellidoMaterno() {
        return perApellidoMaterno;
    }

    public void setPerApellidoMaterno(String perApellidoMaterno) {
        this.perApellidoMaterno = perApellidoMaterno;
    }

    @Override
    public String toString() {
        return "Persona{" + "perRut=" + perRut + ", perNombre=" + perNombre + ", perApellidoPaterno=" + perApellidoPaterno + ", perApellidoMaterno=" + perApellidoMaterno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.perRut);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.perRut, other.perRut)) {
            return false;
        }
        return true;
    }
    
    
}
