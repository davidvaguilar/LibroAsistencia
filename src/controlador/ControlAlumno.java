/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.FichaAlumno;
/**
 *
 * @author David
 */
public class ControlAlumno implements ActionListener{
    private FichaAlumno modCalculadora;
//    private Alumno visCalculadora;
    
    public ControlAlumno(){
//        this.modCalculadora=mCalculadora;
//        this.visCalculadora=vCalculadora;
//        this.visCalculadora.btnResultado.addActionListener(this);
//        this.visCalculadora.btnLimpiar.addActionListener(this);
//        this.visCalculadora.btnActualizar.addActionListener(this);
    }
    
    public void ActualizarTabla(JTable t){
//        DefaultTableModel modeloTabla= new DefaultTableModel();
//        int cantidadRegitro;
//        t.setModel(modeloTabla);
//        modeloTabla.addColumn("Cod.");
//        modeloTabla.addColumn("1° Numero");
//        modeloTabla.addColumn("Signo");
//        modeloTabla.addColumn("2° Numero");
//        modeloTabla.addColumn("Resultado");
//        
//        Object[] columna=new Object[5];
//        cantidadRegitro=modCalculadora.listar().size();
//        if(cantidadRegitro>10){
//            for (int i = (cantidadRegitro-1); i > cantidadRegitro-10; i--) {
//                columna[0]= modCalculadora.listar().get(i).getCalCodigo();
//                columna[1]= modCalculadora.listar().get(i).getCalPriOperando();
//                columna[2]= modCalculadora.listar().get(i).getCalOperador();
//                columna[3]= modCalculadora.listar().get(i).getCalSegOperando();
//                columna[4]= modCalculadora.listar().get(i).calcular();
//                modeloTabla.addRow(columna);
//            }
//        }else{
//            for (int i = 0; i < cantidadRegitro; i++) {
//                columna[0]= modCalculadora.listar().get(i).getCalCodigo();
//                columna[1]= modCalculadora.listar().get(i).getCalPriOperando();
//                columna[2]= modCalculadora.listar().get(i).getCalOperador();
//                columna[3]= modCalculadora.listar().get(i).getCalSegOperando();
//                columna[4]= modCalculadora.listar().get(i).calcular();
//                modeloTabla.addRow(columna);
//            }
//        }
        
    }
    
//    public void limpiar(){
//        visCalculadora.txtPrimer.setText("");
//        visCalculadora.txtSegundo.setText("");
//        visCalculadora.txtSigno.setText("");
//        visCalculadora.txtPrimer.setBackground(Color.WHITE);
//        visCalculadora.txtSegundo.setBackground(Color.WHITE);
//        visCalculadora.txtSigno.setBackground(Color.WHITE);
//    }
//    
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==this.visCalculadora.btnResultado){
//            Integer primerNumero;
//            String signo;
//            Integer segundoNumero;
//            boolean bandera;
//            Calculadora c;
//            
//            signo=visCalculadora.txtSigno.getText();
//            if(!signo.equals("+")&&!signo.equals("-")&&!signo.equals("*")&&!signo.equals("/")){
//                JOptionPane.showMessageDialog(visCalculadora, "Los operadores son:\n"
//                        + "+ => suma \n"
//                        + "- => resta \n"
//                        + "* => multiplicacion \n"
//                        + "/ => division \n");
//                signo="";
//            }
//                
//            if(!visCalculadora.txtPrimer.getText().isEmpty()&&
//                    !visCalculadora.txtSegundo.getText().isEmpty()&&
//                    !signo.isEmpty()){
//               
//                
//                try{
//                    primerNumero=Integer.valueOf(visCalculadora.txtPrimer.getText());
//                    segundoNumero=Integer.valueOf(visCalculadora.txtSegundo.getText());
//                    c= new Calculadora(primerNumero, segundoNumero, signo);
//                    bandera=modCalculadora.ingresar(c);
//                    if(bandera){
//                        visCalculadora.lblInformacion.setText("El resultado es: "+ c.calcular());
//                    }else{
//                        visCalculadora.lblInformacion.setText("Hubo un error al ingresar, No se pudo terminar el ingreso");
//                    }
//                    limpiar();
//                    
//                }catch(Exception ex){
//                    this.visCalculadora.lblInformacion.setText( "Debe ingresar numeros");
//                    ex.printStackTrace();
//                }finally{
//                    ActualizarTabla(visCalculadora.tblDatos);
//                }
//            }else{
//            
//                if(this.visCalculadora.txtPrimer.getText().isEmpty()){
//                    this.visCalculadora.txtPrimer.setBackground(Color.red);
//                }else{
//                    this.visCalculadora.txtPrimer.setBackground(Color.white);
//                }
//                if(this.visCalculadora.txtSegundo.getText().isEmpty()){
//                    this.visCalculadora.txtSegundo.setBackground(Color.red);
//                }else{
//                    this.visCalculadora.txtSegundo.setBackground(Color.white);
//                }
//                if(this.visCalculadora.txtSigno.getText().isEmpty()){
//                    this.visCalculadora.txtSigno.setBackground(Color.red);
//                }else{
//                    this.visCalculadora.txtSigno.setBackground(Color.white);
//                }
//                this.visCalculadora.lblInformacion.setText("Ingrese valor (es)");
//            }
//        }
//        
//        if(e.getSource()==this.visCalculadora.btnActualizar){
//            ActualizarTabla(this.visCalculadora.tblDatos);
//        }
    }
    
}
