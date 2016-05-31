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
public class Asistencia {
    private String asisFecha;
    private String asisAnotacion;
    private String asisPeriodo;
    private String perRut;
    private String asiCodigo;
    private String actCodigo;
    private String bloCodigo;

    public Asistencia(String asisFecha, String asisAnotacion, String asisPeriodo, String perRut, String asiCodigo, String actCodigo, String bloCodigo) {
        this.asisFecha = asisFecha;
        this.asisAnotacion = asisAnotacion;
        this.asisPeriodo = asisPeriodo;
        this.perRut = perRut;
        this.asiCodigo = asiCodigo;
        this.actCodigo = actCodigo;
        this.bloCodigo = bloCodigo;
    }
    
    
}
