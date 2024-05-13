/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.post;

import com.pagzone.dao.PostDao;
import com.pagzone.model.Post;
import java.util.List;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Arias
 */
public class PostList extends javax.swing.JPanel {
    /**
     * Creates new form PostList
     */
    public PostList() {
        initComponents();
        pnlPostList.setLayout(new MigLayout("wrap 1", "[grow, fill]"));
    }
    
    public void showAllPosts() {    
        pnlPostList.removeAll();
        
        List<Post> posts = PostDao.getAllPosts();
        List<Post> reversedPosts = posts.reversed();
        for (Post post : reversedPosts) {
            PostItem postItem = new PostItem(post);
            pnlPostList.add(postItem);
        }
        pnlPostList.validate();
        pnlPostList.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spnlPosts = new javax.swing.JScrollPane();
        pnlPostList = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.BorderLayout());

        spnlPosts.setBackground(new java.awt.Color(255, 255, 255));
        spnlPosts.setBorder(null);
        spnlPosts.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlPostList.setBackground(new java.awt.Color(255, 255, 255));
        pnlPostList.setLayout(null);
        spnlPosts.setViewportView(pnlPostList);

        add(spnlPosts, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlPostList;
    private javax.swing.JScrollPane spnlPosts;
    // End of variables declaration//GEN-END:variables
}
