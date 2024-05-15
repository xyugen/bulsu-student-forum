/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.sidebar;

import com.pagzone.main.Main;
import com.pagzone.model.User;
import com.pagzone.props.ChangePageListener;
import com.pagzone.service.SessionManager;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Arias
 */
public class Sidebar extends javax.swing.JPanel {
    private MenuItem activeButton;
    private ChangePageListener listener;
    private User currentUser;
    
    private MenuItem btnStudents;
            
    public Sidebar(ChangePageListener listener) {
        initComponents();
        this.listener = listener;
        
        SessionManager sessionManager = SessionManager.getInstance();
        currentUser = sessionManager.getCurrentUser();
        
        if (currentUser.isAdmin()) {
            btnStudents = new MenuItem();
            btnStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file_cog_red_28.png")));
            btnStudents.setSize(60, 50);
            btnStudents.setName("data");
            btnStudents.addActionListener(e -> {
                btnActionPerformed(e);
            });
            add(btnStudents, "cell 0 1");
            add(btnLogout);
        }
        this.setLayout(new MigLayout("filly, wrap 1", "", "[][][][][grow][]"));
        
        applyActive(btnFeed);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFeed = new com.pagzone.view.sidebar.MenuItem();
        btnWrite = new com.pagzone.view.sidebar.MenuItem();
        btnUser = new com.pagzone.view.sidebar.MenuItem();
        btnSettings = new com.pagzone.view.sidebar.MenuItem();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        btnLogout = new com.pagzone.view.sidebar.MenuItem();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(55, 32767));
        setLayout(null);

        btnFeed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chat_quote_icon_red_28.png"))); // NOI18N
        btnFeed.setToolTipText("Feed");
        btnFeed.setMargin(null);
        btnFeed.setName("feed"); // NOI18N
        btnFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        add(btnFeed);
        btnFeed.setBounds(0, 0, 60, 50);

        btnWrite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pencil_icon_red_28.png"))); // NOI18N
        btnWrite.setToolTipText("Create post");
        btnWrite.setMargin(null);
        btnWrite.setName("write"); // NOI18N
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        add(btnWrite);
        btnWrite.setBounds(0, 40, 60, 50);

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user_icon_red_28.png"))); // NOI18N
        btnUser.setToolTipText("Student profile");
        btnUser.setMargin(null);
        btnUser.setName("profile"); // NOI18N
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        add(btnUser);
        btnUser.setBounds(0, 90, 60, 50);

        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bolt_icon_red_28.png"))); // NOI18N
        btnSettings.setToolTipText("User settings");
        btnSettings.setMargin(null);
        btnSettings.setName("settings"); // NOI18N
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        add(btnSettings);
        btnSettings.setBounds(0, 140, 60, 50);
        add(filler1);
        filler1.setBounds(30, 220, 0, 0);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout_icon_red_28.png"))); // NOI18N
        btnLogout.setToolTipText("Log out");
        btnLogout.setMargin(null);
        btnLogout.setName("logout"); // NOI18N
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutbtnActionPerformed(evt);
            }
        });
        add(btnLogout);
        btnLogout.setBounds(0, 350, 60, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        MenuItem selectedButton = (MenuItem) evt.getSource();
        
        if (selectedButton.isActive()) {
            return;
        }
        
        listener.setPage(selectedButton.getName());
        applyActive(selectedButton);
    }//GEN-LAST:event_btnActionPerformed

    private void btnLogoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutbtnActionPerformed
        SessionManager instance = SessionManager.getInstance();
        Window parentFrame = SwingUtilities.getWindowAncestor(this);
        
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to log out?",
                "Log Out", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            instance.endSession();
            new Main().setVisible(true);

            parentFrame.dispose();
        }
    }//GEN-LAST:event_btnLogoutbtnActionPerformed

    private void applyActive(MenuItem button) {
        if (activeButton != null) {
            activeButton.setIsActive(false);
            activeButton.setContentAreaFilled(false);
        }

        activeButton = button;
        activeButton.setIsActive(true);
        activeButton.setContentAreaFilled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pagzone.view.sidebar.MenuItem btnFeed;
    private com.pagzone.view.sidebar.MenuItem btnLogout;
    private com.pagzone.view.sidebar.MenuItem btnSettings;
    private com.pagzone.view.sidebar.MenuItem btnUser;
    private com.pagzone.view.sidebar.MenuItem btnWrite;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables
}
