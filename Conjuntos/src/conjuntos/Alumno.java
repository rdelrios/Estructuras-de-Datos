/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author robertodelriosalgado
 */
public class Alumno implements Serializable{
    private String nombre;
    private int edad;
    private double promedio;
//    private boolean frances;
//    private boolean ingles;
//    private boolean otro;

    public Alumno(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

//    public Alumno(String nombre, boolean frances, boolean ingles, boolean otro) {
//        this.nombre = nombre;
//        this.frances = frances;
//        this.ingles = ingles;
//        this.otro = otro;
//    }
    
    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public String toString() {
        return "Alumno: "+ nombre + ", de edad " + edad + " años, con promedio = " + promedio + '\n';
    }


    @Override
    public boolean equals(Object obj) {
        Alumno a=(Alumno) obj;
        return this.nombre.equalsIgnoreCase(a.nombre);
    }
    
    
    
    
    
}
