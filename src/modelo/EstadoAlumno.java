/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David
 */
public class EstadoAlumno {
    private String estAluCodigo;
    private String estAluDescripcion;

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
    
    
}
