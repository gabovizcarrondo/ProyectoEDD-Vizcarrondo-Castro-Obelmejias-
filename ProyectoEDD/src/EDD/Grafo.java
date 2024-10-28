/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import EDD.Estacion;
import javax.swing.JOptionPane;

/**
 *Esta clase define un Grafo en el que los nodos son estaciones y las aristas son las conexiones.
 * @author obelm and samantha
 */
public class Grafo {
    
    
    private Lista estaciones;

    public Grafo() {
        this.estaciones = new Lista();
    }
//Getters y setters
    public Lista getEstaciones() {
        return estaciones;
    }
/**
 * Verifica si el
 * @param estaciones 
 */
    public void setEstaciones(Lista estaciones) {
        this.estaciones = estaciones;
    }
    /**
     * Verifica si el grafo es vac&iacute;o
     * @return True si el grafo no tiene estaciones, False en caso contrario
     */
    public boolean isEmpty(){
        return this.estaciones.isEmpty();
    }
    /**
     * Nusca una estaci&oacute;n por su nombre
     * @param nombreEstacion Nombre de la estaci&oacute;n a buscar
     * @return La estaci&oacute;n encontrada o null si no existe
     */
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
    /**
     * Agrega una estaci&oacute;n al grafo
     * @param nombreEstacion Nombre nuevo 
     */
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
    /**
     * Agrega una conexi&oacute;n entre dos estaciones si ambas existen
     * @param nombreEstacion1 Nombre de la primera
     * @param nombreEstacion2 Nobre de la segunda
     */
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
    /**
     * Elimina la conexi&oacute;n entre dos estaciones en caso de que exista
     * @param nombreEstacion1 Nombre de la primera
     * @param nombreEstacion2 Nombre de la segunda
     */
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
    /**
     * Imprime las estaciones adyacentes a una en espec&iacute;co
     * @param nombreEstacion Nombre de la estaci&oacute;n
     */
    public void getAdjacent(String nombreEstacion){
        if(this.search(nombreEstacion) != null){ 
           Estacion estacion = this.search(nombreEstacion);
            JOptionPane.showMessageDialog(null,estacion.printAdy());
        }else{
            JOptionPane.showMessageDialog(null, "La estacion ya existe.");
        }
    }
    /**
     * Verifica si dos estaciones est&aacute;n conectadas directamente
     * @param nombreEstacion1 Nombre de la primera estaci&oacute;n
     * @param nombreEstacion2 Nombre de la segunda estaci&oacute;n
     * @return True si est&aacute;n conectadas, False en caso contrario
     */
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
/**
 * Elimina todas las estacines y conexiones del grafo
 */
    public void destruir (){
       this.estaciones = new Lista();
    }
    /**
     * Se realiza para representar en formato de cadena al grafo
     * @return Cadena 
     */
    @Override
    public String toString() {
        if(!this.isEmpty()){ //comprobar si es vacio
        String estacionesStr = "";
        Nodo aux = this.estaciones.getpFirst();
        while(aux.getpNext() != null){ //si el grafo no es vacio
            Estacion estacionActual = (Estacion)aux.getDato(); //se obtiene la lista de estaciones adyacentes a la actual
            estacionesStr += estacionActual.getNombre() + " ---> " + estacionActual.printAdy() + "\n"; 
            aux = aux.getpNext();
        }
         Estacion estacionActual = (Estacion) aux.getDato();
            estacionesStr += estacionActual.getNombre() + " ---> " + estacionActual.printAdy();

        return estacionesStr; //contiene la representacion textua completa del grafo
        
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
    
    /**
 * Realiza una b&uacute;squeda en anchura (BFS) desde la estaci&oacute;n inicial para encontrar todas las estaciones
 * que se encuentran dentro de una distancia m&aacute;xima de `t` estaciones.
 * 
 * @param estacionInicial La estaci&oacute;n desde la cual comienza la b&uacute;squeda. No debe ser nula.
 * @param t La distancia m&cute;xima (n&uacute;mero de estaciones) a la que se buscar&aacute;n estaciones adyacentes.
 * 
 * Muestra un mensaje con la cobertura de estaciones alcanzadas dentro de la distancia `t`. La cobertura
 * incluye el nombre de cada estaci&oacute;n alcanzada y la distancia a la estación inicial.
 * 
 * La búsqueda se lleva a cabo utilizando dos colas para:
 * - Controlar la estaci&oacute;n en proceso (cola de estaciones).
 * - Controlar la distancia de cada estación a la estaci&oacute;n inicial (cola de distancias).
 * 
 * El m&eacute;todo funciona de la siguiente manera:
 * 1. Verifica que la estaci&oacute;n inicial no sea nula.
 * 2. Inicializa la cobertura de estaciones como una cadena de texto.
 * 3. Utiliza una lista `estacionesVisitadas` para evitar visitar estaciones repetidas.
 * 4. Agrega la estaci&oacute;n inicial a la cola de estaciones y su distancia (0) a la cola de distancias.
 * 5. Procesa cada estaci&oacute;n en la cola de estaciones hasta que esté vac&iacute;a:
 *    - Si la distancia de una estaci&oacute;n es mayor a `t`, pasa a la siguiente.
 *    - Si no, la estaci&oacute;n y su distancia se agregan al registro de cobertura.
 *    - Se obtienen las estaciones adyacentes de la estación actual y se agregan a la cola si a&uacute;n no han sido visitadas.
 * 
 * Finalmente, muestra la cobertura de estaciones alcanzadas en un cuadro de di&aacute;logo.
 *
 */
    
    public void busquedaDFS (Estacion estacionInicial, int t){
        //si la estacion inicial es nula, se muestra un mensaje de eror
        if (estacionInicial == null){
            JOptionPane.showMessageDialog(null, "La estación inicial no puede ser nula");
            return;
        }
        
        Lista visitadas = new Lista();
        StringBuilder resultado = new StringBuilder();
        
        //agrega el nombre de la estacion inicial al resultado
        resultado.append("Estación inicial: ").append(estacionInicial.getNombre()).append("\n");
        
        //iniciamos busqueda recursiva 
        dfsRecursivo(estacionInicial,visitadas, 0, resultado, t);
        //mensaje que indica que la busqueda finalizó
        resultado.append("Cobertura DFS finalizada\n");
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
    
 /**
 * M&eacute;todo auxiliar para realizar la b&uacute;squeda DFS de manera recursiva.
 * 
 * @param estacion La estaci&oacute;n en proceso.
 * @param visitadas Lista de estaciones ya visitadas para evitar ciclos.
 * @param distanciaActual La distancia actual desde la estaci&oacute;n inicial.
 * @param resultado StringBuilder que guarda la cobertura de estaciones alcanzadas.
 * @param t La distancia m&aacute;xima a la que se buscar&aacute;n estaciones.
 * 
 * Este m&eacute;todo verifica si la distancia actual ha alcanzado el l&iacute;mite `t`. Si la estaci&oacute;n tiene
 * una conexi&oacute;n peatonal, explora primero esa conexi&oacute;n y luego explora todas las estaciones adyacentes.
 */
    public void dfsRecursivo (Estacion estacion, Lista visitadas, int distanciaActual, StringBuilder resultado, int t){
        //marca la estacion actual como visitada
        visitadas.insertFinale(estacion);
        
        resultado.append("Estación: ").append(estacion.getNombre()).append(", Distancia: ").append(distanciaActual).append("\n");
        //si la distancia actual supera el limite de t, se detiene la busqueda
        if (distanciaActual>=t){
            return;
        }
        //comprueba si hay una conexion peatonal desde la estacion actual
        if (estacion.getPasoPeatonal()!= null){
            Estacion peatonal = estacion.getPasoPeatonal();
            //verifica si la estacion peatonal ya ha sido visitada
            if(!visitadas.search(peatonal)){
                //recursividad 
                dfsRecursivo(peatonal,visitadas,distanciaActual,resultado,t);
            }
        }
        //obtenemos la lista de estaciones adyacentes 
        Lista adyacentes = estacion.getAdyacentes();
        //iteramos sobre cada estacion adyacente
        for (int i = 0; i < adyacentes.getSize(); i++) {
            Estacion adyacente = (Estacion) adyacentes.getValor(i);
            //verificamos si ya ha sido visitada
            if (!visitadas.search(adyacente)){
                //recursividad
                dfsRecursivo(adyacente, visitadas, distanciaActual + 1, resultado, t);
            }
        }
    }
    
    
    
    //funcion para ver hasta donde se puede cubrir una sucursal
    public void verificarCoberturaTotal(int rangoCobertura){
        //si esta vacio, mostramos un mensaje y salimos del metodo
        if(this.isEmpty()){
            System.out.println("El grafo está vacío. No hay estaciones para revisar");
            return;
        }
        //creamos dos listas, una para las estaciones cubiertas y otra para las NO cubiertas
        Lista estacionesCubiertas = new Lista();
        Lista estacionesNoCubiertas = new Lista();
        
        //obtenemos el primer nodo para comenzar el bucle que recorre todas las estaciones
        Nodo aux= this.getEstaciones().getpFirst();
        //en cada iteracion obtenemos la estacion actual
        while (aux != null){
            Estacion estacionActual = (Estacion) aux.getDato();
            if (estacionActual.isSucursal()){
                //si es una sucursal, llamamos al metodo marcarCoberturaDesdeSucursal para macar la cobertura
                marcarCoberturaDesdeSucursal (estacionActual, estacionesCubiertas, rangoCobertura);
            }
            //avanzamos al siguiente nodo
            aux = aux.getpNext();
        }
        //reiniciamos el nodo auxiliar para verificar las estaciones no cubiertas
        aux = this.getEstaciones().getpFirst();
        while (aux != null) {
            Estacion estacionActual = (Estacion) aux.getDato();
            
            //si la estacion actual no esta en la lista de estaciones cubiertas, la agregamos la lista de estaciones NO cubiertas
            if (!estacionesCubiertas.search(estacionActual)){
                estacionesNoCubiertas.insertFinale(estacionActual);
            }
            
            aux = aux.getpNext();
        }
        //si todas las estaciones estan cubiertas
        if(estacionesNoCubiertas.getSize() == 0){
            JOptionPane.showMessageDialog(null, "Cobertura total alcanzada. Todas las estaciones están cubiertas");
        }else{
            JOptionPane.showMessageDialog(null, "Cobertura NO total. Hay estaciones que no están cubiertas");
            sugerirNuevaSucursal(estacionesNoCubiertas, estacionesCubiertas, rangoCobertura);
        }
    }
    
    public void marcarCoberturaDesdeSucursal (Estacion sucursal, Lista estacionesCubiertas,int rangoCobertura){
        marcarCoberturaRecursiva (sucursal, estacionesCubiertas, 0, rangoCobertura);
    }
    
    public void marcarCoberturaRecursiva(Estacion estacionActual, Lista estacionesCubiertas,int distancia, int rangoCobertura){
        //verificamos si la distancia es mayor que el rango o si la estacion ya esta cubierta. Si es asi, nos salimos del metodo
        if (distancia > rangoCobertura || estacionesCubiertas.search(estacionActual)){
            return;
        }
        
        estacionesCubiertas.insertFinale(estacionActual);
        
        //obtenemos las estaciones adyacentes y aplicamos la recursividad para cada una, asi se incrementa la distancia
        Lista adyacentes = estacionActual.getAdyacentes();
        for (int i = 0; i < adyacentes.getSize(); i++) {
            Estacion adyacente = (Estacion) adyacentes.getValor(i);
            marcarCoberturaRecursiva(adyacente, estacionesCubiertas, distancia + 1,rangoCobertura);
            
        }
        //si la estacion tiene un paso peatonal, lo marcamos recursivamente 
        if (estacionActual.getPasoPeatonal() != null){
            Estacion peatonal = estacionActual.getPasoPeatonal();
            marcarCoberturaRecursiva(peatonal, estacionesCubiertas, distancia, rangoCobertura);
        }
    }
    
    public void sugerirNuevaSucursal(Lista estacionesNoCubiertas, Lista estacionesCubiertas, int rangoCobertura){
        Estacion mejorEstacion = null;
        //para tener un registro de la maxima cantidad de estaciones que se pueden cubrir con la nueva sucursal
        int maxCoberturaAdicional = 0;
        
        //iterar sobre las estaciones NO cubiertas
        for (int i = 0; i < estacionesNoCubiertas.getSize(); i++) {
            
            //obtenemos la estacion no cubierta actual de la lista
            Estacion estacionNoCubierta = (Estacion) estacionesNoCubiertas.getValor(i);
            
            //nueva lista para simular la cobertura de la estacion actual
            Lista coberturaSimulada = new Lista();
            //llamamos al metodo que simula la cobertura de la estacion no cubierta y almacena el resultado
            marcarCoberturaDesdeSucursal (estacionNoCubierta, coberturaSimulada, rangoCobertura);
            
            //contar cuantas nuevas estaciones cubriria
            int coberturaAdicional = 0;
            for (int j = 0; j < coberturaSimulada.getSize(); j++) {
                Estacion estacionCubiertaSimulada = (Estacion) coberturaSimulada.getValor(j);
                
                //verificamos si la estacion cubierta simulada ya esta en la lista de estaciones cubiertas
                if (!estacionesCubiertas.search(estacionCubiertaSimulada)){
                    coberturaAdicional++;//si no esta, incrementamos contador 
                }
                
            }
            //comparamos que cobertura es mejor
            if (coberturaAdicional > maxCoberturaAdicional){
                //si la cobertura adicional es mejor, actualizamos la mejor estacion con la estacion actual
                mejorEstacion = estacionNoCubierta;
                //actualizamos el maximo de cobertura adicional
                maxCoberturaAdicional = coberturaAdicional;
            }
        }
        
        if (mejorEstacion != null){
            JOptionPane.showMessageDialog(null, "Sugerencia: Colocar una sucursal en la estación "  + mejorEstacion.getNombre() + " para cubrir " + maxCoberturaAdicional + " estaciones adicionales");
            
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró una estación adecuada para aumentar la cobertura");
        }
    }
    
    public boolean tieneSucursales(){
        if(this.estaciones.isEmpty()){
            return false;
        }else{
            Nodo aux = this.estaciones.getpFirst();
            while(aux!=null){
                Estacion estacionActual = (Estacion) aux.getDato();
                if (estacionActual.isSucursal()){
                    return true;
                }
                aux = aux.getpNext();
            }
            
            return false; 
        }
    }
}
    