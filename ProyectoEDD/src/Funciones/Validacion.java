/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

/**
 *
 * @author vizca
 */

/**
 * Clase que proporciona m&eacute;todos para validar y convertir cadenas num&eacute;ricas.
 */

public class Validacion {
    
       /**
     * Verifica si la cadena dada contiene solo caracteres num&eacute;ricos.
     *
     * @param num la cadena a validar.
     * @return true si la cadena contiene solo n&uacute;meros, false en caso contrario.
     */
    
    private boolean validarnumeros(String num){
        return num.matches("[0-9]*");
    }
     
    /**
     * Convierte una cadena num&eacute;rica en un entero, siempre que solo contenga caracteres num&eacute;ricos.
     *
     * @param numero la cadena que representa un número.
     * @return el n&uacute;mero entero convertido si la cadena es v&aacute;lida; -1 si contiene caracteres no num&eacute;ricos.
     */
    
    public int convertirNumero(String numero){
        if(validarnumeros(numero)== true){ // no es necesario comparar con '== true'
            int num = Integer.parseInt(numero);
            return num;
        }else{
            return -1;
        }
    }
}
