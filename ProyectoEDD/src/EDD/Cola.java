/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *Clase cola ejerce el papel de almacenador de elementos de la mano de los nodos.
 * @author obelm
 */
public class Cola {
    private Nodo pFirst; //apunta a nodo1 de la cola
    private Nodo pLast; // apunta al útlimo nodo de la cola
    private int size; //tamaño de la cola

    public Cola() { //constructor
        this.pFirst = this.pLast = null;
        this.size = 0; //cola vacía
    }
//métodos getters y setters
    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Para comprobar que la cola est&aacute vac&iacute;a
     * @return Es verdadero si est&aacute vac&iacute;a, es falso si no lo est&aacute
     */
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    /**
     * Inserta un nuevo objeto al final de la cola
     * @param dato El elemento a insertar
     */
    public void insert(Object dato){
        Nodo pNew = new Nodo(dato);
        if(this.isEmpty()){ //Si la cola está vacía, el nuevo nodo será el primero y el útlimo
           this.setpFirst(pNew);
           this.setpLast(pNew);
           
        }else{
            //Si la cola no está vacía
        Nodo aux = this.pFirst; 
        while(aux.getpNext()!= null){
            aux = aux.getpNext(); // se agrega new nodo
        }
        
        aux.setpNext(pNew);
        this.setpLast(pNew);
        }
    }
    /**
     * Elimina y regresa el primer elemento de la cola
     * @return El elemento que se elimin&oacute, o es null si est&aacute vac&iacute;a
     */
    public Object delete(){
        if(!this.isEmpty()){
            if(size == 1){
                Object eliminado = this.pFirst.getDato(); //cola con un solo elemento
                this.setpFirst(null);
                this.setpLast(null);
                size--;
                return eliminado;
            }else{
                Object eliminado = this.pFirst.getDato(); //cola com varios elementos
                this.setpFirst(this.pFirst.getpNext());
                size--;
                 return eliminado;

        }
    }
        return null; 
    }
    /**
     * Esta funci&oacute;n muestra o imprime los elementos de la cola
     */
        public void print(){ //imprime los elementos de la cola
        if(!this.isEmpty()){
            Nodo aux = this.pFirst;
            String colaStr = "";
            while(aux.getpNext() != null){ //agrega el dato del nodo actual 
                colaStr += aux.getDato() + "\n";
                aux = aux.getpNext();
            }
            
            colaStr += aux.getDato(); //agrega el dato del ultimo nodo
            
            JOptionPane.showMessageDialog(null, colaStr);
            
        }else{ //si la cola es vacia muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "la lista esta vacia");

        }
        }
}

        
