package com.pagzone.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.pagzone.view.Login;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.Timer;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {
    private Point initialClick;

    public Main() {
        initComponents();
        initSplashScreen();
        
        JFrame parentFrame = this;
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });
        
        addMouseMotionListener(new MouseAdapter() {
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
    
    private void initSplashScreen() {
        Login pnlLogin = new Login();
        pnlLogin.setSize(0, 400);
        pnlLogin.setVisible(false);
        pnlMain.add(pnlLogin, BorderLayout.WEST);
        pnlMain.setComponentZOrder(pnlLogin, 0);
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                int splashScreenWidth = (int) (600 - 250 * fraction);
                int x = (int) (0 + 250 * fraction);
                pnlSplashScreen.setBounds(x, 0, splashScreenWidth, 400);
                
                pnlLogin.setVisible(true);
                int loginWidth = (int) (0 + 300 * fraction);
                pnlLogin.setSize(loginWidth, 400);
            }
            
            @Override
            public void end() {
                pnlMain.revalidate();
                pnlMain.repaint();
            }
        };
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        
        Timer delayTimer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("STARTED!");
                animator.start();
            }
        });
        delayTimer.setRepeats(false);
        delayTimer.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlSplashScreen = new com.pagzone.view.SplashScreen();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BulSU Student Forum");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setLayout(new java.awt.BorderLayout());
        pnlMain.add(pnlSplashScreen, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlMain;
    private com.pagzone.view.SplashScreen pnlSplashScreen;
    // End of variables declaration//GEN-END:variables
}
