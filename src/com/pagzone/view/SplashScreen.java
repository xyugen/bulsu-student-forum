/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view;

/**
 *
 * @author Arias
 */
public class SplashScreen extends javax.swing.JPanel {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChatQuoteIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(199, 36, 36));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(2, 1));

        lblChatQuoteIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChatQuoteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/chat_quote_icon_white_32.png"))); // NOI18N
        lblChatQuoteIcon.setToolTipText("");
        lblChatQuoteIcon.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(lblChatQuoteIcon);

        lblTitle.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("BulSU Student Forum");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblTitle);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblChatQuoteIcon;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
