/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Estacion;
import EDD.Grafo;
import EDD.Lista;

/**
 *
 * @author vizca
 */
public class Funcion {
    public Lista estacionessinSucursal (Grafo grafo ){
        if(!grafo.isEmpty()){
            Lista estacionesinSucursal = new Lista();
            for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
                Estacion estacionActual = (Estacion) grafo.getEstaciones().getValor(i);
                if(!estacionActual.isSucursal()){
                    estacionesinSucursal.insertFinale(estacionActual.getNombre());
                }
            }
            return estacionesinSucursal;
        }
        return null;
    }
}
