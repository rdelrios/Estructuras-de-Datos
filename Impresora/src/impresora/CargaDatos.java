/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresora;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author robertodelriosalgado
 */
public class CargaDatos {
    
public static void main(String[] args){
    
    try{
        FileOutputStream file=new FileOutputStream("archivos");
        ObjectOutputStream escribe= new ObjectOutputStream(file);
        
        escribe.writeObject(new Documento("....", 501, "dddd", "juan", "01/12/5435"));
        escribe.writeObject(new Foto(300, 200, "dddd", "juan", "01/12/5435"));
        escribe.writeObject(new Documento("lol", 200, "aaaaa", "pedro", "12/12/5435"));
        escribe.writeObject(new Foto(300, 200, "dddd", "juan", "01/12/5435"));
        escribe.writeObject(new Documento("..44..", 500, "dd44dd", "ju44an", "01/142/5435"));
        
        escribe.close();
    } catch (Exception e){
        System.out.println("no se pudo abrir el archivo");
    } 
    
    
    Impresora imp1= new Impresora();
    
    imp1.cargaArchivos("archivos", 5);
    System.out.println(imp1.imprimeArchivo());

 
    

}
    
    
}
