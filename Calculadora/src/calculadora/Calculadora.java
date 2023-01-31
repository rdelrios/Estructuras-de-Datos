/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author robertodelriosalgado
 */
public class Calculadora {
    /**
     * 
     * @param c char que va a revisar 
     * @return determina si el char dado es un operador 
     */
    
    public static boolean esOperador(char c){
        boolean operador=false;
        if (c=='+' || c=='-' || c=='*' || c=='/'){
            operador=true;
        }
        return operador;
                    
    }
    
    /**
     * 
     * @param c char que va a revisar
     * @return determina si el char dado es un operando
     */
    public static boolean esOperando(char c){
        boolean operando=false;
        if (c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8'
                || c=='9' || c=='0'  || c=='_' || c=='.'){
            operando=true;
        }
        return operando;
        
    }
    
    /**
     * 
     * @param exp String de expresion a modificar 
     * @return la expresion ingresada en forma de arreglo 
     */
    public static String[] hacerArreglo(String exp){
        String[] arreExp=new String[exp.length()+1]; 
        int i=0,k;
        String aux;
        
        while (i<exp.length()){
            if (exp.charAt(i)=='(' || exp.charAt(i)==')' || esOperador(exp.charAt(i))){
                arreExp[i]=exp.charAt(i)+"";
                i++;
            }
            else{
                k=0;
                aux="";
                while (i+k<exp.length() && esOperando(exp.charAt(i+k))){
                    aux+=exp.charAt(i+k)+"";
                    
                    k++; 
                }
                arreExp[i]=aux;
                i+=k;        
            }   
        }
        return arreExp;
    }
    
    /**
     * 
     * @param c char a revisar
     * @return el valor de la jerarquia de la operación
     */
    
    public static int checarJerarquia(char c){
        int numJer=0;
        if (c=='*' || c=='/')
            numJer=2;
        else if (c=='+' || c=='-' )
            numJer=1;
        return numJer;
    }
    
    /**
     * 
     * @param arreExp arreglo de la expresion dada
     * @return la modifica de expresion  infija a postfija
     */
    public static String [] notacionPostfija(String[] arreExp){
        PilaA<String> operadores=new PilaA();
        String[] notPost=new String[arreExp.length];
        int k=0;
        char c;
        operadores.push("(");
        arreExp[arreExp.length-1]=")";
        char negativo='-';
        char indnegativo='_';
        
        for (int i=0; i<arreExp.length; i++){
            if (arreExp[i]!=null){
                c=arreExp[i].charAt(0);
                if (esOperando(c)){
                    if (arreExp[i].charAt(0)=='_'){
                        notPost[k]=arreExp[i].replace(indnegativo, negativo);
                        k++;
                    }
                    else{
                        notPost[k]=arreExp[i];
                        k++;
                    }
                }
                if (c=='('){
                    operadores.push(arreExp[i]);
                }
                if (esOperador(c)){
                    while ( operadores.peek()!=null && esOperador(operadores.peek().charAt(0)) && 
                            checarJerarquia(c)<=checarJerarquia(operadores.peek().charAt(0))){
                        notPost[k]=operadores.pop();
                        k++;        
                    }
                    operadores.push(arreExp[i]);
                }
                if(c==')'){
                    while(operadores.peek()!=null && esOperador(operadores.peek().charAt(0)) && operadores.peek().charAt(0)!='('){
                        notPost[k]=operadores.pop();
                        k++;
                    }
                    operadores.pop();
                }     
            }
        }
        return notPost;
    }
    
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cad="9.99+_5432";
        String [] lol=hacerArreglo(cad);
        String[] hehe=notacionPostfija(lol);
        for (int i=0; i<hehe.length;i++){
            System.out.println(hehe[i]);
        }
       

        
        
    }

   
    
}
