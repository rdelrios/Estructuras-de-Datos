/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasenlazadas;

import java.util.Iterator;

/**
 *
 * @author robertodelriosalgado
 */
public class EE <T> implements Iterable<T>{
    private Nodo<T> primero;

    public EE() {
        primero = null; //indicar el estado de vacia
    }
    
    public boolean estaVacia(){
        return primero==null;
    }
    
    public void agregaInicio(T dato){
        Nodo<T> nuevo= new Nodo(dato);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }
    
    
    public void agregaFinal(T dato){
        if (estaVacia())
            agregaInicio(dato);
        else{
            Nodo<T> nuevo = new Nodo(dato);
            Nodo<T> apuntador = primero;
            while (apuntador.getSiguiente() != null)
                apuntador=apuntador.getSiguiente();
            apuntador.setSiguiente(nuevo);
        } 
    }
    
    public T quitaPrimero(){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("no hay datos."); 
        T dato = primero.getDato();
        Nodo<T> apuntador = primero;
        primero= primero.getSiguiente();
        apuntador.setSiguiente(null);
        return dato;
    }
    
    public T quitaUtlimo(){
        if(estaVacia())
            throw new ExcepcionColeccionVacia("no hay datos.");
        else{
            Nodo<T> ant, act;
            ant = null;
            act = primero;
            while (act.getSiguiente() != null){
                ant = act;
                act = act.getSiguiente();
            }
//            if (ant == null) //la EE tiene un solo nodo
//                primero = null;
//            else{ // hay 2 o más nodos
//                ant.setSiguiente(null);
//            }
            try{
                ant.setSiguiente(null);
            } catch (NullPointerException nP){
                primero=null;
            }
            return act.getDato();
        }
    }
    
    //quita un dato version resultado null. Otra opcion es con excepciones.
    public T quitaDato(T dato){
        T resultado = null;
        Nodo<T> ant, act;
        ant = null;
        act = primero;
        while (act != null && !act.getDato().equals(dato)){
            ant = act;
            act = act.getSiguiente();
        }
        if (act != null){ // el dato esta en la EE
            resultado = act.getDato();
            if (ant == null) //el dato es el primero
                primero = primero.getSiguiente();
            else
                ant.setSiguiente(act.getSiguiente());
            act.setSiguiente(null);
            
        }
        return resultado;
    }
    
    public boolean eliminaSiguienteDe(T info){
        boolean resp = false;
        Nodo<T> desp, act;
        desp = null;
        act = primero;
        while (act != null && !act.getDato().equals(info)){
            act = act.getSiguiente();
        }
        if (act!=null){
            desp=act.getSiguiente();
            if(desp != null){ //significa que no esta en el ultimo 
                act.setSiguiente(desp.getSiguiente());
                resp = true;
            }
        }  
        return resp;
    }
    
    public boolean eliminaAnteriorA(T info){
        boolean resp = false;
        Nodo<T> preant, act, ant;
        preant = null;
        ant = primero;
        act = primero.getSiguiente();
        if(!(primero.getDato().equals(info))){
            while (act != null && !act.getDato().equals(info)){
                preant = ant;
                ant = act;
                act = act.getSiguiente();
            }
            if(act == null)
                resp=false;
            else{
                if(preant==null)
                    quitaPrimero();
                else{
                    preant.setSiguiente(act);
                    ant.setSiguiente(null);
                }
                resp=true;
            }
        }
        return resp;
    }
   

    public boolean busca(T dato){
        if (estaVacia())
            throw new ExcepcionColeccionVacia("no hay datos.");
        Nodo<T> auxiliar = primero;
        boolean resp=false;
        while (auxiliar!=null && !resp){
            if (auxiliar.getDato().equals(dato))
                resp=true;
            else
                auxiliar=auxiliar.getSiguiente();
        }
        return resp;
    }
    
    public boolean buscaR(T dato){
        if(estaVacia())
            return false;
        else
            return buscaR(dato, primero);
    }
    
    private boolean buscaR(T dato, Nodo<T> apuntador){
        if(apuntador==null){
            return false;
        }
        else if(apuntador.getDato().equals(dato))
            return true;
        else
            return buscaR(dato, apuntador.getSiguiente());
    }
    
