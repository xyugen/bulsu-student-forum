/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data.dialog;

import com.pagzone.dao.CourseDao;
import com.pagzone.dao.StudentDao;
import com.pagzone.dao.UserDao;
import com.pagzone.model.Course;
import com.pagzone.model.Student;
import com.pagzone.model.User;
import com.pagzone.props.DataChangeListener;
import com.pagzone.service.SessionManager;
import com.pagzone.util.Helper;
import com.pagzone.util.UserValidator;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arias
 */
public final class StudentEdit extends javax.swing.JPanel {
    private Student student;
    private DataChangeListener listener;
    
    public StudentEdit() {
        initComponents();
        populateCoursesComboBox();
    }
    
    public StudentEdit(Student student) {
        initComponents();
        this.student = student;
        populateCoursesComboBox();
        
        showData();
    }
    
    private void populateCoursesComboBox() {
        List<Course> courses = CourseDao.getAllCourses();
        String[] courseNames = new String[courses.size()];
        
        for (Course course : courses) {
            courseNames[courses.indexOf(course)] = course.getCourseName();
        }
        
        cmbCourse.setModel(new DefaultComboBoxModel(courseNames));
    }

    public void setListener(DataChangeListener listener) {
        this.listener = listener;
    }
    
    public void setPost(Student student) {
        this.student = student;
    }
    
    public void showData() {
        if (student != null) {
            txtFieldId.setText(String.valueOf(student.getId()));
            txtStudentId.setText(student.getStudId());
            txtFirstName.setText(student.getFirstName());
            txtMiddleName.setText(student.getMiddleName());
            txtLastName.setText(student.getLastName());
            cmbYear.setSelectedItem(String.valueOf(student.getYear()));
            cmbCourse.setSelectedItem(student.getCourse());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditUser = new javax.swing.JLabel();
        txtFieldId = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        txtFirstName = new com.pagzone.component.LimitedTextField();
        txtMiddleName = new com.pagzone.component.LimitedTextField();
        txtLastName = new com.pagzone.component.LimitedTextField();
        cmbYear = new javax.swing.JComboBox<>();
        cmbCourse = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblEditUser.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        lblEditUser.setForeground(new java.awt.Color(0, 0, 0));
        lblEditUser.setText("Edit Student");

        txtFieldId.setEditable(false);
        txtFieldId.setBackground(new java.awt.Color(255, 255, 255));
        txtFieldId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtFieldId.setForeground(new java.awt.Color(0, 0, 0));
        txtFieldId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Field ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtStudentId.setEditable(false);
        txtStudentId.setBackground(new java.awt.Color(255, 255, 255));
        txtStudentId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtStudentId.setForeground(new java.awt.Color(0, 0, 0));
        txtStudentId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtFirstName.setBackground(new java.awt.Color(255, 255, 255));
        txtFirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(0, 0, 0));
        txtFirstName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtFirstName.setMaxLength(50);

        txtMiddleName.setBackground(new java.awt.Color(255, 255, 255));
        txtMiddleName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Middle Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        txtMiddleName.setForeground(new java.awt.Color(0, 0, 0));
        txtMiddleName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtMiddleName.setMaxLength(255);

        txtLastName.setBackground(new java.awt.Color(255, 255, 255));
        txtLastName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        txtLastName.setForeground(new java.awt.Color(0, 0, 0));
        txtLastName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtLastName.setMaxLength(255);

        cmbYear.setBackground(new java.awt.Color(255, 255, 255));
        cmbYear.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbYear.setForeground(new java.awt.Color(0, 0, 0));
        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        cmbYear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Year", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        cmbCourse.setBackground(new java.awt.Color(255, 255, 255));
        cmbCourse.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbCourse.setForeground(new java.awt.Color(0, 0, 0));
        cmbCourse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 50, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSave))
                            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEditUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtStudentId)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblEditUser)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame,
                """
                    Are you sure you want to delete student?
                    Deleting this student will delete the corresponding user.""",
                "Delete Student", JOptionPane.YES_NO_OPTION);
        
        if (choice == 0) {
            try {
                StudentDao.deleteStudent(student.getId());
                if (listener != null) {
                    if (student.getId() == SessionManager
                            .getInstance()
                            .getCurrentUser()
                            .getStudent()
                            .getId())
                        System.exit(0);
                    listener.refresh();
                } else {
                    System.out.println("No listener");
                }
                parentFrame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(StudentEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to update student?",
                "Update Student", JOptionPane.YES_NO_OPTION);
       
        Student newStudent = student;
        newStudent.setFirstName(txtFirstName.getText().trim());
        newStudent.setMiddleName(txtMiddleName.getText().trim());
        newStudent.setLastName(txtLastName.getText().trim());
        newStudent.setYear(Integer.parseInt((String) cmbYear.getSelectedItem()));
        newStudent.setCourse(String.valueOf(cmbCourse.getSelectedItem()));
        if (choice == 0) {
            try {
                StudentDao.updateStudent(newStudent);
                if (listener != null) {
                    listener.refresh();
                } else {
                    System.out.println("No listener");
                }
                parentFrame.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(StudentEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbCourse;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JLabel lblEditUser;
    private javax.swing.JTextField txtFieldId;
    private com.pagzone.component.LimitedTextField txtFirstName;
    private com.pagzone.component.LimitedTextField txtLastName;
    private com.pagzone.component.LimitedTextField txtMiddleName;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}
