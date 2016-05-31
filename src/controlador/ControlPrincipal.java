/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;
import vista.FichaAlumno;
import vista.Principal;

/**
 *
 * @author David
 */
public class ControlPrincipal {
    private Principal visPrincipal;
    private Usuario u;

    public ControlPrincipal(Principal vPrincipal, Usuario u) {
        this.visPrincipal = vPrincipal;
        this.u = u;
        this.visPrincipal.setVisible(true);
        FichaAlumno visAlumno= new FichaAlumno();
        this.visPrincipal.dskEscritorio.add(visAlumno);
        visAlumno.setVisible(true);
    }
    
    
    
}
