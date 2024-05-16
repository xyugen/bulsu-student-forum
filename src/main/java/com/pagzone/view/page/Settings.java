/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page;

import com.pagzone.dao.UserDao;
import com.pagzone.model.User;
import com.pagzone.service.SessionManager;
import com.pagzone.util.Helper;
import com.pagzone.util.UserValidator;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arias
 */
public class Settings extends javax.swing.JPanel {
    private JFrame parentFrame;
    private User currentUser;
    
    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        
        SessionManager sessionManager = SessionManager.getInstance();
        currentUser = sessionManager.getCurrentUser();
        
        populateDataFields();
    }

    private void populateDataFields() {
        txtEmail.setText(currentUser.getEmail());
        txtUsername.setText(currentUser.getUsername());
        
        lblAccountTypeValue.setText(currentUser.isAdmin() ? "Administrator" : "Regular");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSettings = new javax.swing.JLabel();
        pnlUserSettings = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblAccountType = new javax.swing.JLabel();
        lblAccountTypeValue = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblOldPassword = new javax.swing.JLabel();
        ptxtOldPassword = new javax.swing.JPasswordField();
        chkOldPassword = new javax.swing.JCheckBox();
        lblNewPassword = new javax.swing.JLabel();
        ptxtNewPassword = new javax.swing.JPasswordField();
        lblConfirmNewPassword = new javax.swing.JLabel();
        ptxtConfirmNewPassword = new javax.swing.JPasswordField();
        chkChangePassword = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setLayout(new java.awt.BorderLayout());

        lblSettings.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lblSettings.setForeground(new java.awt.Color(199, 36, 36));
        lblSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSettings.setText("Settings");
        add(lblSettings, java.awt.BorderLayout.PAGE_START);

        pnlUserSettings.setOpaque(false);

        lblEmail.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setLabelFor(txtEmail);
        lblEmail.setText("Email");

        txtEmail.setEditable(false);
        txtEmail.setBackground(new java.awt.Color(247, 247, 247));
        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));

        lblAccountType.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblAccountType.setForeground(new java.awt.Color(0, 0, 0));
        lblAccountType.setText("Account Type");

        lblAccountTypeValue.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblAccountTypeValue.setForeground(new java.awt.Color(0, 0, 0));

        lblUsername.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(0, 0, 0));
        lblUsername.setLabelFor(lblUsername);
        lblUsername.setText("Username");

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));

        lblOldPassword.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblOldPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblOldPassword.setLabelFor(lblOldPassword);
        lblOldPassword.setText("Old Password");

        ptxtOldPassword.setBackground(new java.awt.Color(255, 255, 255));
        ptxtOldPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ptxtOldPassword.setForeground(new java.awt.Color(0, 0, 0));

        chkOldPassword.setBackground(new java.awt.Color(255, 255, 255));
        chkOldPassword.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        chkOldPassword.setForeground(new java.awt.Color(102, 102, 102));
        chkOldPassword.setText("Show old password");
        chkOldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOldPasswordActionPerformed(evt);
            }
        });

        lblNewPassword.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblNewPassword.setLabelFor(ptxtNewPassword);
        lblNewPassword.setText("New Password");

        ptxtNewPassword.setBackground(new java.awt.Color(247, 247, 247));
        ptxtNewPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ptxtNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        ptxtNewPassword.setEnabled(false);

        lblConfirmNewPassword.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblConfirmNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblConfirmNewPassword.setLabelFor(ptxtConfirmNewPassword);
        lblConfirmNewPassword.setText("Confirm New Password");

        ptxtConfirmNewPassword.setBackground(new java.awt.Color(247, 247, 247));
        ptxtConfirmNewPassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ptxtConfirmNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        ptxtConfirmNewPassword.setEnabled(false);

        chkChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        chkChangePassword.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        chkChangePassword.setForeground(new java.awt.Color(102, 102, 102));
        chkChangePassword.setText("Change password");
        chkChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkChangePasswordActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(199, 36, 36));
        btnSave.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setBorder(null);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserSettingsLayout = new javax.swing.GroupLayout(pnlUserSettings);
        pnlUserSettings.setLayout(pnlUserSettingsLayout);
        pnlUserSettingsLayout.setHorizontalGroup(
            pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ptxtOldPassword)
                        .addComponent(txtUsername)
                        .addComponent(lblOldPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtEmail)
                        .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ptxtNewPassword)
                            .addComponent(ptxtConfirmNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(lblNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblConfirmNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAccountTypeValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAccountType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(186, 186, 186))
        );
        pnlUserSettingsLayout.setVerticalGroup(
            pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblAccountType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccountTypeValue))
                .addGap(9, 9, 9)
                .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlUserSettingsLayout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOldPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ptxtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlUserSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkOldPassword)
                            .addComponent(chkChangePassword)))
                    .addGroup(pnlUserSettingsLayout.createSequentialGroup()
                        .addComponent(lblNewPassword)
                        .addGap(38, 38, 38)
                        .addComponent(lblConfirmNewPassword))
                    .addGroup(pnlUserSettingsLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(ptxtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(ptxtConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        add(pnlUserSettings, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void chkOldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOldPasswordActionPerformed
        JCheckBox curCheckBox = (JCheckBox) evt.getSource();
        if (curCheckBox.isSelected()) {
            ptxtOldPassword.setEchoChar((char) 0);
        } else {
            ptxtOldPassword.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_chkOldPasswordActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        
        String email = txtEmail.getText().trim();
        String username = txtUsername.getText().trim();
        String oldPassword = new String(ptxtOldPassword.getPassword()).trim();
        String newPassword = new String(ptxtNewPassword.getPassword()).trim();
        if (validateFields()) {
            if (UserDao.verifyCredentials(email, Helper.hashPassword(oldPassword))) {
                if (chkChangePassword.isSelected())
                    UserDao.updateUser(currentUser.getId(), username, Helper.hashPassword(newPassword));
                else
                    UserDao.updateUsername(currentUser.getId(), username);
                
                clearFields();
                JOptionPane.showMessageDialog(parentFrame, "Your credentials has been updated successfully.", "Update Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Wrong old password.", "Credential Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void chkChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkChangePasswordActionPerformed
        JCheckBox curCheckBox = (JCheckBox) evt.getSource();
        if (curCheckBox.isSelected()) {
            ptxtNewPassword.setEnabled(true);
            ptxtConfirmNewPassword.setEnabled(true);
            
            ptxtNewPassword.setBackground(new Color(255, 255, 255));
            ptxtConfirmNewPassword.setBackground(new Color(255, 255, 255));
        } else {
            ptxtNewPassword.setEnabled(false);
            ptxtConfirmNewPassword.setEnabled(false);
            
            ptxtNewPassword.setBackground(new Color(247,247,247));
            ptxtConfirmNewPassword.setBackground(new Color(247,247,247));
        }
    }//GEN-LAST:event_chkChangePasswordActionPerformed

    private void clearFields() {
        ptxtOldPassword.setText("");
        ptxtNewPassword.setText("");
        ptxtConfirmNewPassword.setText("");
    }
    
    private boolean validateFields() {
        String username = txtUsername.getText().trim();
        String oldPassword = new String(ptxtOldPassword.getPassword()).trim();
        String newPassword = new String(ptxtNewPassword.getPassword()).trim();
        String confirmNewPassword = new String(ptxtConfirmNewPassword.getPassword()).trim();
        
        // Validate username
        if (!UserValidator.isValidUsername(username)) {
            JOptionPane.showMessageDialog(parentFrame, "Invalid username.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Validate old password
        if (!UserValidator.isValidPassword(oldPassword)) {
            // Old password is invalid
            JOptionPane.showMessageDialog(parentFrame, "Invalid old password.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (chkChangePassword.isSelected()) {
            // Validate new password
            if (!UserValidator.isValidPassword(newPassword)) {
                // New password is invalid
                JOptionPane.showMessageDialog(parentFrame, "Invalid new password.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Validate new password and confirmation match
            if (!newPassword.equals(confirmNewPassword)) {
                // New password and confirm password do not match
                JOptionPane.showMessageDialog(parentFrame, "New password and confirm password do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // All validations passed
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkChangePassword;
    private javax.swing.JCheckBox chkOldPassword;
    private javax.swing.JLabel lblAccountType;
    private javax.swing.JLabel lblAccountTypeValue;
    private javax.swing.JLabel lblConfirmNewPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlUserSettings;
    private javax.swing.JPasswordField ptxtConfirmNewPassword;
    private javax.swing.JPasswordField ptxtNewPassword;
    private javax.swing.JPasswordField ptxtOldPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
