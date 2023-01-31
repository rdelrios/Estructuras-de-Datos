/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Iterator;

/**
 *
 * @author robertodelriosalgado
 */
public class Escuela {
    private String nombre;
    private ConjuntoADT<Alumno> alumIng;
    private ConjuntoADT<Alumno> alumLic;

    public Escuela(String nombre) {
        this.nombre = nombre;
        alumIng= new ConjuntoA();
        alumLic= new ConjuntoA();
    }
    
    //a
    public boolean altaAlumno(String nom, int edad, double prom, String tipoCarrera){
        Alumno nuevo= new Alumno(nom, edad, prom);
        boolean res;
        if(tipoCarrera.equalsIgnoreCase("ing"))
            res=alumIng.agrega(nuevo);
        else
            res=alumLic.agrega(nuevo);
        
        return res;   
    }
    
    //b tarea
    public void quitaAlumno(String nombre, String tipoCarrera){
        Alumno auxiliar;
        boolean resp = false;
        if(tipoCarrera.equalsIgnoreCase("ing")){
            Iterator<Alumno> itI=alumIng.iterator();
            while(itI.hasNext() && !resp){
                auxiliar=itI.next();
                if(auxiliar.getNombre().equalsIgnoreCase(nombre)){
                    alumIng.quita(auxiliar);
                    resp = true;
                }
            }
        }  
        else if(tipoCarrera.equalsIgnoreCase("lic")){
            Iterator<Alumno> itL=alumLic.iterator();
            while(itL.hasNext() && !resp){
                auxiliar=itL.next();
                if(auxiliar.getNombre().equalsIgnoreCase(nombre)){
                    alumLic.quita(auxiliar);
                    resp=true;
                }
            }
        }
    }
    
    public boolean quitaAlumno2(String nombre){
        Alumno aux= new Alumno(nombre);
        boolean resp=false;
        try{
            alumIng.quita(aux);
            resp=true;
        } catch(Exception e){
            
        }
        try{
            alumLic.quita(aux);
            resp=true;
        } catch(Exception e){
            
        }
        return resp;
    }
    
    
    //c
    public String reporteAlumnosEscuela(){
        return alumIng.union(alumLic).toString();
    }
    
    //d
    public String reporteAlumnosDosCarrera(){
        return alumIng.interseccion(alumLic).toString();
    }
    
    //e
    public String reporteAlumnosSoloUnaCarrera(){
//        return alumIng.union(alumLic).diferencia(alumIng.interseccion(alumLic)).toString();
        return alumIng.diferencia(alumLic).union(alumLic.diferencia(alumIng)).toString();
    }
    
    //f
    public double calculaPromedioIng(){
        if (alumIng.estaVacio())
            throw new ArithmeticException("No se puede ...");
                    
        double suma=0;
        Iterator<Alumno> it= alumIng.iterator();
        
        while(it.hasNext())
            suma += it.next().getPromedio();
 
        return suma/alumIng.getCardinalidad();
    }
    
    //g tarea
    public int calcularMayoresdeEdad(int edad){
        if (alumLic.estaVacio())
            throw new ArithmeticException("No se puede ...");
        int contador=0;
        Iterator<Alumno> it=alumLic.iterator();
        
        while(it.hasNext()){
            if(it.next().getEdad() > edad){
                contador++;
            }
        }
        return contador;
        
        
    } 
    
    
    
    
}
