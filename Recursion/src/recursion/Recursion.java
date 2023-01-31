/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import java.util.Scanner;
import static recursion.OperacionesArregloBidimensional.multiplicaMatrices;
import static recursion.OperacionesArregloBidimensional.sumaDiagonalPrincipal;
import static recursion.OperacionesArregloBidimensional.sumaMatrices;
import static recursion.OperacionesArregloBidimensional.sumaPorColumna;
import static recursion.OperacionesArregloBidimensional.sumaPorRenglon;
import static recursion.OperacionesArregloBidimensional.toStringAB;

/**
 *
 * @author robertodelriosalgado
 */
public class Recursion {
    
    //TORRES DE HANOI
    public static void imprimeMovHanoi(int n, String origen, String destino, String auxiliar){
        if(n == 1)
            System.out.println("Mover un disco de "+origen+" a "+destino);
        else{
            imprimeMovHanoi(n-1,origen,auxiliar,destino);
            System.out.println("Mover un disco de "+origen+" a "+destino);
            imprimeMovHanoi(n-1,auxiliar,destino,origen);
        }
    }
    
    
    
    
    
    public static double calculaFactorial(int n){
        if (n==0 || n==1) //estado base
            return 1;
        else 
            return n * calculaFactorial(n-1);  //estado recursivo
    }
    
    //problema 27
    public static int sumaArre(int arre[], int total){
        if (total==0)
            return 0;
        else
            return arre[total-1]+sumaArre(arre, total-1);
   
    } 
    
    //Problema 28 a
    public static void imprimeArreA(int arre[], int total){
        if (total==0)
            System.out.println("");
        else {

            System.out.println(arre[total-1]);
            imprimeArreA(arre,total-1);
        }
    }
    //problema 28 b
    private static void imprimeArreB(int arre[], int i, int total){//privado ya que con este se trabaja
        if (i<total){
            System.out.println(arre[i]);
            imprimeArreB(arre, i+1, total);
        }
    }
    
    public static void imprimeArreB(int arre[], int total){ //sobrecarga 
        imprimeArreB(arre,0,total);
    }
    
    static int i=0; //no es buena practica esto !!!
    public static void ImprimeArreB(int arre[],int total){//otra forma
        if (total==0)
            System.out.println("");
        else{
            System.out.println(arre[i]);
            i++;
            ImprimeArreB(arre, total-1);
        }
    }
    
    public static void ImprimeArreBB(int arre[], int total){ //muy costosa
        if (total>0){
            ImprimeArreB(arre,total-1);
            System.out.println(arre[total-1]);
        }
    }
    
    
    
    
    //escribir métodos recursivos para calcular la serie de Fibonacci para n (n > 0)
    //y la serie de Ullman para n (n > 0)
    static int f1=0,f2=1,f3=0;
    public static void serieFib(int n){//n es 
        if (n==0)
            System.out.println("");
        else{
            //int res=f3;
            f3=f1+f2;
            f1=f2;
            f2=f3;
            int res=f3;
            serieFib(n-1);
            System.out.println(""+res);
        }
    }
    public static int calculaFibonacciA(int n){
        if (n<0)
            return -1;
        else
            return calculaFibonacci (n);
    }
    private static int calculaFibonacci(int n){
        if (n==0)
            return 0;
        else
            if(n==1)
                return 1;
            else
                return calculaFibonacci(n-1)+calculaFibonacci(n-2);
    }
    
    
    
    
    public static void serieUlam(int n){
        if (n==1)
            System.out.println(n);
        else{
            System.out.println(n);
            if (n%2==0)
                n=n/2;
            else
                n=n*3+1;
            serieUlam(n);
        }
    }
    //con string
    public static String calculaUlam(int num){
        String cad=null;
        if (num>0)
            return calculaUlam(num, new StringBuilder());
        return cad;
    }
    
