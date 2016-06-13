/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Reloj;
import modelo.Usuario;
import vista.FichaAlumno;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlPrincipal implements ActionListener{
    private Principal visPrincipal;
    private Usuario u;
    
    FichaAlumno vAlumno;

    public ControlPrincipal(Principal vPrincipal, Usuario u) {
        this.visPrincipal = vPrincipal;
        this.u = u;
        this.visPrincipal.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.visPrincipal.mniFichaAlumno.addActionListener(this);
        this.visPrincipal.dskEscritorio.setBackground(Color.BLACK);
        this.visPrincipal.setVisible(true);
        Reloj hilo=new Reloj(this.visPrincipal.lblHora);
        hilo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.visPrincipal.mniFichaAlumno){
            
            if(vAlumno==null||vAlumno.isClosed()){   
                vAlumno= new FichaAlumno();
                vAlumno.setTitle("FICHA ALUMNO");
                new ControlAlumno(vAlumno,this.visPrincipal);
                visPrincipal.dskEscritorio.add(vAlumno);
                vAlumno.show();
            }else{
                JOptionPane.showMessageDialog(visPrincipal, "Ya tiene abierta esta ventana");

            }
        }
    }
    
    
    
    
}
