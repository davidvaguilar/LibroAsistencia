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
import javax.swing.JOptionPane;
import modelo.Usuario;
import modeloDAO.UsuarioDAO;
import vista.Login;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlLogin implements ActionListener{
    private Login visLogin;
    private UsuarioDAO modUsuario;

    public ControlLogin(Login vLogin, UsuarioDAO mUsuario) {
        this.visLogin = vLogin;
        this.modUsuario = mUsuario;
        this.visLogin.setVisible(true);
        this.visLogin.btnIngresar.addActionListener(this);

        
    }
    
    public void limpiar(){
        visLogin.txtAlias.setText("");
        visLogin.txtPassword.setText("");
        visLogin.txtAlias.setBackground(Color.WHITE);
        visLogin.txtPassword.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.visLogin.btnIngresar){
            ArrayList<Usuario> usuarios=new ArrayList();
            String alias,pass, tipo;
            Usuario u;
            boolean bandera=false;
            
            alias = this.visLogin.txtAlias.getText();
            pass = new String(this.visLogin.txtPassword.getPassword());
            tipo = this.visLogin.cbbTipo.getSelectedItem().toString();
            
            if(!alias.isEmpty()&&
                    !pass.isEmpty()){
                u=new Usuario(alias, pass, tipo);
                usuarios=modUsuario.listar();
                for (int i = 0; i < usuarios.size(); i++) {
                    if(u.equals(usuarios.get(i))){
                        this.visLogin.dispose();
                        this.modUsuario=null;
                        bandera=true;
                        Principal vPrincipal=new Principal();
                        ControlPrincipal controlPri=new ControlPrincipal(vPrincipal, u);
                        
                    }
                }
                if(!bandera){
                    JOptionPane.showMessageDialog(this.visLogin, "Su usuario o Password no son Correctos");
                }
                
            }else{
                if(alias.isEmpty()){
                    visLogin.txtAlias.setBackground(Color.red);
                }else{
                    visLogin.txtAlias.setBackground(Color.white);
                }
                if(pass.isEmpty()){
                    visLogin.txtPassword.setBackground(Color.red);
                }else{
                    visLogin.txtPassword.setBackground(Color.white);
                }
                visLogin.lblInformacion.setText("Ingrese valor (es)");
            }
        }
    }
}
