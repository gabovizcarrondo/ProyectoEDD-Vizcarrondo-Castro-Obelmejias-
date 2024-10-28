/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *Define un nodo en una lista enlazada, cada nodo refiere al siguiente en la lista y un dato.
 * @author vizca
 */
public class Nodo {
   private Nodo pNext;
   private Object dato;

   /**
    * Crea un nuevo nodo con el dato
    * @param dato Elemento que almacena el nodo
    */
    public Nodo(Object dato) {
        this.pNext = null;
        this.dato = dato;
    }
/**
 * Regresa lo que se almacena en el nodo.
 * @return Elemento que almacena dato
 */
    //métodos getters y setters
    public Object getDato() {
        return dato;
    }
/**
 * Define el dato que guarda el nodo
 * @param dato El nuevo elemento a ser almacenado
 */
    public void setDato(Object dato) {
        this.dato = dato;
    }
/**
 * Regresa al siguiente nodo en la lista
 * @return Siguiente nodo
 */
    public Nodo getpNext() {
        return pNext;
    }
/**
 * Define el nodo siguiente de la lista
 * @param pNext Nuevo nodo.
 */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
    
   
}
