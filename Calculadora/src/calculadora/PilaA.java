/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author robertodelriosalgado
 */
public class PilaA <T> implements PilaADT <T>{
    private T[] elementos;
    private int tope;
    private final int Max=20;
    
    public PilaA(){
        elementos = (T[]) new Object[Max];
        tope=-1; //indica pila vacia
    }

    public PilaA(T[] elementos) {
        this.elementos = elementos;
    }
    
    
    
    public PilaA(int max){
        elementos=(T[]) new Object [max];
        tope=-1;
    }

    
    
    public boolean isEmpty(){
        return tope==-1;
    }
    
    public T peek(){ //opcion B
        if(isEmpty())
            throw new ExcepcionColeccionVacia("Pila vacia. No se puede consultar.");
        else
            return elementos[tope];
        
    }
    
    public T pop(){
        if (isEmpty())
            throw new ExcepcionColeccionVacia("Pila vacia. No se puede consultar.");
        else{
            T dato=elementos[tope];
            elementos[tope]=null;
            tope--;
            return dato;
        }
            
    }
    
    
    public void push(T dato){
        if (tope==elementos.length-1) 
            aumentaCapacidad();
        tope++;
        elementos[tope]=dato;
    }
    
    private void aumentaCapacidad(){
        T[] nuevo= (T[]) new Object[elementos.length *2];
        
        for (int i=0; i<=tope; i++)
            nuevo[i]=elementos[i];
        elementos=nuevo;
        
    }
    
}
