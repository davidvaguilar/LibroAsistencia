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
public class EstadoAlumno {
    private String estAluCodigo;
    private String estAluDescripcion;

    public EstadoAlumno() {
    }

    public EstadoAlumno(String estAluCodigo, String estAluDescripcion) {
        this.estAluCodigo = estAluCodigo;
        this.estAluDescripcion = estAluDescripcion;
    }

    public String getEstAluCodigo() {
        return estAluCodigo;
    }

    public void setEstAluCodigo(String estAluCodigo) {
        this.estAluCodigo = estAluCodigo;
    }

    public String getEstAluDescripcion() {
        return estAluDescripcion;
    }

    public void setEstAluDescripcion(String estAluDescripcion) {
        this.estAluDescripcion = estAluDescripcion;
    }

    @Override
    public String toString() {
        return "EstadoAlumno{" + "estAluCodigo=" + estAluCodigo + ", estAluDescripcion=" + estAluDescripcion + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.estAluCodigo);
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
        final EstadoAlumno other = (EstadoAlumno) obj;
        if (!Objects.equals(this.estAluCodigo, other.estAluCodigo)) {
            return false;
        }
        return true;
    }
    
    
}
