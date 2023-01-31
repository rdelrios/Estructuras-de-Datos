/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.Objects;

/**
 *
 * @author robertodelriosalgado
 */
public class Persona {
    private String nombre;
    private String CURP;

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean resp =false;
        
        if (obj != null && obj instanceof Persona)
            resp=((Persona) obj).CURP.equalsIgnoreCase(CURP);
        return resp;
    }
    
    

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre{" + "nombre=" + nombre + '}';
    }
    
    
}
