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
/**
 * Clase que define funciones para operar con estaciones en un grafo.
 * Permite agregar, eliminar y visualizar estaciones con y sin sucursales,
 * además de gestionar conexiones y l&iacute;neas de estaciones.
 */

public class Funcion {
    
    /**
     * Devuelve una lista de estaciones que no tienen sucursal en el grafo.
     * 
     * @param grafo el grafo de estaciones a revisar.
     * @return Lista de nombres de estaciones sin sucursal o null si el grafo está vac&iacute;o.
     */
    
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
    
    /**
     * Devuelve una lista de estaciones que tienen sucursal en el grafo.
     * 
     * @param grafo el grafo de estaciones a revisar.
     * @return Lista de nombres de estaciones con sucursal o null si el grafo est&aacute vac&iacute;o.
     */
    
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
    
     /**
     * Devuelve una lista con los nombres de todas las estaciones en el grafo.
     * 
     * @param grafo el grafo de estaciones a revisar.
     * @return Lista de nombres de todas las estaciones o null si el grafo est&aacute vac&iacuteo.
     */
    
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
    
    /**
     * Establece una estación específica como sucursal en el grafo.
     * 
     * @param grafo el grafo donde se encuentra la estación.
     * @param nombreEstacion el nombre de la estaci&oacute;n a convertir en sucursal.
     */
    
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
    
    /**
     * Elimina la sucursal de una estaci&oacute;n espec&iacute;fica en el grafo.
     * 
     * @param grafo el grafo donde se encuentra la estación.
     * @param nombreEstacion el nombre de la estaci&oacute;n a eliminar como sucursal.
     */
    
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
    
    /**
     * Muestra los nombres de las estaciones en una lista.
     * 
     * @param linea la lista de estaciones a mostrar.
     * @return Un string con los nombres de las estaciones, o un mensaje si la lista est&aacute vac&iacute;a.
     */
    
    public String mostrarEstaciones(Lista linea){
        //si la lista linea no esta vacía entra en el if, sino retorna un mensaje
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
    
      /**
     * Agrega una conexi&oacute;n entre dos estaciones en una lista de conexiones.
     * 
     * @param nombreEstacionLinea nombre de la estaci&oacute;n en la l&iacute;nea.
     * @param nombreEstacionRed nombre de la estaci&oacute;n en la red.
     * @param conexion la lista donde se agrega la conexi&oacute;n.
     */
    
    public void agregarConexion (String nombreEstacionLinea, String nombreEstacionRed,Lista conexion){
        if (conexion.isEmpty()){
            conexion.insertFinale(nombreEstacionRed);
            conexion.insertFinale(nombreEstacionLinea);
        }else{
            conexion.destruir();
            conexion.insertFinale(nombreEstacionRed);
            conexion.insertFinale(nombreEstacionLinea);
            
        }
        
        JOptionPane.showMessageDialog(null, "Se estableció la conexión con la red :)");
    }
     
    /**
     * Establece conexiones directas entre estaciones consecutivas en una l&iacute;nea.
     * 
     * @param linea la lista de estaciones en la l&iacute;nea.
     */
    
    public void agregarConexionesLinea(Lista linea){
        for (int i = 0; i < linea.getSize()-1; i++) {
            Estacion estacionActual = (Estacion) linea.getValor(i);
            Estacion estacionSiguiente = (Estacion) linea.getValor(i + 1);
            
            estacionActual.getAdyacentes().insertFinale(estacionSiguiente);
            estacionSiguiente.getAdyacentes().insertFinale(estacionActual);
        }
    }
    
    /**
     * Agrega una lista de estaciones a un grafo.
     * 
     * @param grafo el grafo donde se insertan las estaciones.
     * @param linea la lista de estaciones a agregar.
     */
    
    public void agregarLinea(Grafo grafo, Lista linea){
        for (int i = 0; i < linea.getSize(); i++) {
            Estacion estacionActual = (Estacion) linea.getValor(i);
            grafo.insertStation2(estacionActual);
        }
    }
}
