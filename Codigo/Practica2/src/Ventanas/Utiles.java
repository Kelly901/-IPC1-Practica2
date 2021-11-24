/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author Kelly
 */
public class Utiles {
    
     public static ChartPanel pa(JFreeChart chart){
       ChartPanel pa= new ChartPanel(chart);
        pa.setBounds(10,10, 400, 350);
        pa.setVisible(true);
        return pa ;
        
    }
}
