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
public class Alumno extends Persona {
    private String carCodigo;
    private String estAluCodigo;

    public Alumno(String perRut,String carCodigo, String estAluCodigo ) {
        super(perRut);
        this.carCodigo = carCodigo;
        this.estAluCodigo = estAluCodigo;
    }

    

    public Alumno(String carCodigo, String estAluCodigo, String perRut, 
            String perNombre, String perApellidoPaterno, String perApellidoMaterno) {
        super(perRut, perNombre, perApellidoPaterno, perApellidoMaterno);
        this.carCodigo = carCodigo;
        this.estAluCodigo = estAluCodigo;
    }
    

    public String getCarCodigo() {
        return carCodigo;
    }

    public void setCarCodigo(String carCodigo) {
        this.carCodigo = carCodigo;
    }

    public String getEstAluCodigo() {
        return estAluCodigo;
    }

    public void setEstAluCodigo(String estAluCodigo) {
        this.estAluCodigo = estAluCodigo;
    }
    
    
    
}
