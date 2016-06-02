/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
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
        cantidadRegistro=this.modAlumno.listar().size();
        
            for (int i = (cantidadRegistro-1); i >= 0; i--) {
                columna[0]= this.modAlumno.listar().get(i).getPerRut();
                p = modPersona.buscar(columna[0]);
                columna[1]= p.getPerNombre();
                columna[2]= p.getPerApellidoPaterno();
                columna[3]= this.modAlumno.listar().get(i).getEstAluCodigo();
                columna[4]= this.modAlumno.listar().get(i).getCarCodigo();
                modTabla.addRow(columna);
            }
    }
    
    public void comboCarrera(JComboBox cbbCarrera){
        cbbCarrera.removeAllItems();
        int cantidadRegistro = this.modCarrera.listar().size();
        cbbCarrera.addItem("Seleccione :");
        for (int i = 0; i < cantidadRegistro; i++) {
            cbbCarrera.addItem(modCarrera.listar().get(i).getCarNombre());
        }
    }
    
    public void comboEstadoAlumno(JComboBox cbbEstado){
        cbbEstado.removeAllItems();
        cbbEstado.addItem("Seleccione :");
        int cantidadRegistro = this.modEstadoAlumno.listar().size();
        for (int i = 0; i < cantidadRegistro; i++) {
            cbbEstado.addItem(modEstadoAlumno.listar().get(i).getEstAluDescripcion());
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
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.visAlumno.btnRegistrar){
            String rut, nombre, apePaterno, apeMaterno,carrera, estado;
            boolean bandera;
            Alumno a;
            Persona p;
            rut=this.visAlumno.txtRut.getText();
            nombre = this.visAlumno.txtNombre.getText();
            apePaterno=this.visAlumno.txtApePaterno.getText();
            apeMaterno=this.visAlumno.txtApeMaterno.getText();
            carrera=(String)this.visAlumno.cbbCarrera.getSelectedItem();
            estado=(String)this.visAlumno.cbbEstado.getSelectedItem();
            if(!rut.equals("")&&!nombre.equals("")&&!apePaterno.equals("")){
                try{
                    p=new Persona(rut, nombre, apePaterno, apeMaterno);
                    bandera=modPersona.ingresar(p);
                    if(bandera){                        
                        a=new Alumno(carrera, estado, rut, nombre, apePaterno, apeMaterno);
                        bandera=modAlumno.ingresar(a);
                        if(bandera){
                            this.visPrincipal.lblInformacion.setText("El Alumno ha sido registrado satisfactoriamente");
                            limpiar();
                        }else{
                            JOptionPane.showMessageDialog(visAlumno, "Hubo un error al Ingresar al Alumno, No se pudo terminar el ingreso");
                        }
                    }else{
                        JOptionPane.showMessageDialog(visAlumno, "No se pudo agregar al Alumno");                    
                    }                    
                }catch(Exception ex){
                    this.visPrincipal.lblInformacion.setText( "Hubo un Error del Sistema cod."+ex.toString());
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
            }
        }
    }
}
