package db.ui.panels;

import db.dao.TownDAO;
import db.entity.Bill;
import db.entity.Hotel;
import db.entity.Route;
import db.entity.RouteTown;
import db.entity.Town;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gobinath
 */
public class TownEditPanel extends javax.swing.JPanel {

    private Town town;
    private TownDAO townDAO;
    private static TownEditPanel instance;

    /**
     * Creates new form TownEditPanel
     */
    private TownEditPanel() {
        initComponents();
        townDAO = new TownDAO();
    }

    public static TownEditPanel getInstance() {
        if (instance == null) {
            instance = new TownEditPanel();
        }
        return instance;
    }

    public void refresh(Town town) {
        DefaultTableModel modelBills = (DefaultTableModel) tblBillRight.getModel();
        DefaultTableModel modelRoutes = (DefaultTableModel) tblRouteRight.getModel();
        DefaultTableModel modelHotels = (DefaultTableModel) tblHotelRight.getModel();

        while (modelBills.getRowCount() != 0) {
            modelBills.removeRow(0);
        }
        while (modelRoutes.getRowCount() != 0) {
            modelRoutes.removeRow(0);
        }
        while (modelHotels.getRowCount() != 0) {
            modelHotels.removeRow(0);
        }
        this.town = town;
        if (town == null) {
            btnDelete.setVisible(false);
            txtTownID.setText("");
            txtTownName.setText("");
            chkAllowed.setSelected(false);
            txtTownID.setEnabled(true);
        } else {
            btnDelete.setVisible(true);
            txtTownID.setText("" + town.getId());
            txtTownName.setText(town.getName());
            chkAllowed.setSelected(town.getOverNightStop());
            txtTownID.setEnabled(false);
            for (Object obj : town.getBills()) {
                Bill bill = (Bill) obj;
                modelBills.addRow(new Object[]{bill.getRefNo(), bill.getBillDate()});
            }

            for (Object obj : town.getRouteTowns()) {
                Route route = ((RouteTown) obj).getRoute();
                modelRoutes.addRow(new Object[]{route.getId(), route.getName()});
            }

            for (Object obj : town.getHotels()) {
                Hotel hotel = (Hotel) obj;
                modelHotels.addRow(new Object[]{hotel.getId(), hotel.getName()});
            }

        }
    }

