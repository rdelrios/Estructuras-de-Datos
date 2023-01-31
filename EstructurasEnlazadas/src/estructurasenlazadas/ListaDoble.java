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
public class ListaDoble <T> {
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;

    public ListaDoble() {
        primero = null;
        ultimo = null;
    }
    
    public boolean estaVacia(){
        return primero == null;
    }
    
    public void agregaInicio(T dato){
       NodoDoble<T> nuevo = new NodoDoble(dato);
       if(estaVacia())
           ultimo = nuevo;
       else{
           primero.setAnterior(nuevo);
           nuevo.setSiguiente(primero);
       }
       primero = nuevo;  
    }
    
    public void agregaFinal(T dato){
        NodoDoble<T> nuevo = new NodoDoble(dato);
        if(estaVacia())
            primero = nuevo;
        else{
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
        }
        ultimo = nuevo;
    }
    
    public String toString(){
        StringBuilder cadena = new StringBuilder();
        toString(primero, cadena);
        return cadena.toString();
    }
    
    private void toString(NodoDoble<T> apuntador, StringBuilder sB){
        if (apuntador != null){
            sB.append(apuntador.getDato()+" ");
            toString(apuntador.getSiguiente(),sB);
        }
    }
    
    public T quitaPrimero(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("No hay datos en la lista");
        NodoDoble<T> auxiliar = primero;
        if (primero == ultimo)//hay un solo nodo
            ultimo = null;
        else
            primero.getSiguiente().setAnterior(null);
        primero = primero.getSiguiente();
        auxiliar.setSiguiente(null);
        return auxiliar.getDato();
    }
    
     public T quitaUltimo(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("No hay datos en la lista");
        NodoDoble<T> auxiliar = ultimo;
        if (primero == ultimo)//hay un solo nodo
            primero = null;
        else
            ultimo.getAnterior().setSiguiente(null);
        ultimo = ultimo.getAnterior();
        auxiliar.setAnterior(null);
        return auxiliar.getDato();
    }
    
    public T quita(T dato){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("No hay datos en la lista");
        T resultado;
        if(dato.equals(ultimo.getDato()))
            resultado = this.quitaUltimo();
        else{
            if(dato.equals(primero.getDato()))
                resultado = this.quitaPrimero();
            else //posicion intermedia
                resultado = quitaDato(dato, primero.getSiguiente());
        }
        return resultado;
    }
    
    private T quitaDato(T dato, NodoDoble<T> apuntador){
        if (apuntador==null) // dato no esta en la lista
            return null;
        else{
            if(dato.equals(apuntador.getDato())){ // se encontro, ahora hay que quitarlo
                apuntador.getAnterior().setSiguiente(apuntador.getSiguiente());
                apuntador.getSiguiente().setAnterior(apuntador.getAnterior());
                apuntador.setAnterior(null);
                apuntador.setSiguiente(null);
                return apuntador.getDato();
            }
            else
                return quitaDato(dato, apuntador.getSiguiente());
        }
    }
    
}
