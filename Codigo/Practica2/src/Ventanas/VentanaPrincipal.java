/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class VentanaPrincipal extends JFrame {
    JTextField buscar;
    JTextField titulo;
    JButton botonBuscar;
    JButton botonAcepatar;
    JButton ordenar;
    String texto;
    String texto2;
    String texto3;
    public static String tituloO;
   public static String tituloX;
   public static  String tituloY;

    
       JPanel panel= new JPanel();
    public static int tamaño;
    public VentanaPrincipal(){
        super();
        this.setSize(600,700);
        this.setTitle("Ventana Principal");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        agregarBotones();
    }
    public void agregarBotones(){
        botonBuscar= new JButton("Buscar");
        botonBuscar.setBounds(363,80 ,220, 45);
        
        this.add(botonBuscar);
    //
        buscar= new JTextField();
        buscar.setBounds(10,80,350, 45);
        this.add(buscar);
        //
        
        titulo= new JTextField();
        titulo.setBounds(10,160, 350, 45);
        this.add(titulo);
//
       botonAcepatar= new JButton("Aceptar");
       botonAcepatar.setBounds(363,160 ,220, 45);
        this.add(botonAcepatar);
        
    
        
        ordenar= new JButton("ordenar");
       ordenar.setBounds(363,208 ,100, 45);
        this.add(ordenar);
        
        iniciarBotones();
    }
    
   public void iniciarBotones(){
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               abrirTexto();
               buscar.setText(texto);
            }
        });
        //Evento del boton aceptar
        
        botonAcepatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              texto2=buscar.getText();
                leerRuta();
                tituloO=titulo.getText();
                JOptionPane.showMessageDialog(null, "Listo");
              
            }
        });
        
        ordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             
               
               Opciones op= new Opciones();
              
               op.show();
               dispose();
            }
        });
    }
     
   //Metodo para leer la ruta del jtextfield
   public void leerRuta(){
         String cadena2="";
         int cont=0;
         System.out.println(texto2);
      try{
           
            
                FileReader archivo= new FileReader(texto2);
                BufferedReader leer= new BufferedReader(archivo);
                while((cadena2=leer.readLine())!=null){
                    texto3+=cadena2+"\n";
                    cont++;
                
                
            }
                leer.close();
        }catch(IOException b){
             JOptionPane.showMessageDialog(null, b+" "+"\n No se encontro el archivo f" ,
                   "Adevertencia",JOptionPane.WARNING_MESSAGE);
            
        }
        tamaño=cont-1;
        System.out.println("cont"+tamaño);
               quitarComa();
               obtenerTitulo();
                 graficar();
                 
                 
   }
   //Generar grafica
   
    public void crearGrafica() throws IOException{
             Datos arreglo[] = GuardarDato.dato;
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        for (int i = 0; i < arreglo.length; i++) {
            
            data.addValue(arreglo[i].getCount(), arreglo[i].getUfoShape(),"");
            
           
        }
         JFreeChart chart= ChartFactory.createBarChart(
                    titulo.getText(), 
                    VentanaPrincipal.tituloX,
                    VentanaPrincipal.tituloY, 
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
         int ancho=600;
         int alto=500;
         String graf="grafica"+".jpg";
         File BarChart = new File(graf);
          ChartUtilities.saveChartAsJPEG(BarChart, chart, ancho, alto);
        
    }
   //Metodo para leer el archivo
   public void abrirTexto(){
       
       
       try{
           JFileChooser file= new JFileChooser();
           file.showOpenDialog(this);
           File abrir=file.getSelectedFile();
           if (abrir!=null) {
               FileReader archivo = new FileReader(abrir);
               texto= String.valueOf(abrir);
               
                       
                       
                       
           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e+" "+"\n No se encontro el archivo");
       }
     
       
   }
   //Grafica
    public void graficar(){
          Datos arreglo[] = GuardarDato.dato;
        DefaultCategoryDataset data= new DefaultCategoryDataset();
        for (int i = 0; i < arreglo.length; i++) {
            
            data.addValue(arreglo[i].getCount(), arreglo[i].getUfoShape(), "");
            
           
        }
         JFreeChart chart= ChartFactory.createBarChart(
                    titulo.getText(), 
                    tituloX,
                    tituloY, 
                    data,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
         
     
        ChartPanel panelBarra= new ChartPanel(chart);
        
//        panel.setLayout(null);
//        panel.setBounds(10,250 ,300,300);
//        panel.add(panelBarra);
//        panel.setVisible(true);
//        panel.setBackground(Color.yellow);
        panelBarra.setBounds(10, 250, 500, 350);
        panelBarra.setVisible(true);
        panelBarra.setLayout(null);
        this.repaint();
       this.add(panelBarra);
        
         
        try {
            crearGrafica();
        } catch (IOException ex) {
           
        }
      
       
    }
    
        //Metodo para obtener el titulo de los ejes
        public void obtenerTitulo(){
            System.out.println("---------------------");
            System.out.println("hola");
              GuardarDato gd= new GuardarDato();
             String fila[]= texto3.split("\n");
             String t="";
             int tamañoF=fila.length-(fila.length-1);
             for (int i = 0; i < tamañoF; i++) {
                String[]palabra= fila[i].split(",");
                t=palabra[0];
                tituloY= palabra[1];
               
            }
             System.out.println(t.substring(3,t.length()));
             tituloX=t.substring(4,t.length());
             System.out.println(tituloY);
        }
        //Metodo para quitar la cadena
        public void quitarComa(){
            
             GuardarDato gd= new GuardarDato();
             String fila[]= texto3.split("\n");
             for (int i = 1; i < fila.length; i++) {
                String[]palabra= fila[i].split(",");
                String nombre=palabra[0];
                double numero= Double.parseDouble(palabra[1]);
                gd.guardarDatos(nombre, numero);
             
            }
             
        }
        
        
}
