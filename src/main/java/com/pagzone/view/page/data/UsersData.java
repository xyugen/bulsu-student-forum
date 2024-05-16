/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data;

import com.pagzone.dao.UserDao;
import com.pagzone.model.User;
import com.pagzone.props.DataChangeListener;
import com.pagzone.util.Helper;
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
public final class UsersData extends javax.swing.JPanel implements DataChangeListener {
    private JFrame parentFrame;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> rowSorter;

    public UsersData() {
        initComponents();
        setLayout(new MigLayout("wrap 2, fill", "[][grow]", "[][grow]"));
        add(lblSearch, "w 50:55:60");
        add(txtSearch, "growx");
        add(spnlUserTable, "span 2, grow");
        
        String[] columnNames = {"ID", "Email", "Username", "Student ID", "Admin", "Creation Time"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblUsers.setModel(tableModel);
        
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
            List<User> users = UserDao.getAllUsers();
            for (User user : users) {
                Object[] row = {
                    user.getId(),
                    user.getEmail(),
                    user.getUsername(),
                    user.getStudent().getStudId(),
                    user.isAdmin() ? "Yes" : "No",
                    Helper.formatTimestamp(user.getCreationDate())
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame, "Error loading users", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        spnlUserTable = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 0, 0));
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

        tblUsers.setBackground(new java.awt.Color(255, 255, 255));
        tblUsers.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tblUsers.setForeground(new java.awt.Color(0, 0, 0));
        tblUsers.setGridColor(new java.awt.Color(51, 51, 51));
        tblUsers.getTableHeader().setResizingAllowed(false);
        tblUsers.getTableHeader().setReorderingAllowed(false);
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        spnlUserTable.setViewportView(tblUsers);

        add(spnlUserTable);
        spnlUserTable.setBounds(0, 34, 590, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        javax.swing.JTextField textField = (javax.swing.JTextField) evt.getSource();
        String searchQuery = textField.getText().trim();

        if (searchQuery.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchQuery));
        }
        tblUsers.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        
    }//GEN-LAST:event_tblUsersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSearch;
    private javax.swing.JScrollPane spnlUserTable;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
