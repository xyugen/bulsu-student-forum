package com.pagzone.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.pagzone.service.EmailService;
import com.pagzone.util.OTPHelper;
import com.pagzone.view.Login;
import com.pagzone.view.Signup;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame implements com.pagzone.model.CardLayoutChangeListener {
    private Point initialClick;
    private JPanel pnlCardContainer;

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
    
    @Override
    public void changeCardLayout(String cardName) {
        CardLayout cardLayout = (CardLayout) pnlCardContainer.getLayout();
        cardLayout.show(pnlCardContainer, cardName);
    }
    
    private void initSplashScreen() {
        Login pnlLogin = new Login(this);
        Signup pnlSignup = new Signup(this);
        
        pnlCardContainer = new JPanel(new CardLayout());
        pnlCardContainer.setVisible(false);
        pnlMain.add(pnlCardContainer, BorderLayout.WEST);

        pnlCardContainer.add(pnlLogin, "login");
        pnlCardContainer.add(pnlSignup, "signup");
        CardLayout cardLayout = (CardLayout) pnlCardContainer.getLayout();
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                int splashScreenWidth = (int) (pnlMain.getWidth() - 250 * fraction);
                int x = (int) (0 + 300 * fraction);
                pnlSplashScreen.setBounds(x, 0, splashScreenWidth, 400);
                
                pnlCardContainer.setVisible(true);
                cardLayout.show(pnlCardContainer, "login");
                int loginWidth = (int) (0 + 300 * fraction);
                pnlCardContainer.setSize(loginWidth, 400);
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

        pnlMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(199, 36, 36)));
        pnlMain.setLayout(new java.awt.BorderLayout());
        pnlMain.add(pnlSplashScreen, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

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
