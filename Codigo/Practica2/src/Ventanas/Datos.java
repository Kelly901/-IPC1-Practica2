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
public class Datos {
    private String ufoShape;
    private double count;


    public Datos(String ufoShape, double count) {
        this.ufoShape = ufoShape;
        this.count = count;
        
    }

//    public Datos(String ufoShape, int count) {
//        this.ufoShape = ufoShape;
//        this.count = count;
//    }

    /**
     * @return the ufoShape
     */
    public String getUfoShape() {
        return ufoShape;
    }

    /**
     * @param ufoShape the ufoShape to set
     */
    public void setUfoShape(String ufoShape) {
        this.ufoShape = ufoShape;
    }

    /**
     * @return the count
     */
    public double getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
    public void imprimir(){
        System.out.println("n: "+this.getUfoShape());
        System.out.println("numero "+this.getCount());
    }

}