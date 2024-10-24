/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Funciones.Validacion;
import static Interfaces.Cargar.valorT;
import javax.swing.JOptionPane;



/**
 *
 * @author samantha
 */
public class InicializarT extends javax.swing.JFrame {

    /**
     * Creates new form InicializarT
     */
    public InicializarT() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inicializar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        inputT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inicioExit1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inicializar.setBackground(new java.awt.Color(204, 204, 255));
        inicializar.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        inicializar.setText("Inicializar valor");
        inicializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicializarActionPerformed(evt);
            }
        });
        jPanel1.add(inicializar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 190, -1));

        jLabel1.setFont(new java.awt.Font("Palatino", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el valor de T:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        inputT.setBackground(new java.awt.Color(204, 204, 255));
        inputT.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        inputT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTActionPerformed(evt);
            }
        });
        jPanel1.add(inputT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, -1));

        jLabel2.setFont(new java.awt.Font("Palatino", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INICIALIZAR EL VALOR DE T");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        inicioExit1.setBackground(new java.awt.Color(204, 204, 255));
        inicioExit1.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        inicioExit1.setText("X");
        inicioExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioExit1ActionPerformed(evt);
            }
        });
        jPanel1.add(inicioExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 10, 50, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTActionPerformed

    private void inicioExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioExit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioExit1ActionPerformed

    private void inicializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicializarActionPerformed
        String valorTStr = inputT.getText();
        Validacion help = new Validacion();
        
        //si pasa la validacion
        if (help.convertirNumero(valorTStr)!= -1){
            valorT = help.convertirNumero(valorTStr);
            JOptionPane.showMessageDialog(null, "Se agregó el valor a T"); 
            Menu menu = new Menu();
            this.dispose();
      
        } else {
            JOptionPane.showMessageDialog(null, "Solo se admiten enteros positivos para T");
    }//GEN-LAST:event_inicializarActionPerformed
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicializarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicializarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicializarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicializarT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicializarT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicializar;
    private javax.swing.JToggleButton inicioExit1;
    private javax.swing.JTextField inputT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
