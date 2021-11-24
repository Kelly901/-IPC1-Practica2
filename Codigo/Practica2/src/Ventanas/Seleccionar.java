/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kelly
 */
public class Seleccionar {
    public static int bubbleCont;
    public static int velocida;
    JRadioButton ascendente;
    JRadioButton descendete;
    JRadioButton baja;
    JRadioButton media;
    JRadioButton alta;
    JRadioButton bubble;
    JRadioButton quick;
    JRadioButton shell;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    public static String nombreAlgo;
    public static String velocidadA;
    public static String orden1;
       public static String mayor;
    public static String mayorN;
    public static String menor;
    public static String menorN;
      public static int cont;
    public static String quicks1;
    public Seleccionar(JRadioButton ascendente, JRadioButton descendete, JRadioButton baja, JRadioButton media, JRadioButton alta, JRadioButton bubble, JRadioButton quick, JRadioButton shell, JLabel label, JLabel label2, JLabel label3) throws IOException {
        this.ascendente = ascendente;
        this.descendete = descendete;
        this.baja = baja;
        this.media = media;
        this.alta = alta;
        this.bubble = bubble;
        this.quick = quick;
        this.shell = shell;
        this.label1 = label;
        this.label2 = label2;
        this.label3 = label3;

        seleccion();
    }

    public void seleccion() throws IOException {

        if (this.ascendente.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "Ascendente");
            orden1="Ascendente";
            ascendente();
          

        } else if (this.descendete.isSelected() == true) {
            orden1="Descendente";
            JOptionPane.showMessageDialog(null, "Descendente");
            descendete();
        }

    }

    //Velocida
    public void asignarVelocidad() {
        velocida = 0;
        if (this.baja.isSelected() == true) {
            velocida = 3000;
            Opciones.velocidad.setText("Velocidad: baja");
            velocidadA="Baja";
      
        } else if (this.media.isSelected() == true) {
            velocida = 2000;
            Opciones.velocidad.setText("Velocidad: media");
            velocidadA="Media";
           

        } else if (this.alta.isSelected() == true) {
            velocida = 1000;
            Opciones.velocidad.setText("Velocidad: Alta");
             velocidadA="Alta";
        }
    }

    //Ascendente
    public void ascendente() throws IOException {
          
        if (this.bubble.isSelected() == true) {
            bubbleCont=1;
            //Nombre
            Opciones.algoritmo.setText("Bubble Sort");
            nombreAlgo="Bubble Sort";
            //Velocidad
            Opciones.orden.setText("Orden: Ascendente");
            JOptionPane.showMessageDialog(null,"Algoritmo: "+"BubbleSort");
            //Llamar
            BubleSort sort = new BubleSort();
            sort.bublesSort(this.label1, this.label2, this.label3);
            asignarVelocidad();
              
        } else if (this.quick.isSelected() == true) {
            quicks1="quicksort";
            //Asignar nombre
               bubbleCont=1;
            Opciones.algoritmo.setText("QuickSort");
               Opciones.orden.setText("Orden: Ascendente");
               nombreAlgo="QuickSort"; 
               //Asignar velocidad
            asignarVelocidad();
            JOptionPane.showMessageDialog(null,"Algoritmo: "+"Quicksort");
            Quicksort quicksort= new Quicksort();
            //LLamar
               Datos quickA[]= GuardarDato.dato4;
            quicksort.iniciarContador();
            quicksort.ordenarQuickSort(0, quickA.length-1);
            GuardarDato.ordenada=quickA;
         
          
            //DATO mayot
            mayor=quickA[quickA.length-1].getUfoShape();
            mayorN=String.valueOf(quickA[quickA.length-1].getCount());
             //dato menor
            menor=quickA[0].getUfoShape();
            menorN=String.valueOf(quickA[0].getCount());
            grafica((cont+1), quickA);
             Hilo nuev= new Hilo(cont, label1,label2,label2);
        Thread hilo= new Thread(nuev);
        hilo.start();
            
        } else if (this.shell.isSelected() == true) {
               bubbleCont=1;
            //Asignar nombre
            Opciones.algoritmo.setText("Algoritmo: "+"ShellSort");
               Opciones.orden.setText("Orden: Ascendente");
               nombreAlgo="ShellSort";
               //Asignar nombre
            asignarVelocidad();
            JOptionPane.showMessageDialog(null, "Algoritmo: "+"ShellSort");
            //Llamar al ordenamiento
            Datos shell1[]= GuardarDato.dato6;
            OrdenamientoShellSort shel= new OrdenamientoShellSort();
            shel.shellSort1(shell1,label1,label2,label3);
            
        }

    }
//Descendente

    public void descendete() throws IOException {
       
        if (this.bubble.isSelected()==true) {
            bubbleCont=1;
            //Asignarle al algoritmo nombre
            Opciones.algoritmo.setText("Algoritmo: "+"Bubble Sort");
               Opciones.orden.setText("Orden: Descendente");
               nombreAlgo="Bubble Sort";
           BubleSort b= new BubleSort();
           //Asignar la velocidad
           asignarVelocidad();
           b.BubbleSortDescendente(this.label1, this.label2, this.label3);
           
        }else if (this.quick.isSelected()==true) {
               bubbleCont=1;
            //Asignarle al algoritmo nombre
             JOptionPane.showMessageDialog(null, "Algoritmo: "+"Quicksort");
              Opciones.orden.setText("Orden: Descendente");
                 nombreAlgo="QuickSort"; 
           Quicksort b= new Quicksort();
         asignarVelocidad();
           //Llamar al ordenamiento
           Datos quickB[]= GuardarDato.dato5;
           b.iniciarContador();
           b.ordenarQuickSortDescendente(quickB,0,quickB.length-1);
           GuardarDato.ordenada=quickB;
           //
            mayor=quickB[0].getUfoShape();
            mayorN=String.valueOf(quickB[0].getCount());
            //DATO mayot
            menor=quickB[quickB.length-1].getUfoShape();
            menorN=String.valueOf(quickB[quickB.length-1].getCount());
            
             //Asignar la velocidad
          grafica((cont+1), quickB);
//           b.grafica2Des();
              Hilo nuev= new Hilo(cont, label1,label2,label2);
        Thread hilo= new Thread(nuev);
        hilo.start();
        }else if (this.shell.isSelected()==true) {
               bubbleCont=1;
            //Asignarle al algoritmo nombre
             Opciones.algoritmo.setText("Algoritmo: "+"ShellSort");
              Opciones.orden.setText("Orden: Descendente");
                nombreAlgo="ShellSort";
             //Asignar la velocidad
            asignarVelocidad();
            //Llamar al ordenamiento
            Datos arr[]= GuardarDato.dato7;
            
            OrdenamientoShellSort or= new OrdenamientoShellSort();
            or.shellSort1Desc(arr, label1, label2, label3);
            
        }
    }
    
    
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
      public void mostrar(Datos []arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i].imprimir();
        }
        System.out.println("-----------------");
    }
      
       public ImageIcon agregarDimensionesDeImagenP(int ancho,int alto,String direccion){
        ImageIcon x= new ImageIcon(direccion);
        ImageIcon y= new ImageIcon(x.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return y;
        
    }
  

}
