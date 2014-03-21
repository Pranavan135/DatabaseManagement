package db.ui.panels;

import db.dao.PassengerDAO;
import db.dao.TourDAO;
import db.dao.TownDAO;
import db.entity.Bill;
import db.entity.Coach;
import db.entity.Driver;
import db.entity.Passenger;
import db.entity.Route;
import db.entity.Tour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gobinath
 */
public class TourEditPanel extends javax.swing.JPanel {

    private static TourEditPanel instance;
    private Tour tour;
    private final TourDAO tourDAO;
    private final TownDAO townDAO;
    private final PassengerDAO passengerDAO;

    /**
     * Creates new form TownEditPanel
     */
    private TourEditPanel() {
        initComponents();
        tourDAO = new TourDAO();
        townDAO = new TownDAO();
        passengerDAO = new PassengerDAO();
    }

    public static TourEditPanel getInstance() {
        if (instance == null) {
            instance = new TourEditPanel();
        }
        return instance;
    }

    public void refresh(Tour tour) {

        List<Coach> coachs = townDAO.getAllCoaches();
        List<Route> routes = townDAO.getAllRoutes();
        List<Driver> drivers = townDAO.getAllDrivers();

        this.tour = tour;

        DefaultComboBoxModel<Coach> coachModel = new DefaultComboBoxModel<>(coachs.toArray(new Coach[0]));
        comboCoach.setModel(coachModel);

        DefaultComboBoxModel<Route> routeModel = new DefaultComboBoxModel<>(routes.toArray(new Route[0]));
        comboRoute.setModel(routeModel);

        DefaultComboBoxModel<Driver> driverModel = new DefaultComboBoxModel<>(drivers.toArray(new Driver[0]));
        comboDriver.setModel(driverModel);

        DefaultTableModel modelBills = (DefaultTableModel) tblBill.getModel();
        DefaultTableModel modelPassengers = (DefaultTableModel) tblPassenger.getModel();

        while (modelBills.getRowCount() != 0) {
            modelBills.removeRow(0);
        }
        while (modelPassengers.getRowCount() != 0) {
            modelPassengers.removeRow(0);
        }
        if (tour == null) {
            btnDelete.setVisible(false);
            txtTourCode.setEnabled(true);
            txtTourCode.setText("");
            txtExecuted.setText("");
            dateChooser.setDate(null);

        } else {
            btnDelete.setVisible(true);
            txtTourCode.setEnabled(false);
            txtTourCode.setText("" + tour.getTourCode());
            txtExecuted.setText(tour.getExecuted());
            dateChooser.setDate(tour.getStartDate());
            comboCoach.setSelectedItem(tour.getCoach());
            comboDriver.setSelectedItem(tour.getDriver());
            comboRoute.setSelectedItem(tour.getRoute());
            viewBills(new ArrayList<Bill>(tour.getBills()));
            viewPassengers(new ArrayList<Passenger>(tour.getPassengers()));
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
            tblBill.setModel(new javax.swing.table.DefaultTableModel(
                    passengerData,
                    new String[]{
                        "Reference No", "Date"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false
                };

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });
        } catch (Exception e) {
        }
    }

