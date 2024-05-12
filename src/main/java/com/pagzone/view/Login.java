/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view;

import com.pagzone.dao.UserDao;
import com.pagzone.props.CardLayoutChangeListener;
import com.pagzone.model.User;
import com.pagzone.service.SessionManager;
import com.pagzone.util.UserValidator;
import com.pagzone.util.Helper;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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
        chkShowPassword = new javax.swing.JCheckBox();
        ptxtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        pnlSignUpLabels = new javax.swing.JPanel();
        lblNoAccount = new javax.swing.JLabel();
        lblSignUpLink = new javax.swing.JLabel();
        customTitleBar1 = new com.pagzone.component.CustomTitleBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(301, 411));

        lblChatIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChatIcon.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chat_quote_icon.png"));

        lblTitle.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("<html><p><span style=\"color:#C72424;\">BulSU</span> Student Forum</p></html>");

        lblWelcomeBack.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        lblWelcomeBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcomeBack.setText("Welcome Back");

        txtUsername.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email/Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        chkShowPassword.setBackground(new java.awt.Color(255, 255, 255));
        chkShowPassword.setFont(new java.awt.Font("Poppins", 0, 10)); // NOI18N
        chkShowPassword.setForeground(new java.awt.Color(102, 102, 102));
        chkShowPassword.setText("Show password");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        ptxtPassword.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        ptxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        btnLogin.setBackground(new java.awt.Color(199, 36, 36));
        btnLogin.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        pnlSignUpLabels.setBackground(new java.awt.Color(255, 255, 255));
        pnlSignUpLabels.setPreferredSize(new java.awt.Dimension(20, 20));

        lblNoAccount.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkShowPassword)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                        .addComponent(pnlSignUpLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ptxtPassword)
                                        .addComponent(lblWelcomeBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTitle)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkShowPassword)
                .addGap(9, 9, 9)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSignUpLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void lblSignUpLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpLinkMouseEntered
        Helper.setLabelUnderline((JLabel) evt.getSource(), true);
    }//GEN-LAST:event_lblSignUpLinkMouseEntered

    private void lblSignUpLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpLinkMouseExited
        Helper.setLabelUnderline((JLabel) evt.getSource(), false);
    }//GEN-LAST:event_lblSignUpLinkMouseExited

    private void lblSignUpLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpLinkMouseClicked
        listener.changeCardLayout("signup");
    }//GEN-LAST:event_lblSignUpLinkMouseClicked

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
        JCheckBox curCheckBox = (JCheckBox) evt.getSource();
        if (curCheckBox.isSelected()) {
            ptxtPassword.setEchoChar((char) 0);
        } else {
            ptxtPassword.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = txtUsername.getText().trim();
        String password = new String(ptxtPassword.getPassword()).trim();
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (UserValidator.verifyLogin(username, password)) {
            Helper.setTextFieldBorder(txtUsername, "Email/Username", new Color(153,153,153));
            Helper.setTextFieldBorder(ptxtPassword, "Password", new Color(153,153,153));
            
            User loginUser = UserDao.getUserByEmailOrUsername(username);
            if (loginUser != null) {
                if (loginUser.getUsername().isEmpty() || loginUser.getUsername() == null) {
                    // Set new username
                    String newUsername = JOptionPane.showInputDialog(parentFrame, "Input your username", "New Account", JOptionPane.OK_OPTION);
                    while (!UserValidator.isValidUsername(newUsername)) {
                        if (newUsername == null) return;
                        System.out.println(newUsername);
                        newUsername = JOptionPane.showInputDialog(parentFrame, "Input proper username", "Invalid Username", JOptionPane.OK_OPTION);
                    }
                    
                    newUsername = newUsername.trim();
                    
                    // Verify and update database
                    UserDao.updateUsername(loginUser.getId(), newUsername);
                    loginUser.setUsername(newUsername);
                }
                // Create session
                SessionManager sessionManager = SessionManager.getInstance();
                sessionManager.createSession(loginUser);
            }
        } else {
            // Validate email/username input
            if (UserValidator.isValidUsername(username) || UserValidator.isValidEmail(username)) {
                Helper.setTextFieldBorder(txtUsername, "Email/Username", new Color(153,153,153));
                
                if (!UserDao.verifyCredentials(username, password)) {
                    JOptionPane.showMessageDialog(parentFrame, "Username or password is incorrect.", "Credential Error", JOptionPane.OK_OPTION);
                }
            } else {
                Helper.setTextFieldBorder(txtUsername, "Email/Username", new Color(199,36,36));
            }
            
            // Validate password
            if (UserValidator.isValidPassword(password)) {
                Helper.setTextFieldBorder(ptxtPassword, "Password", new Color(153,153,153));
            } else {
                Helper.setTextFieldBorder(ptxtPassword, "Password", new Color(199,36,36));
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkShowPassword;
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
