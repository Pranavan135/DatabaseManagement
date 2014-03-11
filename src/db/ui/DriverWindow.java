/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui;

import db.entity.Bill;
import db.entity.Driver;
import db.entity.DriverId;
import db.ui.dao.DriverDAO;
import db.util.HibernateUtil;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Pranavan
 */
public class DriverWindow extends javax.swing.JFrame {

    /**
     * Creates new form DriverUI
     */
    public DriverWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        driverTab = new javax.swing.JTabbedPane();
        addDriverTab = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        telephoneNoLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        telephoneNoTextField = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        editDriverTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTextFieldEdit = new javax.swing.JTextField();
        goEdit = new javax.swing.JButton();
        exitEditButton = new javax.swing.JButton();
        deleteDriverTab = new javax.swing.JPanel();
        viewDriverTab = new javax.swing.JPanel();
        idViewLabel = new javax.swing.JLabel();
        idViewTextField = new javax.swing.JTextField();
        viewGoButtonField = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 354));

        addDriverTab.setLayout(new java.awt.GridBagLayout());

        idLabel.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 20, 0, 0);
        addDriverTab.add(idLabel, gridBagConstraints);

        nameLabel.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        addDriverTab.add(nameLabel, gridBagConstraints);

        addressLabel.setText("Address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 20, 0, 0);
        addDriverTab.add(addressLabel, gridBagConstraints);

        telephoneNoLabel.setText("Telephone No");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 20, 0, 0);
        addDriverTab.add(telephoneNoLabel, gridBagConstraints);

        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 46, 0, 0);
        addDriverTab.add(idTextField, gridBagConstraints);

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 46, 0, 0);
        addDriverTab.add(nameTextField, gridBagConstraints);

        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 46, 0, 0);
        addDriverTab.add(addressTextField, gridBagConstraints);

        telephoneNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneNoTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 46, 0, 0);
        addDriverTab.add(telephoneNoTextField, gridBagConstraints);

        clear.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 20, 29, 0);
        addDriverTab.add(clear, gridBagConstraints);

        save.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 46, 29, 0);
        addDriverTab.add(save, gridBagConstraints);

        exit.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 39, 29, 167);
        addDriverTab.add(exit, gridBagConstraints);

        driverTab.addTab("ADD", addDriverTab);

        jLabel1.setText("ID");

        idTextFieldEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldEditActionPerformed(evt);
            }
        });

        goEdit.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        goEdit.setText("Go");
        goEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goEditActionPerformed(evt);
            }
        });

        exitEditButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        exitEditButton.setText("EXIT");
        exitEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitEditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editDriverTabLayout = new javax.swing.GroupLayout(editDriverTab);
        editDriverTab.setLayout(editDriverTabLayout);
        editDriverTabLayout.setHorizontalGroup(
            editDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDriverTabLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(idTextFieldEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(goEdit)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editDriverTabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        editDriverTabLayout.setVerticalGroup(
            editDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editDriverTabLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(editDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextFieldEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        driverTab.addTab("EDIT", editDriverTab);

        javax.swing.GroupLayout deleteDriverTabLayout = new javax.swing.GroupLayout(deleteDriverTab);
        deleteDriverTab.setLayout(deleteDriverTabLayout);
        deleteDriverTabLayout.setHorizontalGroup(
            deleteDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        deleteDriverTabLayout.setVerticalGroup(
            deleteDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        driverTab.addTab("DELETE", deleteDriverTab);

        idViewLabel.setText("Enter Driver ID");

        viewGoButtonField.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        viewGoButtonField.setText("GO");
        viewGoButtonField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGoButtonFieldActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Tele No"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        javax.swing.GroupLayout viewDriverTabLayout = new javax.swing.GroupLayout(viewDriverTab);
        viewDriverTab.setLayout(viewDriverTabLayout);
        viewDriverTabLayout.setHorizontalGroup(
            viewDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDriverTabLayout.createSequentialGroup()
                .addGroup(viewDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDriverTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(idViewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(viewGoButtonField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewDriverTabLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        viewDriverTabLayout.setVerticalGroup(
            viewDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDriverTabLayout.createSequentialGroup()
                .addGroup(viewDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDriverTabLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(viewDriverTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idViewLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewDriverTabLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(viewGoButtonField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        driverTab.addTab("VIEW", viewDriverTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(driverTab))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(driverTab, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed

    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void telephoneNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneNoTextFieldActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        idTextField.setText("");
        nameTextField.setText("");
        addressTextField.setText("");
        telephoneNoTextField.setText("");
    }//GEN-LAST:event_clearActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void idTextFieldEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldEditActionPerformed

    private void goEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goEditActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_goEditActionPerformed

    private void viewGoButtonFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGoButtonFieldActionPerformed
        // TODO add your handling code here:
        if (!viewGoButtonField.getText().trim().equals("")) {
            System.out.println("Pranavan You are here");
            runQueryBasedOnID();
        } else {
            JOptionPane.showMessageDialog(null, "Searching Drivers", QUERY_BASED_ON_Name, JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_viewGoButtonFieldActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        DriverDAO.addData(Integer.parseInt(idTextField.getText().trim()),nameTextField.getText().trim(),addressTextField.getText().trim(),telephoneNoTextField.getText().trim());
    }//GEN-LAST:event_saveActionPerformed

    private void exitEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitEditButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitEditButtonActionPerformed

private static String QUERY_BASED_ON_Name = "from drivers a where a.name like '";

    private void runQueryBasedOnID() {
        executeHQLQuery(QUERY_BASED_ON_Name + idViewTextField.getText().trim() + "%'");
    }

    private void executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            java.util.List resultList = q.list();
            displayResult(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }


    private void displayResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Id");
        tableHeaders.add("Name");
        tableHeaders.add("Address");
        tableHeaders.add("TelephoneNumber");

        for (Object o : resultList) {
            Driver driver = (Driver) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(driver.getId().getId());
            oneRow.add(driver.getId().getName());
            oneRow.add(driver.getAddress());
            oneRow.add(driver.getTpNo());
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addDriverTab;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton clear;
    private javax.swing.JPanel deleteDriverTab;
    private javax.swing.JTabbedPane driverTab;
    private javax.swing.JPanel editDriverTab;
    private javax.swing.JButton exit;
    private javax.swing.JButton exitEditButton;
    private javax.swing.JButton goEdit;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField idTextFieldEdit;
    private javax.swing.JLabel idViewLabel;
    private javax.swing.JTextField idViewTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton save;
    private javax.swing.JLabel telephoneNoLabel;
    private javax.swing.JTextField telephoneNoTextField;
    private javax.swing.JPanel viewDriverTab;
    private javax.swing.JButton viewGoButtonField;
    // End of variables declaration//GEN-END:variables
}
