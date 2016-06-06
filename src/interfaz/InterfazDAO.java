/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public interface InterfazDAO <Algo> {
    public boolean ingresar (Algo x);
    public boolean actualizar (Algo x);
    public boolean eliminar (Algo x);
    public Algo buscar(Algo x);
    public ArrayList<Algo> listar();
}
