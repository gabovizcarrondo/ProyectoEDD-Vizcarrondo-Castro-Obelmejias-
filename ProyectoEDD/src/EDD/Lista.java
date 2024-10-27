/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *Define una lista enlazada simple, almacena de forma secuencial.Cada elemento/Nodo
 * contiene un dato y apuntador al siguiente nodo.
 * 
 * @author vizca
 */
public class Lista {

    private Nodo pFirst;
    private int size;

    /**
     * Constructor que inicializa la lista
     */
    public Lista() { //elimino los parametros
        this.pFirst = null;
        this.size = 0;
    }
//metodos getters y setters para los atributos pFirst y size
    /**
     * Obtiene el primer nodo de la lista.
     * @return El primer nodo.
     */
    public Nodo getpFirst() {
        return pFirst;
    }
/**
 * Establece el nodo1 de la lista.
 * @param pFirst El nuevo nodo1.
 */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }
/**
 * Obtiene el tamaño de la lista
 * @return numero de elementos dentro de la lista
 */
    public int getSize() {
        return size;
    }
/**
 * Define tamaño de la lista
 * @param size nuevo tamaño de Lista.
 */
    public void setSize(int size) {
        this.size = size;
    }
/**
 * Nos ayuda a comprobar que la lista se encuentra vac&iacute;a
 * @return nuevo tamaño de la lista
 */
    public boolean isEmpty() { //verifica si la lista esta vacia
        return pFirst == null;
    }
/** 
 * Agrega nuevo objeto al final de la lista
 * @param dato El valor o dato a agregar
 */
    public void insertFinale(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.isEmpty()) { //si la lista esta vacia 
            this.setpFirst(pNew);
        } else {
            Nodo aux = this.pFirst;//si la lista no esta vacia recorro la lista hasta el ultimo nodo 
            while (aux.getpNext() != null) {
                aux = aux.getpNext();//cambio el apuntador
            }
            aux.setpNext(pNew); //obtengo New
        }
        size++;
    }

    public void deleteFinale() { //no le paso ningun parametro
        if (!this.isEmpty()) {
            if (size == 1) {//si hay un solo elemento en la lista
                this.setpFirst(null);//nodo1 es nulo
            } else {
                Nodo aux = this.pFirst;

                while (aux.getpNext().getpNext() != null) { //recorre hasta encntrar el penúltimo
                    aux = aux.getpNext();
                }
                aux.setpNext(null);
            }
            size--;
        }
    }
/**
 * Elimina el nodo1 de la lista que contenga el valor "ref"
 * @param ref El valor que se busca o se elimina
 */
    public void deleteForReference(Object ref) {
        if (!this.isEmpty()) {
            if (size == 1) { //caso especial de una lista que contenga un solo elemento
                if (this.pFirst.getDato() == ref) {
                    this.setpFirst(null);//si el único elemento coincide, la lista es vacia
                    size--;
                }
            } else {
                if (this.pFirst.getDato() == ref) {
                    this.setpFirst(this.pFirst.getpNext());//si el primer elemento coincide, lo eliminamos
                    size--;
                } else {
                    Nodo aux = this.pFirst; //buscamos el nodo prev al que se elimina
                    int count = 0;
                    while (aux.getpNext() != null) {
                        if (aux.getpNext().getDato() == ref) {
                            count++;
                            break;
                        }
                        aux = aux.getpNext();
                    }
                    if (count != 0) { //si se encuentra, lo eliminamos
                        Nodo siguiente = aux.getpNext().getpNext();
                        aux.getpNext().setpNext(null);
                        aux.setpNext(siguiente);
                        size--;
                    } else {
                        if (aux.getDato() == ref) {//en caso de que sea el último
                            this.deleteFinale();
                            size--;
                        }
                    }

                }

            }
        }
    }
/**
 * Busco para saber si existe o no un elemento dentro de la lista
 * @param dato Refiere al elemento a buscar.
 * @return Es verdadero si hay un elemento,es falso si no lo hay
 */
    public boolean search(Object dato) {
        if (!this.isEmpty()) { 
            if (size == 1) {
                return this.pFirst.getDato() == dato; //se iguala al dato que se recibe
            } else {
                Nodo aux = this.pFirst;
                while (aux != null) { 
                    if (aux.getDato() == dato) { //se revisa si es igual o no al dato que se recibe
                        return true;
                    }
                    aux = aux.getpNext();
                }
                return false;
            }
        }
        return false;
    }
/**
 * Imprime los elementos de la lista
 */
    public void print() {
        if (!this.isEmpty()) { //si la lista no es vacía 
            Nodo aux = this.pFirst;
            String listaStr = "";
            while (aux.getpNext() != null) { 
                listaStr += aux.getDato() + "\n"; //le sumo el dato que se está guardando 
                aux = aux.getpNext();
            }

            listaStr += aux.getDato();

            JOptionPane.showMessageDialog(null, listaStr);//muestro

        } else {
            JOptionPane.showMessageDialog(null, "la lista esta vacia");
        }
    }
    /**
     * Refiere a la obtención del elemento de la lista en una posición
     * @param posicion Refiere a la posici&oacute;n del elemento 
     * @return El valor del elemento o nulo si es inv&aacute;lido
     */
    public Object getValor(int posicion){
        
        if(posicion  >= 0 && posicion < size){
            
            if(posicion == 0){
                return this.pFirst.getDato();
            }else{
                Nodo aux = this.pFirst;
                for(int i = 0; i < posicion; i++){
                    aux = aux.getpNext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
/**
 * Se desocupa la memoria que ocupaba la lista
 */
    public void destruir(){
        this.pFirst = null;
        this.size = 0;
    }
    
}
