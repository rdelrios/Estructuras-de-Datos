/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.util.ArrayList;

/**
 *
 * @author robertodelriosalgado
 */
public interface ColaADT <T> {
    public void agrega(T nuevo);
    public T quita();
    public T consultaPrimero();
    public boolean estaVacia();
    public String imprimeCola();
    //Ejercicio 36
    public int cuentaElementos();
    public T consultaUltimo();
    public ArrayList<T> multiQuita(int n);
}
