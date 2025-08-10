/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data.dialog;

import com.pagzone.dao.PostDao;
import com.pagzone.dao.StudentDao;
import com.pagzone.dao.UserDao;
import com.pagzone.model.Post;
import com.pagzone.model.User;
import com.pagzone.props.DataChangeListener;
import com.pagzone.service.SessionManager;
import com.pagzone.util.Helper;
import com.pagzone.util.UserValidator;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arias
 */
public final class UserEdit extends javax.swing.JPanel {
    private User user;
    private DataChangeListener listener;
    
    public UserEdit() {
        initComponents();
    }
    
    public UserEdit(User user) {
        initComponents();
        this.user = user;
        
        showData();
    }

    public void setListener(DataChangeListener listener) {
        this.listener = listener;
    }
    
    public void setPost(User user) {
        this.user = user;
    }
    
    public void showData() {
        if (user != null) {
            txtUserId.setText(String.valueOf(user.getId()));
            txtStudentId.setText(user.getStudent().getStudId());
            txtUsername.setText(user.getUsername());
            txtEmail.setText(user.getEmail());
            cmbAdmin.setSelectedIndex(user.isAdmin() ? 1 : 0);
            lblCreationTimeValue.setText(Helper.formatTimestamp(user.getCreationDate()));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditUser = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        txtUsername = new com.pagzone.component.LimitedTextField();
        txtEmail = new com.pagzone.component.LimitedTextField();
        cmbAdmin = new javax.swing.JComboBox<>();
        lblCreationTime = new javax.swing.JLabel();
        lblCreationTimeValue = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblEditUser.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        lblEditUser.setForeground(new java.awt.Color(0, 0, 0));
        lblEditUser.setText("Edit User");

        txtUserId.setEditable(false);
        txtUserId.setBackground(new java.awt.Color(255, 255, 255));
        txtUserId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtUserId.setForeground(new java.awt.Color(0, 0, 0));
        txtUserId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtStudentId.setEditable(false);
        txtStudentId.setBackground(new java.awt.Color(255, 255, 255));
        txtStudentId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtStudentId.setForeground(new java.awt.Color(0, 0, 0));
        txtStudentId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtUsername.setMaxLength(50);

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtEmail.setMaxLength(255);

        cmbAdmin.setBackground(new java.awt.Color(255, 255, 255));
        cmbAdmin.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbAdmin.setForeground(new java.awt.Color(0, 0, 0));
        cmbAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        cmbAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        lblCreationTime.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblCreationTime.setForeground(new java.awt.Color(0, 0, 0));
        lblCreationTime.setText("Creation Time");

        lblCreationTimeValue.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblCreationTimeValue.setForeground(new java.awt.Color(0, 0, 0));
        lblCreationTimeValue.setText("Creation Time Value");

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
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEditUser)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtStudentId))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCreationTime)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblCreationTimeValue, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblEditUser)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCreationTimeValue))
                    .addComponent(lblCreationTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame,
                """
                    Are you sure you want to delete user?
                    Deleting this student will delete the corresponding student.""",
                "Delete User", JOptionPane.YES_NO_OPTION);
        
        if (choice == 0) {
            try {
                StudentDao.deleteStudent(user.getStudent().getId());
                if (listener != null) {
                    if (user.getId() == SessionManager
                            .getInstance()
                            .getCurrentUser()
                            .getId())
                        System.exit(0);
                    listener.refresh();
                } else {
                    System.out.println("No listener");
                }
                parentFrame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UserEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to update user?",
                "Update User", JOptionPane.YES_NO_OPTION);
        
        String newEmail = txtEmail.getText().trim();
        String newUsername = txtUsername.getText().trim();
        boolean isAdmin = cmbAdmin.getSelectedIndex() == 1;
        
        if (UserValidator.isValidEmail(newEmail)
                && UserValidator.isValidBulsuEmail(newEmail)
                && UserValidator.isValidUsername(newUsername)) {
            User newUser = user;
            newUser.setUsername(newUsername);
            newUser.setEmail(newEmail);
            newUser.setAdmin(isAdmin);
            if (choice == 0) {
                UserDao.updateUser(newUser.getId(), newUser);
                if (listener != null) {
                    listener.refresh();
                } else {
                    System.out.println("No listener");
                }
                parentFrame.dispose();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbAdmin;
    private javax.swing.JLabel lblCreationTime;
    private javax.swing.JLabel lblCreationTimeValue;
    private javax.swing.JLabel lblEditUser;
    private com.pagzone.component.LimitedTextField txtEmail;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtUserId;
    private com.pagzone.component.LimitedTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
