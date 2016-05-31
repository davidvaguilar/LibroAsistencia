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
public class Persona {
    private String perRut;
    private String perNombre;
    private String perApellidoPaterno;
    private String perApellidoMaterno;

    public Persona(String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno) {
        this.perRut = perRut;
        this.perNombre = perNombre;
        this.perApellidoPaterno = perApellidoPaterno;
        this.perApellidoMaterno = perApellidoMaterno;
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
    
    
}
