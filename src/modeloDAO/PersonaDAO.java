/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import controlador.Conexion;
import interfaz.InterfazDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author David
 */
public class PersonaDAO implements InterfazDAO<Persona>{

    private static final String SQL_INGRESAR=
            "INSERT INTO Persona(perRut, perNombre, perApellidoPaterno,perApellidoMaterno) "
            + "VALUES (?, ?, ?, ?)";
    private static final String SQL_ACTUALIZAR=
            "UPDATE FROM Persona "
            + "SET perNombre = ?, perApellidoPaterno = ?, perApellidoMaterno = ?  WHERE perRut = ?";
    private static final String SQL_ELIMINAR=
            "DELETE FROM Persona WHERE perRut = ?";
    private static final String SQL_BUSCAR= 
            "SELECT * FROM Persona WHERE perRut = ? OR perNombre = ? "
            + "OR perApellidoPaterno = ? OR perApellidoMaterno = ?";
    private static final String SQL_LISTAR=
            "SELECT * FROM Persona";
    
    private static final Conexion cnn=Conexion.saberEstado();
  
    @Override
    public boolean ingresar(Persona x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setString(1, x.getPerRut());
            ps.setString(2, x.getPerNombre());
            ps.setString(3, x.getPerApellidoPaterno());
            ps.setString(4, x.getPerApellidoMaterno());
            bandera=ps.executeUpdate();
            if(bandera > 0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean actualizar(Persona x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1,x.getPerNombre());
            ps.setString(2,x.getPerApellidoPaterno());
            ps.setString(3, x.getPerApellidoMaterno());
            ps.setString(4, x.getPerRut());
            bandera=ps.executeUpdate();
            if(bandera>0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean eliminar(Persona x) {
        PreparedStatement ps;
        int bandera;
        try{
            ps=cnn.getCnn().prepareStatement(SQL_ELIMINAR);
            ps.setString(1, x.getPerRut());
            bandera=ps.executeUpdate();
            if(bandera>0){
                return true;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Persona buscar(Persona x) {
        PreparedStatement ps;
        ResultSet rs;
        Persona p=null;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setString(1, x.getPerRut());
            ps.setString(2, x.getPerNombre());
            ps.setString(3, x.getPerApellidoPaterno());
            ps.setString(4, x.getPerApellidoMaterno());
            rs=ps.executeQuery();
            while(rs.next()){
                p=new Persona(rs.getString("perRut"),rs.getString("perNombre"),rs.getString("perApellidoPaterno"),rs.getString("perApellidoMaterno"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return p;
    }

    @Override
    public ArrayList<Persona> listar() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Persona> personas= new ArrayList();
        try {
            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while(rs.next()){
                personas.add(
                        new Persona(rs.getString("perRut"),
                                rs.getString("perNombre"),
                                rs.getString("perApellidoPaterno"),
                                rs.getString("perApellidoMaterno")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personas;
    }
    
}
