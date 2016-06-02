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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modeloDAO.AlumnoDAO;
import modeloDAO.CarreraDAO;
import vista.FichaAlumno;
/**
 *
 * @author David
 */
public class ControlAlumno implements ActionListener{
    private FichaAlumno visAlumno;
    private AlumnoDAO modAlumno;
    private CarreraDAO modCarrera;
    
    public ControlAlumno(FichaAlumno vFichaAlumno, AlumnoDAO mAlumno, CarreraDAO mCarrera){
        this.modAlumno=mAlumno;
        this.modCarrera=mCarrera;
        this.visAlumno=vFichaAlumno;
        this.visAlumno.btnRegistrar.addActionListener(this);
        this.visAlumno.btnActualizar.addActionListener(this);
        this.visAlumno.btnSeleccionar.addActionListener(this);
        this.visAlumno.btnEliminar.addActionListener(this);
        this.visCarComboBox(this.visAlumno.cbbCarrera);
    }
    
    public void visAluTabla(JTable tblVisualizar){
        DefaultTableModel modTabla= new DefaultTableModel();
        int cantidadRegistro;
        tblVisualizar.setModel(modTabla);
        modTabla.addColumn("Rut");
        modTabla.addColumn("Nombre");
        modTabla.addColumn("Apellido");
        modTabla.addColumn("Estado");
        modTabla.addColumn("Carrera");
        Object[] columna=new Object[5];
        cantidadRegistro=this.modAlumno.listar().size();
        if(cantidadRegistro>10){
            for (int i = (cantidadRegistro-1); i > cantidadRegistro-10; i--) {
                columna[0]= this.modAlumno.listar().get(i).getPerRut();
                columna[1]= this.modAlumno.listar().get(i).getPerNombre();
                columna[2]= this.modAlumno.listar().get(i).getPerApellidoPaterno();
                columna[3]= this.modAlumno.listar().get(i).getEstAluCodigo();
                columna[4]= this.modAlumno.listar().get(i).getCarCodigo();
                modTabla.addRow(columna);
            }
        }        
    }
    
    public void visCarComboBox(JComboBox cbbCarrera){
        
    }
    
    public void limpiar(){
        this.visAlumno.txtRut.setText("");
        this.visAlumno.txtNombre.setText("");
        this.visAlumno.txtApePaterno.setText("");
        this.visAlumno.txtApeMaterno.setText("");
        this.visAlumno.txtRut.setBackground(Color.WHITE);
        this.visAlumno.txtNombre.setBackground(Color.WHITE);
        this.visAlumno.txtApePaterno.setBackground(Color.WHITE);
        this.visAlumno.txtApeMaterno.setBackground(Color.WHITE);
    }
    
    
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
