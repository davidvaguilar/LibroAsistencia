/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Carrera;
import modelo.EstadoAlumno;
import modelo.Persona;
import modeloDAO.AlumnoDAO;
import modeloDAO.CarreraDAO;
import modeloDAO.EstadoAlumnoDAO;
import modeloDAO.PersonaDAO;
import vista.FichaAlumno;
import vista.Principal;
/**
 *
 * @author David
 */
public class ControlAlumno implements ActionListener{
    private FichaAlumno visAlumno;
    private Principal visPrincipal;
    private AlumnoDAO modAlumno;
    private PersonaDAO modPersona;
    private CarreraDAO modCarrera;
    private EstadoAlumnoDAO modEstadoAlumno;
    
    public ControlAlumno(FichaAlumno vFichaAlumno, Principal vPrincipal){
        this.modAlumno = new AlumnoDAO();
        this.modCarrera = new CarreraDAO();
        this.modEstadoAlumno = new EstadoAlumnoDAO();
        this.modPersona=new PersonaDAO();
        this.visAlumno = vFichaAlumno;
        this.visPrincipal= vPrincipal;
        this.tablaAlumno(this.visAlumno.tblVisualizar);
        this.comboCarrera(this.visAlumno.cbbCarrera);
        this.comboEstadoAlumno(this.visAlumno.cbbEstado);
        this.visAlumno.btnRegistrar.addActionListener(this);
        this.visAlumno.btnActualizar.addActionListener(this);
        this.visAlumno.btnSeleccionar.addActionListener(this);
        this.visAlumno.btnEliminar.addActionListener(this);
        
        this.visAlumno.btnActualizar.setEnabled(false);
        this.visAlumno.btnEliminar.setEnabled(false);
    }
    
    public void tablaAlumno(JTable tblVisualizar){
        DefaultTableModel modTabla= new DefaultTableModel();
        int cantidadRegistro;
        Persona p;
        tblVisualizar.setModel(modTabla);
        modTabla.addColumn("Rut");
        modTabla.addColumn("Nombre");
        modTabla.addColumn("Apellido");
        modTabla.addColumn("Estado");
        modTabla.addColumn("Carrera");
        Object[] columna=new Object[5];
        ArrayList<Alumno> alumnos=this.modAlumno.listar();
        cantidadRegistro=alumnos.size();
        for (int i = (cantidadRegistro-1); i >= 0; i--) {
            columna[0] = alumnos.get(i).getPerRut();
            p = modPersona.buscar(alumnos.get(i));
            columna[1] = p.getPerNombre();
            columna[2] = p.getPerApellidoPaterno();
            columna[3] = alumnos.get(i).getEstAluCodigo();
            columna[4] = alumnos.get(i).getCarCodigo();
            modTabla.addRow(columna);
        }
    }
    
    public void comboCarrera(JComboBox cbbCarrera){
        cbbCarrera.removeAllItems();
        ArrayList<Carrera> carreras = modCarrera.listar();
        int cantidadRegistro = carreras.size();
        cbbCarrera.addItem("Seleccione : ");
        for (int i = 0; i < cantidadRegistro; i++) {
            cbbCarrera.addItem(carreras.get(i).getCarNombre());
        }
    }
    
    public void comboEstadoAlumno(JComboBox cbbEstado){
        cbbEstado.removeAllItems();
        ArrayList<EstadoAlumno> estados= modEstadoAlumno.listar();
        int cantidadRegistro = estados.size();
        for (int i = 0; i < cantidadRegistro; i++) {
            cbbEstado.addItem(estados.get(i).getEstAluDescripcion());
        }
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
        this.visAlumno.cbbCarrera.setSelectedIndex(0);
        this.visAlumno.cbbEstado.setSelectedIndex(0);
    }
    
