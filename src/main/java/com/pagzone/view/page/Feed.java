/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page;

import com.pagzone.props.DataChangeListener;

/**
 *
 * @author Arias
 */
public class Feed extends javax.swing.JPanel implements DataChangeListener {

    public Feed() {
        initComponents();
        lstPosts.showAllPosts();
    }

    @Override
    public void refresh() {
        lstPosts.showAllPosts();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblFeed = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnRefresh = new javax.swing.JButton();
        lstPosts = new com.pagzone.view.page.post.PostList();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.BorderLayout(0, 5));

        pnlHeader.setOpaque(false);
        pnlHeader.setLayout(new java.awt.GridLayout(1, 2));

        lblFeed.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblFeed.setForeground(new java.awt.Color(0, 0, 0));
        lblFeed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFeed.setText("Feed");
        pnlHeader.add(lblFeed);

        pnlButton.setOpaque(false);
        pnlButton.setLayout(new java.awt.BorderLayout());

        btnRefresh.setBackground(new java.awt.Color(199, 36, 36));
        btnRefresh.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.setBorderPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        pnlButton.add(btnRefresh, java.awt.BorderLayout.LINE_END);

        pnlHeader.add(pnlButton);

        add(pnlHeader, java.awt.BorderLayout.PAGE_START);
        add(lstPosts, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        lstPosts.showAllPosts();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel lblFeed;
    private com.pagzone.view.page.post.PostList lstPosts;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlHeader;
    // End of variables declaration//GEN-END:variables
}
