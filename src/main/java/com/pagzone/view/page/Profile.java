/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page;

import com.pagzone.dao.CourseDao;
import com.pagzone.dao.StudentDao;
import com.pagzone.model.Course;
import com.pagzone.model.Student;
import com.pagzone.model.User;
import com.pagzone.service.SessionManager;
import com.pagzone.util.Helper;
import static com.pagzone.util.Helper.resizeImage;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Arias
 */
public class Profile extends javax.swing.JPanel {
    private SessionManager sessionManager;
    private Student currentStudent;
    
    /**
     * Creates new form Profile
     */
    public Profile() {
        initComponents();
        populateCoursesComboBox();
        try {
            populateStudentData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void populateCoursesComboBox() {
        List<Course> courses = CourseDao.getAllCourses();
        String[] courseNames = new String[courses.size()];
        
        for (Course course : courses) {
            courseNames[courses.indexOf(course)] = course.getCourseName();
        }
        
        cmbCourse.setModel(new DefaultComboBoxModel(courseNames));
    }

    private void populateStudentData() throws IOException {
        sessionManager = SessionManager.getInstance();
        User currentUser = sessionManager.getCurrentUser();
        currentStudent = currentUser.getStudent();
        
        txtStudentId.setText(String.valueOf(currentStudent.getStudId()));
        txtFirstName.setText(currentStudent.getFirstName() == null ? "" : currentStudent.getFirstName());
        txtMiddleName.setText(currentStudent.getMiddleName()== null ? "" : currentStudent.getMiddleName());
        txtLastName.setText(currentStudent.getLastName() == null ? "" : currentStudent.getLastName());
        cmbYear.setSelectedItem(String.valueOf(currentStudent.getYear()));
        cmbCourse.setSelectedItem(currentStudent.getCourse() == null ? cmbCourse.getItemAt(0) : currentStudent.getCourse());
        
        if (currentStudent.getProfilePicture() != null &&
                currentStudent.getProfilePicture().length > 0) {
            try {
                Image profilePic = Helper.convertToImage(currentStudent.getProfilePicture());
                ImageIcon profileIcon = resizeImage(profilePic, 100, 100);
                lblProfilePicture.setIcon(profileIcon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            Image profilePic = ImageIO.read(getClass().getResource("/avatar_placeholder.png"));
            ImageIcon profileIcon = resizeImage(profilePic, 100, 100);
            lblProfilePicture.setIcon(profileIcon);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProfile = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblStudentId = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblMiddleName = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox<>();
        lblCourse = new javax.swing.JLabel();
        cmbCourse = new javax.swing.JComboBox<>();
        pnlProfileContainer = new javax.swing.JPanel();
        lblProfilePicture = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        pnlProfile.setBackground(new java.awt.Color(199, 36, 36));

        lblTitle.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Student Profile");

        lblStudentId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblStudentId.setForeground(new java.awt.Color(255, 255, 255));
        lblStudentId.setLabelFor(txtStudentId);
        lblStudentId.setText("Student ID");

        txtStudentId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtStudentId.setEnabled(false);

        lblLastName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(255, 255, 255));
        lblLastName.setLabelFor(txtLastName);
        lblLastName.setText("Last Name");

        txtLastName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        lblFirstName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstName.setLabelFor(txtFirstName);
        lblFirstName.setText("First Name");

        txtFirstName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        lblMiddleName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblMiddleName.setForeground(new java.awt.Color(255, 255, 255));
        lblMiddleName.setLabelFor(txtFirstName);
        lblMiddleName.setText("Middle Name");

        txtMiddleName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        lblYear.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblYear.setForeground(new java.awt.Color(255, 255, 255));
        lblYear.setLabelFor(txtFirstName);
        lblYear.setText("Year");

        cmbYear.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        lblCourse.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblCourse.setForeground(new java.awt.Color(255, 255, 255));
        lblCourse.setLabelFor(txtFirstName);
        lblCourse.setText("Course");

        cmbCourse.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        pnlProfileContainer.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfileContainer.setLayout(new java.awt.BorderLayout());
        pnlProfileContainer.add(lblProfilePicture, java.awt.BorderLayout.CENTER);

        btnUpload.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProfileLayout = new javax.swing.GroupLayout(pnlProfile);
        pnlProfile.setLayout(pnlProfileLayout);
        pnlProfileLayout.setHorizontalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfileLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlProfileLayout.createSequentialGroup()
                        .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstName)
                            .addComponent(txtStudentId)
                            .addComponent(txtLastName)
                            .addComponent(txtMiddleName, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStudentId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlProfileLayout.createSequentialGroup()
                                .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCourse, 0, 185, Short.MAX_VALUE))))
                        .addGap(37, 37, 37)
                        .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlProfileContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        pnlProfileLayout.setVerticalGroup(
            pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblStudentId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfileLayout.createSequentialGroup()
                        .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLastName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFirstName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMiddleName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYear)
                            .addComponent(lblCourse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave)))
                    .addGroup(pnlProfileLayout.createSequentialGroup()
                        .addComponent(pnlProfileContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpload)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        add(pnlProfile, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Image File", "png", "jpg", "jpeg", "bmp");
        fileChooser.setFileFilter(filter);
        
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                Image image = ImageIO.read(selectedFile);
                ImageIcon icon = Helper.resizeImage(image, 100, 100);
                lblProfilePicture.setIcon(icon);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error loading image: " + ex.getMessage(),
                        "Image Loading Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("No file selected.");
//            JOptionPane.showMessageDialog(parentFrame, "No image selected. Please select an image.", "None Selected", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        int id = currentStudent.getId();
        String studId = txtStudentId.getText().trim();
        String firstName = txtFirstName.getText().trim();
        String middleName = txtMiddleName.getText().trim();
        String lastName = txtLastName.getText().trim();
        int year = Integer.parseInt(cmbYear.getSelectedItem().toString());
        String course = (String) cmbCourse.getSelectedItem();
        
        byte[] profilePicture = null;
        try {
            BufferedImage bufferedProfilePicture = Helper.convertToBufferedImage((ImageIcon) lblProfilePicture.getIcon());
            profilePicture = Helper.convertToByteArray(bufferedProfilePicture, "png");
        } catch (IOException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Student student = new Student(id, studId, firstName, middleName, lastName, year, course, profilePicture);
        try {
            StudentDao.updateStudent(student);
            JOptionPane.showMessageDialog(parentFrame, "Student updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(parentFrame, "Failed to update student. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblProfilePicture;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlProfile;
    private javax.swing.JPanel pnlProfileContainer;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
