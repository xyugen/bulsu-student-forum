/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data;

import com.pagzone.dao.StudentDao;
import com.pagzone.model.Student;
import com.pagzone.props.DataChangeListener;
import com.pagzone.view.page.data.dialog.EditDialog;
import com.pagzone.view.page.data.dialog.StudentEdit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class StudentsData extends javax.swing.JPanel implements DataChangeListener {
    private JFrame parentFrame;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> rowSorter;

    public StudentsData() {
        initComponents();
        setLayout(new MigLayout("wrap 2, fill", "[][grow]", "[][grow]"));
        add(lblSearch, "w 50:55:60");
        add(txtSearch, "growx");
        add(spnlStudentsTable, "span 2, grow");
        
        String[] columnNames = {"ID", "Student ID", "First Name", "Middle Name", "Last Name", "Year", "Course"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblStudents.setModel(tableModel);
        
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
            List<Student> students = StudentDao.getAllStudents();
            for (Student student : students) {
                Object[] row = {
                    student.getId(),
                    student.getStudId(),
                    student.getFirstName(),
                    student.getMiddleName(),
                    student.getLastName(),
                    student.getYear(),
                    student.getCourse()
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame, "Error loading students", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        spnlStudentsTable = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();

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

        tblStudents.setBackground(new java.awt.Color(255, 255, 255));
        tblStudents.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tblStudents.setForeground(new java.awt.Color(0, 0, 0));
        tblStudents.setGridColor(new java.awt.Color(51, 51, 51));
        tblStudents.getTableHeader().setResizingAllowed(false);
        tblStudents.getTableHeader().setReorderingAllowed(false);
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        spnlStudentsTable.setViewportView(tblStudents);

        add(spnlStudentsTable);
        spnlStudentsTable.setBounds(0, 34, 590, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        javax.swing.JTextField textField = (javax.swing.JTextField) evt.getSource();
        String searchQuery = textField.getText().trim();

        if (searchQuery.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchQuery));
        }
        tblStudents.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
        try {
            int selectedRow = tblStudents.getSelectedRow();
            int selectedId = (int) tblStudents.getValueAt(selectedRow, 0);
            
            StudentEdit studentEdit = new StudentEdit(StudentDao.getStudent(selectedId));
            studentEdit.setListener(this);
            EditDialog editDialog = new EditDialog(parentFrame, true, studentEdit);
            editDialog.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(StudentsData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblStudentsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSearch;
    private javax.swing.JScrollPane spnlStudentsTable;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
