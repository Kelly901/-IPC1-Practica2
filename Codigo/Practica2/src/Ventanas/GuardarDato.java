/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author Kelly
 */
public class GuardarDato {
     public static Datos dato[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos dato2[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos dato3[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos dato4[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos dato5[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos dato6[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos dato7[] = new Datos[VentanaPrincipal.tamaño];
     public static Datos ordenada[] = new Datos[VentanaPrincipal.tamaño];
     
  
    public void guardarDatos(String nombres, double datosN){
          
        for (int i = 0; i < dato.length; i++) {
            if (dato[i]==null) {
                dato[i]= new Datos(nombres, datosN);
                dato2[i]= new Datos(nombres, datosN);
                dato3[i]= new Datos(nombres, datosN);
                dato4[i]= new Datos(nombres, datosN);
                dato5[i]= new Datos(nombres, datosN);
                dato6[i]= new Datos(nombres, datosN);
                dato7[i]= new Datos(nombres, datosN);
                
                
                break;
                        
            }
        }
      
    }
    

   
}
