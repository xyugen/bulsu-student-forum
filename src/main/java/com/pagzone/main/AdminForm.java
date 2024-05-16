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
    private Point initialClick;
    private UsersData usersData;
    
    
    public AdminForm() {
        initComponents();
        init();
        applyMouseListener();
    }
    
    private void init() {
        usersData = new UsersData();
        pnlAdmin.add(usersData, BorderLayout.CENTER);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAdmin.setBackground(new java.awt.Color(255, 255, 255));
        pnlAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 36, 36), 2));
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

        getContentPane().add(pnlAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAdminPanel;
    private javax.swing.JPanel pnlAdmin;
    private com.pagzone.view.Header pnlHeader;
    // End of variables declaration//GEN-END:variables
}
