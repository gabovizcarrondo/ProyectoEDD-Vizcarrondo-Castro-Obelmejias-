/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoedd;

import EDD.Lista;

/**
 *
 * @author vizca
 */
public class ProyectoEDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista  = new Lista();
        
        lista.insertFinale(1);
        lista.insertFinale(2);
        lista.insertFinale(3);
        lista.insertFinale(4);
        
        lista.print();
        
        lista.deleteForReference(4);
        
        lista.print();
    }
    
}
