/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public ControlPrincipal(Principal vPrincipal, Usuario u) {
        this.visPrincipal = vPrincipal;
        this.u = u;
        this.visPrincipal.mniFichaAlumno.addActionListener(this);
        this.visPrincipal.setVisible(true);
        Reloj hilo=new Reloj(this.visPrincipal.lblHora);
        hilo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.visPrincipal.mniFichaAlumno){
            FichaAlumno vAlumno= new FichaAlumno();
            ControlAlumno cAlumno=new ControlAlumno(vAlumno,this.visPrincipal);
            visPrincipal.dskEscritorio.add(vAlumno);
            vAlumno.show();
        }
    }
    
    
    
    
}
