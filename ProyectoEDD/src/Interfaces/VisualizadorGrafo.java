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
import EDD.Grafo;
public class VisualizadorGrafo extends JFrame{
     private Grafo grafo;
    private Viewer visor;
    private ViewPanel panelVista;

    public VisualizadorGrafo(Grafo grafo) {
        this.grafo = grafo;
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }
   private void configurarInterfaz() {
        setTitle("Mapa de Estaciones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
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


}
