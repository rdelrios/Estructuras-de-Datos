/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasenlazadas;

import conjuntos.Alumno;
import java.util.Iterator;

/**
 *
 * @author robertodelriosalgado
 */
public class EstructurasEnlazadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EE est1 = new EE();
        EE<Integer> est2 = new EE();
        EE<Integer> est3 = new EE();
        
        est2.agregaInicio(1);
        est2.agregaInicio(2);
        est2.agregaInicio(3);
        est2.agregaInicio(4);
        est2.agregaInicio(5);
//        est3.agregaInicio(-1);
//        est3.agregaInicio(-2);
//        est3.agregaInicio(-3);
//        est3.agregaInicio(-4);
//        est3.agregaInicio(-5);
//        est3.agregaInicio(-6);
//        est3.agregaInicio(-7);
//        System.out.println(est2.toString());
//        System.out.println(est3.toString());
//        est2.intercalaNodos(est3);
        est3.intercalaNodos(est2);
//        System.out.println(est2.toString());
        System.out.println(est3.toString());
//        EE<Alumno> alums = new EE();
//        boolean resp;
//        double suma;
//        int contador;
//        
////        est1.agregaInicio("verde");
////        est1.agregaFinal(34);
////        System.out.println(est1); //sout toma por default el toString() no es necesario ponerlo
////        
//        est2.agregaFinal(12);
////        est2.agregaFinal(45);
////        est2.agregaFinal(18);
////        est2.agregaFinal(35);
//        System.out.println(est2); 
////        System.out.println(est2.insertaAntesQue(35, 32));
//        System.out.println(est2.calculaTamanio());
//        
//        est3.agregaFinal(14);
//        System.out.println(est3.quitaUtlimo());
//        System.out.println("\n"+est3);
        
//        System.out.println(est2);
//        System.out.println(est2.eliminaAnteriorA(12));
//        System.out.println(est2);
        
//        
//        alums.agregaFinal(new Alumno("Juan", 19, 9.5));
//        alums.agregaFinal(new Alumno("Ines", 20, 8.5));
////        alums.agregaFinal(new Alumno("Maria", 22, 7.4));
////        alums.agregaFinal(new Alumno("Carlos", 18, 7.6));
//        alums.agregaFinal(new Alumno("Daniel", 19, 8.9));
//        System.out.println("\nAlumnos\n" + alums);
//        System.out.println(alums.calculaTamanio());
//        
//        //promedio menor a 8
//        Iterator<Alumno> it = alums.iterator();
//        resp=false;
//        while (it.hasNext() && !resp)
//            resp = it.next().getPromedio() < 8;
//        if (resp)
//            System.out.println("\nSi hay alguien con promedio menor a 8\n");
//        
//        // promedio de todos los alumnos
//        suma=0;
//        contador=0;
//        for (Alumno a : alums){
//            suma+=a.getPromedio();
//            contador++;
//        }
//        if (contador>0)
//            System.out.println("\nPromedio = "+suma/contador);
//        else
//            System.out.println("\nNo hay alumnos");
        
        
    }
    
}
