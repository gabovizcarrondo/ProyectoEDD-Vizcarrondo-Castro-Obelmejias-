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
                if(estacionActual.getNombre().equalsIgnoreCase(nombreEstacion)){
                  return estacionActual;
                        
                }
                
                aux = aux.getpNext();
            }
            return null;
        }
        return null;
    }
    
    public void insertStation(String nombreEstacion){ //cuando necesito agregar una estacion,agrego el nombre de la estacion
        if(this.search(nombreEstacion) == null){ //la estacion puede llegar a existir o no, por eso debo hacer "search", para comprobar
            Estacion estacion = new Estacion(nombreEstacion);//en caso de que la estacion no exista, agrego otra
            estacion.setNumVertice(this.estaciones.getSize());
            this.estaciones.insertFinale(estacion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La estacion ya existe.");
        }
    }
    
    public void addConnection(String nombreEstacion1, String nombreEstacion2){
        if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) != null){
        
    }else{
            if(this.search(nombreEstacion1) == null && this.search(nombreEstacion2) != null){
                JOptionPane.showMessageDialog(null, "La estacion de inicio no existe.");
            }else if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) != null){
                JOptionPane.showMessageDialog(null, "La estacion de llegada no existe.");
            }
        
    }
    }
}
