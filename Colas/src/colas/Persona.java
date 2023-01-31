/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.util.Calendar;

/**
 *
 * @author robertodelriosalgado
 */
public class Persona {
    
    private String nombre;
    private String fechaNac; //dd/mm/aaaa
    private int años;

    public Persona() {
    }
    
    public Persona(String nombre, String fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    
    public int obtenerAños(){
        Calendar c1 = Calendar.getInstance();
        int difmes,difdia, anioH;
        anioH = c1.get(Calendar.YEAR);
        int años;
        difdia = 31 - Integer.parseInt((String) this.fechaNac.subSequence(0, 2));
        difmes = 12 - Integer.parseInt((String) this.fechaNac.subSequence(3, 5));
        años = anioH - Integer.parseInt((String) this.fechaNac.subSequence(6, 10));

        
        if ((difmes)<0 ||  (difmes)==0 && (difdia)<0)
                años=años-1;
        this.años=años;
        return años;
    }

    @Override
    public String toString() {
        return "\nNombre: " + nombre + "; fechaNac: " + fechaNac +"; edad: "+obtenerAños()  ;
    }
    
    
    
}
