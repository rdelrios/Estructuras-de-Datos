/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import ejemplopilas.PilaA;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author robertodelriosalgado
 */
public class Colas {
    
    public static <T> void invierteCola(ColaADT<T> cola){
        PilaA<T> pila=new PilaA();
        
        while(!cola.estaVacia())
            pila.push(cola.quita());
        while(!pila.isEmpty())
            cola.agrega(pila.pop());
    }
    
//Escribe un método estático que quite todos los elementos repetidos de una estructura tipo cola 
    //(si la cola tiene elementos repetidos, estos se encuentran en posiciones consecutivas). 
    public static <T> void quitarRepetidos(ColaADT<T> cola){
        ColaADT<T> colaAux=new ColaA<T>();
        T aux;
        
        while (!cola.estaVacia()){
            aux= cola.quita();
            colaAux.agrega(aux);
            while(!cola.estaVacia() && cola.consultaPrimero().equals(aux)){
                    cola.quita();
                }
            }
            while(!colaAux.estaVacia()){
                cola.agrega(colaAux.quita());
            }
    }    
    
    
    //Escribe un método estático que quite todas las ocurrencias de un cierto objeto de una estructura tipo cola. 
    //Es decir, dado un objeto, si se encuentra en la cola, se deben eliminar todas sus ocurrencias.
    
    public static <T> void quitaOcurrencias(ColaADT<T> cola, T dato){
        ColaA<T> aux= new ColaA();
        while (!cola.estaVacia()){
            if(cola.consultaPrimero().equals(dato))
                cola.quita();
            else
                aux.agrega(cola.quita());
        }
        while(!aux.estaVacia()){
            cola.agrega(aux.quita());
        }
    }
    
    
    
    
    public static Persona[] pasarArreglo(ColaADT<Persona> colaPers){
        int elementos;
        elementos= colaPers.cuentaElementos();
        Persona lista[]= new Persona[elementos+1];
        int i=0;
        while (!colaPers.estaVacia()){
            lista[i]=colaPers.quita();
            i++;
        }
        
        return lista;
    }
    
    public static void ordenaPorEdad(ColaADT<Persona> colaPers){
        Persona lista[];
        lista=pasarArreglo(colaPers);
        
        for( boolean ordenado=false; !ordenado;){
            ordenado=true;
            for (int i=0; i<lista.length-2;i++){
                if (lista[i].obtenerAños()<lista[i+1].obtenerAños()){
                    Persona aux=lista[i];
                    lista[i]=lista[i+1];
                    lista[i+1]=aux;
                    ordenado=false;
                }
                
            }
        }
        for(int i=0; i<lista.length-1;i++){
            colaPers.agrega(lista[i]);
        }
            
    }
    
    //EJERCICIOS PRACTICA EXAMEN
    public static <T> boolean cambiaPosicionDe(ColaADT<T> cola, T dato, int n){
        ColaADT<T> aux= new ColaA();
        boolean resp=false;
//        T datoAux;

        while(!cola.estaVacia()){
//            datoAux=cola.quita();
            if (cola.consultaPrimero().equals(dato)){
                resp=true;
                cola.quita();
            }
            else{
                aux.agrega(cola.quita());
            }
        }
        if(resp){
            for (int i=0; i<n-1; i++){
            cola.agrega(aux.quita());
            }
            cola.agrega(dato);
            while(!aux.estaVacia()){
                cola.agrega(aux.quita());
            }
        }
        else{
            while(!aux.estaVacia()){
            cola.agrega(aux.quita());
            }
        }
        
        return resp;
    }
    
    private static double calculaRaizCuadrada(double numero, double error, double inferior, double superior){
        double raiz=(inferior + superior)/2;
        if (Math.abs(raiz*raiz-numero) < error)
            return raiz;
        else{
            if (raiz*raiz<numero)
                return calculaRaizCuadrada( numero,  error, raiz, superior);
             
            else
                return calculaRaizCuadrada( numero,  error, inferior, raiz);
        }
    }
    
    public static double calculaRaizCuadrada(double numero, double error){
        return calculaRaizCuadrada( numero,  error, 0, numero);
    }
    
   
     public static <T> void agregaFrente(T dato, ColaADT<T> cola){
        T aux;
        if(cola!=null && cola.estaVacia()){
            cola.agrega(dato);
            while(cola.consultaPrimero()!=dato){
//                aux=cola.quita();
                cola.agrega(cola.quita());
            }
        }
        
    }
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("La raiz es: "+calculaRaizCuadrada(28,.001));
        
        ColaADT<Integer> cola= new ColaA();
        cola.agrega(1);
        cola.agrega(2);
        cola.agrega(3);
        cola.agrega(4);
        cola.agrega(5);
        System.out.println("Cola antes: "+cola.imprimeCola());
//        System.out.println(cambiaPosicionDe(cola, 2, 5));
        agregaFrente(10, cola);
        agregaFrente(50, cola);
//        agregaFrente(1, cola);
        System.out.println("Cola despues: "+cola.imprimeCola());
        
        
//        ColaADT<String> colores=new ColaA();
//        colores.agrega("rojo");
//        colores.agrega("verde");
//        colores.agrega("verde");
//        colores.agrega("verde");
//        colores.agrega("azul");
//        colores.agrega("blanco");
//        colores.agrega("amarillo");
//        
//        
//        System.out.println("\nCola original: "+ colores.imprimeCola());
//        
//        quitarRepetidos(colores);
//        
//        System.out.println("\nquitando: "+ colores.imprimeCola());
//        invierteCola(colores);
//        System.out.println("\nCola invertida: "+ colores.imprimeCola());

        
//        Persona p1=new Persona("Roberto","01/01/2000");
//        Persona p2=new Persona("Juan","01/01/1999");
//        Persona p3=new Persona("Pedro","01/01/1990");
//        Persona p4=new Persona("Lol","01/01/1993");
//        Persona p5=new Persona("ahhah","01/01/1999");
//        Persona p6=new Persona("jkrtw","01/01/2000");
//        
//        ColaADT<Persona> colaAv=new ColaA();
//        colaAv.agrega(p1);
//        colaAv.agrega(p3);
//        colaAv.agrega(p2);
//        colaAv.agrega(p5);
//        colaAv.agrega(p4);
//        colaAv.agrega(p6);
//        
//        
//        System.out.println("NORMAL: "+colaAv.imprimeCola().toString());
//        
//        ordenaPorEdad(colaAv);
//        System.out.println("ORDENADO: "+colaAv.imprimeCola().toString());
//        Persona lista[];
//        lista=pasarArreglo(colaAv);
//        for (int i=0; i<lista.length-1;i++){
//            System.out.println(lista[i].obtenerAños());
//        }
        
        
    }

    
    
    
    
}
