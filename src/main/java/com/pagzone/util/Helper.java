/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Arias
 */
public class Helper {
    public static void setLabelUnderline(JLabel label, boolean value) {
        Font font = label.getFont();
        Map attributes = font.getAttributes();
        if (value) {
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        } else {
            attributes.put(TextAttribute.UNDERLINE, -1);
        }
        label.setFont(font.deriveFont(attributes));
    }
    
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle the exception, e.g., logging or throwing a runtime exception
            throw new RuntimeException("Failed to hash password.");
        }
    }
    
    public static void setTextFieldBorder(JTextField comp, String title, Color color) {
        comp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), color));
    }
    
    public static String formatTimestamp(Timestamp timestamp) {
        // Convert Timestamp to LocalDateTime
        LocalDateTime dateTime = timestamp.toLocalDateTime();

        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");

        // Format LocalDateTime using the defined formatter
        String formattedDateTime = dateTime.format(formatter);

        return formattedDateTime;
    }
    
    public static ImageIcon resizeImage(Image image, int width, int height) {
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        BufferedImage resizedBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedBufferedImage.createGraphics();

        g2d.drawImage(resizedImage, 0, 0, null);
        g2d.dispose();

        ImageIcon icon = new ImageIcon(resizedBufferedImage);

        return icon;
    }
    
    public static BufferedImage convertToImage(byte[] imgBytes) throws IOException {
        InputStream in = new ByteArrayInputStream(imgBytes);
        return ImageIO.read(in);
    }
}
