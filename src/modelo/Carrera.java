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
public class Carrera {
    private String carCodigo;
    private String carNombre;

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
       return ("La Carrera contiene: \n"+
               "Codigo :"+this.carCodigo+"\n"+
               "Nombre :"+this.carNombre);
    }
    
    
}
