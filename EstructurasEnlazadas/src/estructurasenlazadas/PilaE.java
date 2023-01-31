/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasenlazadas;

/**
 *
 * @author robertodelriosalgado
 */
public class PilaE<T> implements PilaADT<T> {
    private Nodo<T> tope;
    
    public PilaE(){
        tope = null;
    }
    
 
    @Override
    public void push(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    @Override
    public T pop() {
       if (this.isEmpty())
           throw new ExcepcionColeccionVacia("No hay datos en la pila");
       Nodo<T> aux = tope;
       tope = tope.getSiguiente();
       aux.setSiguiente(null);
       return aux.getDato();
    }

    @Override
    public boolean isEmpty() {
        return tope == null;
    }

    @Override
    public T peek() {
        if (this.isEmpty())
           throw new ExcepcionColeccionVacia("No hay datos en la pila");
        return tope.getDato();
    }

    @Override
    public void multiPop(int n) {
        
    }
    
}
