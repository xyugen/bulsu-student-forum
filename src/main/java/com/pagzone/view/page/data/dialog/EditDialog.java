/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.pagzone.view.page.data.dialog;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arias
 */
public final class EditDialog extends javax.swing.JDialog {
    private Point initialClick;
    private JPanel panel;
    private JFrame parentFrame;
    
    public EditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parentFrame = (JFrame) parent;
        initComponents();
        applyMouseListener();
    }
    
    public EditDialog(java.awt.Frame parent, boolean modal, JPanel panel) {
        super(parent, modal);
        this.parentFrame = (JFrame) parent;
        initComponents();
        applyMouseListener();
        this.panel = panel;
        
        showPanel();
    }
    
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    public void showPanel() {
        if (panel != null) {
            pnlEditDialog.add(panel, BorderLayout.CENTER);
            pack();
        }
    }

    private void applyMouseListener() {
        pnlHeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
                setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        
        pnlHeader.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Window window = SwingUtilities.getWindowAncestor(pnlHeader);
                if (this != null) {
                    int thisX = window.getLocation().x;
                    int thisY = window.getLocation().y;

                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    int X = thisX + xMoved;
                    int Y = thisY + yMoved;
                    window.setLocation(X, Y);
                } else {
                    try {
                        System.out.println(window.getName());    
                    } catch (Exception err) {
                        err.getCause();
                    }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditDialog = new javax.swing.JPanel();
        pnlHeader = new com.pagzone.view.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Dialog");
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));

        pnlEditDialog.setBackground(new java.awt.Color(255, 255, 255));
        pnlEditDialog.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 36, 36), 2));
        pnlEditDialog.setLayout(new java.awt.BorderLayout());
        pnlEditDialog.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlEditDialog, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditDialog dialog = new EditDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlEditDialog;
    private com.pagzone.view.Header pnlHeader;
    // End of variables declaration//GEN-END:variables
}