    private void viewRoutes(List<Route> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                Object[] row = new Object[]{list.get(i).getId(),
                    list.get(i).getName()};
                data.add(row);
            }
            Object[][] passengerData = data.toArray(new Object[0][]);
            tblRouteRight.setModel(new javax.swing.table.DefaultTableModel(
                    passengerData,
                    new String[]{
                        "ID", "Name"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
        }
    }

    private void viewBills(List<Bill> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                Object[] row = new Object[]{list.get(i).getRefNo(),
                    list.get(i).getBillDate()};
                data.add(row);
            }
            Object[][] passengerData = data.toArray(new Object[0][]);
            tblBillRight.setModel(new javax.swing.table.DefaultTableModel(
                    passengerData,
                    new String[]{
                        "Reference No", "Date"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
        }
    }

    private void viewHotels(List<Hotel> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                Object[] row = new Object[]{list.get(i).getId(),
                    list.get(i).getName()};
                data.add(row);
            }
            Object[][] passengerData = data.toArray(new Object[0][]);
            tblHotelRight.setModel(new javax.swing.table.DefaultTableModel(
                    passengerData,
                    new String[]{
                        "ID", "Name"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
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
        lblOvernightStop = new javax.swing.JLabel();
        txtTownName = new javax.swing.JTextField();
        chkAllowed = new javax.swing.JCheckBox();
        txtTownID = new javax.swing.JFormattedTextField();
        panelBills = new javax.swing.JPanel();
        scrollBillRight = new javax.swing.JScrollPane();
        tblBillRight = new javax.swing.JTable();
        panelRouteTowns = new javax.swing.JPanel();
        scrollRouteRight = new javax.swing.JScrollPane();
        tblRouteRight = new javax.swing.JTable();
        panelHotels = new javax.swing.JPanel();
        scrollHotelRight = new javax.swing.JScrollPane();
        tblHotelRight = new javax.swing.JTable();
        panelControlls = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        panelDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        panelDetails.setName(""); // NOI18N

        lblTownID.setText("Town ID");

        lblTownName.setText("Town Name");

        lblOvernightStop.setText("Overnight Stop");

        chkAllowed.setText("Allowed");

        txtTownID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTownName)
                    .addComponent(lblOvernightStop)
                    .addComponent(lblTownID))
                .addGap(40, 40, 40)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTownName, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addComponent(chkAllowed, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtTownID))
                .addContainerGap())
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetailsLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTownID)
                    .addComponent(txtTownID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTownName)
                    .addComponent(txtTownName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOvernightStop)
                    .addComponent(chkAllowed)))
        );

        panelBills.setBorder(javax.swing.BorderFactory.createTitledBorder("Bills"));
        panelBills.setName(""); // NOI18N
        panelBills.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        scrollBillRight.setPreferredSize(new java.awt.Dimension(50, 100));

        tblBillRight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reference No", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollBillRight.setViewportView(tblBillRight);

        panelBills.add(scrollBillRight);

        panelRouteTowns.setBorder(javax.swing.BorderFactory.createTitledBorder("Routes"));
        panelRouteTowns.setName(""); // NOI18N
        panelRouteTowns.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        scrollRouteRight.setPreferredSize(new java.awt.Dimension(50, 100));

        tblRouteRight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRouteRight.setViewportView(tblRouteRight);

        panelRouteTowns.add(scrollRouteRight);

        panelHotels.setBorder(javax.swing.BorderFactory.createTitledBorder("Hotels"));
        panelHotels.setName(""); // NOI18N
        panelHotels.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        scrollHotelRight.setPreferredSize(new java.awt.Dimension(50, 100));

        tblHotelRight.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollHotelRight.setViewportView(tblHotelRight);

        panelHotels.add(scrollHotelRight);

        panelControlls.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelControllsLayout = new javax.swing.GroupLayout(panelControlls);
        panelControlls.setLayout(panelControllsLayout);
        panelControllsLayout.setHorizontalGroup(
            panelControllsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelControllsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addContainerGap())
        );
        panelControllsLayout.setVerticalGroup(
            panelControllsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelControllsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelControllsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
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
                    .addComponent(panelRouteTowns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelHotels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelControlls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBills, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRouteTowns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHotels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelControlls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        panelScroll.setViewportView(panelMain);

        add(panelScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int id;
        try {
            id = Integer.parseInt(txtTownID.getText());
            if (this.town == null && townDAO.getTown(id) != null) {
                JOptionPane.showMessageDialog(this, "Entered town id already exists\nPlease enter another id.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid id.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String name = txtTownName.getText();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Are you sure to save the record?", "Tour Management", JOptionPane.YES_NO_OPTION);
        if (result != JOptionPane.YES_OPTION) {
            return;
        }
        DefaultTableModel dtmBill = (DefaultTableModel) tblBillRight.getModel();
        Set<Bill> bills = new HashSet<>();
        for (Object v : dtmBill.getDataVector()) {
            bills.add(townDAO.getBill(((Vector) v).get(0).toString()));
        }

        DefaultTableModel dtmHotel = (DefaultTableModel) tblHotelRight.getModel();
        Set<Hotel> hotels = new HashSet<>();
        for (Object v : dtmHotel.getDataVector()) {
            hotels.add(townDAO.getHotel(((Vector) v).get(0).toString()));
        }
        Town town = new Town(id, name, chkAllowed.isSelected(), bills, null, hotels);

        DefaultTableModel dtmRoutes = (DefaultTableModel) tblRouteRight.getModel();
        Set<Route> routes = new HashSet<>();
        for (Object v : dtmRoutes.getDataVector()) {
            Route route = townDAO.getRoute(((Vector) v).get(0).toString());
            RouteTown routeTown = new RouteTown();
            routeTown.setTown(town);
            routeTown.setRoute(route);
            routes.add(route);
        }
        town.setRouteTowns(routes);

        if (this.town == null) {
            if (townDAO.addTown(town)) {
                JOptionPane.showMessageDialog(this, "Record is saved successfully.", "Tour Management", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the record.", "Tour Management", JOptionPane.ERROR_MESSAGE);
            }
            refresh(town);
        } else {
            if (townDAO.updateTown(town)) {
                JOptionPane.showMessageDialog(this, "Record is updated successfully.", "Tour Management", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update the record.", "Tour Management", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure to delete the record?", "Tour Management", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (townDAO.deleteTown(town)) {
                JOptionPane.showMessageDialog(this, "Record is saved successfully.", "Tour Management", JOptionPane.INFORMATION_MESSAGE);
                refresh(null);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the record.", "Tour Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        refresh(town);
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkAllowed;
    private javax.swing.JLabel lblOvernightStop;
    private javax.swing.JLabel lblTownID;
    private javax.swing.JLabel lblTownName;
    private javax.swing.JPanel panelBills;
    private javax.swing.JPanel panelControlls;
    private javax.swing.JPanel panelDetails;
    private javax.swing.JPanel panelHotels;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelRouteTowns;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JScrollPane scrollBillRight;
    private javax.swing.JScrollPane scrollHotelRight;
    private javax.swing.JScrollPane scrollRouteRight;
    private javax.swing.JTable tblBillRight;
    private javax.swing.JTable tblHotelRight;
    private javax.swing.JTable tblRouteRight;
    private javax.swing.JFormattedTextField txtTownID;
    private javax.swing.JTextField txtTownName;
    // End of variables declaration//GEN-END:variables
}
