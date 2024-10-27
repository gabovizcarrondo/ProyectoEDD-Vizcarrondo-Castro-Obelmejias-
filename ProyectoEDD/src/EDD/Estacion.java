/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *Define la estaci&oacute;n en nuestro sistema de transporte
 * @author obelm
 */
public class Estacion {
    private int numVertice; //un entero para usar en un grafo
    private String nombre; //nombre que representa a la estación
    private Lista adyacentes; //lista que contiene las estaciones
    private Estacion pasoPeatonal; 
    private boolean sucursal;

    /**
     * Constructor 
     * @param nombre Refiere al nombrede la estaci&oacute;n
     */
    public Estacion(String nombre) {
        this.numVertice = -1;
        this.nombre = nombre;
        this.adyacentes = new Lista();
        this.pasoPeatonal = null;
        this.sucursal = false;
    }

    //métodos getters y setters
    
    /**
     * Devuelve el identificador &uacute;nico de la estaci&oacute;n en el grafo
     * @return El numVertice de la estaci&oacute;n
     */
    public int getNumVertice() {
        return numVertice;
    }
/**
 * Ayuda a identificar a la estaci&oacute;n en el sistema 
 * @param numVertice Nuevo n&uacute;mero de v&eacute;rtice para la estaci&oacute;n
 */
    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(Lista adyacentes) {
        this.adyacentes = adyacentes;
    }

    public Estacion getPasoPeatonal() {
        return pasoPeatonal;
    }

    public void setPasoPeatonal(Estacion pasoPeatonal) {
        this.pasoPeatonal = pasoPeatonal;
    }

    public boolean isSucursal() {
        return sucursal;
    }

    public void setSucursal(boolean sucursal) {
        this.sucursal = sucursal;
    }
    /**
     * Nos arroja una cadena con los nombres de las estaciones adyacentes o un mensaje en caso de que no existan
     * @return La cadena en comento
     */
    public String printAdy(){
        if (!this.adyacentes.isEmpty()) { //comprobar que es vacio
            Nodo aux = this.adyacentes.getpFirst();
            String adyacentesStr = ""; //inicializa una cadena vacia para guardar los nombres de la estaciones ady
            while (aux.getpNext() != null) {
                Estacion estacionActual = (Estacion) aux.getDato(); //se obtiene elo dato
                adyacentesStr += estacionActual.getNombre() + " ---> "; // se añade el nombre de la estacion actual a la cadena y --> indica conexion

                aux = aux.getpNext();

            }
            Estacion estacionActual = (Estacion) aux.getDato();
            adyacentesStr += estacionActual.getNombre(); //se agrega el nombre del ultimo nodo a la cadena
            return adyacentesStr; //contiene los nombres de todas las estaciones
            
        }
        
        return "No tiene adyacentes.";
    }
/**
 * Devuelve el nombre de la estaci&oacute;n a tratar con el uso de un "paso peatonal"
 * @return Nombre de la estac&oacute;n o un mensaje en caso de que no exista paso peatonal
 */
    public String nombrePasoPeatonal(){
        if(this.pasoPeatonal != null){
            return pasoPeatonal.getNombre();
        }else{
            return "No hay paso peatonal";
        }
    }
/**
 * Representa en formato de cadena la estaci&oacute;n
 * @return Cadena con el nombre, numVertice, estaciones adyacentes, paso peatonal y si es sucursal
 */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nNumero de Vertice: " + numVertice + "\nAdyacentes: " + numVertice + this.printAdy() + "\nPasoPeatonal: " + this.nombrePasoPeatonal() + "\nSucursal: " + sucursal + "\n";
    }
            
            
    
    
    
    
    
}
