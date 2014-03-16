/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui;

import db.dao.CoachDAO;
import db.entity.Coach;
import db.validate.CoachValidate;
import javax.swing.JOptionPane;

/**
 *
 * @author Pranavan
 */
public class CoachWindow extends javax.swing.JFrame {

    /**
     * Creates new form CoachWindow
     */
    public static Coach coach;

    public CoachWindow() {
        initComponents();
        regNoEditLabel.setVisible(false);
        regNoEdittextField.setVisible(false);
        capacityEditLabel.setVisible(false);
        capacityEdittextField.setVisible(false);
        lastSerDateEditLabel.setVisible(false);
        editDate.setVisible(false);
        lastServiceMileageLabel.setVisible(false);
        lastServiceMileageEditTextField.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        coachTabbedPane = new javax.swing.JTabbedPane();
        addPanel = new javax.swing.JPanel();
        coachRegNoAddLabel = new javax.swing.JLabel();
        coachCapacityAddLabel = new javax.swing.JLabel();
        coachLastServiceDateAddLabel = new javax.swing.JLabel();
        coachLastServiceMileageAddLabel = new javax.swing.JLabel();
        clearAddButton = new javax.swing.JButton();
        saveAddButton = new javax.swing.JButton();
        exitAddButton = new javax.swing.JButton();
        coachRegNoAddTextField = new javax.swing.JTextField();
        coachCapacityAddTextField = new javax.swing.JTextField();
        coachLastServiceMileageAddTextField = new javax.swing.JTextField();
        coachLastServiceDate = new com.toedter.calendar.JDateChooser();
        editPanel = new javax.swing.JPanel();
        editRegNoLabel = new javax.swing.JLabel();
        regNoEditLabel = new javax.swing.JLabel();
        lastSerDateEditLabel = new javax.swing.JLabel();
        capacityEditLabel = new javax.swing.JLabel();
        lastServiceMileageLabel = new javax.swing.JLabel();
        editRegNoTextField = new javax.swing.JTextField();
        regNoEdittextField = new javax.swing.JTextField();
        capacityEdittextField = new javax.swing.JTextField();
        lastServiceMileageEditTextField = new javax.swing.JTextField();
        editExitButton = new javax.swing.JButton();
        editGoButton = new javax.swing.JButton();
        editSaveButton = new javax.swing.JButton();
        editDate = new com.toedter.calendar.JDateChooser();
        deletePanel = new javax.swing.JPanel();
        regNoDeleteLabel = new javax.swing.JLabel();
        regNoDeleteTextField = new javax.swing.JTextField();
        deleteGoButton = new javax.swing.JButton();
        deleteExitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        viewPanel = new javax.swing.JPanel();
        regNoViewLabel = new javax.swing.JLabel();
        regNoViewTextField = new javax.swing.JTextField();
        goViewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        exitViewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        coachRegNoAddLabel.setText("Reg No");

        coachCapacityAddLabel.setText("Capacity");

        coachLastServiceDateAddLabel.setText("Service Date");

        coachLastServiceMileageAddLabel.setText("Service Mileage");

        clearAddButton.setText("Clear");
        clearAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAddButtonActionPerformed(evt);
            }
        });

        saveAddButton.setText("Save");
        saveAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAddButtonActionPerformed(evt);
            }
        });

        exitAddButton.setText("Exit");
        exitAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachLastServiceDateAddLabel)
                    .addComponent(coachLastServiceMileageAddLabel)
                    .addComponent(coachRegNoAddLabel)
                    .addComponent(clearAddButton)
                    .addComponent(coachCapacityAddLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(saveAddButton)
                        .addGap(77, 77, 77)
                        .addComponent(exitAddButton))
                    .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(coachRegNoAddTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(coachLastServiceMileageAddTextField)
                        .addComponent(coachLastServiceDate, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                    .addComponent(coachCapacityAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachRegNoAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachRegNoAddLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachCapacityAddLabel)
                    .addComponent(coachCapacityAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachLastServiceDateAddLabel)
                    .addComponent(coachLastServiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coachLastServiceMileageAddLabel)
                    .addComponent(coachLastServiceMileageAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearAddButton)
                    .addComponent(saveAddButton)
                    .addComponent(exitAddButton))
                .addGap(35, 35, 35))
        );

        coachTabbedPane.addTab("Add", addPanel);

        editRegNoLabel.setText("Enter RegNo to Edit");

        regNoEditLabel.setText("Reg No");

        lastSerDateEditLabel.setText("Last Service Date");

        capacityEditLabel.setText("Capacity");

        lastServiceMileageLabel.setText("Last Service Mileage");

        editExitButton.setText("Exit");
        editExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editExitButtonActionPerformed(evt);
            }
        });

        editGoButton.setText("Go");
        editGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGoButtonActionPerformed(evt);
            }
        });

        editSaveButton.setText("Update");
        editSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editRegNoLabel)
                    .addComponent(lastServiceMileageLabel)
                    .addComponent(lastSerDateEditLabel)
                    .addComponent(capacityEditLabel)
                    .addComponent(regNoEditLabel))
                .addGap(64, 64, 64)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(regNoEdittextField, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                .addComponent(capacityEdittextField)
                                .addComponent(lastServiceMileageEditTextField))
                            .addGroup(editPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(editSaveButton))
                            .addComponent(editRegNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editGoButton)
                            .addComponent(editExitButton))
                        .addGap(79, 79, 79))
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addComponent(editDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editRegNoLabel)
                    .addComponent(editRegNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editGoButton))
                .addGap(32, 32, 32)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoEditLabel)
                    .addComponent(regNoEdittextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(capacityEditLabel)
                    .addComponent(capacityEdittextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastSerDateEditLabel)
                    .addComponent(editDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastServiceMileageLabel)
                    .addComponent(lastServiceMileageEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editExitButton)
                    .addComponent(editSaveButton))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        coachTabbedPane.addTab("Edit", editPanel);

        regNoDeleteLabel.setText("Enter Reg No ");

        deleteGoButton.setText("Go");

        deleteExitButton.setText("Exit");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg No", "Capacity", "Last Service date", "Last Service Mileage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
        deletePanel.setLayout(deletePanelLayout);
        deletePanelLayout.setHorizontalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanelLayout.createSequentialGroup()
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteExitButton)
                    .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(deletePanelLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(regNoDeleteLabel)
                            .addGap(58, 58, 58)
                            .addComponent(regNoDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteGoButton))
                        .addGroup(deletePanelLayout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        deletePanelLayout.setVerticalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNoDeleteLabel)
                    .addComponent(deleteGoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteExitButton)
                .addGap(32, 32, 32))
        );

        coachTabbedPane.addTab("Delete", deletePanel);

        regNoViewLabel.setText("Enter Reg No");

        goViewButton.setText("GO");

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Reg No", "Capcity", "ServiceDate", "ServiceMileage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(viewTable);

        exitViewButton.setText("Exit");

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(exitViewButton)
                    .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewPanelLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(regNoViewLabel)
                            .addGap(66, 66, 66)
                            .addComponent(regNoViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(goViewButton))
                        .addGroup(viewPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNoViewLabel)
                    .addComponent(regNoViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goViewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitViewButton)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        coachTabbedPane.addTab("View", viewPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(coachTabbedPane)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(coachTabbedPane)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitAddButtonActionPerformed
        this.dispose();

    }//GEN-LAST:event_exitAddButtonActionPerformed

    private void clearAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAddButtonActionPerformed
        coachRegNoAddTextField.setText("");
        coachCapacityAddTextField.setText("");
        coachLastServiceDate.setDate(null);
        coachLastServiceMileageAddTextField.setText("");
    }//GEN-LAST:event_clearAddButtonActionPerformed

    private void saveAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAddButtonActionPerformed
        if (CoachValidate.regNoValidate(coachRegNoAddTextField.getText().trim())) {
            if (CoachValidate.capacityValidate(coachCapacityAddTextField.getText().trim())) {
                if (CoachValidate.dateValidate(coachLastServiceDate.getDate())) {
                    if (CoachValidate.mileageValidate(coachLastServiceMileageAddTextField.getText().trim())) {
                        CoachDAO.addCoach(Integer.parseInt(coachRegNoAddTextField.getText().trim()), Integer.parseInt(coachCapacityAddTextField.getText().trim()), coachLastServiceDate.getDate(), Double.parseDouble(coachLastServiceMileageAddTextField.getText().trim()));
                        //JOptionPane.showMessageDialog(this,"Record Added","Details", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

        }
    }//GEN-LAST:event_saveAddButtonActionPerformed

    private void editGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGoButtonActionPerformed

        Integer regNo = 0;
        try {
            regNo = Integer.parseInt(editRegNoTextField.getText().trim());
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }

        if (CoachDAO.isExistCoach(regNo)) {
            regNoEditLabel.setVisible(true);
            regNoEdittextField.setVisible(true);
            regNoEdittextField.setText(regNo.toString());
            regNoEdittextField.setEditable(false);
            regNoEdittextField.setEnabled(false);
            coach = CoachDAO.getCoach(regNo);
            capacityEditLabel.setVisible(true);
            capacityEdittextField.setVisible(true);
            capacityEdittextField.setText(String.valueOf(coach.getCapacity()));
            lastSerDateEditLabel.setVisible(true);
            editDate.setVisible(true);
            editDate.setDate(coach.getLastServiceDate());
            lastServiceMileageLabel.setVisible(true);
            lastServiceMileageEditTextField.setVisible(true);
            lastServiceMileageEditTextField.setText(String.valueOf(coach.getLastServiceMileage()));
            // DriverDAO.updateData(id, nameEditTextField.getText().trim(), addressEditTextField.getText().trim(), teleNoEditTextField.getText().trim());
            //JOptionPane.showMessageDialog(null, "Record updated", null, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "There is no coach with given id", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editGoButtonActionPerformed

    private void editSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSaveButtonActionPerformed
        // TODO add your handling code here:
        if (CoachValidate.capacityValidate(capacityEdittextField.getText().trim())) {

            if (CoachValidate.dateValidate(editDate.getDate())) {

                if (CoachValidate.mileageValidate(lastServiceMileageEditTextField.getText().trim())) {
                    if (!(coach.getCapacity() == Integer.parseInt(capacityEdittextField.getText().trim())) || !(coach.getLastServiceDate().equals(editDate.getDate()))) {

                        CoachDAO.updateData(Integer.parseInt(regNoEdittextField.getText().trim()), Integer.parseInt(capacityEdittextField.getText().trim()), editDate.getDate(), Double.parseDouble(lastServiceMileageEditTextField.getText().trim()));
                        coach = null;

                        regNoEditLabel.setVisible(false);
                        regNoEdittextField.setVisible(false);
                        capacityEditLabel.setVisible(false);
                        capacityEdittextField.setVisible(false);
                        lastSerDateEditLabel.setVisible(false);
                        editDate.setVisible(false);
                        lastServiceMileageLabel.setVisible(false);
                        lastServiceMileageEditTextField.setVisible(false);
                        editRegNoTextField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nothing has updated", "Details", JOptionPane.INFORMATION_MESSAGE);
                        regNoEditLabel.setVisible(false);
                        regNoEdittextField.setVisible(false);
                        capacityEditLabel.setVisible(false);
                        capacityEdittextField.setVisible(false);
                        lastSerDateEditLabel.setVisible(false);
                        editDate.setVisible(false);
                        lastServiceMileageLabel.setVisible(false);
                        lastServiceMileageEditTextField.setVisible(false);
                        editRegNoTextField.setText("");
                    }

                } else {
                    lastServiceMileageEditTextField.setText(String.valueOf(coach.getLastServiceMileage()));
                    lastServiceMileageEditTextField.requestFocus();
                }

            } else {
                editDate.setDate(coach.getLastServiceDate());
                editDate.requestFocus();
            }

        } else {
            
            capacityEdittextField.setText(String.valueOf(coach.getCapacity()));
            capacityEdittextField.requestFocus();
        }
    }//GEN-LAST:event_editSaveButtonActionPerformed

    private void editExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editExitButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_editExitButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPanel;
    private javax.swing.JLabel capacityEditLabel;
    private javax.swing.JTextField capacityEdittextField;
    private javax.swing.JButton clearAddButton;
    private javax.swing.JLabel coachCapacityAddLabel;
    private javax.swing.JTextField coachCapacityAddTextField;
    private com.toedter.calendar.JDateChooser coachLastServiceDate;
    private javax.swing.JLabel coachLastServiceDateAddLabel;
    private javax.swing.JLabel coachLastServiceMileageAddLabel;
    private javax.swing.JTextField coachLastServiceMileageAddTextField;
    private javax.swing.JLabel coachRegNoAddLabel;
    private javax.swing.JTextField coachRegNoAddTextField;
    private javax.swing.JTabbedPane coachTabbedPane;
    private javax.swing.JButton deleteExitButton;
    private javax.swing.JButton deleteGoButton;
    private javax.swing.JPanel deletePanel;
    private com.toedter.calendar.JDateChooser editDate;
    private javax.swing.JButton editExitButton;
    private javax.swing.JButton editGoButton;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel editRegNoLabel;
    private javax.swing.JTextField editRegNoTextField;
    private javax.swing.JButton editSaveButton;
    private javax.swing.JButton exitAddButton;
    private javax.swing.JButton exitViewButton;
    private javax.swing.JButton goViewButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lastSerDateEditLabel;
    private javax.swing.JTextField lastServiceMileageEditTextField;
    private javax.swing.JLabel lastServiceMileageLabel;
    private javax.swing.JLabel regNoDeleteLabel;
    private javax.swing.JTextField regNoDeleteTextField;
    private javax.swing.JLabel regNoEditLabel;
    private javax.swing.JTextField regNoEdittextField;
    private javax.swing.JLabel regNoViewLabel;
    private javax.swing.JTextField regNoViewTextField;
    private javax.swing.JButton saveAddButton;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
