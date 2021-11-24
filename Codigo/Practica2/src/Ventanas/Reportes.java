/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kelly
 */
public class Reportes {
    
    Scanner sc= new Scanner(System.in);
    
    //Crear el Reporte
    public static void crearReporte(String cadena){
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del reporte");
        String cadena2="";
        File archivo= new File(nombre+".html");
        try{
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter fileW= new FileWriter(archivo);
            BufferedWriter buffer= new BufferedWriter(fileW);
            buffer.write(cadena);
            buffer.close();
        }catch(Exception e){
            System.out.println("error"+e);
        }
        
    }
    
    public static String reporte(){
        String tablas="";
        String tabla2="";
        Datos arreglo []=GuardarDato.dato;
        Datos arreglo2 []=GuardarDato.ordenada;
       
//        try {
//            grafica();
//        } catch (IOException ex) {
//          
//        }
      
          tablas+="<tr>";
           tablas += "<th>"+VentanaPrincipal.tituloX+"</th>";
        for (int i = 0; i < arreglo.length; i++) {
            
            if (arreglo[i]!=null) {
                 
                 tablas += "<th>"+arreglo[i].getUfoShape()+"</th>";
                
            }         
            
        }
          tablas += "</tr>";
          tablas+="<tr>";
           tablas += "<th>"+VentanaPrincipal.tituloY+"</th>";
         for (int i = 0; i < arreglo.length; i++) {
            
            if (arreglo[i]!=null) {
                  
                 tablas+="<th>"+arreglo[i].getCount()+"</th>";
            }         
            
        }
        
         tablas += "</tr>";
         
         //Tabla con el arreglo ordenado
           tabla2+="<tr>";
           tabla2 += "<th>"+VentanaPrincipal.tituloX+"</th>";
        for (int i = 0; i < arreglo2.length; i++) {
            
            if (arreglo[i]!=null) {
                 
                 tabla2 += "<th>"+arreglo2[i].getUfoShape()+"</th>";
                
            }         
            
        }
          tabla2 += "</tr>";
          tabla2+="<tr>";
           tabla2 += "<th>"+VentanaPrincipal.tituloY+"</th>";
         for (int i = 0; i < arreglo2.length; i++) {
            
            if (arreglo[i]!=null) {
                  
                 tabla2+="<th>"+arreglo2[i].getCount()+"</th>";
            }         
            
        }
        
         tablas += "</tr>";
         
         
         //
         int cantidad=0;
         
         //Agregar a la varibale String
         
         //
        String cadena="<!DOCTYPE html>"+
                 "<html lang=\"en\">"+
                 "<head>"+
                "<meta charset=\"UTF-8\">"+
                 "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                 "<style>"+
                 "body{"+
                 "font-size: 20px;"+
                 "}"+
                "h1{"+
                 "size: 108px;"+
                "text-align: center;"+
                 "}"+
                "</style>"+
                "<title>Reporte</title>"+
                 "</head>"+
                 "<body>"+
                 "<style>"+
                 "body{"+
                 "background-image: url(https://static.vix.com/es/sites/default/files/styles/1x1/public/btg/tech.batanga.com/files/Fondos-para-paginas-web-09.jpg);"+
                 "background-size: 100%;"+
                 "}"+
                 "</style>"+
                 "<header><h2>Kelly Mischel Herrera Espino </h2></header>"+
                 "<header><h2>201900716 </h2></header>"+
                 "<style>"+
                 "h2{"+
                "color: blue;"+
                "text-align: center;"+
                "}"+
                "</style>"+
                "<style>"+
                "h3{"+
                "color:darkblue;"+
                "text-align: center;"+
                "}"+
                "</style>"+
                 "<style>"+
                 "table{"+
                 "text-align: center;"+ 
                 "margin: auto;"+
                 "}"+
                 "</style>"+
                "<style>"+
                "table{"+
                "text-align: center;"+ 
                "margin: auto;"+
                "width: 25%;"+
                "height: 25%;"+
                "color: black:"+
                "}"+
                "</style>"+
                "<style>"+
                "#columnas{"+
                "text-align: center;"+
                "column-count:2;"+
                "column-gap:20px;"+
                "column-rule:4px dotted gray;"+
                "}"+
                "</style>"+
                 "<Style>"+
                "p{"+
                "color: darkblue;"+
                "text-align: center;"+
                "}"+
                "</Style>"+
                 "<Style>"+
                "img{"+
                "display: block;"+
                "margin-left: auto;"+
                "margin-right:auto;"+
                "}"+
                "</Style>"+
                "<Style>"+
                "#mayor{"+
                "margin-left: auto;"+
                "margin-right:auto;"+
                "}"+
                "</Style>"+
               " <style>"+
                "td {"+
                "font-size: 15px;"+
                "line-height: 20px;"+
                "padding: 0 20px;"+
                "text-align: justify;"+
                "vertical-align: top;"+
                "width: 50%;"+
                "}"+

                "td.first {"+
                "border-right: 5px solid #4BB495;"+
                "}"+
  
                "</style>"+
                "<style>"+
                "#separar{"+
                "margin-left: auto;"+
                "margin-right:auto;"+
                "}"+
                "</style>"+
                 "<div id=\"columnas\">"+
                "<b><ol>Algoritmo: "+Seleccionar.nombreAlgo+"</ol></b>"+
                "<b><ol>Velocidad: "+Seleccionar.velocidadA+"</ol></b>"+
                "<b><ol>Orden: "+Seleccionar.orden1+"</ol></b>"+
                "<b><ol>Tiempo :"+Tiempo.tiempo3+":"+Tiempo.tiempo2+":"+Tiempo.tiempo+"</ol></b>"+
                "<b><ol>Pasos:"+(Seleccionar.bubbleCont-1)+"</ol></b>"+
                "</div>"+
                 "<table id=\"separar\">"+
                 "<tr>"+ 
                 "<td>"+
                "<table id=\"mayor\" style=\"width:20%\" border=\"4\">"+
                "<tr>"+
                 "<th colspan = \"3\">Valor Minimo</th>"+
                "</tr>"+
                "<tr>"+
                 "<td>"+Seleccionar.menor+"</td>"+
                 "<td>"+Seleccionar.menorN+"</td>"+
                "</tr>"+   
                "</table>"+    
                "</td>"+
                "<td id=\"s\">"+
                "<table id=\"mayor\" style=\"width:20%\" border=\"4\">"+
                "<tr>"+
                 "<th colspan =\"3\">Valor Máximo</th>"+
                "</tr>"+
                "<tr>"+
                 "<td>"+Seleccionar.mayor+"</td>"+
                 "<td>"+Seleccionar.mayorN+"</td>"+
                "</tr>"+   
                "</table>"+  
                "</td>"+
                "</tr>"+
                "</table>"+
                 "<h2>Datos Desordenados</h2>"+
                "<table border=\"2\">"+
                  tablas+
                 "</table>"+
                "<h3><p3>Gráfica</p3></h3>"+
                 "<img src=\"grafica.jpg\""+"alt=hola"+
                "width = \"500\""+
                "height=\"500\">"+
                  "<h2>Datos Ordenados</h2>"+
                "<table border=\"1\">"+
                tabla2+
                 "</table>"+
                "<h3><p3>Gráfica</p3></h3>"+
                 "<img src=\"graficaOrdenada.jpg\""+"alt=hola"+
                "width = \"500\""+
                "height=\"500\">"+
                "<table border=\"1\">"+
                 "</table>"+
                 "<h3>"+
                 "</h3>"+
                 "</body>"+
                 "</html>";
        return cadena;
    }
    

}
