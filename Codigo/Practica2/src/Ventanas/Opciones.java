/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Kelly
 */
public class Opciones extends JFrame {
    
    JRadioButton ascendente;
    JRadioButton descendente;
    JRadioButton baja;
    JRadioButton media;
    JRadioButton alta;
    JRadioButton bubleSort;
    JRadioButton quickSort;
    JRadioButton shellSort;
    JButton ordenar;
    JLabel segundos;
   public static JLabel minutos;
    JLabel milisigundos;
    public static JPanel panel;
    public static  JLabel principal;
    public static  JLabel algoritmo;
    public static  JLabel velocidad;
    public static  JLabel orden;
    public static  JLabel pasos;
    
    public Opciones() {
        super();
        this.setSize(400, 490);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        agregarComponetes();
    }
  

    public void agregarComponetes() {
        //Encabezado
        JLabel etiqueta = new JLabel("Tipo de ordenamiento");
        etiqueta.setBounds(10, 10, 210, 45);
        etiqueta.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        this.add(etiqueta);

        //Opcion acendetne
        ascendente = new JRadioButton("Ascendente");
        ascendente.setBounds(10, 65, 150, 30);
        this.add(ascendente);
        //Opcion descendente
        descendente = new JRadioButton("Descendente");
        descendente.setBounds(200, 65, 150, 30);
        this.add(descendente);
        //Encabezado
        JLabel etiqueta3 = new JLabel("Velocidad de ordenamiento");
        etiqueta3.setBounds(10, 100, 210, 45);
       
        this.add(etiqueta3);
        //Bajo
        baja = new JRadioButton("Baja");
        baja.setBounds(10, 155, 150, 30);
        this.add(baja);
        //Medio
        media = new JRadioButton("Media");
        media.setBounds(10, 195, 150, 30);
        this.add(media);
        //Alto
        alta = new JRadioButton("Alta");
        alta.setBounds(10, 235, 150, 30);
        this.add(alta);
        //
        //OPCION ascedente
        JLabel etiqueta2 = new JLabel("Algoritmo de ordenamiento");
        etiqueta2.setBounds(200, 100, 200, 45);
       
        this.add(etiqueta2);
        //BubbleSort
        bubleSort = new JRadioButton("BubbleSort");
        bubleSort.setBounds(200, 155, 150, 30);
        this.add(bubleSort);
        //Quicksort
        quickSort = new JRadioButton("QuickSort");
        quickSort.setBounds(200, 195, 150, 30);
        this.add(quickSort);
        //Shellsort
        shellSort = new JRadioButton("ShellSort");
        shellSort.setBounds(200, 235, 150, 30);
        this.add(shellSort);
        //Ordena
        ordenar= new JButton("Ordenar");
        ordenar.setBounds(200,275, 110,45);
        this.add(ordenar);
        
        
       
        IniciarBoton();
        
    }
       public void  IniciarBoton(){
            ordenar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    try {
                        CrearGrafica();
                    } catch (IOException ex) {
                        Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
          

                }
            });
        }
       
       public void CrearGrafica() throws IOException{
           panel=new JPanel();
           JFrame frame2= new JFrame();
           frame2.setVisible(true);
           
           frame2.setLayout(null);
           frame2.setVisible(true);
           frame2.setBounds(250, 0, 700, 700);
           frame2.setBackground(Color.WHITE);
           milisigundos= new JLabel("00");
           milisigundos.setBounds(405, 10, 50, 45);
           milisigundos.setOpaque(true);
           frame2.add(milisigundos);
           
           //
           segundos= new JLabel("00:");
           segundos.setBounds(370, 10, 50, 45);
           segundos.setOpaque(false);
           frame2.add(segundos);
           
           minutos= new JLabel();
           minutos.setBounds(300, 10, 50, 45);
           panel.setBounds(10, 65, 600, 400);
           
           panel.setBackground(Color.BLACK);
           //
           algoritmo=new JLabel();
           algoritmo.setBounds(5, 5,250, 35);
           
           algoritmo.setBackground(Color.WHITE);
           frame2.add(algoritmo);
           //
           velocidad=new JLabel();
           velocidad.setBounds(5, 50,250, 35);
           velocidad.setFocusable(false);
           velocidad.setBackground(Color.WHITE);
           frame2.add(velocidad);
           //
           orden=new JLabel();
           orden.setBounds(5, 100,250, 45);
           orden.setFocusable(false);
           orden.setBackground(Color.WHITE);
           frame2.add(orden);
           //pasos
           pasos=new JLabel();
           pasos.setBounds(300, 60,250, 45);
           pasos.setFocusable(false);
           pasos.setBackground(Color.WHITE);
           frame2.add(pasos);
           //
           JButton regresar= new JButton("Regresar");
           regresar.setBounds(350, 100, 60, 45);
           principal=new JLabel();
           principal.setIcon(agregarDimensionesDeImagenP(600, 500, "grafica.jpg"));
           principal.setBounds(10, 150, 600, 500);
           frame2.getContentPane().add(principal);
           frame2.add(minutos);
            Seleccionar sele= new Seleccionar(ascendente, descendente, baja, media, alta, bubleSort, quickSort, shellSort,milisigundos,segundos,minutos);
            
                    
                    
       }
       
       //Imagen
          public ImageIcon agregarDimensionesDeImagenP(int ancho,int alto,String direccion){
        ImageIcon x= new ImageIcon(direccion);
        ImageIcon y= new ImageIcon(x.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return y;
        
    }
}
    
