/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import colas.ColaA;
import colas.ColaADT;
import impresora.Archivo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author robertodelriosalgado
 */
public class Conjuntos {
    
    public static  String interseccionFrIng(ConjuntoADT<String> conj1, ConjuntoADT<String> conj2){
        return conj1.interseccion(conj2).toString();
    }
    
    public static int cardinalidadIng(ConjuntoADT<String> conjIng,ConjuntoADT<String> conjFran,
            ConjuntoADT<String> conjOtr){
        return conjIng.diferencia(conjFran).diferencia(conjOtr).getCardinalidad();
    }
    
    public static String alMenosTresI(ConjuntoADT<String> conj1, ConjuntoADT<String> conj2, 
            ConjuntoADT<String> conj3){
        return conj1.interseccion(conj3).interseccion(conj2).toString();
    }
    
    public static <T> boolean esDiferenciaSimet(ConjuntoADT<T> difSim,ConjuntoADT<T> uno, ConjuntoADT<T> dos){
        ConjuntoADT<T> conjAux;
        if(uno!=null && dos!=null && difSim!=null){
            conjAux=uno.diferencia(dos);
            if(conjAux.getCardinalidad()==difSim.getCardinalidad() && difSim.union(conjAux).getCardinalidad()==difSim.getCardinalidad()){
                return true;
            }
            else
                return false;      
        }
        else
            throw new ExcepcionColeccionVacia("No se encuentra el elemento");
            
    }
    
//    private static <T> void esDiferenciaSimet(ConjuntoADT<T> difSim, Iterator<T> it, boolean resp){
//        if (!it.hasNext())
//            T
//            resp = difSim.contiene(a);
//        
//    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConjuntoADT<Integer> uno= new ConjuntoA();
        ConjuntoADT<Integer> dos= new ConjuntoA();
        ConjuntoADT<Integer> difSim= new ConjuntoA();
        Iterator<Integer> it=difSim.iterator();
        uno.agrega(1);
        uno.agrega(2);
        uno.agrega(3);
        uno.agrega(4);
        dos.agrega(1);
        dos.agrega(21);
        dos.agrega(3);
        dos.agrega(4);
        difSim.agrega(4);
        
        System.out.println(difSim.toString());
        System.out.println(it.next());
//        System.out.println(uno.diferencia(dos).toString());
//        System.out.println(esDiferenciaSimet(difSim,uno,dos));
//        

        
        /*
        ConjuntoADT<String> colores = new ConjuntoA();
        ConjuntoADT<Archivo> archivos = new ConjuntoA();
        colores.agrega("rojo");
        colores.agrega("verde");
        colores.agrega("azul");
        colores.agrega("rojo");
        colores.agrega("verde");
        colores.agrega("amarillo");
       
        Iterator<String> it = colores.iterator();
        ArrayList<String> col = new ArrayList();
        while(it.hasNext())
            col.add(it.next());
        
        System.out.println("\n"+col.toString());
        
        archivos.agrega(new Archivo(2500, "Costos", "Juan Perez", "11/04/2021") {});
        archivos.agrega((new Archivo(1400, "Ventas", "Alicia Perez", "15/04/2021") {}));
        archivos.agrega((new Archivo(3200, "Clientes", "Daniel Paz", "19/04/2021") {}));
        archivos.agrega((new Archivo(3780, "Saldos", "Juan Perez", "23/04/2021") {}));
        Iterator<Archivo> itA= archivos.iterator();
        double suma=0;
        int cont=0;
        while(itA.hasNext()){
            cont++;
            suma+= itA.next().getTamaño();
        }
        try{
            System.out.println("\nPromedio "+suma/cont);
        } catch (Exception e){
            System.out.println("Sin elementos");
        }
        
        // ejemplo de iterador
        for(Archivo a : archivos)
            System.out.println(a.getNombre());
        int[] enteros[1,2,3,4,5,6,7,8,9];
        int sumaEnteros=0;
        for(int i : enteros)
            sumaEnteros+=i;
        System.out.println("Suma: "+ sumaEnteros);
        
        
        */
//         ConjuntoADT<String> frances = new ConjuntoA();
//         ConjuntoADT<String> ingles = new ConjuntoA();
//         ConjuntoADT<String> otros = new ConjuntoA();
//        
//      
//        try{
//            File archivo = new File("/Users/robertodelriosalgado/Desktop/Estructuras de datos/Conjuntos/src/conjuntos/Frances");
//            Scanner lee= new Scanner (archivo);
//            while (lee.hasNextLine()){
//                frances.agrega(lee.nextLine());
//            }
//            
//        }catch (Exception e){
//            System.out.println("Error al abrir archivo");
//        } 
//         try{
//            File archivo = new File("/Users/robertodelriosalgado/Desktop/Estructuras de datos/Conjuntos/src/conjuntos/Ingles");
//            Scanner lee= new Scanner (archivo);
//            while (lee.hasNextLine()){
//                ingles.agrega(lee.nextLine());
//            }
//            
//        }catch (Exception e){
//            System.out.println("Error al abrir archivo");
//        } 
//        try{
//            File archivo = new File("/Users/robertodelriosalgado/Desktop/Estructuras de datos/Conjuntos/src/conjuntos/Otros");
//            Scanner lee= new Scanner (archivo);
//            while (lee.hasNextLine()){
//                otros.agrega(lee.nextLine());
//            }
//            
//        }catch (Exception e){
//            System.out.println("Error al abrir archivo");
//        } 
//        
//        System.out.println("Frances: "+frances.toString());
//        System.out.println("Ingles: "+ingles.toString());
//        System.out.println("otros: "+otros.toString());
//        
//        System.out.println(interseccionFrIng(frances, ingles));
//        System.out.println(cardinalidadIng(ingles, frances, otros));
//        System.out.println(alMenosTresI(frances, ingles, otros));
        
    }
      
    
}
