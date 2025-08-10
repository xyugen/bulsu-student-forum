/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data.dialog;

import com.pagzone.dao.CourseDao;
import com.pagzone.model.Course;
import com.pagzone.props.DataChangeListener;
import com.pagzone.service.SessionManager;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arias
 */
public final class CourseEdit extends javax.swing.JPanel {
    private Course course;
    private DataChangeListener listener;
    private boolean addMode;
    
    public CourseEdit() {
        initComponents();
    }
    
    public CourseEdit(Course course) {
        initComponents();
        this.course = course;
        
        showData();
    }

    public void setListener(DataChangeListener listener) {
        this.listener = listener;
    }
    
    public void setPost(Course course ){
        this.course = course;
    }
    
    public void showData() {
        if (course != null) {
            txtCourseId.setText(String.valueOf(course.getId()));
            txtCourseName.setText(course.getCourseName());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditCourse = new javax.swing.JLabel();
        txtCourseId = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        tbtnAdd = new javax.swing.JToggleButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblEditCourse.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        lblEditCourse.setForeground(new java.awt.Color(0, 0, 0));
        lblEditCourse.setText("Edit Course");

        txtCourseId.setEditable(false);
        txtCourseId.setBackground(new java.awt.Color(255, 255, 255));
        txtCourseId.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtCourseId.setForeground(new java.awt.Color(0, 0, 0));
        txtCourseId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        txtCourseName.setBackground(new java.awt.Color(255, 255, 255));
        txtCourseName.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        txtCourseName.setForeground(new java.awt.Color(0, 0, 0));
        txtCourseName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Course Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        tbtnAdd.setBackground(new java.awt.Color(255, 255, 255));
        tbtnAdd.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tbtnAdd.setForeground(new java.awt.Color(0, 0, 0));
        tbtnAdd.setText("Add");
        tbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnAddActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEditCourse)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCourseName, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tbtnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblEditCourse)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tbtnAdd)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to delete course?",
                "Delete Course", JOptionPane.YES_NO_OPTION);
        
        if (choice == 0) {
            CourseDao.deleteCourse(course.getId());
            if (listener != null) {
                listener.refresh();
            } else {
                System.out.println("No listener");
            }
            parentFrame.dispose();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        JDialog parentFrame = (JDialog) SwingUtilities.getWindowAncestor(this);
        int choice = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to update course?",
                "Update Course", JOptionPane.YES_NO_OPTION);
        
        if (choice == 0) {
            if (addMode) {
                CourseDao.insertCourse(txtCourseName.getText().trim());
            } else {
                CourseDao.editCourse(course.getId(), txtCourseName.getText().trim());
            }
            if (listener != null) {
                listener.refresh();
            } else {
                System.out.println("No listener");
            }
            parentFrame.dispose();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnAddActionPerformed
        addMode = tbtnAdd.isSelected();
        if (addMode) {
            txtCourseId.setText("");
            btnDelete.setEnabled(false);
        } else {
            txtCourseId.setText(String.valueOf(course.getId()));
            btnDelete.setEnabled(true);
        }
    }//GEN-LAST:event_tbtnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblEditCourse;
    private javax.swing.JToggleButton tbtnAdd;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JTextField txtCourseName;
    // End of variables declaration//GEN-END:variables
}
