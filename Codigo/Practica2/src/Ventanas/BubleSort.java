/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kelly
 */
public class BubleSort {

    Datos arreglo[] = GuardarDato.dato2;
    Datos arreglo3[] = GuardarDato.dato3;

    public void bublesSort(JLabel label, JLabel label2, JLabel minutos) throws IOException {
        int v = arreglo.length;
        Seleccionar.cont = 0;
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v - i - 1; j++) {
                if (arreglo[j].getCount() > arreglo[j + 1].getCount()) {

                    Datos temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    System.out.println("-----");
                    grafica(Seleccionar.cont, arreglo);
                    Seleccionar.cont++;

                }

            }

        }
        
        //Dato menor
        
        //DATO MAYOR
        Seleccionar.mayor = arreglo[arreglo.length - 1].getUfoShape();
        Seleccionar.mayorN = String.valueOf(arreglo[arreglo.length - 1].getCount());
        GuardarDato.ordenada = arreglo;
        Seleccionar.menor=arreglo[0].getUfoShape();
        Seleccionar.menorN=String.valueOf(arreglo[0].getCount());
        //LLamar al hilo
        Hilo nuev = new Hilo(Seleccionar.cont, label, label2, minutos);
        Thread hilo = new Thread(nuev);
        hilo.start();

    }

    public void metodo() {

    }

    //Bubble sort Descendente
    public void BubbleSortDescendente(JLabel label, JLabel label2, JLabel minutos) throws IOException {
        int v = arreglo3.length;
        Seleccionar.cont = 1;
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v - i - 1; j++) {
                if (arreglo3[j + 1].getCount() > arreglo3[j].getCount()) {

                    Datos temp = arreglo3[j + 1];
                    arreglo3[j + 1] = arreglo3[j];
                    arreglo3[j] = temp;
                    System.out.println("-----");
                    grafica(Seleccionar.cont, arreglo3);
                     Seleccionar.cont++;

                }

            }

        }
        GuardarDato.ordenada = arreglo;
        //Dato menor
        Seleccionar.mayor=arreglo3[0].getUfoShape();
            Seleccionar.mayorN=String.valueOf(arreglo3[0].getCount());
        //Dato mayor
        Seleccionar.menor = arreglo3[arreglo3.length- 1].getUfoShape();
        Seleccionar.menorN = String.valueOf(arreglo3[arreglo3.length - 1].getCount());
        //
        Hilo nuev = new Hilo(Seleccionar.cont, label, label2, minutos);
        Thread hilo = new Thread(nuev);
        hilo.start();
    }

    //Crar grafica como imagenes
    public void grafica(int contador, Datos[] arreglo) throws IOException {

        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 0; i < arreglo.length; i++) {

            data.addValue(arreglo[i].getCount(), arreglo[i].getUfoShape(), "");

        }
        JFreeChart chart = ChartFactory.createBarChart(
                VentanaPrincipal.tituloO,
                VentanaPrincipal.tituloX,
                VentanaPrincipal.tituloY,
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        int ancho = 600;
        int alto = 500;
        String graf = "grafica" + contador + ".jpg";
        File BarChart = new File(graf);
        ChartUtilities.saveChartAsJPEG(BarChart, chart, ancho, alto);

    }

}
