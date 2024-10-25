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
public class Cola {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public Cola() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

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
    
    public boolean isEmpty(){
        return this.pFirst == null;
    }
    
    public void insert(Object dato){
        Nodo pNew = new Nodo(dato);
        if(this.isEmpty()){
           this.setpFirst(pNew);
           this.setpLast(pNew);
           
        }else{
            
        Nodo aux = this.pFirst;
        while(aux.getpNext()!= null){
            aux = aux.getpNext();
        }
        
        aux.setpNext(pNew);
        this.setpLast(pNew);
        }
    }
    
    public Object delete(){
        if(!this.isEmpty()){
            if(size == 1){
                 Object eliminado = this.pFirst.getDato();
                this.setpFirst(null);
                this.setpLast(null);
                size--;
                return eliminado;
            }else{
                Object eliminado = this.pFirst.getDato();
                this.setpFirst(this.pFirst.getpNext());
                size--;
                 return eliminado;

        }
    }
        return null; 
    }
        public void print(){
        if(!this.isEmpty()){
            Nodo aux = this.pFirst;
            String colaStr = "";
            while(aux.getpNext() != null){
                colaStr += aux.getDato() + "\n";
                aux = aux.getpNext();
            }
            
            colaStr += aux.getDato();
            
            JOptionPane.showMessageDialog(null, colaStr);
            
        }else{
            JOptionPane.showMessageDialog(null, "la lista esta vacia");

        }
        }
}

        
