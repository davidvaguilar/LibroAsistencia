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
import modelo.EstadoAlumno;

/**
 *
 * @author David
 */
public class EstadoAlumnoDAO implements InterfazDAO<EstadoAlumno>{
    private static final String SQL_INGRESAR=
            "INSERT INTO EstadoAlumno(estAluCodigo, estAluDescripcion) "
            + "VALUES (?, ?)";
    private static final String SQL_ACTUALIZAR=
            "UPDATE FROM EstadoAlumno "
            + "SET estAluDescripcion = ? WHERE estAluCodigo = ?";
    private static final String SQL_ELIMINAR=
            "DELETE FROM EstadoAlumno WHERE estAluCodigo = ?";
    private static final String SQL_BUSCAR= 
            "SELECT * FROM EstadoAlumno WHERE estAluCodigo = ?";
    private static final String SQL_LISTAR=
            "SELECT * FROM EstadoAlumno";
    
    private static final Conexion cnn=Conexion.saberEstado();

    @Override
    public boolean ingresar(EstadoAlumno x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_INGRESAR);
            ps.setString(1, x.getEstAluCodigo());
            ps.setString(2, x.getEstAluDescripcion());
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
    public boolean actualizar(EstadoAlumno x) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR);
            ps.setString(1,x.getEstAluDescripcion());
            ps.setString(2,x.getEstAluCodigo());
            bandera = ps.executeUpdate();
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
            bandera = ps.executeUpdate();
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
    public EstadoAlumno buscar(Object llave) {
        PreparedStatement ps;
        ResultSet rs;
        EstadoAlumno ea = null;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setString(1, (String)llave);
            rs=ps.executeQuery();
            while(rs.next()){
                ea=new EstadoAlumno(rs.getString("estAluCodigo"),rs.getString("estAluDescripcion"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            cnn.cerrarConexion();
        }
        return ea;    
    }

    @Override
    public ArrayList<EstadoAlumno> listar() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<EstadoAlumno> estAlumnos= new ArrayList();
        try {
            ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
            rs = ps.executeQuery();
            while(rs.next()){
                estAlumnos.add(
                        new EstadoAlumno(rs.getString("estAluCodigo"),
                                rs.getString("estAluDescripcion"))
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estAlumnos;   
    }
}
