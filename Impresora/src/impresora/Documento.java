/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresora;

/**
 *
 * @author robertodelriosalgado
 */
public class Documento extends Archivo {
    private String tipoProcesador;

    public Documento() {
        super();
    }

    public Documento(String tipoProcesador, double tamaño, String nombre, String dueño, String fecha) {
        super(tamaño, nombre, dueño, fecha);
        this.tipoProcesador = tipoProcesador;
    }
    
    
    

    public Documento(double tamaño) {
        super(tamaño);
    }

    @Override
    public String toString() {
        return "Documento";
    }
    
    
    
    
    
    
}