    public void botonDeseleccionar(){
        this.visAlumno.btnSeleccionar.setText("Seleccionar");
        this.visAlumno.btnSeleccionar.setSelected(false);
        this.visAlumno.txtRut.setEditable(true);
        this.visAlumno.btnRegistrar.setEnabled(true);
        this.visAlumno.btnActualizar.setEnabled(false);
        this.visAlumno.btnEliminar.setEnabled(false);
        this.limpiar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
//        if(e.getSource()==this.visAlumno.btnActualizar){
//            System.out.println("Hola Mundo");
//            Alumno a=new Alumno();
//            Carrera c = new Carrera();
//            EstadoAlumno ea = new EstadoAlumno(); 
//            boolean resultado = false;
//            boolean bandera = false;
//            a.setPerRut(this.visAlumno.txtRut.getText());
//            int cantidadRegistro = this.modAlumno.listar().size();
//            for (int i = 0; i < cantidadRegistro; i++) {
//                if(a.equals(modAlumno.listar().get(i))){
//                    //bandera = true;
//                    a.setPerNombre(this.visAlumno.txtNombre.getText());
//                    a.setPerApellidoPaterno(this.visAlumno.txtApePaterno.getText());
//                    a.setPerApellidoMaterno(this.visAlumno.txtApeMaterno.getText());
//                    c.setCarNombre((String)this.visAlumno.cbbCarrera.getSelectedItem());
//                    ea.setEstAluDescripcion((String)this.visAlumno.cbbEstado.getSelectedItem());
//                    if(!a.getPerNombre().equals("")&&
//                            !a.getPerApellidoPaterno().equals("")&&
//                            !c.getCarNombre().equals("")&&
//                            !ea.getEstAluDescripcion().equals("")){
//                        try{
//                            a.setCarCodigo(modCarrera.buscar(c).getCarCodigo());
//                            a.setEstAluCodigo(modEstadoAlumno.buscar(ea).getEstAluCodigo());
//                            resultado = modPersona.actualizar(a);
//                            if(resultado){   
//                                
//                                
//                                
//                                
//                                HASTA AQUI QUEDE
//                                
//                                resultado=modAlumno.actualizar(a);
//                                if(resultado){
//                                    this.visPrincipal.lblInformacion.setText("El Alumno ha sido registrado satisfactoriamente");
//                                    limpiar();
//                                }else{
//                                    JOptionPane.showMessageDialog(visAlumno, "Hubo un error al Ingresar al Alumno, No se pudo terminar el ingreso");
//                                    this.visPrincipal.lblInformacion.setText("No se pudo agregar al Alumno");
//                                    resultado=modPersona.eliminar(a);
//                                    if(resultado){
//                                        System.out.println("Se ha Eliminado a la Persona");
//                                    }else{
//                                        System.out.println("No se pudo eliminar a la Persona");
//                                    }
//                                    System.out.println(a.toString());   //Imprimir Objeto
//                                }
//                            }else{
//                                JOptionPane.showMessageDialog(visAlumno, "No se pudo agregar al Alumno");  
//                                this.visPrincipal.lblInformacion.setText("No se pudo agregar a la persona");
//                            }                    
//                        }catch(Exception ex){
//                            this.visPrincipal.lblInformacion.setText( "Hubo un Error cod."+ex.toString());
//                            System.out.println("Hubo un Error al Registrar cod."+ex.toString());
//                        }finally{
//                            tablaAlumno(this.visAlumno.tblVisualizar);
//                        }
//                        
//                        
//                        
//                    }
//                }
//            }
//            
//            
//        }
        
        
        if(e.getSource()==this.visAlumno.btnEliminar){
            Alumno a=new Alumno();
            boolean bandera = false;
            if(this.visAlumno.txtRut.getText().isEmpty()){
                this.visAlumno.txtRut.setBackground(Color.red);
                this.visPrincipal.lblInformacion.setText("Ingrese el Rut del Alumno");
            }else{
                this.visAlumno.txtRut.setBackground(Color.white);
                a.setPerRut(this.visAlumno.txtRut.getText());
                int cantidadRegistro = this.modAlumno.listar().size();
                for (int i = 0; i < cantidadRegistro; i++) {
                    if(a.equals(modAlumno.listar().get(i))){
                        try{
                            bandera=modAlumno.eliminar(a);
                            if(bandera){
                                bandera=modPersona.eliminar(a);
                                if(bandera){
                                    JOptionPane.showMessageDialog(visAlumno, "Se ha eliminado Correctamente");
                                }
                            }
                        }catch(Exception ex){
                            this.visPrincipal.lblInformacion.setText( "Hubo un Error cod."+ex.toString());
                            System.out.println("Hubo un Error al Eliminar cod."+ex.toString());
                        }finally{
                            this.botonDeseleccionar();
                            tablaAlumno(this.visAlumno.tblVisualizar);
                        }
                    }
                }
                if(!bandera){
                    JOptionPane.showMessageDialog(this.visAlumno, "Alumno No pudo ser eliminado");
                    this.visPrincipal.lblInformacion.setText("Alumno No pudo ser eliminado");
                }
            }
        }
       
                
        
        if(e.getSource()==this.visAlumno.btnSeleccionar){
            if(this.visAlumno.btnSeleccionar.isSelected()){
                Alumno a = new Alumno();
                int seleccionFila;
                try{
                    seleccionFila = this.visAlumno.tblVisualizar.getSelectedRow();
                    if (seleccionFila == -1){
                        this.visPrincipal.lblInformacion.setText("Seleccione una Fila");
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
                        this.visAlumno.btnSeleccionar.setText("Seleccionar");
                        this.visAlumno.btnSeleccionar.setSelected(false);
                    }else{
                        DefaultTableModel modTabla=(DefaultTableModel) this.visAlumno.tblVisualizar.getModel();
                        //temp.setPerRut((String)modTabla.getValueAt(seleccionFila, 0));
                        a.setPerRut((String)modTabla.getValueAt(seleccionFila, 0));
                        a = modAlumno.buscar(a);
                        this.visAlumno.txtRut.setText(a.getPerRut());
                        this.visAlumno.txtNombre.setText(modPersona.buscar(a).getPerNombre());
                        this.visAlumno.txtApePaterno.setText(modPersona.buscar(a).getPerApellidoPaterno());
                        this.visAlumno.txtApeMaterno.setText(modPersona.buscar(a).getPerApellidoMaterno());
                        ArrayList<EstadoAlumno> estados= modEstadoAlumno.listar();
                        int cantidadEstados = estados.size();
                        for (int i = 0; i < cantidadEstados; i++) {
                            if(estados.get(i).equals(new EstadoAlumno(a.getEstAluCodigo(), null))){
                                this.visAlumno.cbbEstado.setSelectedIndex(i);
                            }
                        }
                        ArrayList<Carrera> carrera= modCarrera.listar();
                        int cantidadCarrera = carrera.size();
                        for (int i = 0; i < cantidadCarrera; i++) {
                            if(carrera.get(i).equals(new Carrera(a.getCarCodigo(), null))){
                                this.visAlumno.cbbCarrera.setSelectedIndex(i+1);
                            }
                        }   
                        this.visAlumno.btnSeleccionar.setText("Deseleccionar");
                        this.visAlumno.btnSeleccionar.setSelected(true);
                        this.visAlumno.txtRut.setEditable(false);
                        this.visAlumno.btnRegistrar.setEnabled(false);
                        this.visAlumno.btnActualizar.setEnabled(true);
                        this.visAlumno.btnEliminar.setEnabled(true);
                    }
                }catch(Exception ex){
                    System.out.println("ERROR AL SACAR DATOS DE LA TABLA"+ ex.toString());
                    this.visPrincipal.lblInformacion.setText("No se pudo Seleccionar toda la informacion");
                }
            }else{
                this.botonDeseleccionar();
            }
        }
        
        if(e.getSource()==this.visAlumno.btnRegistrar){
            boolean bandera=false;
            boolean resultado=false;
            Alumno a = new Alumno();
            Carrera c = new Carrera();
            EstadoAlumno ea = new EstadoAlumno();  
            
            a.setPerRut(this.visAlumno.txtRut.getText());
            int cantidadRegistro = this.modAlumno.listar().size();
            for (int i = 0; i < cantidadRegistro; i++) {
                if(a.equals(modAlumno.listar().get(i))){
                    bandera = true;
                }
            }
            a.setPerNombre(this.visAlumno.txtNombre.getText());
            a.setPerApellidoPaterno(this.visAlumno.txtApePaterno.getText());
            a.setPerApellidoMaterno(this.visAlumno.txtApeMaterno.getText());
            c.setCarNombre((String)this.visAlumno.cbbCarrera.getSelectedItem());
            ea.setEstAluDescripcion((String)this.visAlumno.cbbEstado.getSelectedItem());
            if(!a.getPerRut().equals("")&&
                    !a.getPerNombre().equals("")&&
                    !a.getPerApellidoPaterno().equals("")&&
                  //  !a.getPerApellidoMaterno().equals("")&&
                    !c.getCarNombre().equals("")&&
                    !ea.getEstAluDescripcion().equals("")&&
                    !bandera){
                try{
                    a.setCarCodigo(modCarrera.buscar(c).getCarCodigo());
                    a.setEstAluCodigo(modEstadoAlumno.buscar(ea).getEstAluCodigo());
                    resultado = modPersona.ingresar(a);
                    if(resultado){   
                        resultado=modAlumno.ingresar(a);
                        if(resultado){
                            this.visPrincipal.lblInformacion.setText("El Alumno ha sido registrado satisfactoriamente");
                            limpiar();
                        }else{
                            JOptionPane.showMessageDialog(visAlumno, "Hubo un error al Ingresar al Alumno, No se pudo terminar el ingreso");
                            this.visPrincipal.lblInformacion.setText("No se pudo agregar al Alumno");
                            resultado=modPersona.eliminar(a);
                            if(resultado){
                                System.out.println("Se ha Eliminado a la Persona");
                            }else{
                                System.out.println("No se pudo eliminar a la Persona");
                            }
                            System.out.println(a.toString());   //Imprimir Objeto
                        }
                    }else{
                        JOptionPane.showMessageDialog(visAlumno, "No se pudo agregar al Alumno");  
                        this.visPrincipal.lblInformacion.setText("No se pudo agregar a la persona");
                    }                    
                }catch(Exception ex){
                    this.visPrincipal.lblInformacion.setText( "Hubo un Error cod."+ex.toString());
                    System.out.println("Hubo un Error al Registrar cod."+ex.toString());
                }finally{
                    tablaAlumno(this.visAlumno.tblVisualizar);
                }
            }else{
                if(this.visAlumno.txtRut.getText().isEmpty()){
                    this.visAlumno.txtRut.setBackground(Color.red);
                }else{
                    this.visAlumno.txtRut.setBackground(Color.white);
                }
                if(this.visAlumno.txtNombre.getText().isEmpty()){
                    this.visAlumno.txtNombre.setBackground(Color.red);
                }else{
                    this.visAlumno.txtNombre.setBackground(Color.white);
                }
                if(this.visAlumno.txtApePaterno.getText().isEmpty()){
                    this.visAlumno.txtApePaterno.setBackground(Color.red);
                }else{
                    this.visAlumno.txtApePaterno.setBackground(Color.white);
                }
                this.visPrincipal.lblInformacion.setText("Ingrese valor (es)");
                if(bandera){
                    JOptionPane.showMessageDialog(this.visAlumno, "El alumno ya existe en la Base de Datos");
                    this.visPrincipal.lblInformacion.setText("Alumno ya ingresado anteriormente");
                }
            }
        }
    }
}
