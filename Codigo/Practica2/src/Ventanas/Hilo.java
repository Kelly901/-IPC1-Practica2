/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import static Ventanas.Seleccionar.cont;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kelly
 */
public class Hilo implements Runnable{
    int contador;
    int bubleCont;
    JLabel label;
    JLabel mili;
    JLabel minutos;
    Tiempo t;
    static boolean bandera;
  public Hilo(int contador, JLabel label,JLabel mili,JLabel minutos){
      this.contador=contador;
      this.label=label;
      this.mili=mili;
      this.minutos=minutos;
       t=new Tiempo(this.label,this.mili,minutos);
                Thread hilo= new Thread(t);
                 bandera=true;
                hilo.start();
  }
  
   public ImageIcon agregarDimensionesDeImagenP(int ancho,int alto,String direccion){
        ImageIcon x= new ImageIcon(direccion);
        ImageIcon y= new ImageIcon(x.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return y;
        
    }
  
    @Override
    public void run() {
        int i=0;
        Tiempo ti= new Tiempo();
        
       
        
        while (true) {
         
                Thread hilo= new Thread(ti);
             
          
               Opciones.principal.setIcon(agregarDimensionesDeImagenP(600, 500, "grafica"+i+".jpg"));
                Opciones.pasos.setText("Pasos: "+String.valueOf(Seleccionar.bubbleCont));
             Seleccionar.bubbleCont++;
                 i++;  
            try {
                if (i==this.contador) {
                    hilo.suspend();
                    bandera=false;
                    grafica();
                    System.out.println("finalizado");
                      Reportes .crearReporte(Reportes.reporte());
                  Opciones.principal.setIcon(agregarDimensionesDeImagenP(600, 500, "graficaOrdenada.jpg"));
                      JOptionPane.showMessageDialog(null, "Datos ordenados. \n Reporte generado.");
                   break;
                }
               
                
            Thread.sleep(Seleccionar.velocida);
             
            } catch (InterruptedException ex) {
              
            } catch (IOException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
     public static void grafica() throws IOException{
           Datos arreglo2 []=GuardarDato.ordenada; 
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        for (int i = 0; i < arreglo2.length; i++) {
            
            data.addValue(arreglo2[i].getCount(), arreglo2[i].getUfoShape(),"");
            
           
        }
         JFreeChart chart= ChartFactory.createBarChart(
                    VentanaPrincipal.tituloO, 
                    VentanaPrincipal.tituloX,
                    VentanaPrincipal.tituloY, 
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
         int ancho=600;
         int alto=500;
         String graf="graficaOrdenada.jpg";
         File BarChart = new File(graf);
         ChartUtilities.saveChartAsJPEG(BarChart, chart, ancho, alto);
        
    }
    
    
}
