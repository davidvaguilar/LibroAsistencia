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
import modelo.Alumno;

/**
 *
 * @author David
 */
public class AlumnoDAO implements InterfazDAO<Alumno>{
    private static final String SQL_INGRESAR=
            "INSERT INTO Alumno(perRut, carCodigo, estAluCodigo) "
            + "VALUES (?, ?, ?)";
    private static final String SQL_ACTUALIZAR=
            "UPDATE FROM Alumno "
            + "SET carCodigo = ?, estAluCodigo = ? WHERE perRut = ?";
    private static final String SQL_ELIMINAR=
            "DELETE FROM Alumno WHERE perRut = ?";
    private static final String SQL_BUSCAR= 
            "SELECT * FROM Alumno WHERE perRut = ?";
    private static final String SQL_LISTAR=
            "SELECT * FROM Alumno";
  
    private static final Conexion cnn=Conexion.saberEstado();
    
    @Override
    public boolean ingresar(Alumno x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setString(1, x.getPerRut());
            ps.setString(2, x.getCarCodigo());
            ps.setString(3, x.getEstAluCodigo());
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
    public boolean actualizar(Alumno x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1,x.getCarCodigo());
            ps.setString(2,x.getEstAluCodigo());
            ps.setString(3, x.getPerRut());
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
            ps=cnn.getCnn().prepareStatement(SQL_ELIMINAR);
            ps.setString(1, (String)llave);
            bandera=ps.executeUpdate();
            if(bandera>0){
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
    public Alumno buscar(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        Alumno a = null;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setString(1, (String)llave);
            rs=ps.executeQuery();
            while(rs.next()){
                a=new Alumno(rs.getString("perRut"),rs.getString("carCodigo"),rs.getString("estAluCodigo"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return a;    
    }

    @Override
    public ArrayList<Alumno> listar() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Alumno> alumnos= new ArrayList();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                alumnos.add(
                        new Alumno(rs.getString("perRut"),
                                rs.getString("carCodigo"),
                                rs.getString("estAluCodigo"))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return alumnos;   
    }
    
}
