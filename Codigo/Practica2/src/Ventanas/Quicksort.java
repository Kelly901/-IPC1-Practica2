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
public class Quicksort {

         Datos quickA[]= GuardarDato.dato4;
         Datos quickB[]= GuardarDato.dato5;
    JLabel label;
    JLabel label2;
    JLabel minutos;
    int contador;

    
//    public Quicksort(JLabel label,JLabel label2,JLabel minutos) throws IOException {
//        this.label=label;
//        this.label2=label2;
//        this.minutos=minutos;
//        
//        
//    }

    //Metodo de ordenamiento Quicksort
    public void iniciarContador(){
        contador=0;

         Seleccionar.cont=contador;
               
    }
    public void ordenarQuickSort(int inferior, int superior) throws IOException {
        
        if (superior == -1) {
            superior = 0;
        }
        double piv = quickA[superior].getCount();

        int i = inferior;
        int j = superior - 1;
        int contador = 1;
        Datos aux;
        if (inferior >= superior) {

        } else {
            while (contador == 1) {

                while (quickA[i].getCount() < piv) {

                    i++;

                }
                while (quickA[j].getCount() > piv && j > 0) {
                    j--;

                }
               
                grafica(Seleccionar.cont,quickA);
                Seleccionar.cont++;
                if (i < j) {
                    aux = quickA[i];
                    quickA[i] = quickA[j];
                    quickA[j] = aux;
                    
                } else {
                    contador = 0;
                }
                 
            }

            aux = quickA[i];
            quickA[i] = quickA[superior];
            quickA[superior] = aux;
            ordenarQuickSort(inferior, i - 1);
            ordenarQuickSort(i + 1, superior);
        }
       
    }
    
    //Metodo quicksort descendente
    public void ordenarQuickSortDescendente(Datos [] arrreglo,int inferior, int superior) throws IOException {
      
       if (superior == -1) {
            superior = 0;
        }
    
        double piv = quickB[superior].getCount();

        int i = inferior;
        int j = superior - 1;
        int contador =1;
        Datos aux;
          
        if (inferior >=superior) {

        } else {
           
            while (contador == 1) {
              
                while (quickB[i].getCount() > piv) {

                    i++;
  
                }
                
                while (quickB[j].getCount() <piv && j > 0) {
                    j--;

                }
               
                
                 grafica(Seleccionar.cont,quickB);
                 Seleccionar.cont++;
                if (i < j) {
                    aux = quickB[i];
                   quickB[i] = quickB[j];
                    quickB[j] = aux;
                  
                  
                
                } else {
                    contador = 0;
                }
                 
            }
                 
            aux = quickB[i];
            quickB[i] = quickB[superior];
            quickB[superior] = aux;
            
            ordenarQuickSortDescendente(arrreglo, inferior, i-1);
            
            ordenarQuickSortDescendente(arrreglo, i+1, superior);
            
//            grafica(Seleccionar.cont);
//            Seleccionar.cont++;
        }
            
        
       
    }
        
    //Crear graficas
     public void grafica(int contador,Datos []arreglo) throws IOException{
          
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        for (int i = 0; i < arreglo.length; i++) {
            
            data.addValue(arreglo[i].getCount(), arreglo[i].getUfoShape(),"");
            
           
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
      
    //Mostrar en conso89la
    public void mostrar(Datos []arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i].imprimir();
        }
        System.out.println("-----------------");
    }
            
}
