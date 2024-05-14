/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.component;

/**
 *
 * @author Arias
 */
import javax.swing.*;
import javax.swing.text.*;

public class LimitedTextField extends JTextField {
    private int maxLength;

    public LimitedTextField() {
        this.maxLength = -1;
        setDocument(new JTextFieldLimit(maxLength));
    }
    
    public LimitedTextField(int maxLength) {
        this.maxLength = maxLength;
        setDocument(new JTextFieldLimit(maxLength));
    }
    
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        setDocument(new JTextFieldLimit(maxLength));
    }

    private class JTextFieldLimit extends PlainDocument {
        private final int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= limit || limit < 0) {
                super.insertString(offset, str, attr);
            }
        }
    }
}

