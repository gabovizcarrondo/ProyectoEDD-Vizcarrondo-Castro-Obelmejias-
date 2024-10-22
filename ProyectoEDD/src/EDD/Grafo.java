/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author obelm
 */
public class Grafo {
    
    private Lista estaciones;

    public Grafo() {
        this.estaciones = new Lista();
    }

    public Lista getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(Lista estaciones) {
        this.estaciones = estaciones;
    }
    
    public boolean isEmpty(){
        return this.estaciones.isEmpty();
    }
    
    public Estacion search(String nombreEstacion){
        if(!this.isEmpty()){
            Nodo aux = this.estaciones.getpFirst();
            while(aux != null){
                Estacion estacionActual = (Estacion) aux.getDato();
                if(estacionActual.getNombre().equalsignoreCase(nombreEstacion)){
                  return estacionActual;
                        
                }
                
                aux = aux.getpNext();
            }
            return null;
        }
        return null;
    }
    
    public void insertStation(String nombreEstacion){
        if(this.search(nombreEstacion) == null){
            Estacion estacion = new Estacion(nombreEstacion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La estacion ya existe.");
        }
    }
}
