/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import EDD.Estacion;
import EDD.Grafo;
import EDD.Lista;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

        
/**
 *
 * @author gabo
 */

/**
 * Clase que representa un visualizador gr&aacute;fico para mostrar un grafo de estaciones de transporte.
 */
public class VisualizadorGrafo extends JFrame{
    private Grafo grafo;
    private Viewer visor;
    private ViewPanel panelVista;

     /**
     * Constructor que inicializa el visualizador con el grafo proporcionado.
     *
     * @param grafo el grafo que se va a visualizar.
     */
    
    public VisualizadorGrafo(Grafo grafo) {
        this.grafo = grafo;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }
    /**
     * Configura la interfaz gr&aacute;fica del visualizador.
     */
   private void configurarInterfaz() {
        setTitle("Mapa de Estaciones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
   
   /**
     * Inicializa el visor del grafo y lo muestra en la interfaz.
     */
   
    private void inicializarVisor() {
        Graph grafoVisual = new SingleGraph("Estaciones");
        construirGrafo(grafoVisual);

        // Mostrar el grafo sin crear una nueva ventana
        visor = grafoVisual.display(false);
        visor.enableAutoLayout();  // Permitir que el layout se ajuste automáticamente

        // Creamos el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();  // Sin ventana adicional
            add(panelVista, BorderLayout.CENTER);  // Añadir el panel al JFrame
        }
    }
    
    /**
     * Construye el grafo visual a partir de las estaciones en el grafo.
     *
     * @param grafoVisual el grafo visual que se va a construir.
     */
    
    private void construirGrafo(Graph grafoVisual) {
        
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            Node nodo = grafoVisual.addNode(estacion.getNombre());
            nodo.setAttribute("ui.label", estacion.getNombre());

            // Cambiar el color del nodo si tiene sucursal
            String colorNodo = estacion.isSucursal() ? "yellow" : "gray";
            nodo.setAttribute("ui.style", "fill-color: " + colorNodo + ";");
        }

        agregarRutas(grafoVisual);

        // Ajustar los estilos generales del grafo
        grafoVisual.setAttribute("ui.stylesheet", 
            "node { text-size: 14px; size: 25px; text-alignment: under; }" +
            "edge { size: 2px; }"
        );
    }
   
    /**
     * Agrega las rutas entre las estaciones en el grafo visual.
     *
     * @param grafoVisual el grafo visual al que se agregar&aacute;n las rutas.
     */
     private void agregarRutas(Graph grafoVisual) {
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            Lista adyacentes = estacion.getAdyacentes();

            // Conexiones entre estaciones adyacentes
            for (int j = 0; j < adyacentes.getSize(); j++) {
                Estacion estacionAdyacente = (Estacion) adyacentes.getValor(j);
                String idConexion = estacion.getNombre() + "-" + estacionAdyacente.getNombre();

                if (grafoVisual.getEdge(idConexion) == null && grafoVisual.getEdge(estacionAdyacente.getNombre() + "-" + estacion.getNombre()) == null) {
                    grafoVisual.addEdge(idConexion, estacion.getNombre(), estacionAdyacente.getNombre());
                }
            }

            // Agregar rutas peatonales si existen
            agregarRutaPeatonal(grafoVisual, estacion);
        }
    }
    
     /**
     * Agrega una ruta peatonal entre la estación y su estación adyacente si existe.
     *
     * @param grafoVisual el grafo visual al que se agregar&aacute;n las rutas peatonales.
     * @param estacion la estaci&oacute;n que puede tener una conexi&oacute;n peatonal.
     */
     
     private void agregarRutaPeatonal(Graph grafoVisual, Estacion estacion) {
        Estacion peatonal = estacion.getPasoPeatonal();
        if (peatonal != null) {
            String idPeatonal = estacion.getNombre() + "-" + peatonal.getNombre() + "-peatonal";

            if (grafoVisual.getEdge(idPeatonal) == null) {
                Edge aristaPeatonal = grafoVisual.addEdge(idPeatonal, estacion.getNombre(), peatonal.getNombre(), true);
                aristaPeatonal.setAttribute("ui.style", "stroke-mode: dots; stroke-color: blue;");
            }
        }
    }
      /**
     * Agrega un bot&oacute;n "Regresar" a la interfaz que permite cerrar el visor y volver al men&uacute principal.
     */
      private void agregarBotonRegresar() {
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            cerrarVisor();
            this.dispose();
            // Simulación de abrir menú principal (suponiendo que ya exista una clase 'Menu')
            Menu menuPrincipal = new Menu();
            menuPrincipal.setVisible(true);
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }
      /**
     * Cierra el visor y elimina el panel de visualizaci&oacute;n de la interfaz.
     */
        private void cerrarVisor() {
            if (visor != null) {
                visor.disableAutoLayout();
                visor.close();
            }
            if (panelVista != null) {
                remove(panelVista);
                panelVista = null;
        }
    }




}
