/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.util.ArrayList;

/**
 *
 * @author robertodelriosalgado
 */
public class ColaA <T> implements ColaADT<T>{
    private T[] datos;
    private int fin;
    private int frente;
    private final int MAX=20;

    public ColaA() {
        datos=(T[]) new Object[MAX];
        fin=-1;
        frente=-1;
    }
    
    public ColaA(int maximo) {
        datos=(T[]) new Object[maximo];
        fin=-1;
        frente=-1;
    }
    
    public boolean estaVacia(){
        return frente==-1;
    }
    
    public T consultaPrimero(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("Cola sin elementos");
        return datos[frente];
    }
    
    public void agrega(T nuevo){
        //if (frente == 0 && fin == datos.length-1 || (fin+1) == frente)
        if ((fin+1)% datos.length==frente)
            expandeCapacidad();
        fin=(fin+1)% datos.length;
        datos[fin]=nuevo;
        if(frente==-1)
            frente=0;
    }
    
//    private void expandeCapacidad(){
//        T[] nuevo= (T[])new Object[datos.length+20];
//        
//        if(frente<fin){
//            for (int i=frente; i<=fin;i++){
//                nuevo[i]=datos[i];
//            }
//        } else{
//            int j=0;
//            for(int i=frente; i<datos.length;i++){
//                nuevo[j]=datos[i];
//                j++;
//            }
//            for(int i=0;i<=fin; i++){
//                nuevo[j]=datos [i];
//                j++;
//            }
//            frente=0;
//            fin=datos.length-1;// o j-1 porque esta incrementada
//        }
//        
//        datos=nuevo;
//    }
    
    
    private void expandeCapacidad(){
        T[] nuevo=(T[]) new Object[datos.length*2];
        int i, tam;
        
        tam=datos.length;
        for(i=0; i < tam; i++)
            nuevo[i]=datos[(frente + i)%tam];
        frente=0;
        fin=tam-1;
        datos=nuevo;
    }
    
    
    
    
    public T quita(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("Cola sin elementos");
        T resultado=datos[frente];
        datos[frente]=null;
        if(frente==fin){//hay un solo dato en la cola
            frente=-1;
            fin=-1;
        }
        else
            frente=(frente+1)%datos.length;
        return resultado;
    }
    
    public String imprimeCola(){
        StringBuilder res=new StringBuilder();
        if(!estaVacia()){
            int i = frente;
            while (i % datos.length != fin%datos.length){
                res.append(datos[i % datos.length]+" ");
                i++;
            }

            res.append(datos[i % datos.length]+"\n");
        }
        return res.toString();
    }
    
    //solucion ejercicio 36
    
    public T consultaUltimo(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("Cola sin elementos");
        return datos[fin];
    }
    
    public int cuentaElementos(){
        int total;
        
        if (estaVacia())
            total=0;
        else{
            if (fin>=frente)
                total=fin - frente +1;
            else
                total= datos.length - frente + fin + 1;  
        }
        return total;
    }
    //tarea encontrar una formula que te de todo con una sola operacion
    
    public ArrayList<T> multiQuita(int n){
        ArrayList<T> resultado= new ArrayList();
        
        if (n<=cuentaElementos()){
            for (int i=1; i<=n; i++)
                resultado.add(this.quita());
        }
        else
            throw new ExcepcionColeccionVacia("Datos insuficientes");
        
        return resultado;
    }
    
    
   
}
