/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pagzone.main;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Arias
 */
public class HomeForm extends javax.swing.JFrame {
    private Point initialClick;
    
    public HomeForm() {
        initComponents();
        //this.setLayout(new MigLayout("wrap 1"));
        setBackground(new Color(1, 1, 1, 0.45f));
        
        JFrame parentFrame = this;
        pnlHeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
                pnlHeader.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                pnlHeader.setCursor(Cursor.getDefaultCursor());
            }
        });
        
        pnlHeader.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (parentFrame != null) {
                    // Get current location of the JFrame
                    int thisX = parentFrame.getLocation().x;
                    int thisY = parentFrame.getLocation().y;

                    // Calculate how much the mouse moved since the initial click
                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    // Move the JFrame to this position
                    int X = thisX + xMoved;
                    int Y = thisY + yMoved;
                    parentFrame.setLocation(X, Y);
                } else {
                    try {
                        System.out.println(parentFrame.getName());    
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

        pnlHeader = new javax.swing.JPanel();
        customTitleBar1 = new com.pagzone.component.CustomTitleBar();
        lblTItle = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        sidebar1 = new com.pagzone.view.sidebar.Sidebar();
        pnlMainCard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BulSU Student Forum");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        pnlHeader.setBackground(new java.awt.Color(199, 36, 36));

        lblTItle.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        lblTItle.setForeground(new java.awt.Color(255, 255, 255));
        lblTItle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTItle.setText("BulSU Student Forum");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236)
                .addComponent(lblTItle, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTItle)
                    .addComponent(customTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlContent.setOpaque(false);
        pnlContent.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlContent, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(sidebar1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout pnlMainCardLayout = new javax.swing.GroupLayout(pnlMainCard);
        pnlMainCard.setLayout(pnlMainCardLayout);
        pnlMainCardLayout.setHorizontalGroup(
            pnlMainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        pnlMainCardLayout.setVerticalGroup(
            pnlMainCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMainCard, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pagzone.component.CustomTitleBar customTitleBar1;
    private javax.swing.JLabel lblTItle;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMainCard;
    private com.pagzone.view.sidebar.Sidebar sidebar1;
    // End of variables declaration//GEN-END:variables
}
