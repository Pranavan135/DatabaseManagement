/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.ui;

import db.entity.Passenger;
import db.entity.Tour;
import db.ui.dao.PassengerDAO;
import db.ui.dao.TourDAO;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vishnuvathsasarma
 */
public class PassengerWindow extends javax.swing.JFrame {

    /**
     * Creates new form PassengerWindow
     */
    PassengerDAO passengerDAO = new PassengerDAO();
    TourDAO tourDAO = new TourDAO();
    
    public PassengerWindow() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PassengerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */        
        initComponents();
    }
    
    public void createDelTable(List<Passenger> passenger) {
        
        ArrayList<Object[]> data = new ArrayList<>();
        
        for (int i = 0; i < passenger.size(); i++) {
            
            Object[] row = new Object[]{passenger.get(i).getId(),
                passenger.get(i).getName(),
                passenger.get(i).getTour().getTourCode()};
            data.add(row);
        }
        
        Object[][] passengerData = data.toArray(new Object[data.size()][]);
        
        tableDel.setModel(new javax.swing.table.DefaultTableModel(passengerData, new String[]{"ID", "Name", "Tour"}));
        setVisible(true);
        scrollPaneDel.getViewport().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        
        tableDel.setAutoscrolls(true);
        tableDel.setFillsViewportHeight(true);
        tableDel.setPreferredScrollableViewportSize(new java.awt.Dimension(800, 300));
        tableDel.setGridColor(new java.awt.Color(255, 255, 204));
        tableDel.setName("Passenger Detail");
        
        tableDel.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                
                Component c = super.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new java.awt.Color(255, 255, 204) : Color.WHITE);
                return c;
                
            }
        });
    }
    
    public void createViewTable(List<Passenger> passenger) {
        
        ArrayList<Object[]> data = new ArrayList<>();
        
        for (int i = 0; i < passenger.size(); i++) {
            
            Object[] row = new Object[]{passenger.get(i).getId(),
                passenger.get(i).getName(),
                passenger.get(i).getTour().getTourCode()};
            data.add(row);
        }
        
        Object[][] passengerData = data.toArray(new Object[data.size()][]);
        
        tableView.setModel(new javax.swing.table.DefaultTableModel(passengerData, new String[]{"ID", "Name", "Tour"}));
        setVisible(true);
        scrollPaneView.getViewport().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        
        tableView.setAutoscrolls(true);
        tableView.setFillsViewportHeight(true);
        tableView.setPreferredScrollableViewportSize(new java.awt.Dimension(800, 300));
        tableView.setGridColor(new java.awt.Color(255, 255, 204));
        tableView.setName("Passenger Detail");
        
        tableView.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                
                Component c = super.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? new java.awt.Color(255, 255, 204) : Color.WHITE);
                return c;
                
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanePassenger = new javax.swing.JTabbedPane();
        tabPassengerAdd = new javax.swing.JPanel();
        lblAddName = new javax.swing.JLabel();
        lblAddID = new javax.swing.JLabel();
        lblAddTourCode = new javax.swing.JLabel();
        txtAddTourCode = new javax.swing.JTextField();
        txtAddID = new javax.swing.JTextField();
        txtAddName = new javax.swing.JTextField();
        btnAddAdd = new javax.swing.JButton();
        btnAddClear = new javax.swing.JButton();
        btnAddExit = new javax.swing.JButton();
        tabPassengerEdit = new javax.swing.JPanel();
        lblEditName = new javax.swing.JLabel();
        txtEditName = new javax.swing.JTextField();
        txtEditID = new javax.swing.JTextField();
        txtEditTourCode = new javax.swing.JTextField();
        lblEditTourCode = new javax.swing.JLabel();
        lblEditID = new javax.swing.JLabel();
        btnEditUpdate = new javax.swing.JButton();
        btnEditClear = new javax.swing.JButton();
        btnEditExit = new javax.swing.JButton();
        tabPassengerDelete = new javax.swing.JPanel();
        lblDelSaerch = new javax.swing.JLabel();
        comboDelSearchCategory = new javax.swing.JComboBox();
        txtDelKeyword = new javax.swing.JTextField();
        btnDelFind = new javax.swing.JButton();
        scrollPaneDel = new javax.swing.JScrollPane();
        tableDel = new javax.swing.JTable();
        btnDelClear = new javax.swing.JButton();
        btnDelDelete = new javax.swing.JButton();
        btnDelExit = new javax.swing.JButton();
        tabPassengerView = new javax.swing.JPanel();
        lblViewSaerch = new javax.swing.JLabel();
        comboViewSearchCategory = new javax.swing.JComboBox();
        txtViewKeyword = new javax.swing.JTextField();
        btnViewFind = new javax.swing.JButton();
        scrollPaneView = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        btnViewClear = new javax.swing.JButton();
        btnViewExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPassengerAdd.setToolTipText("");
        tabPassengerAdd.setName(""); // NOI18N

        lblAddName.setText("Name");

        lblAddID.setText("ID");

        lblAddTourCode.setText("Tour Code");

        btnAddAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAddAdd.setText("ADD");
        btnAddAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAddActionPerformed(evt);
            }
        });

        btnAddClear.setText("Clear");
        btnAddClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClearActionPerformed(evt);
            }
        });

        btnAddExit.setText("Exit");
        btnAddExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPassengerAddLayout = new javax.swing.GroupLayout(tabPassengerAdd);
        tabPassengerAdd.setLayout(tabPassengerAddLayout);
        tabPassengerAddLayout.setHorizontalGroup(
            tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerAddLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabPassengerAddLayout.createSequentialGroup()
                        .addComponent(btnAddAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddExit))
                    .addGroup(tabPassengerAddLayout.createSequentialGroup()
                        .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddTourCode)
                            .addComponent(lblAddID)
                            .addComponent(lblAddName))
                        .addGap(18, 18, 18)
                        .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddName)
                            .addComponent(txtAddID)
                            .addComponent(txtAddTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        tabPassengerAddLayout.setVerticalGroup(
            tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerAddLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddName)
                    .addComponent(txtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddID)
                    .addComponent(txtAddID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddTourCode)
                    .addComponent(txtAddTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAdd)
                    .addComponent(btnAddClear)
                    .addComponent(btnAddExit))
                .addContainerGap())
        );

        tabPanePassenger.addTab("ADD", tabPassengerAdd);
        tabPassengerAdd.getAccessibleContext().setAccessibleName("tabPassengerAdd");

        lblEditName.setText("Name");

        lblEditTourCode.setText("Tour Code");

        lblEditID.setText("ID");

        btnEditUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditUpdate.setText("UPDATE");
        btnEditUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUpdateActionPerformed(evt);
            }
        });

        btnEditClear.setText("Clear");
        btnEditClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClearActionPerformed(evt);
            }
        });

        btnEditExit.setText("Exit");
        btnEditExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPassengerEditLayout = new javax.swing.GroupLayout(tabPassengerEdit);
        tabPassengerEdit.setLayout(tabPassengerEditLayout);
        tabPassengerEditLayout.setHorizontalGroup(
            tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerEditLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tabPassengerEditLayout.createSequentialGroup()
                        .addComponent(btnEditUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditExit))
                    .addGroup(tabPassengerEditLayout.createSequentialGroup()
                        .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditTourCode)
                            .addComponent(lblEditID)
                            .addComponent(lblEditName))
                        .addGap(18, 18, 18)
                        .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEditName)
                            .addComponent(txtEditID)
                            .addComponent(txtEditTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        tabPassengerEditLayout.setVerticalGroup(
            tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerEditLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditName)
                    .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditID)
                    .addComponent(txtEditID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditTourCode)
                    .addComponent(txtEditTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditUpdate)
                    .addComponent(btnEditClear)
                    .addComponent(btnEditExit))
                .addContainerGap())
        );

        tabPanePassenger.addTab("EDIT", tabPassengerEdit);
        tabPassengerEdit.getAccessibleContext().setAccessibleName("tabPassengerEdit");

        lblDelSaerch.setText("Search by:");

        comboDelSearchCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "ID" }));

        btnDelFind.setText("Find");
        btnDelFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFindActionPerformed(evt);
            }
        });

        tableDel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneDel.setViewportView(tableDel);

        btnDelClear.setText("Clear");
        btnDelClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelClearActionPerformed(evt);
            }
        });

        btnDelDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDelDelete.setText("DELETE");
        btnDelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDeleteActionPerformed(evt);
            }
        });

        btnDelExit.setText("Exit");
        btnDelExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPassengerDeleteLayout = new javax.swing.GroupLayout(tabPassengerDelete);
        tabPassengerDelete.setLayout(tabPassengerDeleteLayout);
        tabPassengerDeleteLayout.setHorizontalGroup(
            tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                        .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDelKeyword)
                            .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                                .addComponent(lblDelSaerch)
                                .addGap(18, 18, 18)
                                .addComponent(comboDelSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnDelFind))
                    .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                            .addComponent(btnDelDelete)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelClear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelExit))
                        .addComponent(scrollPaneDel, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        tabPassengerDeleteLayout.setVerticalGroup(
            tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelSaerch)
                    .addComponent(comboDelSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelFind))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneDel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelDelete)
                    .addComponent(btnDelExit)
                    .addComponent(btnDelClear))
                .addContainerGap())
        );

        tabPanePassenger.addTab("DELETE", tabPassengerDelete);
        tabPassengerDelete.getAccessibleContext().setAccessibleName("tabPassengerDelete");

        lblViewSaerch.setText("Search by:");

        comboViewSearchCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "ID" }));

        btnViewFind.setText("Find");
        btnViewFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFindActionPerformed(evt);
            }
        });

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneView.setViewportView(tableView);

        btnViewClear.setText("Clear");
        btnViewClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewClearActionPerformed(evt);
            }
        });

        btnViewExit.setText("Exit");
        btnViewExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabPassengerViewLayout = new javax.swing.GroupLayout(tabPassengerView);
        tabPassengerView.setLayout(tabPassengerViewLayout);
        tabPassengerViewLayout.setHorizontalGroup(
            tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerViewLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPassengerViewLayout.createSequentialGroup()
                        .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtViewKeyword)
                            .addGroup(tabPassengerViewLayout.createSequentialGroup()
                                .addComponent(lblViewSaerch)
                                .addGap(18, 18, 18)
                                .addComponent(comboViewSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnViewFind))
                    .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabPassengerViewLayout.createSequentialGroup()
                            .addComponent(btnViewClear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnViewExit))
                        .addComponent(scrollPaneView, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        tabPassengerViewLayout.setVerticalGroup(
            tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewSaerch)
                    .addComponent(comboViewSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewFind))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneView, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewExit)
                    .addComponent(btnViewClear))
                .addContainerGap())
        );

        tabPanePassenger.addTab("VIEW", tabPassengerView);
        tabPassengerView.getAccessibleContext().setAccessibleName("tabPassengerView");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanePassenger)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanePassenger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tabPanePassenger.getAccessibleContext().setAccessibleName("tabPanePassenger");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnAddExitActionPerformed

    private void btnEditExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnEditExitActionPerformed

    private void btnDelExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnDelExitActionPerformed

    private void btnViewExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnViewExitActionPerformed

    private void btnAddClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClearActionPerformed
        // TODO add your handling code here:
        txtAddName.setText("");
        txtAddID.setText("");
        txtAddTourCode.setText("");
    }//GEN-LAST:event_btnAddClearActionPerformed

    private void btnEditClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClearActionPerformed
        // TODO add your handling code here:
        txtEditName.setText("");
        txtEditID.setText("");
        txtEditTourCode.setText("");
    }//GEN-LAST:event_btnEditClearActionPerformed

    private void btnDelClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelClearActionPerformed
        // TODO add your handling code here:
        txtDelKeyword.setText("");
        tableDel.removeAll();        
    }//GEN-LAST:event_btnDelClearActionPerformed

    private void btnViewClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewClearActionPerformed
        // TODO add your handling code here:
        txtViewKeyword.setText("");
        tableView.removeAll();
    }//GEN-LAST:event_btnViewClearActionPerformed

    private void btnDelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelDeleteActionPerformed

    private void btnAddAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAddActionPerformed
        // TODO add your handling code here:
        
        int ID = Integer.parseInt(txtAddID.getText());
        int tourCode = Integer.parseInt(txtAddTourCode.getText());
        String name = txtAddName.getText();
        Tour tour = new Tour();
       //  tour = tourDAO.getTour(tourCode);
        Passenger instance = new Passenger(ID, tour, name);
        boolean success = passengerDAO.addPassenger(instance);
        
    }//GEN-LAST:event_btnAddAddActionPerformed

    private void btnEditUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUpdateActionPerformed
        // TODO add your handling code here:
        
        int ID = Integer.parseInt(txtEditID.getText());
        int tourCode = Integer.parseInt(txtEditTourCode.getText());
        String name = txtEditName.getText();
        Tour tour = new Tour();
       //  tour = tourDAO.getTour(tourCode);
        Passenger instance = new Passenger(ID, tour, name);
        boolean success = passengerDAO.updatePassenger(instance);
        
    }//GEN-LAST:event_btnEditUpdateActionPerformed

    private void btnDelFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFindActionPerformed
        // TODO add your handling code here:
        if(comboDelSearchCategory.getSelectedIndex()==0){
            String name = txtDelKeyword.getText().trim();
            List<Passenger> result = passengerDAO.getPassenger(name);
            createDelTable(result);            
        } else {
            int ID = Integer.parseInt(txtDelKeyword.getText().trim());
            List<Passenger> result = passengerDAO.getPassenger(ID);
            createDelTable(result);
        }
    }//GEN-LAST:event_btnDelFindActionPerformed

    private void btnViewFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFindActionPerformed
        // TODO add your handling code here:
        if(comboViewSearchCategory.getSelectedIndex()==0){
            String name = txtViewKeyword.getText().trim();
            List<Passenger> result = passengerDAO.getPassenger(name);
            createViewTable(result);
        } else {
            int ID = Integer.parseInt(txtViewKeyword.getText().trim());
            List<Passenger> result = passengerDAO.getPassenger(ID);
            createViewTable(result);
        }
    }//GEN-LAST:event_btnViewFindActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAdd;
    private javax.swing.JButton btnAddClear;
    private javax.swing.JButton btnAddExit;
    private javax.swing.JButton btnDelClear;
    private javax.swing.JButton btnDelDelete;
    private javax.swing.JButton btnDelExit;
    private javax.swing.JButton btnDelFind;
    private javax.swing.JButton btnEditClear;
    private javax.swing.JButton btnEditExit;
    private javax.swing.JButton btnEditUpdate;
    private javax.swing.JButton btnViewClear;
    private javax.swing.JButton btnViewExit;
    private javax.swing.JButton btnViewFind;
    private javax.swing.JComboBox comboDelSearchCategory;
    private javax.swing.JComboBox comboViewSearchCategory;
    private javax.swing.JLabel lblAddID;
    private javax.swing.JLabel lblAddName;
    private javax.swing.JLabel lblAddTourCode;
    private javax.swing.JLabel lblDelSaerch;
    private javax.swing.JLabel lblEditID;
    private javax.swing.JLabel lblEditName;
    private javax.swing.JLabel lblEditTourCode;
    private javax.swing.JLabel lblViewSaerch;
    private javax.swing.JScrollPane scrollPaneDel;
    private javax.swing.JScrollPane scrollPaneView;
    private javax.swing.JTabbedPane tabPanePassenger;
    private javax.swing.JPanel tabPassengerAdd;
    private javax.swing.JPanel tabPassengerDelete;
    private javax.swing.JPanel tabPassengerEdit;
    private javax.swing.JPanel tabPassengerView;
    private javax.swing.JTable tableDel;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtAddID;
    private javax.swing.JTextField txtAddName;
    private javax.swing.JTextField txtAddTourCode;
    private javax.swing.JTextField txtDelKeyword;
    private javax.swing.JTextField txtEditID;
    private javax.swing.JTextField txtEditName;
    private javax.swing.JTextField txtEditTourCode;
    private javax.swing.JTextField txtViewKeyword;
    // End of variables declaration//GEN-END:variables
}
