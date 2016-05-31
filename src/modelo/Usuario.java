/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Usuario {
    private String usuAlias;
    private String usuPassword;
    private String usuTipo;

    public Usuario(String alias, String pass, String tipo) {
        this.usuAlias = alias;
        this.usuPassword = pass;
        this.usuTipo=tipo;
    }

    public String getUsuAlias() {
        return usuAlias;
    }

    //No se puede modificar el alias
    private void setUsuAlias(String usuAlias) {
        this.usuAlias = usuAlias;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    @Override
    public String toString() {
        return ("El usuario contiene: \n"+
                "Alias : "+this.usuAlias+"\n"+
                "Password : "+this.usuPassword+"\n"+
                "Tipo :"+this.usuTipo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.usuAlias);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuAlias, other.usuAlias)) {
            return false;
        }
        if (!Objects.equals(this.usuPassword, other.usuPassword)) {
            return false;
        }
        if (!Objects.equals(this.usuTipo, other.usuTipo)) {
            return false;
        }
        return true;
    }



    
    
    
    
}
