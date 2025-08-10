/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pagzone.view.page.data;

import com.pagzone.dao.PostDao;
import com.pagzone.model.Post;
import com.pagzone.props.DataChangeListener;
import com.pagzone.view.page.data.dialog.EditDialog;
import com.pagzone.view.page.data.dialog.PostEdit;
import java.sql.SQLException;
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
public final class PostsData extends javax.swing.JPanel implements DataChangeListener {
    private JFrame parentFrame;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> rowSorter;
    
    public PostsData() {
        initComponents();
        setLayout(new MigLayout("wrap 2, fill", "[][grow]", "[][grow]"));
        add(lblSearch, "w 50:55:60");
        add(txtSearch, "growx");
        add(spnlPostTable, "span 2, grow");
        
        String[] columnNames = {"ID", "Author", "Title", "Body", "Timestamp"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblPosts.setModel(tableModel);
        
        populateTableData();
        rowSorter = new TableRowSorter<>(tableModel);
        parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    }
    
    public void populateTableData() {
        try {
            List<Post> posts = PostDao.getAllPosts();
            for (Post post : posts) {
                Object[] row = {
                    post.getId(),
                    post.getUser().getUsername(),
                    post.getTitle(),
                    post.getBody(),
                    post.getTimestamp()
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(parentFrame, "Error loading posts", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @Override
    public void refresh() {
        tableModel.setRowCount(0);
        populateTableData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        spnlPostTable = new javax.swing.JScrollPane();
        tblPosts = new javax.swing.JTable();

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

        tblPosts.setBackground(new java.awt.Color(255, 255, 255));
        tblPosts.setFont(new java.awt.Font("Poppins Light", 0, 12)); // NOI18N
        tblPosts.setForeground(new java.awt.Color(0, 0, 0));
        tblPosts.setGridColor(new java.awt.Color(51, 51, 51));
        tblPosts.getTableHeader().setResizingAllowed(false);
        tblPosts.getTableHeader().setReorderingAllowed(false);
        tblPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPostsMouseClicked(evt);
            }
        });
        spnlPostTable.setViewportView(tblPosts);

        add(spnlPostTable);
        spnlPostTable.setBounds(0, 34, 590, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        javax.swing.JTextField textField = (javax.swing.JTextField) evt.getSource();
        String searchQuery = textField.getText().trim();
        
        if (searchQuery.length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchQuery));
        }
        tblPosts.setRowSorter(rowSorter);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void tblPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPostsMouseClicked
        int selectedRow = tblPosts.getSelectedRow();
        int selectedId = (int) tblPosts.getValueAt(selectedRow, 0);
        
        try {
            PostEdit postEdit = new PostEdit(PostDao.getPost(selectedId));
            postEdit.setListener(this);
            EditDialog editDialog = new EditDialog(parentFrame, true, postEdit);
            editDialog.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tblPostsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSearch;
    private javax.swing.JScrollPane spnlPostTable;
    private javax.swing.JTable tblPosts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
