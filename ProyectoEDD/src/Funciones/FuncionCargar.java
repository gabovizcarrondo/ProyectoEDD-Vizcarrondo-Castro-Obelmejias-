/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
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
// Método auxiliar para procesar las líneas y estaciones
    private void procesarEstaciones(JsonObject lineasObject) {
        // Obtener las claves de las líneas
        Lista nombresLineas = obtenerClavesDeJsonObject(lineasObject);

        for (int i = 0; i < nombresLineas.getSize(); i++) {
            String nombreLinea = (String) nombresLineas.getValor(i);
            JsonArray estacionesArray = lineasObject.getAsJsonArray(nombreLinea);

            Estacion estacionAnterior = null;  // Para enlazar adyacencias entre estaciones consecutivas
            Estacion estacionActual;

            // Procesar cada estación de la línea
            for (JsonElement estacionElement : estacionesArray) {
                if (estacionElement.isJsonPrimitive()) {
                    // Caso de una estación sin conexión peatonal
                    String nombreEstacion = estacionElement.getAsString();
                    estacionActual = obtenerEstacion(nombreEstacion);

                    // Si hay una estación anterior, hacerlas adyacentes
                    if (estacionAnterior != null) {
                        estacionAnterior.getAdyacentes().insertFinale(estacionActual);
                        estacionActual.getAdyacentes().insertFinale(estacionAnterior);
                    }

                    // La estación actual se convierte en la anterior para el próximo ciclo
                    estacionAnterior = estacionActual;

                } else if (estacionElement.isJsonObject()) {
                    
                    JsonObject conexionPeatonal = estacionElement.getAsJsonObject();

                    
                    String estacion1 = conexionPeatonal.keySet().iterator().next(); // Obtener la clave
                    String estacion2 = conexionPeatonal.get(estacion1).getAsString(); // Obtener el valor

                    // Obtener o crear las estaciones
                    Estacion est1 = obtenerEstacion(estacion1);
                    Estacion est2 = obtenerEstacion(estacion2);

                    // Añadirlas como paso peatonal (conexión en ambos sentidos)
                    est1.setPasoPeatonal(est2); // Añadir conexión peatonal
                    est2.setPasoPeatonal(est1); // Conexión en ambos sentidos

                    
                    // Establecer también la adyacencia lógica entre las estaciones de la misma línea
                    if (estacionAnterior != null) {
                        estacionAnterior.getAdyacentes().insertFinale(est1); // Enlazar adyacencia entre estaciones de la línea
                        est1.getAdyacentes().insertFinale(estacionAnterior); // Enlazar en ambos sentidos
                    }

                    estacionAnterior = est1; // La estación siguiente se convierte en la anterior
                }

            }
        }
    }

    // Método auxiliar para obtener una estación existente o crear una nueva
   private Estacion obtenerEstacion(String nombreEstacion) {
        // Buscar si la estación ya fue creada en la lista de estaciones
        for (int i = 0; i < estaciones.getSize(); i++) {
            Estacion estacion = (Estacion) estaciones.getValor(i);
            if (estacion.getNombre().equals(nombreEstacion)) {
                return estacion;
            }
        }
        // Si no existe, la creamos y la añadimos a la lista de estaciones
        Estacion nuevaEstacion = new Estacion(nombreEstacion);
        estaciones.insertFinale(nuevaEstacion);
        return nuevaEstacion;
    }


}
