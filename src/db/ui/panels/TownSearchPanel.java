/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui.panels;

import db.dao.TownDAO;
import db.entity.Town;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gobinath
 */
public class TownSearchPanel extends javax.swing.JPanel {

    private TownDAO townDAO;
    private static TownSearchPanel instance;

    /**
     * Creates new form TownSearchPanel
     */
    private TownSearchPanel() {
        initComponents();
        townDAO = new TownDAO();
    }

    public static TownSearchPanel getInstance() {
        if (instance == null) {
            instance = new TownSearchPanel();
        }
        return instance;
    }

    private void createViewTable(List<Town> towns) {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            for (int i = 0; i < towns.size(); i++) {
                Object[] row = new Object[]{towns.get(i).getId(),
                    towns.get(i).getName(), towns.get(i).getOverNightStop(), towns.get(i).getBills().size(), towns.get(i).getRouteTowns().size(), towns.get(i).getHotels().size()};
                data.add(row);
            }
            Object[][] passengerData = data.toArray(new Object[0][]);
            tableView.setModel(new javax.swing.table.DefaultTableModel(
                    passengerData,
                    new String[]{
                        "ID", "Name", "Overnight Stop", "No Of Bills", "No Of Route Towns", "No Of Hotels"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
            tableView.setAutoscrolls(true);
            tableView.setFillsViewportHeight(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelScroll = new javax.swing.JScrollPane();
        panelMain = new javax.swing.JPanel();
        panelDetails = new javax.swing.JPanel();
        lblTownID = new javax.swing.JLabel();
        lblTownName = new javax.swing.JLabel();
        txtTownId = new javax.swing.JTextField();
        txtTownName = new javax.swing.JTextField();
        panelBills = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        panelControlls = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        panelDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        panelDetails.setName(""); // NOI18N

        lblTownID.setText("Town ID");

        lblTownName.setText("Town Name");

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addComponent(lblTownID)
                        .addGap(73, 73, 73)
                        .addComponent(txtTownId))
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addComponent(lblTownName)
                        .addGap(57, 57, 57)
                        .addComponent(txtTownName, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTownID)
                    .addComponent(txtTownId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTownName)
                    .addComponent(txtTownName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        panelBills.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));
        panelBills.setName(""); // NOI18N
        panelBills.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Town ID", "Name", "Overnight Stop", "Bills", "Route Towns", "Hotels"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableView);

        panelBills.add(jScrollPane1);

        panelControlls.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelControllsLayout = new javax.swing.GroupLayout(panelControlls);
        panelControlls.setLayout(panelControllsLayout);
        panelControllsLayout.setHorizontalGroup(
            panelControllsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelControllsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap())
        );
        panelControllsLayout.setVerticalGroup(
            panelControllsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelControllsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelControllsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnClear))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelControlls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(panelBills, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(panelControlls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        panelScroll.setViewportView(panelMain);

        add(panelScroll);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tableView.setModel(new javax.swing.table.DefaultTableModel(null, new String[]{"ID", "Name", "Overnight Stop", "No Of Bills", "No Of Route Towns", "No Of Hotels"}));
        txtTownId.setText("");
        txtTownName.setText("");
        txtTownId.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String strID = txtTownId.getText();
        String name = txtTownName.getText().trim();

        Integer id = null;
        if (!strID.equals("")) {
            try {
                id = Integer.valueOf(strID);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Warning", JOptionPane.WARNING_MESSAGE);
                txtTownId.selectAll();
                txtTownId.requestFocus();
                return;
            }
        }
        List<Town> result = townDAO.getTowns(id, name);
        if (result == null) {
            JOptionPane.showMessageDialog(this, "No data found", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            createViewTable(result);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked
        if (evt.getClickCount() == 2) {
            int id = Integer.parseInt(tableView.getValueAt(tableView.getSelectedRow(), 0).toString());
            TownEditPanel panel = TownEditPanel.getInstance();
            panel.refersh(townDAO.getTown(id));
            Container container = this.getParent();
            container.removeAll();
            container.add(panel);
            container.repaint();
            container.validate();
        }
    }//GEN-LAST:event_tableViewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTownID;
    private javax.swing.JLabel lblTownName;
    private javax.swing.JPanel panelBills;
    private javax.swing.JPanel panelControlls;
    private javax.swing.JPanel panelDetails;
    private javax.swing.JPanel panelMain;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField txtTownId;
    private javax.swing.JTextField txtTownName;
    // End of variables declaration//GEN-END:variables
}