    private static String calculaUlam(int num, StringBuilder cad){
        cad.append(num+" ");
        if (num==1)
            return cad.toString();
        else{
            if (num%2==0)
                return calculaUlam(num/2, cad);
            else
                return calculaUlam(num*3+1, cad);
        }
    }
    
    
    
    private static boolean checarPalin(String cad, int i, int j,int medio, boolean resp){
        if(i>medio)
            return resp;
        else if (cad.charAt(i)==cad.charAt(j))
            return checarPalin(cad, i+1,j-1,medio,true);
        else
            return false;
    }
    
    public static boolean checarPalin(String cad){
        String l=quitarEspacios(cad);
        int j=l.length()-1;
        int medio=j/2;
        
        return checarPalin(l.toLowerCase(),0,j,medio, false);
        
    }
    
    private static String quitarEspacios(String cad, int i , StringBuilder aux){
        if (i==cad.length())
            return aux.toString();
        else if (Character.isLetter(cad.charAt(i)) || Character.isDigit(cad.charAt(i))){
            aux.append(cad.charAt(i));
            return quitarEspacios(cad,i+1,aux); 
        }
        else
            return quitarEspacios(cad,i+1,aux);
    }
    
    public static String quitarEspacios(String cad){
        return quitarEspacios(cad,0,new StringBuilder());
    }
    
    
    
    public static int cuentaPalabras(Scanner lee, int contador){
        if (lee.hasNext()){
            lee.next(); //interrumpe con el espacio en blanco
            contador++;
        return cuentaPalabras(lee,contador);
        }
        else{
            lee.close();
            return contador;
        }
            
    }
    
    private static int espejoNum(int n, StringBuilder cad){
        if (n==0){
            return Integer.parseInt(cad.toString());
        }
        else{
            int mod=n%10;
           
            cad.append(mod);
            return espejoNum(n/10, cad);
        }
    }
    
    public static int espejoNum(int n){
        return espejoNum(n,new StringBuilder());
    }
    
    private static int mcd(int i, int j, int res){
        if (j==0)
            return i;
        else if (i==0)
            return j;
        else{
            return mcd(j, i%j,res);
        }
    }
    
    public static int mcd(int i, int j){
        if (j>=0 && i>=0)
            return mcd(i,j,0);
        else
            return -1;
    }
    
    private static double calculaRaizCuadrada(double numero, double error, double inferior, double superior){
        double raiz=(inferior + superior)/2;
        if (Math.abs(raiz*raiz-numero) < error)
            return raiz;
        else{
            if (raiz*raiz<numero)
                return calculaRaizCuadrada( numero,  error, raiz, superior);
             
            else
                return calculaRaizCuadrada( numero,  error, inferior, raiz);
        }
    }
    
    public static double calculaRaizCuadrada(double numero, double error){
        return calculaRaizCuadrada( numero,  error, 0, numero);
    }
    
    //suma los elementos de la primera columna con los de la ultima y los de la segunda con los de la antepenultima
    public static void sumaColumnas(int[][] matriz, int totR, int totC){
        if (matriz!=null && totR>0 && totC>0){
            sumaColumnas(matriz, totR, totC, 0, 0, totC-1);
        }
    }
    
    private static void sumaColumnas(int[][] matriz, int totR, int totC, int i, int j, int control){
        if(j<control){
            if(i<totR){
                matriz[i][j]=matriz[i][j]+ matriz[i][control];
                System.out.println(matriz[i][j]+" i: "+i+" j: "+j);
                sumaColumnas(matriz, totR,totC,i+1,j,control);
            }
            else{
                System.out.println("break");
                sumaColumnas(matriz, totR,totC,0,j+1,control-1);
            }
        }
       
        
    }
    
