/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Estacion;
import EDD.Grafo;
import EDD.Lista;
import javax.swing.JOptionPane;

/**
 *
 * @author vizca
 */
public class Funcion {
    public Lista estacionesSinSucursal (Grafo grafo ){
        if(!grafo.isEmpty()){
            Lista estacioneSinSucursal = new Lista();
            for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
                Estacion estacionActual = (Estacion) grafo.getEstaciones().getValor(i);
                if(!estacionActual.isSucursal()){
                    estacioneSinSucursal.insertFinale(estacionActual.getNombre());
                }
            }
            return estacioneSinSucursal;
        }
        return null;
    }
    
    public Lista estacionesConSucursal(Grafo grafo){
         if(!grafo.isEmpty()){
             Lista estacionesConSucursal = new Lista();
             for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
                 Estacion estacionActual =(Estacion) grafo.getEstaciones().getValor(i);
                 if(estacionActual.isSucursal()){
                     estacionesConSucursal.insertFinale(estacionActual.getNombre());
                 }
             }
             return estacionesConSucursal;
         }
         return null;
    }
    
    public Lista verEstaciones(Grafo grafo){
         if(!grafo.isEmpty()){
             Lista estaciones = new Lista();
             for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
                 Estacion estacionActual =(Estacion) grafo.getEstaciones().getValor(i);
                 
                     estaciones.insertFinale(estacionActual.getNombre());
                 
             }
             return estaciones;
         }
         return null;
    }
    
    public void agregarSucursal(Grafo grafo, String nombreEstacion){
        if(grafo.search(nombreEstacion) != null){
            //guardar la estacion e igualarla a la busqueda
            Estacion estacion = grafo.search(nombreEstacion);
            estacion.setSucursal(true);
            JOptionPane.showMessageDialog(null, "Sucursal agregada con exito en: " + estacion.getNombre());
        }else{
            JOptionPane.showMessageDialog(null, "La sucursal no se pudo agregar, ya que el nombre de la estacion no se encuentra en el grafo");
        }
    }
    
    public void eliminarSucursal(Grafo grafo, String nombreEstacion){
        if(grafo.search(nombreEstacion) != null){
            //guardar la estacion e igualarla a la busqueda
            Estacion estacion = grafo.search(nombreEstacion);
            estacion.setSucursal(false);
            JOptionPane.showMessageDialog(null, "Sucursal eliminada en: " + estacion.getNombre());
        }else{
            JOptionPane.showMessageDialog(null, "La sucursal no se pudo eliminar, ya que el nombre de la estacion no se encuentra en el grafo");
        }
    }
    
    public String mostrarEstaciones(Lista linea){
        //si la lista linea no está vacía entra en el if, sino retorna un mensaje
        if(!linea.isEmpty()){
            String estacionesStr = "";
            for (int i = 0; i < linea.getSize(); i++) {
                Estacion estacionActual = (Estacion) linea.getValor(i);
                estacionesStr += estacionActual.getNombre() + "\n";
            }
            
            return estacionesStr;
        }
        return "La lista aún no tiene estaciones";
        
    }
    
    
    public void agregarConexion (String nombreEstacionLinea, String nombreEstacionRed,Lista conexion){
        if (conexion.isEmpty()){
            conexion.insertFinale(nombreEstacionRed);
            conexion.insertFinale(nombreEstacionLinea);
        }else{
            conexion.destruir();
            conexion.insertFinale(nombreEstacionRed);
            conexion.insertFinale(nombreEstacionLinea);
        }
    }
}