    public String toString(){
        if(estaVacia())
            return null;
        else{
            StringBuilder cad = new StringBuilder();
            Nodo<T> apuntador = primero;
            while (apuntador != null){
                cad.append(apuntador.getDato()+"\n");
                apuntador = apuntador.getSiguiente();
            }
            return cad.toString();
        }
    }
    
    public String toStringR(){
        if (estaVacia())
            return null;
        else
            return toStringR(new StringBuilder(), primero);
    }
    
    private String toStringR(StringBuilder cad, Nodo<T> apuntador){
        if (apuntador==null)
            return cad.toString();
        else{
            cad.append(apuntador.getDato()+"\n");
            return toStringR(cad, apuntador.getSiguiente());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorEE(primero);
    }
    
    public boolean insertaAntesQue(T refer, T nuevo){
        if(estaVacia())
            throw new ExcepcionColeccionVacia("no hay datos.");
        boolean resp = true;
        Nodo<T> act, ant;
        Nodo<T> nuevoN = new Nodo(nuevo);
        act = primero;
        ant = null;
        while (act != null && !act.getDato().equals(refer)){
            ant = act;
            act = act.getSiguiente();
        }
        if(act != null){
            if(ant == null){
                nuevoN.setSiguiente(primero);
                primero = nuevoN;
            }
            else{
                nuevoN.setSiguiente(act);
                ant.setSiguiente(nuevoN);
            }
        }
        else{
            resp = false;
        }
        return resp;
    }
  
    /*
    Control: estructuras enlazadas y recursión

 

- En la clase EE agrega el método calculaTamanio() que cuente y regrese el total de nodos que forman a la EE.

- Considera todos los casos que puedan presentarse.

- Debes programar recursivamente tu solución.

Al terminar sube el método programado a Canvas.
    */
    
    private int calculaTamanio(Nodo<T> apuntador, int contador){
        if (apuntador != null){
            contador++;
            return calculaTamanio(apuntador.getSiguiente(), contador);
        }
        else
            return contador;   
    }
    
    public int calculaTamanio(){
        int contador = 0;
        Nodo<T> apuntador;
        apuntador = primero;
        if(estaVacia())
            return 0;
        else
            return calculaTamanio(apuntador, contador);
    }
    /*
    Escribe un método en la clase EE que reciba como parámetro un objeto de tipo EE (objEE) y
    modifique a la EE que llama al método (this), mezclando sus nodos con los de objEE de acuerdo 
    a lo descrito a continuación. A this se le deberá intercalar un nodo de objEE entre cada par de ella. 
    Es decir, quedará el primer nodo de this seguido del primero de objEE, luego el segundo de this 
    seguido del segundo de objEE, y así sucesivamente. Si tienen diferente cantidad de nodos, al final 
    quedarán los nodos de la EE más larga. SE DEBEN USAR LOS NODOS DE LAS EE, NO SÓLO LAS INFORMACIONES 
    QUE ALMACENAN. Prueba tu solución. Una vez ejecutado el método, 
    ¿en qué estado quedan las dos EE involucradas?
    */
    public void intercalaNodos(EE<T> otra){
        Nodo<T> apuntador, apuntadorOtro, nuevo;
        if(this.primero!=null && otra!=null && otra.primero!=null){
            apuntador=primero;
            apuntadorOtro=otra.primero;
            while(apuntador!=null && apuntadorOtro!=null){
                nuevo=apuntadorOtro;
                apuntadorOtro=apuntadorOtro.getSiguiente();
                nuevo.setSiguiente(apuntador.getSiguiente());
                apuntador.setSiguiente(nuevo);
                apuntador=nuevo.getSiguiente();
            }
            if(apuntadorOtro!=null){
               apuntador=primero;
               while(apuntador.getSiguiente()!=null) {
                   apuntador=apuntador.getSiguiente(); 
               }
               apuntador.setSiguiente(apuntadorOtro); 
            }
        }
       
        
        
    }
    
    
    
    
    
}
