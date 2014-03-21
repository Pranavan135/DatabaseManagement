/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui;

import db.entity.Passenger;
import db.entity.Tour;
import db.dao.PassengerDAO;
import db.dao.TourDAO;
import db.validate.PassengerValidator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vishnuvathsasarma
 */
public class PassengerWindow extends javax.swing.JFrame {

    /**
     * Creates new form PassengerWindow
     */
    private final PassengerDAO passengerDAO;
    private final TourDAO tourDAO;
    private final PassengerValidator passengerValidator;
    private Passenger passenger;
    private Tour tour;
    private List<Tour> tours;

    private final String idLengthWarningMessage;
    private final String idFormatWarningMessage;
    private final String nameFormatLengthWarningMessage;
    private final String nameFormatWarningMessage;
    private final String idExistWarningMessage;

    private final String[] columnHeaders;

    private DefaultTableModel passengerTableModel;
    private final Color gridColour1;
    private final DefaultTableCellRenderer tableCellRenderer;
    private final Dimension scrollableViewportDimension;
    private ArrayList<Object[]> data;

    public PassengerWindow() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
                 
         try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
         if ("Nimbus".equals(info.getName())) {
         javax.swing.UIManager.setLookAndFeel(info.getClassName());
         break;
         }
         }
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(PassengerWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }

         try {
         UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel");
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException classNotFoundException) {
         }
         */
        //</editor-fold>

        /* Create and display the form */
        initComponents();

        passengerDAO = new PassengerDAO();
        tourDAO = new TourDAO();
        passengerValidator = new PassengerValidator();
        passenger = new Passenger();
        tour = new Tour();

        idLengthWarningMessage = "Please enter a valid ID\nID should contain " + passengerValidator.getIdLength() + " digits";
        idFormatWarningMessage = "Please enter a valid ID\nID shuold be numeric whole number";
        nameFormatLengthWarningMessage = "Entered Name is not valid\n"
                + "You can enter charactors from [A-Z], [a-z], and '.' only\n"
                + "Name should contain only " + passengerValidator.getMinNameLength() + " - " + passengerValidator.getMaxNameLength() + " number of charactors";
        nameFormatWarningMessage = "Entered Name is not valid\n"
                + "You can enter charactors from [A-Z], [a-z], and '.' only\n";
        idExistWarningMessage = "Entered ID already exists\nPlease enter new ID";

        columnHeaders = new String[]{"ID", "Name", "Tour Code", "Route", "Driver ID", "Driver T.P.no", "Coach Reg.no"};

        passengerTableModel = new DefaultTableModel(null, columnHeaders);
        gridColour1 = new Color(104, 136, 170);
        tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {

                Component c = super.getTableCellRendererComponent(table,
                        value, isSelected, hasFocus, row, column);
                c.setBackground(row % 2 == 0 ? gridColour1 : new Color(138, 154, 91));
                return c;

            }
        };
        scrollableViewportDimension = new Dimension(800, 300);
        data = new ArrayList<>();

        //to make the table cells non-editable
        tableDel.setDefaultEditor(tableDel.getColumnClass(0), null);

        addRefresh();
    }

    public void addRefresh() {
        txtAddID.requestFocus();
        tours = tourDAO.getAllTours();

        DefaultComboBoxModel<Tour> tourModel = new DefaultComboBoxModel<>(tours.toArray(new Tour[0]));
        comboAddTourCode.setModel(tourModel);

        comboAddTourCode.setSelectedIndex(-1);
    }

    public void editRefresh(Passenger passenger) {

        tours = tourDAO.getAllTours();

        // this.passenger = passenger;
        DefaultComboBoxModel<Tour> tourModel = new DefaultComboBoxModel(tours.toArray(new Tour[0]));
        comboEditTourCode.setModel(tourModel);

        if (passenger == null) {
            JOptionPane.showMessageDialog(this, "No data found on given ID", "Passenger Management", JOptionPane.ERROR_MESSAGE);
            btnEditUpdate.setEnabled(false);
            btnEditGet.setEnabled(true);
            txtEditID.setEnabled(true);
            txtEditID.selectAll();
            txtEditID.requestFocus();
            txtEditName.setText("");
            lblEditID.setEnabled(true);
            lblEditName.setEnabled(false);
            lblEditTourCode.setEnabled(false);
            txtEditName.setEnabled(false);
            comboEditTourCode.setSelectedIndex(-1);
            comboEditTourCode.setEnabled(false);

        } else {
            btnEditUpdate.setEnabled(true);
            btnEditGet.setEnabled(false);
            txtEditID.setEnabled(false);
            txtEditID.setText("" + passenger.getId());
            lblEditID.setEnabled(false);
            lblEditName.setEnabled(true);
            lblEditTourCode.setEnabled(true);
            txtEditName.setEnabled(true);
            txtEditName.setText(passenger.getName());
            comboEditTourCode.setEnabled(true);
            comboEditTourCode.setSelectedItem(passenger.getTour());
        }
    }

    public void createDelTable(List<Passenger> passenger) {

        data.removeAll(data);

        for (int i = 0; i < passenger.size(); i++) {

            Object[] row = new Object[]{passenger.get(i).getId(),
                passenger.get(i).getName(),
                passenger.get(i).getTour().getTourCode(),
                passenger.get(i).getTour().getRoute().getId(),
                passenger.get(i).getTour().getDriver().getId().getId(),
                passenger.get(i).getTour().getDriver().getTpNo(),
                passenger.get(i).getTour().getCoach().getRegNo()
            };
            data.add(row);

        }

        Object[][] passengerData = data.toArray(new Object[data.size()][]);

        passengerTableModel.setDataVector(passengerData, columnHeaders);
        tableDel.setModel(passengerTableModel);
        setVisible(true);
        scrollPaneDel.getViewport().setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        tableDel.setAutoscrolls(true);
        tableDel.setFillsViewportHeight(true);
        tableDel.setPreferredScrollableViewportSize(scrollableViewportDimension);
        tableDel.setGridColor(gridColour1);
        tableDel.setName("Passenger Detail");

        tableDel.setDefaultRenderer(Object.class, tableCellRenderer);
    }

    public void createDelTable(Passenger passenger) {

        data.removeAll(data);

        Object[] row = new Object[]{passenger.getId(),
            passenger.getName(),
            passenger.getTour().getTourCode(),
            passenger.getTour().getRoute().getId(),
            passenger.getTour().getDriver().getId().getId(),
            passenger.getTour().getDriver().getTpNo(),
            passenger.getTour().getCoach().getRegNo()
        };
        data.add(row);

        Object[][] passengerData = data.toArray(new Object[data.size()][]);

        passengerTableModel.setDataVector(passengerData, columnHeaders);
        tableDel.setModel(passengerTableModel);
        setVisible(true);
        scrollPaneDel.getViewport().setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        tableDel.setAutoscrolls(true);
        tableDel.setFillsViewportHeight(true);
        tableDel.setPreferredScrollableViewportSize(scrollableViewportDimension);
        tableDel.setGridColor(gridColour1);
        tableDel.setName("Passenger Detail");

        tableDel.setDefaultRenderer(Object.class, tableCellRenderer);
    }

    public void createViewTable(List<Passenger> passenger) {

        data.removeAll(data);

        for (int i = 0; i < passenger.size(); i++) {

            Object[] row = new Object[]{passenger.get(i).getId(),
                passenger.get(i).getName(),
                passenger.get(i).getTour().getTourCode(),
                passenger.get(i).getTour().getRoute().getId(),
                passenger.get(i).getTour().getDriver().getId().getId(),
                passenger.get(i).getTour().getDriver().getTpNo(),
                passenger.get(i).getTour().getCoach().getRegNo()
            };
            data.add(row);
        }

        Object[][] passengerData = data.toArray(new Object[data.size()][]);
        passengerTableModel.setDataVector(passengerData, columnHeaders);
        tableView.setModel(passengerTableModel);

        setVisible(true);
        scrollPaneView.getViewport().setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        tableView.setAutoscrolls(true);
        tableView.setFillsViewportHeight(true);
        tableView.setPreferredScrollableViewportSize(scrollableViewportDimension);
        tableView.setGridColor(gridColour1);
        tableView.setName("Passenger Detail");

        tableView.setDefaultRenderer(Object.class, tableCellRenderer);
    }

    public void createViewTable(Passenger passenger) {

        data.removeAll(data);

        Object[] row = new Object[]{passenger.getId(),
            passenger.getName(),
            passenger.getTour().getTourCode(),
            passenger.getTour().getRoute().getId(),
            passenger.getTour().getDriver().getId().getId(),
            passenger.getTour().getDriver().getTpNo(),
            passenger.getTour().getCoach().getRegNo()
        };
        data.add(row);

        Object[][] passengerData = data.toArray(new Object[data.size()][]);

        passengerTableModel.setDataVector(passengerData, columnHeaders);
        tableView.setModel(passengerTableModel);

        setVisible(true);
        scrollPaneView.getViewport().setBackground(Color.LIGHT_GRAY);
        setVisible(true);

        tableView.setAutoscrolls(true);
        tableView.setFillsViewportHeight(true);
        tableView.setPreferredScrollableViewportSize(scrollableViewportDimension);
        tableView.setGridColor(gridColour1);
        tableView.setName("Passenger Detail");

        tableView.setDefaultRenderer(Object.class, tableCellRenderer);
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
        txtAddID = new javax.swing.JTextField();
        txtAddName = new javax.swing.JTextField();
        btnAddAdd = new javax.swing.JButton();
        btnAddClear = new javax.swing.JButton();
        btnAddExit = new javax.swing.JButton();
        comboAddTourCode = new javax.swing.JComboBox();
        tabPassengerEdit = new javax.swing.JPanel();
        lblEditName = new javax.swing.JLabel();
        txtEditName = new javax.swing.JTextField();
        txtEditID = new javax.swing.JTextField();
        lblEditTourCode = new javax.swing.JLabel();
        lblEditID = new javax.swing.JLabel();
        btnEditUpdate = new javax.swing.JButton();
        btnEditClear = new javax.swing.JButton();
        btnEditExit = new javax.swing.JButton();
        btnEditGet = new javax.swing.JButton();
        comboEditTourCode = new javax.swing.JComboBox();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Passenger Management");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setName("passengerFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));

        tabPanePassenger.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabPanePassenger.setForeground(new java.awt.Color(51, 0, 51));
        tabPanePassenger.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabPanePassenger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanePassengerMouseClicked(evt);
            }
        });

        tabPassengerAdd.setToolTipText("");
        tabPassengerAdd.setName(""); // NOI18N
        tabPassengerAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPassengerAddMouseClicked(evt);
            }
        });
        tabPassengerAdd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabPassengerAddFocusGained(evt);
            }
        });

        lblAddName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddName.setForeground(new java.awt.Color(0, 51, 51));
        lblAddName.setText("Name");

        lblAddID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddID.setForeground(new java.awt.Color(0, 51, 51));
        lblAddID.setText("ID");

        lblAddTourCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAddTourCode.setForeground(new java.awt.Color(0, 51, 51));
        lblAddTourCode.setText("Tour Code");

        txtAddID.setBackground(new java.awt.Color(250, 250, 250));
        txtAddID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddID.setForeground(new java.awt.Color(51, 51, 0));

        txtAddName.setBackground(new java.awt.Color(250, 250, 250));
        txtAddName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAddName.setForeground(new java.awt.Color(51, 51, 0));

        btnAddAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddAdd.setForeground(new java.awt.Color(51, 51, 51));
        btnAddAdd.setText("ADD");
        btnAddAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAddActionPerformed(evt);
            }
        });

        btnAddClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddClear.setForeground(new java.awt.Color(51, 51, 51));
        btnAddClear.setText("Clear");
        btnAddClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClearActionPerformed(evt);
            }
        });

        btnAddExit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddExit.setForeground(new java.awt.Color(51, 51, 51));
        btnAddExit.setText("Exit");
        btnAddExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExitActionPerformed(evt);
            }
        });

        comboAddTourCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboAddTourCode.setForeground(new java.awt.Color(51, 51, 0));

        javax.swing.GroupLayout tabPassengerAddLayout = new javax.swing.GroupLayout(tabPassengerAdd);
        tabPassengerAdd.setLayout(tabPassengerAddLayout);
        tabPassengerAddLayout.setHorizontalGroup(
            tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPassengerAddLayout.createSequentialGroup()
                        .addComponent(btnAddAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                        .addComponent(btnAddExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabPassengerAddLayout.createSequentialGroup()
                        .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddID, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddTourCode))
                        .addGap(18, 18, 18)
                        .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddName)
                            .addComponent(txtAddID)
                            .addComponent(comboAddTourCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        tabPassengerAddLayout.setVerticalGroup(
            tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerAddLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAddTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(tabPassengerAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabPanePassenger.addTab("ADD", tabPassengerAdd);
        tabPassengerAdd.getAccessibleContext().setAccessibleName("tabPassengerAdd");

        tabPassengerEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPassengerEditMouseClicked(evt);
            }
        });

        lblEditName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEditName.setForeground(new java.awt.Color(0, 51, 51));
        lblEditName.setText("Name");
        lblEditName.setEnabled(false);

        txtEditName.setForeground(new java.awt.Color(51, 51, 0));
        txtEditName.setEnabled(false);

        txtEditID.setForeground(new java.awt.Color(51, 51, 0));
        txtEditID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEditIDKeyPressed(evt);
            }
        });

        lblEditTourCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEditTourCode.setForeground(new java.awt.Color(0, 51, 51));
        lblEditTourCode.setText("Tour Code");
        lblEditTourCode.setEnabled(false);

        lblEditID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblEditID.setForeground(new java.awt.Color(0, 51, 51));
        lblEditID.setText("ID");

        btnEditUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditUpdate.setForeground(new java.awt.Color(51, 51, 51));
        btnEditUpdate.setText("UPDATE");
        btnEditUpdate.setEnabled(false);
        btnEditUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUpdateActionPerformed(evt);
            }
        });

        btnEditClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditClear.setForeground(new java.awt.Color(51, 51, 51));
        btnEditClear.setText("Clear");
        btnEditClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditClearActionPerformed(evt);
            }
        });

        btnEditExit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditExit.setForeground(new java.awt.Color(51, 51, 51));
        btnEditExit.setText("Exit");
        btnEditExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditExitActionPerformed(evt);
            }
        });

        btnEditGet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditGet.setForeground(new java.awt.Color(51, 51, 51));
        btnEditGet.setText("Get");
        btnEditGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditGetActionPerformed(evt);
            }
        });

        comboEditTourCode.setForeground(new java.awt.Color(51, 51, 0));
        comboEditTourCode.setEnabled(false);

        javax.swing.GroupLayout tabPassengerEditLayout = new javax.swing.GroupLayout(tabPassengerEdit);
        tabPassengerEdit.setLayout(tabPassengerEditLayout);
        tabPassengerEditLayout.setHorizontalGroup(
            tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabPassengerEditLayout.createSequentialGroup()
                        .addComponent(btnEditUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditExit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabPassengerEditLayout.createSequentialGroup()
                        .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditTourCode)
                            .addComponent(lblEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEditID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabPassengerEditLayout.createSequentialGroup()
                                .addComponent(txtEditID, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditGet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEditName)
                            .addComponent(comboEditTourCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        tabPassengerEditLayout.setVerticalGroup(
            tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerEditLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditGet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboEditTourCode)
                    .addComponent(lblEditTourCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(tabPassengerEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabPanePassenger.addTab("EDIT", tabPassengerEdit);
        tabPassengerEdit.getAccessibleContext().setAccessibleName("tabPassengerEdit");

        tabPassengerDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPassengerDeleteMouseClicked(evt);
            }
        });

        lblDelSaerch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDelSaerch.setForeground(new java.awt.Color(0, 51, 51));
        lblDelSaerch.setText("Search by:");

        comboDelSearchCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboDelSearchCategory.setForeground(new java.awt.Color(51, 51, 0));
        comboDelSearchCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "ID" }));

        txtDelKeyword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDelKeyword.setForeground(new java.awt.Color(51, 51, 0));
        txtDelKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDelKeywordKeyPressed(evt);
            }
        });

        btnDelFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelFind.setForeground(new java.awt.Color(51, 51, 51));
        btnDelFind.setText("Find");
        btnDelFind.setPreferredSize(new java.awt.Dimension(60, 30));
        btnDelFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelFindActionPerformed(evt);
            }
        });

        tableDel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableDel.setForeground(new java.awt.Color(51, 0, 51));
        tableDel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Tour Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableDel.setName("tableDelList"); // NOI18N
        tableDel.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableDel.getTableHeader().setReorderingAllowed(false);
        scrollPaneDel.setViewportView(tableDel);
        tableDel.getAccessibleContext().setAccessibleName("tableDelList");

        btnDelClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelClear.setForeground(new java.awt.Color(51, 51, 51));
        btnDelClear.setText("Clear");
        btnDelClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelClearActionPerformed(evt);
            }
        });

        btnDelDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelDelete.setForeground(new java.awt.Color(51, 51, 51));
        btnDelDelete.setText("DELETE");
        btnDelDelete.setEnabled(false);
        btnDelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDelDeleteMouseEntered(evt);
            }
        });
        btnDelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDeleteActionPerformed(evt);
            }
        });

        btnDelExit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDelExit.setForeground(new java.awt.Color(51, 51, 51));
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
                .addContainerGap()
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                        .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                                .addComponent(lblDelSaerch)
                                .addGap(18, 18, 18)
                                .addComponent(comboDelSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                                .addComponent(txtDelKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelFind, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                        .addComponent(btnDelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tabPassengerDeleteLayout.setVerticalGroup(
            tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDelSaerch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboDelSearchCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDelKeyword, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnDelFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(scrollPaneDel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(tabPassengerDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabPanePassenger.addTab("DELETE", tabPassengerDelete);
        tabPassengerDelete.getAccessibleContext().setAccessibleName("tabPassengerDelete");

        tabPassengerView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPassengerViewMouseClicked(evt);
            }
        });

        lblViewSaerch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblViewSaerch.setForeground(new java.awt.Color(0, 51, 51));
        lblViewSaerch.setText("Search by:");

        comboViewSearchCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboViewSearchCategory.setForeground(new java.awt.Color(51, 51, 0));
        comboViewSearchCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Name", "ID" }));

        txtViewKeyword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtViewKeyword.setForeground(new java.awt.Color(51, 51, 0));
        txtViewKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtViewKeywordKeyPressed(evt);
            }
        });

        btnViewFind.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnViewFind.setForeground(new java.awt.Color(51, 51, 51));
        btnViewFind.setText("Find");
        btnViewFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFindActionPerformed(evt);
            }
        });

        tableView.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableView.setForeground(new java.awt.Color(51, 0, 51));
        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Tour Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableView.setEnabled(false);
        tableView.setName("tableViewList"); // NOI18N
        scrollPaneView.setViewportView(tableView);
        tableView.getAccessibleContext().setAccessibleName("tableViewList");

        btnViewClear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnViewClear.setForeground(new java.awt.Color(51, 51, 51));
        btnViewClear.setText("Clear");
        btnViewClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewClearActionPerformed(evt);
            }
        });

        btnViewExit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnViewExit.setForeground(new java.awt.Color(51, 51, 51));
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
                .addContainerGap()
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabPassengerViewLayout.createSequentialGroup()
                        .addComponent(btnViewClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabPassengerViewLayout.createSequentialGroup()
                        .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabPassengerViewLayout.createSequentialGroup()
                                .addComponent(lblViewSaerch)
                                .addGap(18, 18, 18)
                                .addComponent(comboViewSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtViewKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnViewFind, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabPassengerViewLayout.setVerticalGroup(
            tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabPassengerViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboViewSearchCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblViewSaerch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewFind, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneView, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(tabPassengerViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(tabPanePassenger)
        );

        tabPanePassenger.getAccessibleContext().setAccessibleName("tabPanePassenger");

        pack();
        setLocationRelativeTo(null);
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
        txtAddID.requestFocus();
        comboAddTourCode.setSelectedIndex(-1);
    }//GEN-LAST:event_btnAddClearActionPerformed

    private void btnEditClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditClearActionPerformed
        // TODO add your handling code here:
        btnEditUpdate.setEnabled(false);
        btnEditGet.setEnabled(true);
        lblEditID.setEnabled(true);
        lblEditName.setEnabled(false);
        lblEditTourCode.setEnabled(false);
        txtEditID.setEnabled(true);
        txtEditID.setText("");
        txtEditID.requestFocus();
        txtEditName.setText("");
        txtEditName.setEnabled(false);
        comboEditTourCode.setSelectedIndex(-1);
        comboEditTourCode.setEnabled(false);
    }//GEN-LAST:event_btnEditClearActionPerformed

    private void btnDelClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelClearActionPerformed
        // TODO add your handling code here:
        txtDelKeyword.setText("");
        txtDelKeyword.requestFocus();
        passengerTableModel.setDataVector(null, columnHeaders);
        tableDel.setModel(passengerTableModel);
        btnDelDelete.setEnabled(false);
    }//GEN-LAST:event_btnDelClearActionPerformed

    private void btnViewClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewClearActionPerformed
        // TODO add your handling code here:
        txtViewKeyword.setText("");
        txtViewKeyword.requestFocus();
        passengerTableModel.setDataVector(null, columnHeaders);
        tableView.setModel(passengerTableModel);
    }//GEN-LAST:event_btnViewClearActionPerformed

    private void btnDelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDeleteActionPerformed
        // TODO add your handling code here:
        // if(tableDel.is)
        passenger.setId((Integer) tableDel.getValueAt(tableDel.getSelectedRow(), 0));
        passenger.setName((String) tableDel.getValueAt(tableDel.getSelectedRow(), 1));
        tour = tourDAO.getTour((Integer) tableDel.getValueAt(tableDel.getSelectedRow(), 2));
        passenger.setTour(tour);
        int result = JOptionPane.showConfirmDialog(this, "Are you sure to delete the record?", "Passenger Management", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (passengerDAO.deletePassenger(passenger)) {
                JOptionPane.showMessageDialog(this, "Successfully deleted", "Passenger Management", JOptionPane.INFORMATION_MESSAGE);
                //remove table row     
                //efficient way
               /* tableDel.setValueAt(null, tableDel.getSelectedRow(),0);
                 tableDel.setValueAt(null, tableDel.getSelectedRow(),1);
                 tableDel.setValueAt(null, tableDel.getSelectedRow(),2); */
                //easy way
                passengerTableModel.setDataVector(null, columnHeaders);
                tableDel.setModel(passengerTableModel);
                btnDelFind.doClick();
                btnDelDelete.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Database Error", "Passenger Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelDeleteActionPerformed

    private void btnAddAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAddActionPerformed
        // TODO add your handling code here:
        try {
            int ID = Integer.parseInt(txtAddID.getText().trim());
            if (passengerValidator.isValidID(ID)) {
                if (passengerValidator.isDuplicateID(ID)) {
                    String name = txtAddName.getText().trim();
                    if (passengerValidator.isValidName(name)) {
                        if (comboAddTourCode.getSelectedIndex() >= 0) {
                            passenger.setId(ID);
                            passenger.setName(name);
                            tour = (Tour) comboAddTourCode.getSelectedItem();
                            passenger.setTour(tour);
                            int result = JOptionPane.showConfirmDialog(this, "Are you sure to save the record?", "Passenger Management", JOptionPane.YES_NO_OPTION);
                            if (result == JOptionPane.YES_OPTION) {
                                if (passengerDAO.addPassenger(passenger)) {
                                    JOptionPane.showMessageDialog(this, "Successfully added", "Passenger Management", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(this, "Database Error", "Passenger Management", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Please select the tour code before adding", "Passenger Management", JOptionPane.WARNING_MESSAGE);
                            comboAddTourCode.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, nameFormatLengthWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
                        txtAddName.selectAll();
                        txtAddName.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, idExistWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
                    txtAddID.selectAll();
                    txtAddID.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, idLengthWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
                txtAddID.selectAll();
                txtAddID.requestFocus();
            }
        } catch (NumberFormatException numEx) {
            JOptionPane.showMessageDialog(this, idFormatWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
            txtAddID.selectAll();
            txtAddID.requestFocus();
        }
    }//GEN-LAST:event_btnAddAddActionPerformed

    private void btnEditUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUpdateActionPerformed
        // TODO add your handling code here:

        String name = txtEditName.getText().trim();
        if (passengerValidator.isValidName(name)) {
            tour = (Tour) comboEditTourCode.getSelectedItem();
            passenger.setId(Integer.parseInt(txtEditID.getText().trim()));
            passenger.setName(name);
            passenger.setTour(tour);
            int result = JOptionPane.showConfirmDialog(this, "Are you sure to update the record?", "Passenger Management", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                if (passengerDAO.updatePassenger(passenger)) {
                    JOptionPane.showMessageDialog(this, "Successfully Updated", "Passenger Management", JOptionPane.INFORMATION_MESSAGE);
                    // editRefresh(passenger);
                } else {
                    JOptionPane.showMessageDialog(this, "Database Error", "Passenger Management", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, nameFormatLengthWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
            txtEditName.selectAll();
            txtEditName.requestFocus();
        }

    }//GEN-LAST:event_btnEditUpdateActionPerformed

    private void btnDelFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelFindActionPerformed
        // TODO add your handling code here:
        if (comboDelSearchCategory.getSelectedIndex() == 0) {
            String name = txtDelKeyword.getText().trim();
            if (passengerValidator.isAlphabet(name)) {
                List<Passenger> result = passengerDAO.getPassenger(name);
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No data found relevant to given Name", "Passenger Management", JOptionPane.ERROR_MESSAGE);
                } else {
                    createDelTable(result);
                }
            } else {
                JOptionPane.showMessageDialog(this, nameFormatWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                int ID = Integer.parseInt(txtDelKeyword.getText().trim());
                if (passengerValidator.isValidID(ID)) {
                    Passenger result = passengerDAO.getPassenger(ID);
                    if (result == null) {
                        JOptionPane.showMessageDialog(this, "No data found on given ID", "Passenger Management", JOptionPane.ERROR_MESSAGE);
                    } else {
                        createDelTable(result);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, idLengthWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException numEx) {
                JOptionPane.showMessageDialog(this, idFormatWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelFindActionPerformed

    private void btnViewFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFindActionPerformed
        // TODO add your handling code here:
        if (comboViewSearchCategory.getSelectedIndex() == 0) {
            String name = txtViewKeyword.getText().trim();
            if (passengerValidator.isAlphabet(name)) {
                List<Passenger> result = passengerDAO.getPassenger(name);
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No data found relevant to given Name", "Passenger Management", JOptionPane.ERROR_MESSAGE);
                } else {
                    createViewTable(result);
                }
            } else {
                JOptionPane.showMessageDialog(this, nameFormatWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            try {
                int ID = Integer.parseInt(txtViewKeyword.getText().trim());
                if (passengerValidator.isValidID(ID)) {
                    Passenger result = passengerDAO.getPassenger(ID);
                    if (result == null) {
                        JOptionPane.showMessageDialog(this, "No data found on given ID", "Passenger Management", JOptionPane.ERROR_MESSAGE);
                    } else {
                        createViewTable(result);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, idLengthWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException numEx) {
                JOptionPane.showMessageDialog(this, idFormatWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnViewFindActionPerformed

    private void btnEditGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditGetActionPerformed
        // TODO add your handling code here:
        try {
            int ID = Integer.parseInt(txtEditID.getText().trim());
            if (passengerValidator.isValidID(ID)) {
                Passenger result = passengerDAO.getPassenger(ID);
                editRefresh(result);
            } else {
                JOptionPane.showMessageDialog(this, idLengthWarningMessage, "Passenger Management", JOptionPane.WARNING_MESSAGE);
                txtEditID.selectAll();
                txtEditID.requestFocus();
            }
        } catch (NumberFormatException numEx) {
            JOptionPane.showMessageDialog(this, idFormatWarningMessage, "Passenger Management", JOptionPane.ERROR_MESSAGE);
            txtEditID.selectAll();
            txtEditID.requestFocus();
        }
    }//GEN-LAST:event_btnEditGetActionPerformed

    private void btnDelDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelDeleteMouseEntered
        // TODO add your handling code here:
        if (tableDel.getSelectedRow() >= 0) {
            btnDelDelete.setEnabled(true);
        }
    }//GEN-LAST:event_btnDelDeleteMouseEntered

    private void txtEditIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditIDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEditGet.doClick();
        }
    }//GEN-LAST:event_txtEditIDKeyPressed

    private void txtDelKeywordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDelKeywordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDelFind.doClick();
        }
    }//GEN-LAST:event_txtDelKeywordKeyPressed

    private void txtViewKeywordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtViewKeywordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnViewFind.doClick();
        }
    }//GEN-LAST:event_txtViewKeywordKeyPressed

    private void tabPassengerAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPassengerAddMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabPassengerAddMouseClicked

    private void tabPassengerEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPassengerEditMouseClicked
        // TODO add your handling code here:
        if (evt.getComponent() == tabPassengerEdit) {
            txtEditID.requestFocus();
            txtEditID.selectAll();
        }
    }//GEN-LAST:event_tabPassengerEditMouseClicked

    private void tabPassengerDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPassengerDeleteMouseClicked
        // TODO add your handling code here:
        if (evt.getComponent() == tabPassengerDelete) {
            txtDelKeyword.requestFocus();
            txtDelKeyword.selectAll();
        }
    }//GEN-LAST:event_tabPassengerDeleteMouseClicked

    private void tabPassengerViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPassengerViewMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabPassengerViewMouseClicked

    private void tabPassengerAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabPassengerAddFocusGained
        // TODO add your handling code here:
        if (evt.getComponent() == tabPassengerAdd) {
            txtAddID.requestFocus();
            txtAddID.selectAll();
        }
    }//GEN-LAST:event_tabPassengerAddFocusGained

    private void tabPanePassengerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanePassengerMouseClicked
        // TODO add your handling code here:
        if (tabPassengerAdd.isShowing()) {
            txtAddID.requestFocus();
        } else if (tabPassengerEdit.isShowing() && txtEditID.isEnabled()) {
            txtEditID.requestFocus();
        } else if (tabPassengerDelete.isShowing()) {
            txtDelKeyword.requestFocus();
        } else if (tabPassengerView.isShowing()) {
            txtViewKeyword.requestFocus();
        }
    }//GEN-LAST:event_tabPanePassengerMouseClicked

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
    private javax.swing.JButton btnEditGet;
    private javax.swing.JButton btnEditUpdate;
    private javax.swing.JButton btnViewClear;
    private javax.swing.JButton btnViewExit;
    private javax.swing.JButton btnViewFind;
    private javax.swing.JComboBox comboAddTourCode;
    private javax.swing.JComboBox comboDelSearchCategory;
    private javax.swing.JComboBox comboEditTourCode;
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
    private javax.swing.JTextField txtDelKeyword;
    private javax.swing.JTextField txtEditID;
    private javax.swing.JTextField txtEditName;
    private javax.swing.JTextField txtViewKeyword;
    // End of variables declaration//GEN-END:variables
}
