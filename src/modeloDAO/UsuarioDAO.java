/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import interfaz.InterfazDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author David
 */
public class UsuarioDAO implements InterfazDAO<Usuario>{

    private static final String URL= "usuario.csv";
    
    
    @Override
    public boolean ingresar(Usuario x) {
        File f;
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            f=new File(this.URL);
            if(f.exists()){
                fw=new FileWriter(f,true);
                bw=new BufferedWriter(fw);
                bw.newLine();
                bw.write(x.getUsuAlias());
                bw.write(";");
                bw.write(x.getUsuPassword());
                bw.write(";");
                bw.write(x.getUsuTipo());
            }else{            
                fw=new FileWriter(f);
                bw=new BufferedWriter(fw);
                bw.write("ALIAS;CONTRASEÑA;TIPO");
                bw.newLine();
                bw.write(x.getUsuAlias());
                bw.write(";");
                bw.write(x.getUsuPassword());
                bw.write(";");
                bw.write(x.getUsuTipo());
            }            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error al Cerrar al Archivo");
            }
        }
        return true;       
    }
    
    @Override
    public boolean actualizar(Usuario x) {
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public boolean eliminar(Usuario x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Usuario buscar(Usuario x) {
        File f;
        FileReader fr=null;
        BufferedReader br=null;
        String linea;
        String segmento[] = null;
        Usuario u=null;
        
        try{
            f = new File(this.URL);
            if(f.exists()){
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                br.readLine();
                linea = br.readLine();
                while(linea!=null){
                    segmento = linea.split(";");
                    if(segmento[0].equals(x.getUsuAlias())){
                        u=new Usuario(segmento[0], segmento[1],segmento[2]);
                    }
                    linea = br.readLine();
                }  
            }else{
                JOptionPane.showMessageDialog(null, "El Archivo no Existe");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;   
    }
    
    

    @Override
    public ArrayList<Usuario> listar() {
        File f;
        FileReader fr=null;
        BufferedReader br=null;
        String linea;
        String segmento[] = null;
        ArrayList<Usuario> usuarios = new ArrayList();
        
        try{
            f = new File(this.URL);
            if(f.exists()){
                fr = new FileReader(f);
                br = new BufferedReader(fr);
                br.readLine();
                linea = br.readLine();
                while(linea!=null){
                    segmento = linea.split(";");
                    usuarios.add(new Usuario(segmento[0], segmento[1],segmento[2]));
                    linea = br.readLine();
                }  
            }else{
                JOptionPane.showMessageDialog(null, "El Archivo no Existe");
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;        
    }



    
}
