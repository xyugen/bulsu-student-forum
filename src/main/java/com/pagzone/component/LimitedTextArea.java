/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.component;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Arias
 */
public class LimitedTextArea extends javax.swing.JTextArea {
    private int maxLength;
    
    public LimitedTextArea() {
        this.maxLength = -1;
        setDocument(new JTextAreaLimit(maxLength));
    }
    
    public LimitedTextArea(int maxLength) {
        this.maxLength = maxLength;
        setDocument(new JTextAreaLimit(maxLength));
    }
    
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        setDocument(new JTextAreaLimit(maxLength));
    }
    
    public class JTextAreaLimit extends PlainDocument {
        private int limit;
        
        JTextAreaLimit(int limit) {
            super();
            this.limit = limit;;
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
