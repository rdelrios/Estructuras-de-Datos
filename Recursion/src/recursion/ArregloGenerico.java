/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author robertodelriosalgado
 */
public class ArregloGenerico <T extends Comparable<T>>{ //t que exteinde a la interface de comparable, no es cualquier t
    private int tam;                                    // usando el comparable se hace menos generico tu clase, 
                                                        //es necesario que las demas clases extiendan esta interface
    private T[] arreglo;                                //arreglos ordenados no combina objetos (comparable solo trabaja con arreglos ordenados)
    private final int Max=20;                           //el metodo compareto solo lo tiene la interface comparable

    public ArregloGenerico() {
        tam=0;
        arreglo= (T[])new Comparable [Max];
    }
    
    public ArregloGenerico(int maximo) {
        tam=0;
        arreglo= (T[])new Comparable [maximo];
    }
    
    public boolean altaDato(T dato){
        boolean resp=false;
        if (tam<Max){
            arreglo[tam]=dato;
            tam++;
            resp=true;
        }
        return resp;
    }
    
    
    private  int busqSec(T dato, int n){
        if(arreglo==null|| n==tam)
            return -1;
        else
            if(dato.equals(arreglo[n]))
                return n;
            else 
                return busqSec(dato, n+1);
            
    }
    
    public int busqSec(T dato){
        return busqSec(dato, 0);
    }
    
    
    
    private int busBin(T dato, int indxI, int indxF){
        if (indxI>indxF)
            return -(indxI+1);
        else{
            int medio=(indxI+indxF)/2;
            if (dato.equals(arreglo[medio]))
                return medio;
            
            else if (dato.compareTo(arreglo[medio])<0)
                return busBin(dato, indxI ,medio-1);
            
            else 
                return busBin(dato , medio+1, indxF);
        }
       
    }
    
    public int busBin(T dato){
        return busBin (dato,0,tam-1);
    }
    
    
    
    public String toStrings(){//toStrings con s es para pruebas
       return toStrings(new StringBuilder(),0); 
    }
    
    private String toStrings(StringBuilder cad, int n){
       if (n==tam)
           return cad.toString();
       else{
           cad.append(arreglo[n]+" ");
           return toStrings(cad,n+1);
       }       
    }
    
    private int posMayor(int ind, int indMayor){   
        if(ind==tam)
            return indMayor;
        
        else{
            if (arreglo[ind].compareTo(arreglo[indMayor])>0)
                indMayor=ind;
            
            return posMayor(ind+1,indMayor);
        }
//        else 
//            return posMayor(ind+1,indMayor);
        
    }
    
    
    public int posMayor(){
        return posMayor(0,0);
    }
    
    
    private void elimOcurr(int in, String cad){
        if (arreglo==null || in==tam)
            System.out.println("");

        else if(arreglo[in].getClass().getSimpleName().equals(cad)){
            elimOcurr(in+1,cad);
        }
        else{
            arreglo[in]=null;
            elimOcurr(in+1,cad);
        }     
    }
    
//    public void elimOcurr(String cad){
//        elimOcurr(0,cad);
//    }
//    
//    private void elimOcurrB(int in, T dato){
//        if (arreglo==null || in==tam)
//            System.out.println("");
//
//        else if(!(arreglo[in].equals(dato))){
//            elimOcurrB(in+1, dato);
//        }
//        else{
//            arreglo[in]=null;
//            elimOcurrB(in+1,dato);
//        }     
//    }
//    
//    public void elimOcurrB(T dato){
//        elimOcurrB(0, dato);
//    }
   
  
    private int quicksortStep(int lo, int hi){
        T pivot;
        pivot = arreglo[lo];
        while(hi>lo){
            while(hi>lo && arreglo[hi].compareTo(pivot)>=0 ){
                hi--;
            }
            if(hi==lo)
                break;
            arreglo[lo]=arreglo[hi];
            lo++;
            while(hi>lo && arreglo[lo].compareTo(pivot)<=0){
                lo++;   
            }
            if (hi==lo)
                break;
            arreglo[hi]=arreglo[lo];
            hi--;
        }
        arreglo[lo]=pivot;
        return lo;
    }
    
    private void quicksort(int lo, int hi){
        if (hi<=lo){
            return;
        }
        else{
            int pivotPosition=quicksortStep(lo,hi);
            quicksort(lo, pivotPosition-1);
            quicksort(pivotPosition+1,hi);
        }
    }
    
    public void quicksort(){
        quicksort(0,tam-1);
    }
    
    
    private int posMenor(int ind, int indMenor){   
        if(ind==tam)
            return indMenor;
        
        else{
            if (arreglo[ind].compareTo(arreglo[indMenor])<0)
                indMenor=ind;
            
            return posMenor(ind+1,indMenor);
        }

    }
    
    
    public int posMenor(){
        return posMenor(0,0);
    }
    
    private void cambio(int i, int j){
        T uno=arreglo[i];
        T dos=arreglo[j];
        arreglo[i]=dos;
        arreglo[j]=uno;
    }
  
    private void selDir(int n){
        if (n!=tam){
            int min=posMenor(n,n);
            cambio(n,min);
            selDir(n+1);
        }  
    }
    
    public void selDri(){
        selDir(0);
    }
    
    
    
    public void ordenacionSeleccionDirecta(){
        ordenacionSeleccionDirecta(0,1, arreglo[0], 0);
    }
    
    private void ordenacionSeleccionDirecta(int i, int j, T menor, int pos){
        if(i<tam-1){
            if (j<tam){
               if (arreglo[j].compareTo(menor) < 0){
                   menor=arreglo[j];
                   pos=j;
               }
               ordenacionSeleccionDirecta(i,j+1,menor,pos);
            }
            else{
                arreglo[pos]=arreglo[i];
                arreglo[i]=menor;
                ordenacionSeleccionDirecta(i+1,i+2,arreglo[i+1],i+1);
            }
                   
            
        }
            
    }
    
 
}
