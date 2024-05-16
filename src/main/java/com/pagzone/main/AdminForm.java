package com.pagzone.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.pagzone.dao.UserDao;
import com.pagzone.props.DataChangeListener;
import com.pagzone.view.page.data.UsersData;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Arias
 */
public class AdminForm extends javax.swing.JFrame {
    private DataChangeListener listener;
    private Point initialClick;
    private UsersData usersData;
    private int userId;
    private boolean isAdmin;
    
    private JScrollPane spnlUserTable;
    private JTable tblUsers;
    
    public AdminForm() {
        initComponents();
        init();
        applyMouseListener();
    }
    
    private void init() {
        usersData = new UsersData();
        listener = usersData;
        pnlAdmin.add(usersData, BorderLayout.CENTER);
        
        spnlUserTable = (JScrollPane) usersData.getComponent(2);
        tblUsers = (JTable) spnlUserTable.getViewport().getView();
        
        tblUsers.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                tblUsersMouseClicked(e);
            }
        });
    }
    
    private void tblUsersMouseClicked(MouseEvent evt) {
        int selectedRow = tblUsers.getSelectedRow();
        
        if (selectedRow > -1) {
            btnSave.setEnabled(true);
            userId = (int) tblUsers.getValueAt(selectedRow, 0);
            txtUserId.setText(String.valueOf(userId));
        } else {
            btnSave.setEnabled(false);
        }
        
        try {
            isAdmin = UserDao.getIsAdminById(userId);
            cmbIsAdmin.setSelectedIndex(isAdmin ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void applyMouseListener() {
        JFrame parentFrame = this;
        pnlHeader.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
                setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        
        pnlHeader.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (parentFrame != null) {
                    // Get current location of the JFrame
                    int thisX = parentFrame.getLocation().x;
                    int thisY = parentFrame.getLocation().y;

                    // Calculate how much the mouse moved since the initial click
                    int xMoved = e.getX() - initialClick.x;
                    int yMoved = e.getY() - initialClick.y;

                    // Move the JFrame to this position
                    int X = thisX + xMoved;
                    int Y = thisY + yMoved;
                    parentFrame.setLocation(X, Y);
                } else {
                    try {
                        System.out.println(parentFrame.getName());    
                    } catch (Exception err) {
                        err.getCause();
                    }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAdmin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new com.pagzone.view.Header();
        lblAdminPanel = new javax.swing.JLabel();
        pnlActions = new javax.swing.JPanel();
        lblUserId = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        lblIsAdmin = new javax.swing.JLabel();
        cmbIsAdmin = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAdmin.setBackground(new java.awt.Color(255, 255, 255));
        pnlAdmin.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        lblAdminPanel.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lblAdminPanel.setForeground(new java.awt.Color(199, 36, 36));
        lblAdminPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdminPanel.setText("Admin Panel");
        jPanel1.add(lblAdminPanel, java.awt.BorderLayout.CENTER);

        pnlAdmin.add(jPanel1, java.awt.BorderLayout.NORTH);

        pnlActions.setBackground(new java.awt.Color(255, 255, 255));

        lblUserId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblUserId.setForeground(new java.awt.Color(0, 0, 0));
        lblUserId.setText("User ID");
        pnlActions.add(lblUserId);

        txtUserId.setEditable(false);
        txtUserId.setBackground(new java.awt.Color(204, 204, 204));
        txtUserId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtUserId.setForeground(new java.awt.Color(51, 51, 51));
        pnlActions.add(txtUserId);
        pnlActions.add(filler1);

        lblIsAdmin.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblIsAdmin.setForeground(new java.awt.Color(0, 0, 0));
        lblIsAdmin.setText("Is Admin");
        pnlActions.add(lblIsAdmin);

        cmbIsAdmin.setBackground(new java.awt.Color(255, 255, 255));
        cmbIsAdmin.setForeground(new java.awt.Color(0, 0, 0));
        cmbIsAdmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        pnlActions.add(cmbIsAdmin);

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlActions.add(btnSave);

        pnlAdmin.add(pnlActions, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int selectedIndex = cmbIsAdmin.getSelectedIndex();
        boolean newIsAdmin = (selectedIndex == 1);
        try {
            UserDao.updateIsAdminById(userId, newIsAdmin);
            listener.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbIsAdmin;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdminPanel;
    private javax.swing.JLabel lblIsAdmin;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlAdmin;
    private com.pagzone.view.Header pnlHeader;
    private javax.swing.JTextField txtUserId;
    // End of variables declaration//GEN-END:variables
}
