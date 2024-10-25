/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author obelm
 */
public class Estacion {
    private int numVertice;
    private String nombre;
    private Lista adyacentes;
    private Estacion pasoPeatonal;
    private boolean sucursal;

    public Estacion(String nombre) {
        this.numVertice = -1;
        this.nombre = nombre;
        this.adyacentes = new Lista();
        this.pasoPeatonal = null;
        this.sucursal = false;
    }

    public int getNumVertice() {
        return numVertice;
    }

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
    
    public String printAdy(){
        if (!this.adyacentes.isEmpty()) {
            Nodo aux = this.adyacentes.getpFirst();
            String adyacentesStr = "";
            while (aux.getpNext() != null) {
                Estacion estacionActual = (Estacion) aux.getDato();
                adyacentesStr += estacionActual.getNombre() + " ---> ";

                aux = aux.getpNext();

            }
            Estacion estacionActual = (Estacion) aux.getDato();
            adyacentesStr += estacionActual.getNombre();
            return adyacentesStr;
            
        }
        
        return "No tiene adyacentes.";
    }

    public String nombrePasoPeatonal(){
        if(this.pasoPeatonal != null){
            return pasoPeatonal.getNombre();
        }else{
            return "No hay paso peatonal";
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nNumero de Vertice: " + numVertice + "\nAdyacentes: " + numVertice + this.printAdy() + "\nPasoPeatonal: " + this.nombrePasoPeatonal() + "\nSucursal: " + sucursal + "\n";
    }
            
            
    
    
    
    
    
}
