/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view;

import com.pagzone.model.CardLayoutChangeListener;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JLabel;

/**
 *
 * @author Arias
 */
public class Login extends javax.swing.JPanel {
    private CardLayoutChangeListener listener;
    
    public Login() {
        initComponents();
    }
    
    public Login(CardLayoutChangeListener listener) {
        this.listener = listener;
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

        lblChatIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblWelcomeBack = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        ptxtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        pnlSignUpLabels = new javax.swing.JPanel();
        lblNoAccount = new javax.swing.JLabel();
        lblSignUpLink = new javax.swing.JLabel();
        customTitleBar1 = new com.pagzone.component.CustomTitleBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(301, 411));

        lblChatIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChatIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/chat_quote_icon.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<html><p><span style=\"color:#C72424;\">BulSU</span> Student Forum</p></html>");

        lblWelcomeBack.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        lblWelcomeBack.setForeground(new java.awt.Color(0, 0, 0));
        lblWelcomeBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomeBack.setText("Welcome Back");

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        ptxtPassword.setBackground(new java.awt.Color(255, 255, 255));
        ptxtPassword.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ptxtPassword.setForeground(new java.awt.Color(0, 0, 0));
        ptxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        btnLogin.setBackground(new java.awt.Color(199, 36, 36));
        btnLogin.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);

        pnlSignUpLabels.setBackground(new java.awt.Color(255, 255, 255));
        pnlSignUpLabels.setForeground(new java.awt.Color(0, 0, 0));
        pnlSignUpLabels.setPreferredSize(new java.awt.Dimension(20, 20));

        lblNoAccount.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblNoAccount.setForeground(new java.awt.Color(0, 0, 0));
        lblNoAccount.setText("Don't have an account?");
        pnlSignUpLabels.add(lblNoAccount);

        lblSignUpLink.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblSignUpLink.setForeground(new java.awt.Color(255, 102, 102));
        lblSignUpLink.setText("Sign Up");
        lblSignUpLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignUpLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignUpLinkMouseExited(evt);
            }
        });
        pnlSignUpLabels.add(lblSignUpLink);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customTitleBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnlSignUpLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ptxtPassword)
                                    .addComponent(lblWelcomeBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTitle))
                                .addGap(0, 22, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblChatIcon)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblChatIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblWelcomeBack)
                .addGap(35, 35, 35)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ptxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSignUpLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void lblSignUpLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpLinkMouseEntered
        setLabelUnderline((JLabel) evt.getSource(), true);
    }//GEN-LAST:event_lblSignUpLinkMouseEntered

    private void lblSignUpLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpLinkMouseExited
        setLabelUnderline((JLabel) evt.getSource(), false);
    }//GEN-LAST:event_lblSignUpLinkMouseExited

    private void lblSignUpLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpLinkMouseClicked
        listener.changeCardLayout("signup");
    }//GEN-LAST:event_lblSignUpLinkMouseClicked

    private void setLabelUnderline(JLabel label, boolean value) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        if (value) {
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        } else {
            attributes.put(TextAttribute.UNDERLINE, -1);
        }
        label.setFont(font.deriveFont(attributes));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private com.pagzone.component.CustomTitleBar customTitleBar1;
    private javax.swing.JLabel lblChatIcon;
    private javax.swing.JLabel lblNoAccount;
    private javax.swing.JLabel lblSignUpLink;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWelcomeBack;
    private javax.swing.JPanel pnlSignUpLabels;
    private javax.swing.JPasswordField ptxtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
