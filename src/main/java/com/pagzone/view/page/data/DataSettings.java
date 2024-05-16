/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data;

/**
 *
 * @author Arias
 */
public class DataSettings extends javax.swing.JPanel {
    private PostsData postsData;
    private UsersData usersData;
    private StudentsData studentsData;
    
    public DataSettings() {
        initComponents();
        init();
    }
    
    private void init() {
        postsData = new PostsData();
        usersData = new UsersData();
        studentsData = new StudentsData();
        
        tpnlDataSettings.add(postsData, "Posts");
        tpnlDataSettings.add(usersData, "Users");
        tpnlDataSettings.add(studentsData, "Students");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpnlDataSettings = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.BorderLayout());

        tpnlDataSettings.setBackground(new java.awt.Color(255, 255, 255));
        tpnlDataSettings.setForeground(new java.awt.Color(0, 0, 0));
        tpnlDataSettings.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        add(tpnlDataSettings, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tpnlDataSettings;
    // End of variables declaration//GEN-END:variables
}
