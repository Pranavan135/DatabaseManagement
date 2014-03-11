/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.ui;

import db.entity.Bill;
import db.ui.dao.BillDAO;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class BillWindow extends javax.swing.JFrame {

    /**
     * Creates new form BillWindow
     */
    private BillDAO billDAO = new BillDAO();
    private static BillWindow billWindow = null;
    
    public BillWindow() {
        initComponents();
    }
    
    public static BillWindow create()  {
        if (billWindow == null) {
             billWindow = new BillWindow();
        }
            return billWindow;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        billsTab = new javax.swing.JTabbedPane();
        addBillsTab = new javax.swing.JPanel();
        tourCodeLabel = new javax.swing.JLabel();
        referenceNoLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        townIDTextField = new javax.swing.JTextField();
        numberOfIndvidualsTextField = new javax.swing.JTextField();
        amountTextField = new javax.swing.JTextField();
        hotelIDLabel = new javax.swing.JLabel();
        billDateLabel = new javax.swing.JLabel();
        numberOfIndvidualsLabel = new javax.swing.JLabel();
        tourCodeTextField = new javax.swing.JTextField();
        hotelIDtextField = new javax.swing.JTextField();
        townIDLabel = new javax.swing.JLabel();
        billDateTextField = new javax.swing.JTextField();
        referenceNoTextField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        editBillsTab = new javax.swing.JPanel();
        editTourCodeLabel = new javax.swing.JLabel();
        editReferenceLabel = new javax.swing.JLabel();
        editAmountLabel = new javax.swing.JLabel();
        editTownIDTextField = new javax.swing.JTextField();
        editNumberOfIndividualsTextField = new javax.swing.JTextField();
        editAmountTextField = new javax.swing.JTextField();
        editHotelIDLabel = new javax.swing.JLabel();
        editBillDateLabel = new javax.swing.JLabel();
        editNumberofIndividualsLabel = new javax.swing.JLabel();
        editTourCodeTextField = new javax.swing.JTextField();
        editHotelIDTextField = new javax.swing.JTextField();
        editTownIDLabel = new javax.swing.JLabel();
        editBillDateTextField = new javax.swing.JTextField();
        editReferenceNoTextField = new javax.swing.JTextField();
        editExitButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        editClearButton = new javax.swing.JButton();
        editEditButton1 = new javax.swing.JButton();
        deleteBillsTab = new javax.swing.JPanel();
        deleteReferenceLabel = new javax.swing.JLabel();
        deleteReferenceTextField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        viewBillsTab = new javax.swing.JPanel();
        viewReferenceLabel = new javax.swing.JLabel();
        viewReferenceTextField = new javax.swing.JTextField();
        viewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addBillsTab.setLayout(null);

        tourCodeLabel.setText("Tour Code");
        addBillsTab.add(tourCodeLabel);
        tourCodeLabel.setBounds(360, 30, 101, 30);

        referenceNoLabel.setText("Reference No");
        addBillsTab.add(referenceNoLabel);
        referenceNoLabel.setBounds(30, 30, 101, 25);

        amountLabel.setText("Amount");
        addBillsTab.add(amountLabel);
        amountLabel.setBounds(30, 180, 101, 38);
        addBillsTab.add(townIDTextField);
        townIDTextField.setBounds(190, 80, 124, 28);
        addBillsTab.add(numberOfIndvidualsTextField);
        numberOfIndvidualsTextField.setBounds(490, 130, 124, 33);
        addBillsTab.add(amountTextField);
        amountTextField.setBounds(190, 180, 124, 33);

        hotelIDLabel.setText("Hotel ID");
        addBillsTab.add(hotelIDLabel);
        hotelIDLabel.setBounds(360, 80, 101, 30);

        billDateLabel.setText("Bill date");
        addBillsTab.add(billDateLabel);
        billDateLabel.setBounds(30, 130, 101, 30);

        numberOfIndvidualsLabel.setText("Number of Individuals");
        addBillsTab.add(numberOfIndvidualsLabel);
        numberOfIndvidualsLabel.setBounds(360, 140, 110, 14);
        addBillsTab.add(tourCodeTextField);
        tourCodeTextField.setBounds(490, 30, 124, 28);
        addBillsTab.add(hotelIDtextField);
        hotelIDtextField.setBounds(490, 80, 124, 28);

        townIDLabel.setText("Town ID");
        addBillsTab.add(townIDLabel);
        townIDLabel.setBounds(30, 80, 101, 25);
        addBillsTab.add(billDateTextField);
        billDateTextField.setBounds(190, 130, 124, 28);
        addBillsTab.add(referenceNoTextField);
        referenceNoTextField.setBounds(190, 30, 124, 28);

        exitButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        addBillsTab.add(exitButton);
        exitButton.setBounds(440, 260, 160, 70);

        addButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addBillsTab.add(addButton);
        addButton.setBounds(40, 260, 160, 70);

        clearButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        addBillsTab.add(clearButton);
        clearButton.setBounds(240, 260, 160, 70);

        billsTab.addTab("ADD", addBillsTab);

        editBillsTab.setLayout(null);

        editTourCodeLabel.setText("Tour Code");
        editBillsTab.add(editTourCodeLabel);
        editTourCodeLabel.setBounds(360, 80, 101, 30);

        editReferenceLabel.setText("Reference No");
        editBillsTab.add(editReferenceLabel);
        editReferenceLabel.setBounds(30, 30, 101, 25);

        editAmountLabel.setText("Amount");
        editBillsTab.add(editAmountLabel);
        editAmountLabel.setBounds(30, 180, 101, 38);
        editBillsTab.add(editTownIDTextField);
        editTownIDTextField.setBounds(190, 80, 124, 28);
        editBillsTab.add(editNumberOfIndividualsTextField);
        editNumberOfIndividualsTextField.setBounds(500, 180, 124, 33);
        editBillsTab.add(editAmountTextField);
        editAmountTextField.setBounds(190, 180, 124, 33);

        editHotelIDLabel.setText("Hotel ID");
        editBillsTab.add(editHotelIDLabel);
        editHotelIDLabel.setBounds(360, 130, 101, 30);

        editBillDateLabel.setText("Bill date");
        editBillsTab.add(editBillDateLabel);
        editBillDateLabel.setBounds(30, 130, 101, 30);

        editNumberofIndividualsLabel.setText("Number of Individuals");
        editBillsTab.add(editNumberofIndividualsLabel);
        editNumberofIndividualsLabel.setBounds(360, 190, 110, 14);
        editBillsTab.add(editTourCodeTextField);
        editTourCodeTextField.setBounds(500, 80, 124, 30);
        editBillsTab.add(editHotelIDTextField);
        editHotelIDTextField.setBounds(500, 130, 124, 28);

        editTownIDLabel.setText("Town ID");
        editBillsTab.add(editTownIDLabel);
        editTownIDLabel.setBounds(30, 80, 101, 25);
        editBillsTab.add(editBillDateTextField);
        editBillDateTextField.setBounds(190, 130, 124, 28);
        editBillsTab.add(editReferenceNoTextField);
        editReferenceNoTextField.setBounds(190, 30, 124, 28);

        editExitButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editExitButton.setText("EXIT");
        editExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editExitButtonActionPerformed(evt);
            }
        });
        editBillsTab.add(editExitButton);
        editExitButton.setBounds(440, 260, 160, 70);

        showButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        showButton.setText("SHOW");
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });
        editBillsTab.add(showButton);
        showButton.setBounds(360, 30, 140, 30);

        editClearButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editClearButton.setText("CLEAR");
        editClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClearButtonActionPerformed(evt);
            }
        });
        editBillsTab.add(editClearButton);
        editClearButton.setBounds(240, 260, 160, 70);

        editEditButton1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editEditButton1.setText("EDIT");
        editEditButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEditButton1ActionPerformed(evt);
            }
        });
        editBillsTab.add(editEditButton1);
        editEditButton1.setBounds(40, 260, 160, 70);

        billsTab.addTab("EDIT", editBillsTab);

        deleteReferenceLabel.setText("Reference No");

        deleteButton.setText("Delete");

        javax.swing.GroupLayout deleteBillsTabLayout = new javax.swing.GroupLayout(deleteBillsTab);
        deleteBillsTab.setLayout(deleteBillsTabLayout);
        deleteBillsTabLayout.setHorizontalGroup(
            deleteBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBillsTabLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(deleteReferenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(deleteReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(deleteButton)
                .addGap(59, 59, 59))
        );
        deleteBillsTabLayout.setVerticalGroup(
            deleteBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBillsTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(deleteBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteReferenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton))
                .addContainerGap(381, Short.MAX_VALUE))
        );

        billsTab.addTab("DELETE", deleteBillsTab);

        viewReferenceLabel.setText("Reference No");

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(viewTable);

        javax.swing.GroupLayout viewBillsTabLayout = new javax.swing.GroupLayout(viewBillsTab);
        viewBillsTab.setLayout(viewBillsTabLayout);
        viewBillsTabLayout.setHorizontalGroup(
            viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBillsTabLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewBillsTabLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(viewBillsTabLayout.createSequentialGroup()
                        .addComponent(viewReferenceLabel)
                        .addGap(101, 101, 101)
                        .addComponent(viewReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(viewButton)
                        .addGap(61, 61, 61))))
        );
        viewBillsTabLayout.setVerticalGroup(
            viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBillsTabLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewReferenceLabel)
                    .addComponent(viewReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        billsTab.addTab("VIEW", viewBillsTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(billsTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(billsTab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void validateAddData()  {
        Bill bill = new Bill();
        billDAO.addBill(bill);
    }
    
    private void viewBills() {
        String referenceNo = viewReferenceTextField.getText();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        
        tableHeaders.add("Reference No");
        tableHeaders.add("Tour Code");
        tableHeaders.add("Town Name");
        tableHeaders.add("Hotel Name");
        tableHeaders.add("Bill date");
        tableHeaders.add("Number of People");
        tableHeaders.add("Amount");
        
        List resultList = billDAO.searchOnReferenceNo(referenceNo);
        
        if (resultList != null)     {
            for (Object o : resultList) {
                Bill bill = (Bill) o;
                
                Vector<Object> oneRow = new Vector<Object>();
                oneRow.add(bill.getRefNo());
                oneRow.add(bill.getTour().getTourCode());
                oneRow.add(bill.getTown().getName());
                oneRow.add(bill.getHotel().getName());
                oneRow.add(bill.getBillDate());
                oneRow.add(bill.getAmount());
                tableData.add(oneRow);
            }
        viewTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        }
        else {
            
        }
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        validateAddData();
    }//GEN-LAST:event_addButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        viewBills();
    }//GEN-LAST:event_viewButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        referenceNoTextField.setText("");
        townIDTextField.setText("");
        tourCodeTextField.setText("");
        numberOfIndvidualsTextField.setText("");
        amountTextField.setText("");
        billDateTextField.setText("");
        hotelIDtextField.setText("");
        
    }//GEN-LAST:event_clearButtonActionPerformed

    private void editExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editExitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_editExitButtonActionPerformed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showButtonActionPerformed

    private void editClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClearButtonActionPerformed
        referenceNoTextField.setText("");
        townIDTextField.setText("");
        tourCodeTextField.setText("");
        numberOfIndvidualsTextField.setText("");
        amountTextField.setText("");
        billDateTextField.setText("");
        hotelIDtextField.setText("");
    }//GEN-LAST:event_editClearButtonActionPerformed

    private void editEditButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEditButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEditButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addBillsTab;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel billDateLabel;
    private javax.swing.JTextField billDateTextField;
    private javax.swing.JTabbedPane billsTab;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel deleteBillsTab;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteReferenceLabel;
    private javax.swing.JTextField deleteReferenceTextField;
    private javax.swing.JLabel editAmountLabel;
    private javax.swing.JTextField editAmountTextField;
    private javax.swing.JLabel editBillDateLabel;
    private javax.swing.JTextField editBillDateTextField;
    private javax.swing.JPanel editBillsTab;
    private javax.swing.JButton editClearButton;
    private javax.swing.JButton editEditButton1;
    private javax.swing.JButton editExitButton;
    private javax.swing.JLabel editHotelIDLabel;
    private javax.swing.JTextField editHotelIDTextField;
    private javax.swing.JTextField editNumberOfIndividualsTextField;
    private javax.swing.JLabel editNumberofIndividualsLabel;
    private javax.swing.JLabel editReferenceLabel;
    private javax.swing.JTextField editReferenceNoTextField;
    private javax.swing.JLabel editTourCodeLabel;
    private javax.swing.JTextField editTourCodeTextField;
    private javax.swing.JLabel editTownIDLabel;
    private javax.swing.JTextField editTownIDTextField;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hotelIDLabel;
    private javax.swing.JTextField hotelIDtextField;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numberOfIndvidualsLabel;
    private javax.swing.JTextField numberOfIndvidualsTextField;
    private javax.swing.JLabel referenceNoLabel;
    private javax.swing.JTextField referenceNoTextField;
    private javax.swing.JButton showButton;
    private javax.swing.JLabel tourCodeLabel;
    private javax.swing.JTextField tourCodeTextField;
    private javax.swing.JLabel townIDLabel;
    private javax.swing.JTextField townIDTextField;
    private javax.swing.JPanel viewBillsTab;
    private javax.swing.JButton viewButton;
    private javax.swing.JLabel viewReferenceLabel;
    private javax.swing.JTextField viewReferenceTextField;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
