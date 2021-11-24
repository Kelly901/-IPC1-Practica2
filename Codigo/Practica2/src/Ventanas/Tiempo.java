/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Kelly
 */
public class Tiempo implements Runnable{
     int contador;
    JLabel label;
    JLabel mili;
    JLabel minutos;
   int segundos;
   public static String tiempo;
   public static String tiempo2;
   public static String tiempo3="00";
   public Tiempo(){
       
   }
    public Tiempo(JLabel label, JLabel mili,JLabel minutos) {
        this.label = label;
        this.mili = mili;
        this.minutos=minutos;
       
    }

    @Override
    public void run() {
        int i=0;
        segundos=0;
        int minutos1=0;
        int milisegundos=0;
       while(Hilo.bandera){
           
            try {
                Thread.sleep(10);
                 milisegundos+=10;
                 tiempo=String.valueOf(milisegundos);
                if (milisegundos==1000) {
                    
                    
                    
//                    minutos=minutos+1;
                    milisegundos=0;
                    segundos++;
                    this.mili.setText(":"+String.valueOf(segundos));
                    tiempo2=String.valueOf(segundos);
                } 
                if (segundos==59) {
                    segundos=0;
                    minutos1++;
                    System.out.println("minutos");
                    Opciones.minutos.setText(":"+String.valueOf(minutos1));
                    tiempo3=String.valueOf(minutos1);
                    
                }
               
//                   if (minutos==60) {
//                     minutos=0;
//                }
 
               
                this.label.setText(String.valueOf(":"+milisegundos));
                
                
            } catch (InterruptedException ex) {
                
            }
       }
    }
}
