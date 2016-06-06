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
public class Carrera {
    private String carCodigo;
    private String carNombre;

    public Carrera() {
    }

    public Carrera(String carCodigo, String carNombre) {
        this.carCodigo = carCodigo;
        this.carNombre = carNombre;
    }

    public String getCarCodigo() {
        return carCodigo;
    }

    public void setCarCodigo(String carCodigo) {
        this.carCodigo = carCodigo;
    }

    public String getCarNombre() {
        return carNombre;
    }

    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }

    @Override
    public String toString() {
        return "Carrera{" + "carCodigo=" + carCodigo + ", carNombre=" + carNombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.carCodigo);
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
        final Carrera other = (Carrera) obj;
        if (!Objects.equals(this.carCodigo, other.carCodigo)) {
            return false;
        }
        return true;
    }


    
    
}
