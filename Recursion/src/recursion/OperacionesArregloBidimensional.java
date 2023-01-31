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
public class OperacionesArregloBidimensional {
    
    //1)sumaPorRenglón: suma por renglón todos los elementos del arreglo bidimensional, regresando la suma obtenida.
    private static double sumaPorRenglon( int ren, int col,double suma, double[][] arre, int i, int j){
        if(i<ren){
            if(j<col){
                suma+=arre[i][j];
                return sumaPorRenglon(ren,col,suma,arre,i,j+1);  
            }
            else{
                j=0;
                return sumaPorRenglon(ren, col,suma,arre,i+1,j);
            } 
        }
        return suma;
    }
    
    public static double sumaPorRenglon( int ren, int col,double[][] arre){
        return sumaPorRenglon(ren,col,0,arre,0,0); 
    }
    
    //2)sumaPorColumna: suma por columna todos los elementos del arreglo bidimensional, regresando la suma obtenida.

     private static void sumaPorColumna( int ren, int col,double suma, double[][] arre, int i, int j){
        if(j<col){
            if(i<ren){
                suma+=arre[i][j];
                sumaPorColumna(ren,col,suma,arre,i+1,j);  
            }
            else{
                i=0;
                sumaPorColumna(ren,col,suma,arre,i,j+1);
            }
        }
        else{
            System.out.println(suma);
        }
    }
    
    public static void sumaPorColumna( int ren, int col,double[][] arre){
        sumaPorColumna(ren, col,0,arre,0,0); 
    }
    
    //3)toString(): regresa el contenido del arreglo en forma de cadena.
    private static String toStringAB(int ren, int col, StringBuilder cad, int i, int j, double[][] arre){
            if(i<ren){
                if(j<col){
                    cad.append(arre[i][j]+" ");
                    return toStringAB(ren,col,cad,i,j+1,arre);
                }
                else{
                    j=0;
                    cad.append("\n");
                    return toStringAB(ren,col,cad,i+1,j,arre);
                }
            }
        return cad.toString();
    }
    
    public static String toStringAB(int ren, int col,double[][] arre){
        if(arre!=null)
            return toStringAB(ren,col,new StringBuilder(),0,0,arre);
        else
            return null;
    }
    
    
    private static double sumaDiagonalPrincipal(int ren, int col, double[][] arre,double suma, int i){
        if (i<ren){
            suma+=arre[i][i];
            
            return sumaDiagonalPrincipal(ren,col,arre,suma,i+1);
        }
        return suma;
    }
    
    public static double sumaDiagonalPrincipal(int ren, int col, double [][] arre){
        if (ren==col){
            return sumaDiagonalPrincipal(ren,col,arre,0,0);
        }
        else
            return Double.NaN;
    }
    
    
    private static double[][] sumaMatrices(int ren1, int col1, double [][] arre1,
            int ren2, int col2, double [][] arre2, double [][] arresum, int i, int j){
        if (i<ren1){
            if(j<col1){
                arresum[i][j]=arre1[i][j]+arre2[i][j];
                return sumaMatrices(ren1,col1,arre1,ren2,col2,arre2,arresum,i,j+1);
            }
            else{
                j=0;
                return sumaMatrices(ren1,col1,arre1,ren2,col2,arre2,arresum,i+1,j);
            }
        }
        else{
            return arresum;
        }
    }
    
    public static double[][] sumaMatrices(int ren1, int col1, double [][] arre1,
            int ren2, int col2, double [][] arre2){
        if (ren1==ren2 && col1==col2)
            return sumaMatrices(ren1,col1,arre1,ren2,col2,arre2,new double[ren1][col1],0,0);
        else
            return null;
    }
    
    private static double[][] multiplicaMatrices(int ren1, int col1, double [][] arre1,
            int ren2, int col2, double [][] arre2, double [][] arremult, int i, int j,int z,double suma){
        if(i<ren1){
            if(j<col2){
                if(z<col1){
                    suma+=arre1[i][z]*arre2[z][j];
                    return multiplicaMatrices(ren1,col1,arre1,ren2,col2,arre2,arremult,i,j,z+1,suma);
                }
                else{
                    arremult[i][j]=suma;
                    suma=0;
                    z=0;
                    return multiplicaMatrices(ren1,col1,arre1,ren2,col2,arre2,arremult,i,j+1,z,suma);
                }
            }
            else{
                suma=0;
                z=0;
                j=0;
                return multiplicaMatrices(ren1,col1,arre1,ren2,col2,arre2,arremult,i+1,j,z,suma);
            }
        }
        else{
            return arremult;
        }
        
    }
    
    public static double[][] multiplicaMatrices(int ren1, int col1, double [][] arre1,
            int ren2, int col2, double [][] arre2){
        if (ren2==col1)
            return multiplicaMatrices(ren1,col1,arre1,ren2,col2,arre2,new double[ren1][col2],0,0,0,0);
        else
            return null;
    }
    
}  
