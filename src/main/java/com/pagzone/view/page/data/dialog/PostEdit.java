/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data.dialog;

import com.pagzone.dao.PostDao;
import com.pagzone.model.Post;
import com.pagzone.props.DataChangeListener;
import com.pagzone.util.Helper;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arias
 */
public final class PostEdit extends javax.swing.JPanel {
    private Post post;
    private DataChangeListener listener;
    
    public PostEdit() {
        initComponents();
        txtaBody.setMaxLength(500);
    }
    
    public PostEdit(Post post) {
        initComponents();
        txtaBody.setMaxLength(500);
        this.post = post;
        
        showData();
    }

    public void setListener(DataChangeListener listener) {
        this.listener = listener;
    }
    
    public void setPost(Post post) {
        this.post = post;
    }
    
    public void showData() {
        if (post != null) {
            txtPostId.setText(String.valueOf(post.getId()));
            txtAuthor.setText(post.getUser().getUsername());
            txtTitle.setText(post.getTitle());
            lblTimestampValue.setText(Helper.formatTimestamp(post.getTimestamp()));
            txtaBody.setText(post.getBody());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditPost = new javax.swing.JLabel();
        txtPostId = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        lblTimestamp = new javax.swing.JLabel();
        lblTimestampValue = new javax.swing.JLabel();
        txtTitle = new com.pagzone.component.LimitedTextField();
        spnlBody = new javax.swing.JScrollPane();
        txtaBody = new com.pagzone.component.LimitedTextArea();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblEditPost.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        lblEditPost.setForeground(new java.awt.Color(0, 0, 0));
        lblEditPost.setText("Edit Post");

        txtPostId.setEditable(false);
        txtPostId.setBackground(new java.awt.Color(255, 255, 255));
        txtPostId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtPostId.setForeground(new java.awt.Color(0, 0, 0));
        txtPostId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Post ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtAuthor.setEditable(false);
        txtAuthor.setBackground(new java.awt.Color(255, 255, 255));
        txtAuthor.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtAuthor.setForeground(new java.awt.Color(0, 0, 0));
        txtAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Author", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        lblTimestamp.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblTimestamp.setForeground(new java.awt.Color(0, 0, 0));
        lblTimestamp.setText("Timestamp");

        lblTimestampValue.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblTimestampValue.setForeground(new java.awt.Color(0, 0, 0));
        lblTimestampValue.setText("afds");

        txtTitle.setBackground(new java.awt.Color(255, 255, 255));
        txtTitle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Title", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        txtTitle.setForeground(new java.awt.Color(0, 0, 0));
        txtTitle.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtTitle.setMaxLength(50);

        spnlBody.setBackground(new java.awt.Color(255, 255, 255));
        spnlBody.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Body", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        spnlBody.setForeground(new java.awt.Color(0, 0, 0));
        spnlBody.setOpaque(false);

        txtaBody.setColumns(20);
        txtaBody.setRows(5);
        txtaBody.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        spnlBody.setViewportView(txtaBody);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEditPost)
                                .addGap(0, 296, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTimestamp)
                                    .addComponent(lblTimestampValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPostId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAuthor))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spnlBody))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblEditPost)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPostId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTimestampValue))
                    .addComponent(lblTimestamp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnlBody, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to delete post?",
                "Delete Post", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            PostDao.deletePost(post.getId());
            if (listener != null) {
                listener.refresh();
            } else {
                System.out.println("No listener");
            }
            parentFrame.dispose();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to update post?",
                "Update Post", JOptionPane.YES_NO_OPTION);
        
        Post newPost = new Post();
        newPost.setTitle(txtTitle.getText().trim());
        newPost.setBody(txtaBody.getText().trim());
        if (choice == 0) {
            PostDao.updatePost(post.getId(), newPost);
            if (listener != null) {
                listener.refresh();
            } else {
                System.out.println("No listener");
            }
            parentFrame.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblEditPost;
    private javax.swing.JLabel lblTimestamp;
    private javax.swing.JLabel lblTimestampValue;
    private javax.swing.JScrollPane spnlBody;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtPostId;
    private com.pagzone.component.LimitedTextField txtTitle;
    private com.pagzone.component.LimitedTextArea txtaBody;
    // End of variables declaration//GEN-END:variables
}
