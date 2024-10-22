/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import javax.swing.JOptionPane;

/**
 *
 * @author vizca
 */
public class Lista {

    private Nodo pFirst;
    private int size;

    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return pFirst == null;
    }

    public void insertFinale(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.isEmpty()) {
            this.setpFirst(pNew);
        } else {
            Nodo aux = this.pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(pNew);
        }
        size++;
    }

    public void deleteFinale() {
        if (!this.isEmpty()) {
            if (size == 1) {
                this.setpFirst(null);
            } else {
                Nodo aux = this.pFirst;

                while (aux.getpNext().getpNext() != null) {
                    aux = aux.getpNext();
                }
                aux.setpNext(null);
            }
            size--;
        }
    }

    public void deleteForReference(Object ref) {
        if (!this.isEmpty()) {
            if (size == 1) {
                if (this.pFirst.getDato() == ref) {
                    this.setpFirst(null);
                    size--;
                }
            } else {
                if (this.pFirst.getDato() == ref) {
                    this.setpFirst(this.pFirst.getpNext());
                    size--;
                } else {
                    Nodo aux = this.pFirst;
                    int count = 0;
                    while (aux.getpNext() != null) {
                        if (aux.getpNext().getDato() == ref) {
                            count++;
                            break;
                        }
                        aux = aux.getpNext();

                        if (count != 0) {
                            Nodo siguiente = aux.getpNext().getpNext();
                            aux.getpNext().setpNext(null);
                            aux.setpNext(siguiente);
                            size--;
                        } else {
                            if (aux.getDato() == ref) {
                                this.deleteFinale();
                                size--;
                            }
                        }
                    }

                }

            }
        }
    }

    public boolean search(Object dato) {
        if (!this.isEmpty()) {
            if (size == 1) {
                return this.pFirst.getDato() == dato;
            } else {
                Nodo aux = this.pFirst;
                while (aux != null) {
                    if (aux.getDato() == dato) {
                        return true;
                    }
                    aux = aux.getpNext();
                }
                return false;
            }
        }
        return false;
    }

    public void print() {
        if (!this.isEmpty()) {
            Nodo aux = this.pFirst;
            String listaStr = "";
            while (aux.getpNext() != null) {
                listaStr += aux.getDato() + "\n";
                aux = aux.getpNext();
            }

            listaStr += aux.getDato();

            JOptionPane.showMessageDialog(null, listaStr);

        } else {
            JOptionPane.showMessageDialog(null, "la lista esta vacia");
        }
    }

}
