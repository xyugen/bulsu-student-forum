/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data;

import com.pagzone.dao.CourseDao;
import com.pagzone.dao.UserDao;
import com.pagzone.model.Course;
import com.pagzone.model.User;
import com.pagzone.props.DataChangeListener;
import com.pagzone.util.Helper;
import com.pagzone.view.page.data.dialog.CourseEdit;
import com.pagzone.view.page.data.dialog.EditDialog;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Arias
 */
public final class CoursesData extends javax.swing.JPanel implements DataChangeListener {
    private final JFrame parentFrame;
    private final DefaultTableModel tableModel;
    private final TableRowSorter<DefaultTableModel> rowSorter;

    public CoursesData() {
        initComponents();
        setLayout(new MigLayout("wrap 2, fill", "[][grow]", "[][grow]"));
        add(lblSearch, "w 50:55:60");
        add(txtSearch, "growx");
        add(spnlCourseTable, "span 2, grow");
        
        String[] columnNames = {"ID", "Course Name"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblCourses.setModel(tableModel);
        
        populateTableData();
        rowSorter = new TableRowSorter<>(tableModel);
        parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    }
    
    @Override
    public void refresh() {
        tableModel.setRowCount(0);
        populateTableData();
    }
    
    public void populateTableData() {
        try {
            List<Course> courses = CourseDao.getAllCourses();
            for (Course course : courses) {
                Object[] row = {
                    course.getId(),
                    course.getCourseName()
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame, "Error loading courses", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        spnlCourseTable = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        lblSearch.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(0, 0, 0));
        lblSearch.setText("Search");
        add(lblSearch);
        lblSearch.setBounds(10, 9, 50, 20);

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        add(txtSearch);
        txtSearch.setBounds(80, 0, 160, 30);

        tblCourses.setBackground(new java.awt.Color(255, 255, 255));
        tblCourses.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tblCourses.setForeground(new java.awt.Color(0, 0, 0));
        tblCourses.setGridColor(new java.awt.Color(51, 51, 51));
        tblCourses.getTableHeader().setResizingAllowed(false);
        tblCourses.getTableHeader().setReorderingAllowed(false);
        tblCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCoursesMouseClicked(evt);
            }
        });
        spnlCourseTable.setViewportView(tblCourses);

        add(spnlCourseTable);
        spnlCourseTable.setBounds(0, 40, 460, 260);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        javax.swing.JTextField textField = (javax.swing.JTextField) evt.getSource();
        String searchQuery = textField.getText().trim();

        if (searchQuery.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchQuery));
        }
        tblCourses.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void tblCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCoursesMouseClicked
        int selectedRow = tblCourses.getSelectedRow();
        int selectedId = (int) tblCourses.getValueAt(selectedRow, 0);
        
        CourseEdit courseEdit = new CourseEdit(CourseDao.getCourse(selectedId));
        courseEdit.setListener(this);
        EditDialog editDialog = new EditDialog(parentFrame, true, courseEdit);
        editDialog.setVisible(true);
    }//GEN-LAST:event_tblCoursesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSearch;
    private javax.swing.JScrollPane spnlCourseTable;
    private javax.swing.JTable tblCourses;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
