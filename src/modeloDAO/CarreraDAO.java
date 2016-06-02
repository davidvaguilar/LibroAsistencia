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
import modelo.Carrera;

/**
 *
 * @author David
 */
public class CarreraDAO implements InterfazDAO<Carrera>{
    private static final String SQL_INGRESAR=
            "INSERT INTO Carrera(carCodigo, carNombre) "
            + "VALUES (?, ?)";
    private static final String SQL_ACTUALIZAR=
            "UPDATE FROM Carrera "
            + "SET carNombre = ? WHERE carCodigo = ?";
    private static final String SQL_ELIMINAR=
            "DELETE FROM Carrera WHERE carCodigo = ?";
    private static final String SQL_BUSCAR= 
            "SELECT * FROM Carrera WHERE carCodigo = ?";
    private static final String SQL_LISTAR=
            "SELECT * FROM Carrera";    

    private static final Conexion cnn=Conexion.saberEstado();
    
    @Override
    public boolean ingresar(Carrera x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setString(1, x.getCarCodigo());
            ps.setString(2, x.getCarNombre());
            bandera=ps.executeUpdate();
            if(bandera > 0){
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
    public boolean actualizar(Carrera x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1,x.getCarNombre());
            ps.setString(2,x.getCarCodigo());
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
    public boolean eliminar(Object llave) {
        PreparedStatement ps;
        int bandera;
        try{
            ps = cnn.getCnn().prepareStatement(SQL_ELIMINAR);
            ps.setString(1, (String)llave);
            bandera = ps.executeUpdate();
            if(bandera > 0){
                return true;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
            return false;    
    }

    @Override
    public Carrera buscar(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        Carrera c = null;
            try {
            ps=cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setInt(1, (Integer)llave);
            rs=ps.executeQuery();
            while(rs.next()){
                c = new Carrera(rs.getString("carCodigo"),rs.getString("carNombre"));
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                cnn.cerrarConexion();
            }
        return c;        }

    @Override
    public ArrayList<Carrera> listar() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Carrera> carreras= new ArrayList();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                carreras.add(
                        new Carrera(rs.getString("carCodigo"),
                                rs.getString("carNombre"))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return carreras;   
    }
}