    public static String imprimeMatriz(int[][] matriz, int totR, int totC){
        StringBuilder cad=new StringBuilder();
        for (int i=0; i<totR;i++){
            cad.append("\n");
            for (int j=0; j<totC; j++){
                cad.append(matriz[i][j]+" ");
            }
        }
        return cad.toString();
            
    }
            
            

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws FileNotFoundException {
        
        int[][] matriz= new int[4][4];
        matriz[0][0]=2;
        matriz[1][0]=2;
        matriz[2][0]=2;
        matriz[3][0]=2;
        matriz[0][1]=5;
        matriz[1][1]=5;
        matriz[2][1]=5;
        matriz[3][1]=5;
        matriz[0][2]=3;
        matriz[1][2]=3;
        matriz[2][2]=3;
        matriz[3][2]=3;
        matriz[0][3]=4;
        matriz[1][3]=4;
        matriz[2][3]=4;
        matriz[3][3]=4;
        
        System.out.println(imprimeMatriz(matriz,4,4));
        sumaColumnas(matriz,4,4);
        System.out.println(imprimeMatriz(matriz,4,4));
        
//        System.out.println(calculaRaizCuadrada(4,0.));
//        System.out.println(mcd(0,51));
//        int[] arre=new int[10];
//        int j=0;
//        for (int i=0;i<arre.length;i++){
//            arre[i]=j;
//            j++;
//            System.out.println(arre[i]);
//        }
//        imprimeArreA(arre,10);
//        ImprimeArreBB(arre,10);
//        serieFib(5);
//        System.out.println("");
//        System.out.println(calculaFibonacciA(6));
//        System.out.println("");
//        serieUlam(26);
//        System.out.println("");
//        System.out.println(calculaUlam(26));
//        ArregloGenerico arr=new ArregloGenerico();
//        StringBuilder lol=new StringBuilder();
//        arr.altaDato(55);
//        arr.altaDato(43);
//        
//        arr.altaDato(1780);
//        arr.altaDato(1780);
//        arr.altaDato(58);
//        arr.altaDato(1783);
//        arr.altaDato(59);
//        arr.altaDato(1);
//        arr.selDri();
//        arr.quicksort();
//        System.out.println(arr.toStrings());
//        
//
//        arr.altaDato("hola");
//       System.out.println(arr.busBin(55));
//        arr.elimOcurr("String");
//       
//        arr.elimOcurrB(1780);
//        System.out.println(arr.toStrings());
//        System.out.println(arr.posMayor());
//        
//        try{
//            File archivo = new File("Frases");
//            Scanner lee= new Scanner (archivo);
//            int totalPalabras;
//            totalPalabras=cuentaPalabras(lee, 0);
//            System.out.println("\nTotal de palabras: "+totalPalabras);
//            
//        }catch (Exception e){
//            System.out.println("Error al abrir archivo");
//        }
//12321
//neuquen
//1001001
//anita lava la tina
//amigo no gima
//yo dono rosas oro no doy
//        String cad="12211";
//        
//        System.out.println(checarPalin(cad));
//        

//        double[][] arre;
//        arre=new double[2][2];
//        arre[0][0]=10;
//        arre[1][0]=4;
//        arre[1][1]=4;
//        arre[0][1]=5;
//        double[][] arre2;
//        arre2=new double[2][2];
//        arre2[0][0]=20;
//        arre2[1][0]=5;
//        arre2[1][1]=7;
//        arre2[0][1]=10;
//        
//        double[][] arresuma;
//        arresuma=new double[2][2];
//        arresuma=sumaMatrices(2,1,arre,2,2,arre2);
//        
        
        
//        System.out.println(sumaPorRenglon(3,3,arre));
//        sumaPorColumna(3,3,arre);
//        System.out.println(toStringAB(2,2,arresuma));
//        System.out.println(sumaDiagonalPrincipal(2,2,arre2));
//        System.out.println(sumaMatrices(2,2,arre,2,2,arre2));
//        System.out.println(multiplicaMatrices(1,2,arre,2,2,arre2));


       
//        imprimeMovHanoi(3, "Origen","Destino", "Auxiliar");

//        System.out.println(espejoNum(6543));

        
    }
    
}
