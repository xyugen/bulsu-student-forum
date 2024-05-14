/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pagzone.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.pagzone.props.ChangePageListener;
import com.pagzone.view.page.Feed;
import com.pagzone.view.page.Profile;
import com.pagzone.view.page.Write;
import com.pagzone.view.sidebar.Sidebar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Arias
 */
public class HomeForm extends javax.swing.JFrame implements ChangePageListener {
    private Point initialClick;
    Sidebar pnlSidebar;
    javax.swing.JPanel pnlContent;
    
    Feed pnlFeed;
    Write pnlWrite;
    Profile pnlProfile;
    
    public HomeForm(boolean startAnimation) {
        initComponents();
        setBackground(new Color(1, 1, 1, 0.45f));
        
        if (startAnimation) initAnimation();
        
        applyMouseListener();
    }
    
    public HomeForm() {
        initComponents();
        setBackground(new Color(1, 1, 1, 0.45f));
        
        initAnimation();
        
        applyMouseListener();
    }
    
    public void startAnimation() {
        initAnimation();
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
    
    private void init() {
        pnlSidebar = new Sidebar(this);
        
        pnlContent = new javax.swing.JPanel();
        pnlContent.setLayout(new CardLayout());
        pnlContent.setOpaque(false);
        
        pnlFeed = new Feed();
        pnlWrite = new Write();
        pnlProfile = new Profile();
        
        pnlContent.add(pnlFeed, "feed");
        pnlContent.add(pnlWrite, "write");
        pnlContent.add(pnlProfile, "profile");
    }
    
    private void initAnimation() {
        init();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                pnlLoadingScreen.setSize(getWidth(), (int) (getHeight() - 460 * fraction));
            }
            
            @Override
            public void end() {
                pnlSidebar.setVisible(true);
                initSidebarAnimation();
                pnlHome.add(pnlSidebar, BorderLayout.WEST);
                pnlHome.add(pnlContent, BorderLayout.CENTER);
                pnlHome.remove(pnlLoadingScreen);
                pnlHome.revalidate();
                pnlHome.repaint();
            }
        };
        
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        
        Timer delayTimer = new Timer(1500, (ActionEvent e) -> {
            animator.start();
        });
        delayTimer.setRepeats(false);
        delayTimer.start();
    }

    private void initSidebarAnimation() {
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                pnlSidebar.setSize((int) (0 + 50 * fraction), getHeight());
                pnlContent.setSize((int) (0 + getWidth() * fraction), getHeight());
                pnlContent.setLocation((int) ((getWidth()) - (getWidth() - 50) * fraction), pnlContent.getLocation().y);
            }
        };
        
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        animator.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        pnlLoadingScreen = new com.pagzone.view.HomeLoadingScreen();
        pnlHeader = new com.pagzone.view.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BulSU Student Forum");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlHome.setOpaque(false);
        pnlHome.setLayout(new java.awt.BorderLayout());
        pnlHome.add(pnlLoadingScreen, java.awt.BorderLayout.CENTER);
        pnlHome.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 726, 456));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void setPage(String page) {
        CardLayout cardLayout = (CardLayout) pnlContent.getLayout();
        cardLayout.show(pnlContent, page);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.pagzone.view.Header pnlHeader;
    private javax.swing.JPanel pnlHome;
    private com.pagzone.view.HomeLoadingScreen pnlLoadingScreen;
    // End of variables declaration//GEN-END:variables
}
