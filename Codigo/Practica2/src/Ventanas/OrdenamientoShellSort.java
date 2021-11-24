/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kelly
 */
public class OrdenamientoShellSort {
    
   
     public  void shellSort1(Datos [] arreglo,JLabel label1,JLabel label2,JLabel label3) throws IOException{
         Seleccionar.cont=0;
           int salto,i,j,k;
           Datos auxiliar;
           salto=arreglo.length/2;
           while(salto>0){
               for ( i = salto; i < arreglo.length; i++) {
                   j=i-salto;
                   while (j>=0) {
                      k=j+salto;
                      
                       if (arreglo[j].getCount()<=arreglo[k].getCount()) {
                           j=-1;
                       }else{
                           auxiliar=arreglo[j];
                           arreglo[j]=arreglo[k];
                           arreglo[k]=auxiliar;
                           j=j-salto;
                            
                            grafica(Seleccionar.cont,arreglo);
                            Seleccionar.cont++;
                       }
                      
                   }
               }
                 
                salto=salto/2;
           }
           //
            GuardarDato.ordenada=arreglo;
            
            //Dato mayor
             Seleccionar.mayor=arreglo[arreglo.length-1].getUfoShape();
            Seleccionar.mayorN=String.valueOf(arreglo[arreglo.length-1].getCount());
            //
            //Dato menor
                 Seleccionar.menor=arreglo[0].getUfoShape();
            Seleccionar.menorN=String.valueOf(arreglo[0].getCount());
          //Hilo
           Hilo nuev= new Hilo(Seleccionar.cont, label1,label2,label2);
        Thread hilo= new Thread(nuev);
        hilo.start();
           
       }
     //Shell Sort descendiente
     public  void shellSort1Desc(Datos [] arreglo,JLabel label,JLabel label2,JLabel label3) throws IOException{
         Seleccionar.cont=0;
           int salto,i,j,k;
           Datos auxiliar;
           salto=arreglo.length/2;
           while(salto>0){
               for ( i = salto; i < arreglo.length; i++) {
                   j=i-salto;
                   while (j>=0) {
                      k=j+salto;
                      
                       if (arreglo[j].getCount()>=arreglo[k].getCount()) {
                           j=-1;
                       }else{
                           auxiliar=arreglo[j];
                           arreglo[j]=arreglo[k];
                           arreglo[k]=auxiliar;
                           j=j-salto;
                          
                            grafica(Seleccionar.cont, arreglo);
                            Seleccionar.cont++;
                       }
                      
                   }
               }
                 
                salto=salto/2;
           }
           GuardarDato.ordenada=arreglo;
           System.out.println("arrreglo ordenado ");
           //Dato menor
           Seleccionar.mayor=arreglo[0].getUfoShape();
            Seleccionar.mayorN=String.valueOf(arreglo[0].getCount());
           //DATO mayor
                Seleccionar.menor=arreglo[arreglo.length-1].getUfoShape();
            Seleccionar.menorN=String.valueOf(arreglo[arreglo.length-1].getCount());
           //Hilo
             Hilo nuev= new Hilo(Seleccionar.cont, label,label2,label2);
        Thread hilo= new Thread(nuev);
        hilo.start();
           
       }

     //Metodo para crar imganes de la grafica segun un contador
     public void grafica(int contador,Datos [] arreglo) throws IOException{
          
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        for (int i = 0; i < arreglo.length; i++) {
            
            data.addValue(arreglo[i].getCount(), arreglo[i].getUfoShape(), "");
            
           
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
         String graf="grafica"+contador+".jpg";
         File BarChart = new File(graf);
         ChartUtilities.saveChartAsJPEG(BarChart, chart, ancho, alto);
        
    }
    
    
     
    
}
