/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresora;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author robertodelriosalgado
 */
public abstract class Archivo implements Serializable{
    private double tamaño;
    private String nombre;
    private String dueño;
    private String fecha; // dd/mm/aaaa
    

    public Archivo() {
    }

    public Archivo(double tamaño, String nombre, String dueño, String fecha) {
        this.tamaño = tamaño;
        this.nombre = nombre;
        this.dueño = dueño;
        this.fecha = fecha;
    }

  

    public Archivo(double tamaño) {
        this.tamaño = tamaño;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Archivo";
    }
    
    

 
  
    
    
    
    
    
}