    private void viewPassengers(List<Passenger> list) {
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            for (int i = 0; i < list.size(); i++) {
                Object[] row = new Object[]{list.get(i).getId(),
                    list.get(i).getName()};
                data.add(row);
            }
            Object[][] passengerData = data.toArray(new Object[0][]);
            tblPassenger.setModel(new javax.swing.table.DefaultTableModel(
                    passengerData,
                    new String[]{
                        "ID", "Name"
                    }
            ) {
                boolean[] canEdit = new boolean[]{
                    false, false
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
        txtTourCode = new javax.swing.JTextField();
        lblOvernightStop1 = new javax.swing.JLabel();
        lblOvernightStop2 = new javax.swing.JLabel();
        txtExecuted = new javax.swing.JTextField();
        comboRoute = new javax.swing.JComboBox();
        comboCoach = new javax.swing.JComboBox();
        dateChooser = new com.toedter.calendar.JDateChooser();
        comboDriver = new javax.swing.JComboBox();
        lblOvernightStop3 = new javax.swing.JLabel();
        panelBills = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        panelPassengers = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPassenger = new javax.swing.JTable();
        panelControlls = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        panelDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        panelDetails.setName(""); // NOI18N
        panelDetails.setPreferredSize(new java.awt.Dimension(400, 219));

        lblTownID.setText("Tour Code");

        lblTownName.setText("Route");

        lblOvernightStop.setText("Coach");

        lblOvernightStop1.setText("Start Date");

        lblOvernightStop2.setText("Executed");

        lblOvernightStop3.setText("Driver");

        javax.swing.GroupLayout panelDetailsLayout = new javax.swing.GroupLayout(panelDetails);
        panelDetails.setLayout(panelDetailsLayout);
        panelDetailsLayout.setHorizontalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOvernightStop1)
                            .addComponent(lblOvernightStop2)
                            .addComponent(lblOvernightStop3))
                        .addGap(50, 50, 50)
                        .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtExecuted, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboDriver, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelDetailsLayout.createSequentialGroup()
                        .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTownName)
                            .addComponent(lblOvernightStop)
                            .addComponent(lblTownID))
                        .addGap(50, 50, 50)
                        .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboRoute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCoach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTourCode))))
                .addGap(5, 5, 5))
        );
        panelDetailsLayout.setVerticalGroup(
            panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTownID)
                    .addComponent(txtTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTownName)
                    .addComponent(comboRoute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOvernightStop)
                    .addComponent(comboCoach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOvernightStop3)
                    .addComponent(comboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOvernightStop2)
                    .addComponent(txtExecuted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOvernightStop1)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelBills.setBorder(javax.swing.BorderFactory.createTitledBorder("Bills"));
        panelBills.setName(""); // NOI18N
        panelBills.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblBill.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBill);

        panelBills.add(jScrollPane1);

        panelPassengers.setBorder(javax.swing.BorderFactory.createTitledBorder("Passengers"));
        panelPassengers.setName(""); // NOI18N
        panelPassengers.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        tblPassenger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPassenger.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPassenger);

        panelPassengers.add(jScrollPane2);

        panelControlls.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelControlls.setMinimumSize(new java.awt.Dimension(100, 38));
        panelControlls.setPreferredSize(new java.awt.Dimension(100, 38));
        panelControlls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        panelControlls.add(btnClear);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panelControlls.add(btnSave);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panelControlls.add(btnDelete);

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelControlls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPassengers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(panelBills, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBills, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(panelPassengers, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelControlls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        panelScroll.setViewportView(panelMain);

        add(panelScroll, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        int id;
        try {
            id = Integer.parseInt(txtTourCode.getText());
            if (this.tour == null && tourDAO.getTour(id) != null) {
                JOptionPane.showMessageDialog(this, "Entered tour code already exists\nPlease enter another code.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid tour code.", "Error", JOptionPane.ERROR_MESSAGE);
            txtTourCode.selectAll();
            txtTourCode.requestFocus();
            return;
        }
        String executed = txtExecuted.getText();
        if (executed.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid executed details.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(this, "Are you sure to save the record?", "Tour Management", JOptionPane.YES_NO_OPTION);
        if (result != JOptionPane.YES_OPTION) {
            return;
        }
        DefaultTableModel dtmBill = (DefaultTableModel) tblBill.getModel();
        Set<Bill> bills = new HashSet<>();
        for (Object v : dtmBill.getDataVector()) {
            bills.add(townDAO.getBill(((Vector) v).get(0).toString()));
        }

        DefaultTableModel dtmPassenger = (DefaultTableModel) tblPassenger.getModel();
        Set<Passenger> passengers = new HashSet<>();
        for (Object v : dtmPassenger.getDataVector()) {
            passengers.add(townDAO.getPassenger(Integer.parseInt(((Vector) v).get(0).toString())));
        }

        Tour tour = new Tour(id, (Route) comboRoute.getSelectedItem(), (Driver) comboDriver.getSelectedItem(), (Coach) comboCoach.getSelectedItem(), dateChooser.getDate(), executed, bills, passengers);

        if (this.tour == null) {
            if (tourDAO.addTour(tour)) {
                JOptionPane.showMessageDialog(this, "Record is saved successfully.", "Tour Management", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save the record.", "Tour Management", JOptionPane.ERROR_MESSAGE);
            }
            refresh(tour);
        } else {
            if (tourDAO.updateTour(tour)) {
                JOptionPane.showMessageDialog(this, "Record is updated successfully.", "Tour Management", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update the record.", "Tour Management", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure to delete the record?", "Tour Management", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (tourDAO.deleteTour(tour)) {
                JOptionPane.showMessageDialog(this, "Record is deleted successfully.", "Tour Management", JOptionPane.INFORMATION_MESSAGE);
                refresh(null);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the record.", "Tour Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        refresh(null);
    }//GEN-LAST:event_btnClearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox comboCoach;
    private javax.swing.JComboBox comboDriver;
    private javax.swing.JComboBox comboRoute;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblOvernightStop;
    private javax.swing.JLabel lblOvernightStop1;
    private javax.swing.JLabel lblOvernightStop2;
    private javax.swing.JLabel lblOvernightStop3;
    private javax.swing.JLabel lblTownID;
    private javax.swing.JLabel lblTownName;
    private javax.swing.JPanel panelBills;
    private javax.swing.JPanel panelControlls;
    private javax.swing.JPanel panelDetails;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelPassengers;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblPassenger;
    private javax.swing.JTextField txtExecuted;
    private javax.swing.JTextField txtTourCode;
    // End of variables declaration//GEN-END:variables
}
