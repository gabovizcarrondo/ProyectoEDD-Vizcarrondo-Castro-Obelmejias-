/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import EDD.Estacion;
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
    
    public void insertStation2(Estacion estacion){ 
        if(this.search(estacion.getNombre()) == null){          
            estacion.setNumVertice(this.estaciones.getSize());
            this.estaciones.insertFinale(estacion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La estacion ya existe.");
        }
    }
    
    public void addConnection(String nombreEstacion1, String nombreEstacion2){
        if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) != null){
            Estacion estacionInicio = search(nombreEstacion1);
            Estacion estacionFinal = search(nombreEstacion2);
            
            estacionInicio.getAdyacentes().insertFinale(estacionFinal);
            estacionFinal.getAdyacentes().insertFinale(estacionInicio);
            
            JOptionPane.showMessageDialog(null, "Conexion agregada con exito.");
    }else{
            if(this.search(nombreEstacion1) == null && this.search(nombreEstacion2) != null){
                JOptionPane.showMessageDialog(null, "La estacion de inicio no existe.");
            }else if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) == null){
                JOptionPane.showMessageDialog(null, "La estacion de llegada no existe.");
            }else{
                JOptionPane.showMessageDialog(null, "Ninguna de las estaciones existe.");
            }
        
    }
    }
    
    public void deleteConnection(String nombreEstacion1, String nombreEstacion2){
        if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) != null){
            Estacion estacionInicio = search(nombreEstacion1);
            Estacion estacionFinal = search(nombreEstacion2);
            
            if(estacionInicio.getAdyacentes().search(estacionFinal)){
                estacionInicio.getAdyacentes().deleteForReference(estacionFinal);
                estacionFinal.getAdyacentes().deleteForReference(estacionInicio);
                JOptionPane.showMessageDialog(null, "Conexion eliminar con exito.");
            }else{ 
                JOptionPane.showMessageDialog(null, "No son adyacentes.");
            }
      
    }else{
            if(this.search(nombreEstacion1) == null && this.search(nombreEstacion2) != null){
                JOptionPane.showMessageDialog(null, "La estacion de inicio no existe.");
            }else if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) == null){
                JOptionPane.showMessageDialog(null, "La estacion de llegada no existe.");
            }else{
                JOptionPane.showMessageDialog(null, "Ninguna de las estaciones existe.");
            }
    }
}
    public void getAdjacent(String nombreEstacion){
        if(this.search(nombreEstacion) != null){ 
           Estacion estacion = this.search(nombreEstacion);
            JOptionPane.showMessageDialog(null,estacion.printAdy());
        }else{
            JOptionPane.showMessageDialog(null, "La estacion ya existe.");
        }
    }
    
    public boolean connected(String nombreEstacion1, String nombreEstacion2){
        if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) != null){
            Estacion estacionInicio = search(nombreEstacion1);
            Estacion estacionFinal = search(nombreEstacion2);
            
            if(estacionInicio.getAdyacentes().search(estacionFinal)){
                JOptionPane.showMessageDialog(null, "Si estan conectadas.");
                return true;
            }else{ 
                JOptionPane.showMessageDialog(null, "No son adyacentes.");
                return false;
            }
      
    }else{
            if(this.search(nombreEstacion1) == null && this.search(nombreEstacion2) != null){
                JOptionPane.showMessageDialog(null, "La estacion de inicio no existe.");
            }else if(this.search(nombreEstacion1) != null && this.search(nombreEstacion2) == null){
                JOptionPane.showMessageDialog(null, "La estacion de llegada no existe.");
            }else{
                JOptionPane.showMessageDialog(null, "Ninguna de las estaciones existe.");
            }
            return false;
}
    }

    public void destruir (){
       this.estaciones = new Lista();
    }
    
    @Override
    public String toString() {
        if(!this.isEmpty()){
        String estacionesStr = "";
        Nodo aux = this.estaciones.getpFirst();
        while(aux.getpNext() != null){
            Estacion estacionActual = (Estacion)aux.getDato();
            estacionesStr += estacionActual.getNombre() + " ---> " + estacionActual.printAdy() + "\n"; 
            aux = aux.getpNext();
        }
         Estacion estacionActual = (Estacion) aux.getDato();
            estacionesStr += estacionActual.getNombre() + " ---> " + estacionActual.printAdy();

        return estacionesStr;
        
        }else{
            return "Grafo vacio";
        }
    }
    
    public void busquedaBFS(Estacion estacionInicial,int t){
        //si la estacion inicial es nula, mostrar mensaje de error
        if (estacionInicial == null){
            JOptionPane.showMessageDialog(null, "La estación inicial no puede ser nula");
            
        }else{//sino, busca las estaciones adyacentes dentro del limite de T
            //inicializamos una cadena para almacenar la cobertura de las estaciones
            String cobertura = "Estación inicial: " + estacionInicial.getNombre() + "\n";
            //creamos objetos de tipo cola y lista para tener un registro de las estaciones 
            Cola cola = new Cola();
            Cola distancias = new Cola();
            
            //lista para tener registro de las estaciones visitadas
            Lista estacionesVisitadas = new Lista();
            
            cola.insert(estacionInicial);//insertamos estacion inicial en la cola
            distancias.insert(0);//insertamos la distancia inicial 0 en la cola de distancias
            estacionesVisitadas.insertFinale(estacionInicial);//estacion inicial visitada
            
            //mientras la cola no este vacia
            while (!cola.isEmpty()){
                Estacion estacionActual = (Estacion) cola.delete();
                int distanciaActual = (int) distancias.delete();
                
                //si la distancia actual supera el limite de T
                if (distanciaActual>t){
                    continue;
                }
                
                //agregamos info
                cobertura += "Estacion: " + estacionActual.getNombre() + ", Distancia: " + distanciaActual + "\n";
                
                //obtenemos lista de estaciones adyacentes a la estacion actual
                Lista adyacentesActuales = estacionActual.getAdyacentes();
                //iteramos sobre cada estacion adyacente
                for (int i = 0; i < adyacentesActuales.getSize(); i++) {
                    //obtenemos la estacion adyacente actual
                    Estacion adyacenteActual = (Estacion) adyacentesActuales.getValor(i);
                    
                    
                    //si el adyacente en donde estoy no esta en la lista de estaciones visitadas  
                    if (!estacionesVisitadas.search(adyacenteActual)){
                        //añadimos a la cola y actualizamos la distancia
                        cola.insert(adyacenteActual);
                        distancias.insert(distanciaActual +1);
                        //estacion adyacente ahora es una estacion visitada
                        estacionesVisitadas.insertFinale(adyacenteActual);
                    }
                }
            }
            //mostramos la cobertura de estaciones alcanzadas
            JOptionPane.showMessageDialog(null, cobertura);
        }
    }
}
    