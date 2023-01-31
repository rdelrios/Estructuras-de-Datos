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
public class ConjuntoA<T> implements ConjuntoADT<T> {
    private T[] coleccion;
    private int cardinalidad;
    private final int MAXIMO=50;

    public ConjuntoA() {
        coleccion=(T[]) new Object[MAXIMO];
        cardinalidad=0;
    }
    
    public ConjuntoA(int Max) {
        coleccion=(T[]) new Object[Max];
        cardinalidad=0;
    }
    
    public boolean estaVacio(){
        return cardinalidad==0;
    }
    
    public int getCardinalidad(){
        return cardinalidad;       
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(coleccion, cardinalidad);
    }
    
    public boolean contiene(T elemento){ //se puede hacer sin iterador
        Iterator<T> it= this.iterator();
        boolean resp=false;
        while (it.hasNext() && !resp){
            resp= it.next().equals(elemento);
        }
        return resp;
    }
    
    public boolean agrega(T nuevo){
        boolean resp = false;
        
        if(!contiene(nuevo)){
            if (cardinalidad == coleccion.length)
                expande();
            coleccion[cardinalidad] = nuevo;
            cardinalidad++;
            resp=true;
        }
        return resp;
    }
    
    private void expande(){
        T[] masGrande=(T[]) new Object[coleccion.length * 2];
        
        for (int i = 0; i < cardinalidad; i++)
            masGrande[i] = coleccion[i];
        coleccion = masGrande;
    }
    
    public String toString(){
        StringBuilder cad= new StringBuilder();
        
        for (int i = 0; i < cardinalidad; i++){
            cad.append(coleccion[i]).append(" ");
        }
        return cad.toString();
    }
    
    private int buscaElementos(T dato){
        int i;
        i = 0;
        while(i < cardinalidad && !coleccion[i].equals(dato))
            i++;
        if (i == cardinalidad)
            i = -1;
        return i;
    }
    
    public T quita(T elemento){
        int pos;
        T resultado;
        pos = buscaElementos(elemento);
        if(pos >= 0){
            resultado = coleccion[pos];
            coleccion[pos] = coleccion[cardinalidad - 1];
            coleccion[cardinalidad - 1] = null;
            cardinalidad--;
            return resultado;
        }
        throw new ExcepcionColeccionVacia("No se encuentra el elemento");
    }
    
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> conjunto){
        if(conjunto==null){
            throw new ExcepcionColeccionVacia("No se encuentra el elemento");
        }
        ConjuntoADT<T> conjAux= new ConjuntoA();
        
        for( int i = 0; i< cardinalidad; i++){
            if(conjunto.contiene(coleccion[i])){
                conjAux.agrega(coleccion[i]);
            }
        }
        return conjAux;
    }
    
//    public ConjuntoADT<T> interseccion(ConjuntoADT<T> conjunto){
//        if (conjunto != null){
//            ConjuntoADT<T> conjAux= new ConjuntoA();
//            interseccion(conjunto,0, conjAux);
//            return conjAux;
//        }
//        else
//            throw new ExcepcionColeccionVacia("No se encuentra el elemento");
//    }
//    
//    private void interseccion(ConjuntoADT<T> conjunto, int i, ConjuntoADT<T> conjuntoAux){
//        if(i<cardinalidad)
//            if(conjunto.contiene(coleccion[i]))
//                conjuntoAux.agrega(coleccion[i]);
//            interseccion(conjunto,i+1, conjuntoAux);      
//    }
    
//    public ConjuntoADT<T> union(ConjuntoADT<T> conjunto){
//        if(conjunto==null){
//            throw new ExcepcionColeccionVacia("No se encuentra el elemento");
//        }
//        ConjuntoADT<T> conjAux= new ConjuntoA();
//        Iterator<T> it = conjunto.iterator();
//        
//        for( int i = 0; i<cardinalidad; i++){
//            conjAux.agrega(coleccion[i]);
//        }
//        
//        while(it.hasNext()){
//            conjAux.agrega(it.next());
//        }
//        return conjAux;    
//    }
    
    public ConjuntoADT<T> union(ConjuntoADT<T> conjunto){
        ConjuntoADT<T> conjAux= new ConjuntoA();
        Iterator<T> it = conjunto.iterator();
        
        union( 0, conjAux, it);
        return conjAux;
    }
    
    public void union(int i, ConjuntoADT<T> conjAux, Iterator<T> it){
        if (i<cardinalidad){
            conjAux.agrega(coleccion[i]);
            union( i+1, conjAux, it);
        }
        if( it.hasNext()){
            conjAux.agrega(it.next());
            union(i, conjAux, it);
        }
    } 
    
    
//    public ConjuntoADT<T> diferencia(ConjuntoADT<T> conjunto){
//        if(conjunto==null){
//            throw new ExcepcionColeccionVacia("No se encuentra el elemento");
//        }
//        
//        ConjuntoADT<T> conjAux= new ConjuntoA();
//        
//        
//        for (int i = 0; i<cardinalidad; i++){
//            if(!conjunto.contiene(coleccion[i]))
//                conjAux.agrega(coleccion[i]);
//        }
//        return conjAux;
//    }
    
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> conjunto){
        
        if (conjunto!=null){
            ConjuntoADT<T> conjAux= new ConjuntoA();
            Iterator<T> it = conjunto.iterator();
            diferencia(conjunto, 0, conjAux);
            return conjAux;
        }
        else
            throw new ExcepcionColeccionVacia("No se encuentra el elemento");
    }
    
    private void diferencia(ConjuntoADT<T> conjunto, int i, ConjuntoADT<T> conjAux){ 
        if (i<cardinalidad){
            if(!conjunto.contiene(coleccion[i]))
                conjAux.agrega(coleccion[i]);
            diferencia(conjunto, i+1, conjAux);
        }
    }
    
    
    
}
