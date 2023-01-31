/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author robertodelriosalgado
 */
public class Alumno extends Persona{
    private String carrera;
    
    public Alumno(){
        super();
    }

    public Alumno(String carrera, String nombre) {
        super(nombre);
        this.carrera = carrera;
    }
    
    
    
}
