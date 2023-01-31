/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author robertodelriosalgado
 */
public class IteradorArreglo<T> implements Iterator<T> {
    private int actual;
    private T[] datos;
    private int total;

    public IteradorArreglo(T[] datos, int total) {
        this.datos = datos;
        this.total = total;
        actual = 0;
    }
    
    
    

    @Override
    public boolean hasNext() {
        return actual < total;
    }

    @Override
    public T next() {
        if (hasNext()){
            T resultado= datos[actual];
            actual++;
            return resultado;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        Iterator.super.remove(); 
    }
    
    
}
