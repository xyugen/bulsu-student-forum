package com.pagzone.component;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingSource;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Arias
 */
public class CustomTitleBar extends javax.swing.JPanel {
    /**
     * Creates new form CustomTitleBar
     */
    public CustomTitleBar() {
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

        btnClose = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        btnMinimize = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        setLayout(flowLayout1);

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(102, 255, 102));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close_icon.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        add(btnClose);
        add(filler1);

        btnMinimize.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimize.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        btnMinimize.setForeground(new java.awt.Color(255, 51, 51));
        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/minimize_icon.png"))); // NOI18N
        btnMinimize.setBorder(null);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });
        add(btnMinimize);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.dispose(); // Close the enclosing JFrame
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            animateMinimize(frame); // Minimize the enclosing JFrame
        }
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void animateMinimize(JFrame frame) {
        int defaultWidth = frame.getWidth(), defaultHeight = frame.getHeight();
        Animator animator = new Animator(200, new TimingTargetAdapter() {
                    @Override
                    public void timingEvent(float fraction) {
                        int frameHeight = frame.getHeight();
                        int minHeight = 25; // Minimum height for the frame

                        // Calculate the new height of the frame based on the animation fraction
                        int newHeight = (int) (frameHeight - (frameHeight - minHeight) * fraction);

                        // Set the frame's size
                        frame.setSize(frame.getWidth(), newHeight);
                    }

                    @Override
                    public void end() {
                        frame.setState(Frame.ICONIFIED);
                        frame.setSize(defaultWidth, defaultHeight);
                    }
                });

        animator.start();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.Box.Filler filler1;
    // End of variables declaration//GEN-END:variables
}
