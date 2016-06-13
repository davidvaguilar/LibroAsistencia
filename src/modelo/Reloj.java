/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class Reloj extends Thread{
    private JLabel lbl;

    public Reloj (JLabel lbl){
        this.lbl=lbl;
    }        
            
    @Override
    public void run() {
        while(true){
            Date hoy = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
            lbl.setText(s.format(hoy));
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error en el Reloj "+ex.toString());
            }
        }
    }
}
