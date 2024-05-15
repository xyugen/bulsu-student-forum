/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.view.sidebar;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Arias
 */
public class MenuItem extends javax.swing.JButton {
    private boolean active;
    
    public MenuItem() {
        this.setBackground(new java.awt.Color(242, 231, 213));
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setMargin(null);
        
        javax.swing.JButton component = this;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!active) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    component.setContentAreaFilled(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!active) {
                    setCursor(Cursor.getDefaultCursor());
                    component.setContentAreaFilled(false);
                }
            }
        });
    }
    
    public void setIsActive(boolean value) {
        active = value;
    }
    
    public boolean isActive() {
        return active;
    }
}
