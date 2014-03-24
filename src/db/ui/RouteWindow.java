/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui;

import db.dao.RouteDAO;
import db.entity.Driver;
import db.entity.DriverRoute;
import db.entity.DriverRouteId;
import db.entity.Route;
import db.entity.RouteTown;
import db.entity.RouteTownId;
import db.entity.Town;
import db.validate.RouteVallidate;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Annet
 */
public class RouteWindow extends javax.swing.JFrame {

    private final RouteVallidate routeValidate = RouteVallidate.createInstance();
    private final RouteDAO routeDAO = RouteDAO.create();
    private static RouteWindow routeWindow = null;
    private String routeID, routeName, days, distance;
    private List<Integer> routeIDList ,driverIDList, resultList;
    private Vector<String> tableHeaders1 = null;
    private  static boolean  myresult = false;
    /**
     * Creates new form RouteWindow
     */
    public RouteWindow() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/db/Image/Bus.png")));
        this.setResizable(false);
        initComponents();
        routeNameEditTextField.setEnabled(false);
        routeDaysEditTextField.setEnabled(false);
        routeDistanceEditTextField.setEnabled(false);
    }

   public static RouteWindow create(){
        if (routeWindow == null){
            routeWindow = new RouteWindow();}
            return routeWindow;
        
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        RoutePane = new javax.swing.JTabbedPane();
        AddJPanel = new javax.swing.JPanel();
        routeIDLabel = new javax.swing.JLabel();
        routeNameLabel = new javax.swing.JLabel();
        routeDaysLabel = new javax.swing.JLabel();
        routeDistanceLabel = new javax.swing.JLabel();
        routeIDTextField = new javax.swing.JTextField();
        routeNameTextField = new javax.swing.JTextField();
        routeDaysTextField = new javax.swing.JTextField();
        routeDistanceTextField = new javax.swing.JTextField();
        addAddButton = new javax.swing.JButton();
        cleaAddrButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        routeTownAddJPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        routeIDAssignComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        routeTownAddButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        addTownTable = new javax.swing.JTable();
        driverRouteAddJPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        routeIDDriverAssignComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        driverIDAssignComboBox = new javax.swing.JComboBox();
        driverRouteAddSaveButton = new javax.swing.JButton();
        EditJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        routeIDEditTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        routeNameEditTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        routeDaysEditTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        routeDistanceEditTextField = new javax.swing.JTextField();
        showEditButton = new javax.swing.JButton();
        editEditButton = new javax.swing.JButton();
        clearEditButton = new javax.swing.JButton();
        exitEditButton = new javax.swing.JButton();
        DeleteJPanel = new javax.swing.JPanel();
        routeIDDeleteLabel = new javax.swing.JLabel();
        routeIDDeleteTextField = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();
        clearDeleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        deleteTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        showRouteRadioBtn = new javax.swing.JRadioButton();
        showRouteTownRadioBtn = new javax.swing.JRadioButton();
        showDriverRouteRadioBtn = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        ViewJPanel = new javax.swing.JPanel();
        routeIDViewTextField = new javax.swing.JTextField();
        routeIDViewLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        showDriverRouteViewButton = new javax.swing.JButton();
        showRouteTownButton = new javax.swing.JButton();
        showRouteVIewButton = new javax.swing.JButton();

        buttonGroup3.add(showRouteRadioBtn);
        buttonGroup3.add(showRouteTownRadioBtn);
        buttonGroup3.add(showDriverRouteRadioBtn);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Route Management");
        setFont(new java.awt.Font("Andalus", 1, 12)); // NOI18N

        RoutePane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RoutePane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        RoutePane.setFont(new java.awt.Font("Constantia", 1, 14)); // NOI18N
        RoutePane.setPreferredSize(new java.awt.Dimension(700, 500));

        routeIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeIDLabel.setText("Route ID");

        routeNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeNameLabel.setText("Route Name");

        routeDaysLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeDaysLabel.setText("Days");

        routeDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeDistanceLabel.setText("Distance( in Km)");

        addAddButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        addAddButton.setText("Add");
        addAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddButtonActionPerformed(evt);
            }
        });

        cleaAddrButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        cleaAddrButton.setText("Clear");
        cleaAddrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleaAddrButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        routeTownAddJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null), "Assign Towns For Route", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel5.setText("Select Route ID");

        routeIDAssignComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { null }));
        addRouteIDComboBoxData();
        routeIDAssignComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeIDAssignComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Select Town ID ");

        routeTownAddButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        routeTownAddButton.setText("Save");
        routeTownAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeTownAddButtonActionPerformed(evt);
            }
        });

        addTownTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Town ID", "Town Name"
            }
        ));
        addTownTable.setShowHorizontalLines(false);
        addTownTable.setShowVerticalLines(false);
        addTownTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTownTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(addTownTable);
        getTowns();

        javax.swing.GroupLayout routeTownAddJPanelLayout = new javax.swing.GroupLayout(routeTownAddJPanel);
        routeTownAddJPanel.setLayout(routeTownAddJPanelLayout);
        routeTownAddJPanelLayout.setHorizontalGroup(
            routeTownAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(routeTownAddJPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(routeTownAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(routeTownAddJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47)
                        .addComponent(routeIDAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(routeTownAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        routeTownAddJPanelLayout.setVerticalGroup(
            routeTownAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, routeTownAddJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(routeTownAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(routeTownAddJPanelLayout.createSequentialGroup()
                        .addGroup(routeTownAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeIDAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(routeTownAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        driverRouteAddJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 51), null, null), "Assign Driver For Route"));

        jLabel10.setText("Select Route ID");

        routeIDDriverAssignComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { null }));
        addRouteIDComboBoxData();
        routeIDDriverAssignComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeIDDriverAssignComboBoxActionPerformed(evt);
            }
        });

        jLabel11.setText("Select Driver ID");

        driverIDAssignComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { null }));
        addDriverIDComboBoxData();

        driverRouteAddSaveButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        driverRouteAddSaveButton.setText("Save");
        driverRouteAddSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverRouteAddSaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout driverRouteAddJPanelLayout = new javax.swing.GroupLayout(driverRouteAddJPanel);
        driverRouteAddJPanel.setLayout(driverRouteAddJPanelLayout);
        driverRouteAddJPanelLayout.setHorizontalGroup(
            driverRouteAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverRouteAddJPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(driverRouteAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(41, 41, 41)
                .addGroup(driverRouteAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(routeIDDriverAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverIDAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(driverRouteAddSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        driverRouteAddJPanelLayout.setVerticalGroup(
            driverRouteAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverRouteAddJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(driverRouteAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeIDDriverAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverRouteAddSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(driverRouteAddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(driverIDAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AddJPanelLayout = new javax.swing.GroupLayout(AddJPanel);
        AddJPanel.setLayout(AddJPanelLayout);
        AddJPanelLayout.setHorizontalGroup(
            AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddJPanelLayout.createSequentialGroup()
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddJPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(routeIDLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddJPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(routeNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(routeDaysLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(routeDistanceLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(115, 115, 115)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(routeDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeDaysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddJPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddJPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cleaAddrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(routeTownAddJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(driverRouteAddJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        AddJPanelLayout.setVerticalGroup(
            AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeIDLabel))
                        .addGap(16, 16, 16)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeNameLabel)
                            .addComponent(routeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeDaysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeDaysLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeDistanceLabel)))
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addComponent(addAddButton)
                        .addGap(28, 28, 28)
                        .addComponent(cleaAddrButton)
                        .addGap(26, 26, 26)
                        .addComponent(exitButton)))
                .addGap(18, 18, 18)
                .addComponent(routeTownAddJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(driverRouteAddJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        RoutePane.addTab("Add", AddJPanel);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Enter Route ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Route Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Days");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Distance (in Km)");

        showEditButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showEditButton.setText("Show");
        showEditButton.setToolTipText("Show the route details");
        showEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEditButtonActionPerformed(evt);
            }
        });

        editEditButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        editEditButton.setText("Edit");
        editEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEditButtonActionPerformed(evt);
            }
        });
        editEditButton.setEnabled(false);

        clearEditButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        clearEditButton.setText("Clear");
        clearEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearEditButtonActionPerformed(evt);
            }
        });

        exitEditButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        exitEditButton.setText("Exit");
        exitEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitEditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditJPanelLayout = new javax.swing.GroupLayout(EditJPanel);
        EditJPanel.setLayout(EditJPanelLayout);
        EditJPanelLayout.setHorizontalGroup(
            EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditJPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(routeNameEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeIDEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EditJPanelLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(routeDaysEditTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(routeDistanceEditTextField))))
                .addGap(81, 81, 81)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        EditJPanelLayout.setVerticalGroup(
            EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditJPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(routeIDEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(routeNameEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEditButton))
                .addGap(31, 31, 31)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(routeDaysEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditJPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EditJPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeDistanceEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        RoutePane.addTab("Edit", EditJPanel);

        routeIDDeleteLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeIDDeleteLabel.setText("Enter Route ID");

        DeleteButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        clearDeleteButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        clearDeleteButton.setText("Clear");
        clearDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDeleteButtonActionPerformed(evt);
            }
        });

        deleteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(deleteTable);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 51), null, null), "Select the View", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N

        showRouteRadioBtn.setBackground(new java.awt.Color(0, 0, 51));
        showRouteRadioBtn.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showRouteRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        showRouteRadioBtn.setText("Route Details");
        showRouteRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRouteRadioBtnActionPerformed(evt);
            }
        });

        showRouteTownRadioBtn.setBackground(new java.awt.Color(0, 0, 51));
        showRouteTownRadioBtn.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showRouteTownRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        showRouteTownRadioBtn.setText("Towns For Route Details");
        showRouteTownRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRouteTownRadioBtnActionPerformed(evt);
            }
        });

        showDriverRouteRadioBtn.setBackground(new java.awt.Color(0, 0, 51));
        showDriverRouteRadioBtn.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showDriverRouteRadioBtn.setForeground(new java.awt.Color(255, 255, 255));
        showDriverRouteRadioBtn.setText("Driver For Route Detials");
        showDriverRouteRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDriverRouteRadioBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showRouteRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showRouteTownRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showDriverRouteRadioBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showRouteRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showRouteTownRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDriverRouteRadioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton4.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeleteJPanelLayout = new javax.swing.GroupLayout(DeleteJPanel);
        DeleteJPanel.setLayout(DeleteJPanelLayout);
        DeleteJPanelLayout.setHorizontalGroup(
            DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteJPanelLayout.createSequentialGroup()
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(routeIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(routeIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        DeleteJPanelLayout.setVerticalGroup(
            DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteJPanelLayout.createSequentialGroup()
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        RoutePane.addTab("Delete", DeleteJPanel);

        ViewJPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        routeIDViewLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeIDViewLabel.setText("Enter Route ID");

        jButton1.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(resultTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 51), null, null), "Display the Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Andalus", 1, 14), new java.awt.Color(0, 0, 51))); // NOI18N

        showDriverRouteViewButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showDriverRouteViewButton.setText("Driver of Route");
        showDriverRouteViewButton.setBorder(null);
        showDriverRouteViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDriverRouteViewButtonActionPerformed(evt);
            }
        });

        showRouteTownButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showRouteTownButton.setText("Towns of Route");
        showRouteTownButton.setBorder(null);
        showRouteTownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRouteTownButtonActionPerformed(evt);
            }
        });

        showRouteVIewButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showRouteVIewButton.setText("Route");
        showRouteVIewButton.setBorder(null);
        showRouteVIewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRouteVIewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showRouteVIewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showRouteTownButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showDriverRouteViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showRouteVIewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(showRouteTownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showDriverRouteViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewJPanelLayout = new javax.swing.GroupLayout(ViewJPanel);
        ViewJPanel.setLayout(ViewJPanelLayout);
        ViewJPanelLayout.setHorizontalGroup(
            ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewJPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(routeIDViewLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(routeIDViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        ViewJPanelLayout.setVerticalGroup(
            ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewJPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ViewJPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeIDViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeIDViewLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        RoutePane.addTab("View", ViewJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RoutePane, javax.swing.GroupLayout.PREFERRED_SIZE, 661, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RoutePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        ImageIcon add = new ImageIcon(
            this.getClass().getResource("/db/Image/add.png"));
        ImageIcon edit = new ImageIcon(
            this.getClass().getResource("/db/Image/edit.png"));
        ImageIcon delete = new ImageIcon(
            this.getClass().getResource("/db/Image/delete.png"));
        ImageIcon view = new ImageIcon(
            this.getClass().getResource("/db/Image/view.png"));
        RoutePane.setIconAt(0, add);
        RoutePane.setIconAt(1, edit);
        RoutePane.setIconAt(2, delete);
        RoutePane.setIconAt(3, view);

        setSize(new java.awt.Dimension(677, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void cleaAddrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleaAddrButtonActionPerformed
        routeIDTextField.setText("");
        routeNameTextField.setText("");
        routeDaysTextField.setText("");
        routeDistanceTextField.setText("");
        routeIDTextField.requestFocus();
    }//GEN-LAST:event_cleaAddrButtonActionPerformed

    private void addAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddButtonActionPerformed
        routeID = routeIDTextField.getText().trim();
        routeName = routeNameTextField.getText().trim();
        days = routeDaysTextField.getText().trim();
        distance = routeDistanceTextField.getText().trim();
        addRouteData();
    }//GEN-LAST:event_addAddButtonActionPerformed

    private void exitEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitEditButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitEditButtonActionPerformed

    private void editEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEditButtonActionPerformed

       routeID = routeIDEditTextField.getText().trim();
       routeName = routeNameEditTextField.getText().trim();
       days = routeDaysEditTextField.getText().trim();
       distance = routeDistanceEditTextField.getText().trim();
        
        if (  routeValidate.nameValidation(routeName) ){
            if( routeValidate.daysValidation(days)){
                if( routeValidate.distanceValidation(distance)  ){
            boolean response =  routeDAO.updateRoute(new Route(Integer.parseInt(routeID), routeName,Integer.parseInt(days),Integer.parseInt(distance)));                               
            if(response){
            JOptionPane.showMessageDialog(this, "Route Data is Successfully Updated into Database!!", "Success", WIDTH);
         } 
         else {
                    JOptionPane.showMessageDialog(this, "Database Error ", "Error", JOptionPane.ERROR_MESSAGE);
         }  
                }
                else
                {
                    routeDistanceEditTextField.setText("");
                    routeDistanceEditTextField.requestFocus();
                }
            }
            else{
                routeDaysEditTextField.setText("");
                routeDaysEditTextField.requestFocus();
                }
            }
            else
            {
                routeNameEditTextField.setText("");
                routeNameEditTextField.requestFocus();
            }
    }//GEN-LAST:event_editEditButtonActionPerformed

    private void showRouteVIewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRouteVIewButtonActionPerformed
      displayAllRoute(1);
      
    }//GEN-LAST:event_showRouteVIewButtonActionPerformed

   private void displayAllRoute(int num) {
        
       
         if(num == 1){
          if(!routeIDViewTextField.getText().isEmpty())   
             resultList = routeDAO.searchOnRouteID(routeIDViewTextField.getText());
          else
            resultList = routeDAO.searchOnRouteID(routeIDViewTextField.getText());
         }
        
         if(num == 0){
              
         if(!routeIDDeleteTextField.getText().isEmpty())
             resultList = routeDAO.searchOnRouteID(routeIDDeleteTextField.getText());
           else
            resultList = routeDAO.searchOnRouteID(routeIDDeleteTextField.getText());
         
         }
        if (!resultList.isEmpty())     {
            
             tableHeaders1 = new Vector<String>();
             tableHeaders1.add("RouteID"); 
             tableHeaders1.add("RouteName");
             tableHeaders1.add("Days");
             tableHeaders1.add("Distance(in Km)");
             Vector tableData = new Vector();
       
            for(Object o : resultList) {
            Route route = (Route)o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(route.getId());
            oneRow.add(route.getName());
            oneRow.add(route.getDays());
            oneRow.add(route.getDistance());
            tableData.add(oneRow);
          }
         if(num == 1)
            resultTable.setModel(new DefaultTableModel(tableData, tableHeaders1));
        else
         deleteTable.setModel(new DefaultTableModel(tableData, tableHeaders1));  
        }
          else {
            JOptionPane.showMessageDialog(null, "No matches found. Please try again", "ERROR", JOptionPane.INFORMATION_MESSAGE); 
            routeIDViewTextField.setText("");
            routeIDViewTextField.requestFocus();
            routeIDDeleteTextField.setText("");
            routeIDDeleteTextField.requestFocus();
            deleteTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
            resultTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
        }
   } 
    private void showEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEditButtonActionPerformed
        
        if(routeIDEditTextField.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please Enter the Route ID!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
             routeIDEditTextField.requestFocus();
        }
              else
        {
            try{
                
            if(routeDAO.isExist(routeIDEditTextField.getText()))
            {      
                editEditButton.setEnabled(true);
                routeIDEditTextField.setEditable(false);
                routeNameEditTextField.setEnabled(true);
                routeDaysEditTextField.setEnabled(true);
                routeDistanceEditTextField.setEnabled(true);
                Route myroute = routeDAO.getRoute( routeIDEditTextField.getText());
                routeNameEditTextField.setText(myroute.getName());
                routeDaysEditTextField.setText(Integer.toString(myroute.getDays()));
                routeDistanceEditTextField.setText(Integer.toString(myroute.getDistance()));
       }
            else
        {
            JOptionPane.showMessageDialog(this, "Id does not exist!!", "ERROR", JOptionPane.ERROR_MESSAGE);  
            routeIDEditTextField.setText("");
            routeIDEditTextField.requestFocus();
            routeNameEditTextField.setEnabled(false);
            routeDaysEditTextField.setEnabled(false);
            routeDistanceEditTextField.setEnabled(false);
        
            }
            }
            catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(this, "Id contains only 5 digits!!", "ERROR", JOptionPane.ERROR_MESSAGE);  
               routeIDEditTextField.setText("");
               routeIDEditTextField.requestFocus();
            }
       
        }  
    }//GEN-LAST:event_showEditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       
        if(showRouteRadioBtn.isSelected()){
            if(deleteTable.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Please select the rows to delete!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                int response = JOptionPane.showConfirmDialog(null, "Do you want to delete the selected record(s)?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    boolean result = true;
                    int[] count = deleteTable.getSelectedRows();
                    for(int i = 0; i < deleteTable.getSelectedRowCount();i++){
                      Route myroute =  routeDAO.getRoute(deleteTable.getValueAt(count[i], 0).toString());
                      result = routeDAO.deleteRoute(myroute);
                      if(!result)
                          result = false;
                         }
                    if(result){
                            JOptionPane.showMessageDialog(this, "Route Detail is Successfully Deleted from Database", "Success", WIDTH);
                            DefaultTableModel modelTable = (DefaultTableModel)deleteTable.getModel();
                            int[] selectedRow =  deleteTable.getSelectedRows();
                            while(selectedRow.length > 0){
                            modelTable.removeRow(deleteTable.convertRowIndexToModel(selectedRow[0]));
                            selectedRow = deleteTable.getSelectedRows();
                    }
                    }
                            else
                            JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                 
                }
            }
        }
        else if(showRouteTownRadioBtn.isSelected()){
            if(deleteTable.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Please select the rows to delete!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                int response = JOptionPane.showConfirmDialog(null, "Do you want to delete the selected record(s)?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    boolean result = true;
                    int[] count = deleteTable.getSelectedRows();
                    for(int i = 0; i < deleteTable.getSelectedRowCount();i++){
                        
                      RouteTown routeTown =  routeDAO.getRouteTown1(deleteTable.getValueAt(count[i], 0).toString(),deleteTable.getValueAt(count[i], 2).toString());
                      RouteTownId r = new RouteTownId(new Integer(routeTown.getId().getRouteId()),new Integer(routeTown.getId().getTownId()));
                      Route route = routeDAO.getRoute(String.valueOf(routeTown.getRoute().getId()));
                      Town town = routeDAO.getTown(routeTown.getTown().getId());
                      result = routeDAO.deleteRouteTown(new RouteTown(r, route, town));
                      
                      if(!result)
                          result = false;
                      if(result){
                            JOptionPane.showMessageDialog(this, "Towns of Route Detail is Successfully Deleted from Database", "Success", WIDTH);
                            DefaultTableModel modelTable = (DefaultTableModel)deleteTable.getModel();
                            int[] selectedRow =  deleteTable.getSelectedRows();
                            while(selectedRow.length > 0){
                            modelTable.removeRow(deleteTable.convertRowIndexToModel(selectedRow[0]));
                            selectedRow = deleteTable.getSelectedRows();}
                      }
                            else
                            JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                   }
                }
            }
        }
        else if(showDriverRouteRadioBtn.isSelected()){
            if(deleteTable.getSelectedRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Please select the rows to delete!!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                int response = JOptionPane.showConfirmDialog(null, "Do you want to delete the selected record(s)?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    boolean result = true;
                    int[] count = deleteTable.getSelectedRows();
                    for(int i = 0; i < deleteTable.getSelectedRowCount();i++){
                        
                      DriverRoute driverRoute =  routeDAO.getDriverRoute1(Integer.parseInt(deleteTable.getValueAt(count[i], 0).toString()),Integer.parseInt(deleteTable.getValueAt(count[i], 2).toString()));
                       DriverRouteId r = new DriverRouteId(driverRoute.getId().getRouteId(),driverRoute.getId().getDriverId());
                       Route route = routeDAO.getRoute(String.valueOf(driverRoute.getRoute().getId()));
                       Driver driver = routeDAO.getDriver(driverRoute.getId().getDriverId());
               
                    
                      result = routeDAO.deleteDriverRoute(new DriverRoute(r, route, driver));
                      if(!result)
                          result = false;
                      if(result){
                            JOptionPane.showMessageDialog(this, "Driver For Route Detail is successfully deleted from Database!!", "Success", WIDTH);
                            DefaultTableModel modelTable = (DefaultTableModel)deleteTable.getModel();
                            int[] selectedRow =  deleteTable.getSelectedRows();
                            while(selectedRow.length > 0){
                            modelTable.removeRow(deleteTable.convertRowIndexToModel(selectedRow[0]));
                            selectedRow = deleteTable.getSelectedRows();}
                      }
                            else
                            JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                   }
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Please select the table using radio button","ERROR", JOptionPane.ERROR_MESSAGE);
  
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void clearEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearEditButtonActionPerformed
        routeIDEditTextField.setText("");
        routeNameEditTextField.setText("");
        routeDaysEditTextField.setText("");
        routeDistanceEditTextField.setText("");
        routeIDEditTextField.setEnabled(true);
        routeIDEditTextField.setEditable(true);
        routeNameEditTextField.setEnabled(false);
        routeDaysEditTextField.setEnabled(false);
        routeDistanceEditTextField.setEnabled(false);
        editEditButton.setEnabled(false);
        routeIDEditTextField.requestFocus();
    }//GEN-LAST:event_clearEditButtonActionPerformed

    private void clearDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDeleteButtonActionPerformed
        routeIDDeleteTextField.setText("");
        routeIDDeleteTextField.requestFocus();
        tableHeaders1 = null;
        deleteTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
    }//GEN-LAST:event_clearDeleteButtonActionPerformed

    private void routeTownAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeTownAddButtonActionPerformed
      
         if(routeIDAssignComboBox.getSelectedIndex() == -1){
             JOptionPane.showMessageDialog(null, "Please select the route ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       else  if(addTownTable.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select the Town ID", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
         else if(addTownTable.getSelectedRowCount() != 0)  {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to add the selected towns to this route? ", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);         
             if (response == JOptionPane.YES_OPTION) {
                int[] count = addTownTable.getSelectedRows();
                for (int i = 0; i < addTownTable.getSelectedRowCount(); i++) {
                   RouteTownId r = new RouteTownId(Integer.parseInt(routeIDAssignComboBox.getSelectedItem().toString()),Integer.parseInt(addTownTable.getValueAt(count[i], 0).toString()));
                    Route route = routeDAO.getRoute(routeIDAssignComboBox.getSelectedItem().toString());
                    Town town = routeDAO.getTown(Integer.parseInt(addTownTable.getValueAt(count[i], 0).toString()));

                    boolean response1 =  routeDAO.addRouteTown(new RouteTown(r, route,town));
                    if (response1)
                        myresult = true;
                    else
                        myresult = false;
            
             }
                if (myresult)
                     JOptionPane.showMessageDialog(this, "Route_Town Detail is Successfully Added into Database", "Success", WIDTH);
                    else
                        JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                
                addTownTable.clearSelection();
           }
         }
    
    }//GEN-LAST:event_routeTownAddButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        routeIDViewTextField.setText("");
        routeIDViewTextField.requestFocus();
       resultTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void routeIDDriverAssignComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeIDDriverAssignComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routeIDDriverAssignComboBoxActionPerformed

    private void driverRouteAddSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverRouteAddSaveButtonActionPerformed
        if(routeIDDriverAssignComboBox.getSelectedIndex() == -1){
             JOptionPane.showMessageDialog(null, "Please select the route ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           else  if(driverIDAssignComboBox.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Please select the driver ID", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
           else if(!routeDAO.isUniqueDriverRoute(Integer.parseInt(routeIDDriverAssignComboBox.getSelectedItem().toString()), Integer.parseInt(driverIDAssignComboBox.getSelectedItem().toString()))){
               JOptionPane.showMessageDialog(null, "Driver is already assigned to this route", "ERROR", JOptionPane.ERROR_MESSAGE);
          
           }
           else{
               DriverRouteId r = new DriverRouteId(Integer.parseInt(routeIDDriverAssignComboBox.getSelectedItem().toString()), Integer.parseInt(driverIDAssignComboBox.getSelectedItem().toString()));
               Route route = routeDAO.getRoute(routeIDDriverAssignComboBox.getSelectedItem().toString());
               Driver driver = routeDAO.getDriver(Integer.parseInt(driverIDAssignComboBox.getSelectedItem().toString()));
               
               boolean response =  routeDAO.addDriverRoute(new DriverRoute(r, route, driver));
               if (response)
                JOptionPane.showMessageDialog(this, "Driver_Route Detail is Successfully Added into Database", "Success", WIDTH);
               else
                   JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
    }//GEN-LAST:event_driverRouteAddSaveButtonActionPerformed

    private void addTownTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTownTableMouseClicked
    
        if(addTownTable.getSelectedRow() >= 0)   {
            String townID = addTownTable.getValueAt(addTownTable.getSelectedRow(), 0).toString();
          
            if(!routeDAO.isUniqueRouteTown(routeIDAssignComboBox.getSelectedItem().toString(),townID )){
           
                JOptionPane.showMessageDialog(null, "This town already exist in the route", "ERROR", JOptionPane.ERROR_MESSAGE);
                addTownTable.clearSelection();
            }
        }
    }//GEN-LAST:event_addTownTableMouseClicked

    private void showRouteTownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRouteTownButtonActionPerformed
    displayRouteTown(1);
 
    }//GEN-LAST:event_showRouteTownButtonActionPerformed

    private void displayRouteTown(int num) {
        List myresultList = null;
        Vector tableData = new Vector();
       
        if(num == 1)
            myresultList  = routeDAO.getRouteTown(routeIDViewTextField.getText());
        else if(num == 0)
            myresultList  = routeDAO.getRouteTown(routeIDDeleteTextField.getText());
                            
        if (!myresultList.isEmpty())     {
            
       for(Object o : myresultList ) {
            tableHeaders1 = new Vector<String>();
            tableHeaders1.add("RouteID"); 
            tableHeaders1.add("RouteName");
            tableHeaders1.add("Town ID");
            tableHeaders1.add("Town Name");
            
            RouteTown routeTown = (RouteTown)o;
    
            Town t =  routeDAO.getTown(routeTown.getId().getTownId());
            Route r =  routeDAO.getRoute(routeTown.getId().getRouteId().toString());

            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(routeTown.getId().getRouteId());
            oneRow.add(r.getName());
            oneRow.add(routeTown.getId().getTownId());
            oneRow.add(t.getName());
            tableData.add(oneRow);
          }
          if(num ==1)
            resultTable.setModel(new DefaultTableModel(tableData, tableHeaders1));
          else
              deleteTable.setModel(new DefaultTableModel(tableData, tableHeaders1));
        }
          else {
            JOptionPane.showMessageDialog(null, "No matches found. Please try again", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            routeIDViewTextField.setText("");
            routeIDViewTextField.requestFocus();
             routeIDDeleteTextField.setText("");
            routeIDDeleteTextField.requestFocus();
            deleteTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
            resultTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
        }
    }
    
    
    private void showRouteTownRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRouteTownRadioBtnActionPerformed
        displayRouteTown(0);
    }//GEN-LAST:event_showRouteTownRadioBtnActionPerformed

    private void showRouteRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRouteRadioBtnActionPerformed
        displayAllRoute(0);
    }//GEN-LAST:event_showRouteRadioBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void showDriverRouteRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDriverRouteRadioBtnActionPerformed
        displayDriverRoute(0);
    }//GEN-LAST:event_showDriverRouteRadioBtnActionPerformed

    private void showDriverRouteViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDriverRouteViewButtonActionPerformed
        displayDriverRoute(1);
    }//GEN-LAST:event_showDriverRouteViewButtonActionPerformed

    private void routeIDAssignComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeIDAssignComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routeIDAssignComboBoxActionPerformed
    
     private void displayDriverRoute(int num) {
        List myresultList = null;
        if(num == 1)
            myresultList  = routeDAO.getDriverRoute(routeIDViewTextField.getText());
        else if(num == 0)
            myresultList  = routeDAO.getDriverRoute(routeIDDeleteTextField.getText());
                            
        if (!myresultList.isEmpty())     {
            
             tableHeaders1 = new Vector<String>();
            tableHeaders1.add("RouteID"); 
            tableHeaders1.add("RouteName");
            tableHeaders1.add("Driver ID");
            tableHeaders1.add("Driver Name");
            Vector tableData = new Vector();
       
       for(Object o : myresultList ) {
           DriverRoute driverRoute= (DriverRoute)o;
    
          Driver d =  routeDAO.getDriver(driverRoute.getId().getDriverId());
          Route r =  routeDAO.getRoute(String.valueOf(driverRoute.getId().getRouteId()));
          
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(driverRoute.getId().getRouteId());
            oneRow.add(r.getName());
            oneRow.add(driverRoute.getId().getDriverId());
            oneRow.add(d.getId().getName());
            tableData.add(oneRow);
          }
          if(num ==1)
            resultTable.setModel(new DefaultTableModel(tableData, tableHeaders1));
          else
              deleteTable.setModel(new DefaultTableModel(tableData, tableHeaders1));
        }
          else {
            JOptionPane.showMessageDialog(null, "No matches found. Please try again!!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            routeIDViewTextField.setText("");
            routeIDViewTextField.requestFocus();
            routeIDDeleteTextField.setText("");
            routeIDDeleteTextField.requestFocus();
            deleteTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
            resultTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders1));
       }
    }
    
    
    
    
    private void addRouteData(){
      if ( routeValidate.IDValidation(routeID)){
          if( routeValidate.nameValidation(routeName) ){
              if(routeValidate.daysValidation(days)) {
                  if(routeValidate.distanceValidation(distance)){
                       if( routeValidate.isUnique(routeID) )
                            {
                                int response = JOptionPane.showConfirmDialog(null, "Do you want to add the record?", "Confirm",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                if (response == JOptionPane.YES_OPTION) {
                                  routeDAO.addRoute(new Route(Integer.parseInt(routeID), routeName,Integer.parseInt(days),Integer.parseInt(distance)));
                                  JOptionPane.showMessageDialog(this, "Route Data is Successfully Added to Database!!", "Success", WIDTH);
                                  routeIDTextField.setText("");
                                  routeIDTextField.setText("");
                                  routeNameTextField.setText("");
                                  routeDaysTextField.setText("");
                                  routeDistanceTextField.setText("");
                                  routeIDTextField.requestFocus();   
                                }
                            }
                            else {
                               JOptionPane.showMessageDialog(this, "Database Error!!", "Error", JOptionPane.ERROR_MESSAGE);
                            }          
       }
      else
      {
          routeDistanceTextField.setText("");
          routeDistanceTextField.requestFocus();
        }
     }
     else{
        routeDaysTextField.setText("");
        routeDaysTextField.setText("");
                
             }
          }
     else{
          routeNameTextField.setText("");
          routeNameTextField.requestFocus();
           }
      }
     else{
        routeIDTextField.setText("");
        routeIDTextField.requestFocus();
      }
    }
    
   public void addRouteIDComboBoxData(){
         routeIDList = routeDAO.getAllRouteID();
       DefaultComboBoxModel dcb = new DefaultComboBoxModel();
     
        if (routeIDList != null)     {
        for(int i =0 ; i < routeIDList.size();i++){
                dcb.addElement(routeIDList.get(i));
            }     
            routeIDAssignComboBox.setModel(dcb);
            routeIDDriverAssignComboBox.setModel(dcb);
       }
   }
  
    public void addDriverIDComboBoxData(){
         driverIDList = routeDAO.getAllDriverID();
       DefaultComboBoxModel dcb = new DefaultComboBoxModel();
     
        if (driverIDList != null)     {
        for(int i =0 ; i < driverIDList.size();i++){
                dcb.addElement(driverIDList.get(i));
            }     
            driverIDAssignComboBox.setModel(dcb);
       }
   }
  
     private void getTowns() {
         resultList = routeDAO.getAllTowns();
        Vector tableHeaders1 = new Vector();
        Vector tableData = new Vector();
        
        
        if (resultList != null)     {
            tableHeaders1 = new Vector<String>();
            tableHeaders1.add("Town ID");
            tableHeaders1.add("Town Name");
        
            for (Object o : resultList) {
                Town town = (Town) o;
                
                Vector<Object> oneRow = new Vector<Object>();
                oneRow.add(town.getId());
                oneRow.add(town.getName());
                tableData.add(oneRow);
            }
         addTownTable.setModel(new DefaultTableModel(tableData, tableHeaders1));
            }     
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddJPanel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPanel DeleteJPanel;
    private javax.swing.JPanel EditJPanel;
    private javax.swing.JTabbedPane RoutePane;
    private javax.swing.JPanel ViewJPanel;
    private javax.swing.JButton addAddButton;
    private javax.swing.JTable addTownTable;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton cleaAddrButton;
    private javax.swing.JButton clearDeleteButton;
    private javax.swing.JButton clearEditButton;
    private javax.swing.JTable deleteTable;
    private javax.swing.JComboBox driverIDAssignComboBox;
    private javax.swing.JPanel driverRouteAddJPanel;
    private javax.swing.JButton driverRouteAddSaveButton;
    private javax.swing.JButton editEditButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitEditButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField routeDaysEditTextField;
    private javax.swing.JLabel routeDaysLabel;
    private javax.swing.JTextField routeDaysTextField;
    private javax.swing.JTextField routeDistanceEditTextField;
    private javax.swing.JLabel routeDistanceLabel;
    private javax.swing.JTextField routeDistanceTextField;
    private javax.swing.JComboBox routeIDAssignComboBox;
    private javax.swing.JLabel routeIDDeleteLabel;
    private javax.swing.JTextField routeIDDeleteTextField;
    private javax.swing.JComboBox routeIDDriverAssignComboBox;
    private javax.swing.JTextField routeIDEditTextField;
    private javax.swing.JLabel routeIDLabel;
    private javax.swing.JTextField routeIDTextField;
    private javax.swing.JLabel routeIDViewLabel;
    private javax.swing.JTextField routeIDViewTextField;
    private javax.swing.JTextField routeNameEditTextField;
    private javax.swing.JLabel routeNameLabel;
    private javax.swing.JTextField routeNameTextField;
    private javax.swing.JButton routeTownAddButton;
    private javax.swing.JPanel routeTownAddJPanel;
    private javax.swing.JRadioButton showDriverRouteRadioBtn;
    private javax.swing.JButton showDriverRouteViewButton;
    private javax.swing.JButton showEditButton;
    private javax.swing.JRadioButton showRouteRadioBtn;
    private javax.swing.JButton showRouteTownButton;
    private javax.swing.JRadioButton showRouteTownRadioBtn;
    private javax.swing.JButton showRouteVIewButton;
    // End of variables declaration//GEN-END:variables
}
