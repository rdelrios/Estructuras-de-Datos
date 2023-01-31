/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresora;

import colas.ColaA;
import colas.ColaADT;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author robertodelriosalgado
 */
public class Impresora{
    private String marca;
    private ColaADT<Archivo> pendientes;

    public boolean cargaArchivos(String nombreArch, int total){
        //total=entrada.nextIn
        boolean resp=true;
        try{
            FileInputStream file = new FileInputStream(nombreArch);
            ObjectInputStream entrada = new ObjectInputStream(file);
            
            Object aux;
            for(int i=0; i<total;i++){
                aux=(Archivo) entrada.readObject();
                pendientes.agrega((Archivo) aux);
            }
        } catch (Exception e){
            System.out.println("Error al abrir archivo");
            resp=false;
        }
        return resp;
    }
    
    public void agregaArchivo(Archivo a){
        pendientes.agrega(a);       
    }
    
    public String imprimeArchivo(){
        String impresion=null;
        if (!pendientes.estaVacia())
            impresion=pendientes.quita().toString();
        return impresion;
    }
    
    public void eliminiarFotos(){
        if (!pendientes.estaVacia()){
            ColaADT<Archivo> aux=new ColaA();
            Archivo a;
            while(!pendientes.estaVacia()){
                a=pendientes.quita();
                if(a instanceof Documento){
                    aux.agrega(a);
                }
            }
            while(!aux.estaVacia()){
                pendientes.agrega(aux.quita());
            }
        }
    }
    
    
    
    public void eliminarArchPesa(){
        if(!pendientes.estaVacia()){
            ColaADT<Archivo> aux=new ColaA();
            while (!pendientes.estaVacia()){
                Archivo a=pendientes.quita();
                if(a instanceof Foto){
                    aux.agrega(a);
                }
                else{
                    if(a.getTamaño()<=500)
                        aux.agrega(a);
                }
            }
            while (!aux.estaVacia()){
                pendientes.agrega(aux.quita());
            }
        }
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Impresora imp1= new Impresora();
//    
//        imp1.cargaArchivos("archivos", 5);
//        System.out.println(imp1.imprimeArchivo());

        
        
        
    }
    
}
