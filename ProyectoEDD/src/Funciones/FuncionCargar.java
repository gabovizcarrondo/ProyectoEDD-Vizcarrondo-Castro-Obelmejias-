/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Lista;
import EDD.Estacion;
import EDD.Lista;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author samantha and gabo
 */
public class FuncionCargar {
    
    private Lista estaciones;

    public FuncionCargar(){
        this.estaciones = new Lista();
    }
    
    public Lista getEstaciones(){
        return estaciones;
    }
     public void setEstaciones(Lista estaciones){
        this.estaciones = estaciones; 
    }
   
     
    //Función que procesa el archivo JSON
    public void cargar(String rutaArchivo){
     try {
            // Leer el archivo JSON usando Gson
            Gson gson = new Gson();
            JsonObject redTransporteData = gson.fromJson(new FileReader(rutaArchivo), JsonObject.class);

            // Obtener los nombres de las redes de transporte (claves principales)
            Lista nombresRedes = obtenerClavesDeJsonObject(redTransporteData);

            // Iterar sobre cada red de transporte
            for (int i = 0; i < nombresRedes.getSize(); i++) {
                String nombreRed = (String) nombresRedes.getValor(i);
                JsonElement redElement = redTransporteData.get(nombreRed);

                // Verificamos si es un objeto o un arreglo y lo manejamos adecuadamente
                if (redElement.isJsonObject()) {
                    JsonObject lineasObject = redElement.getAsJsonObject();
                    procesarEstaciones(lineasObject);
                } else if (redElement.isJsonArray()) {
                    JsonArray lineasArray = redElement.getAsJsonArray();
                    for (JsonElement elementoLinea : lineasArray) {
                        if (elementoLinea.isJsonObject()) {
                            JsonObject lineaObject = elementoLinea.getAsJsonObject();
                            procesarEstaciones(lineaObject);  // Procesar cada objeto de línea
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     // Método auxiliar para obtener las claves de un JsonObject como ListaSimple
    private Lista obtenerClavesDeJsonObject(JsonObject jsonObject) {
        Lista listaClaves = new Lista();
        for (String key : jsonObject.keySet()) {
            listaClaves.insertFinale(key);
        }
        return listaClaves;
    }

}
