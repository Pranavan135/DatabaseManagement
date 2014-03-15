/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui;
//import db.validate.RouteVallidate;
import db.dao.RouteDAO;
import db.entity.Route;
import db.entity.RouteTown;
import db.entity.RouteTownId;
import db.validate.RouteVallidate;
import java.awt.EventQueue;
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
//import org.hibernate.type.YesNoType;
/**
 *
 * @author userr
 */
public class RouteWindow extends javax.swing.JFrame {

    private RouteVallidate routeValidate = RouteVallidate.createInstance();
    private RouteDAO routeDAO = RouteDAO.create();
    private static RouteWindow routeWindow = null;
    private String routeID, routeName, days, distance;
    private List<Integer> routeIDList , townIDList;
    private Vector<String> tableHeaders;
    /**
     * Creates new form RouteWindow
     */
    public RouteWindow() {
        
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex){
            }
        initComponents();
        routeNameEditTextField.setEnabled(false);
        routeDaysEditTextField.setEnabled(false);
        routeDistanceEditTextField.setEnabled(false);
        tableHeaders = new Vector<String>();
        tableHeaders.add("RouteID"); 
        tableHeaders.add("RouteName");
        tableHeaders.add("Days");
        tableHeaders.add("Distance");
          
    }

   public static RouteWindow create(){
        if (routeWindow == null){
            routeWindow = new RouteWindow();}
            return routeWindow;
        
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        routeTownAddSaveButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        routeIDAssignComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        townIDAssignComboBox = new javax.swing.JComboBox();
        routeTownAddButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        EditJPanel = new javax.swing.JPanel();
        EditRouteTwonPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        routeIDEditComboBox = new javax.swing.JComboBox();
        townIDEditComboBox = new javax.swing.JComboBox();
        routeTownEditUpdateButton = new javax.swing.JButton();
        routeTownEditDeleteButton = new javax.swing.JButton();
        EditRoutePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        routeDaysEditTextField = new javax.swing.JTextField();
        routeIDEditTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        routeNameEditTextField = new javax.swing.JTextField();
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
        exitDeleteButton = new javax.swing.JButton();
        ViewJPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        routeIDViewLabel = new javax.swing.JLabel();
        routeIDViewTextField = new javax.swing.JTextField();
        showRouteVIewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        routeTownViewButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RoutePane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        RoutePane.setPreferredSize(new java.awt.Dimension(700, 500));

        routeIDLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeIDLabel.setText("Route ID");

        routeNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeNameLabel.setText("Route Name");

        routeDaysLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeDaysLabel.setText("Days");

        routeDistanceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        routeDistanceLabel.setText("Distance");

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

        routeTownAddSaveButton.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assign Route_Town ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel5.setText("Select Route ID");

        routeIDAssignComboBox.setModel(new javax.swing.DefaultComboBoxModel<Integer>(addRouteIDComboBoxData())
        );

        jLabel6.setText("Select Town ID ");

        townIDAssignComboBox.setModel(new javax.swing.DefaultComboBoxModel<Integer>
            (addTownIDComboBoxData())
        );
        townIDAssignComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townIDAssignComboBoxActionPerformed(evt);
            }
        });

        routeTownAddButton.setText("Save");
        routeTownAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeTownAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout routeTownAddSaveButtonLayout = new javax.swing.GroupLayout(routeTownAddSaveButton);
        routeTownAddSaveButton.setLayout(routeTownAddSaveButtonLayout);
        routeTownAddSaveButtonLayout.setHorizontalGroup(
            routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(routeTownAddSaveButtonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(routeTownAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(routeTownAddSaveButtonLayout.createSequentialGroup()
                        .addGroup(routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(routeIDAssignComboBox, 0, 575, Short.MAX_VALUE)
                            .addComponent(townIDAssignComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        routeTownAddSaveButtonLayout.setVerticalGroup(
            routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(routeTownAddSaveButtonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeIDAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(routeTownAddSaveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(townIDAssignComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(routeTownAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AddJPanelLayout = new javax.swing.GroupLayout(AddJPanel);
        AddJPanel.setLayout(AddJPanelLayout);
        AddJPanelLayout.setHorizontalGroup(
            AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(routeTownAddSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(AddJPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(routeNameLabel)
                        .addComponent(routeDaysLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(routeDistanceLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(routeIDLabel))
                .addGap(131, 131, 131)
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(routeDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeDaysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(addAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cleaAddrButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        AddJPanelLayout.setVerticalGroup(
            AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddJPanelLayout.createSequentialGroup()
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeIDLabel)
                            .addComponent(addAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddJPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(routeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(routeNameLabel))
                                .addGap(18, 18, 18)
                                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(routeDaysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(routeDaysLabel))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddJPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cleaAddrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))))
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeDistanceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(routeTownAddSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        RoutePane.addTab("Add", AddJPanel);

        EditRouteTwonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Edit Route Town"));

        jLabel7.setText("Select Route ID");

        jLabel8.setText("Select Town ID One By One");

        routeIDEditComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeIDEditComboBoxActionPerformed(evt);
            }
        });

        routeTownEditUpdateButton.setText("Update Route_Town");
        routeTownEditUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeTownEditUpdateButtonActionPerformed(evt);
            }
        });

        routeTownEditDeleteButton.setText("Delete Route_Town");
        routeTownEditDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeTownEditDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditRouteTwonPanelLayout = new javax.swing.GroupLayout(EditRouteTwonPanel);
        EditRouteTwonPanel.setLayout(EditRouteTwonPanelLayout);
        EditRouteTwonPanelLayout.setHorizontalGroup(
            EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditRouteTwonPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(66, 66, 66)
                .addGroup(EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(routeIDEditComboBox, 0, 526, Short.MAX_VALUE)
                    .addComponent(townIDEditComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditRouteTwonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(routeTownEditUpdateButton)
                .addGap(38, 38, 38)
                .addComponent(routeTownEditDeleteButton)
                .addGap(36, 36, 36))
        );
        EditRouteTwonPanelLayout.setVerticalGroup(
            EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditRouteTwonPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(routeIDEditComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(townIDEditComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(EditRouteTwonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeTownEditUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeTownEditDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        EditRoutePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Edit Route Details\n"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Enter Route ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Days");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Route Name");

        routeNameEditTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeNameEditTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        javax.swing.GroupLayout EditRoutePanelLayout = new javax.swing.GroupLayout(EditRoutePanel);
        EditRoutePanel.setLayout(EditRoutePanelLayout);
        EditRoutePanelLayout.setHorizontalGroup(
            EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditRoutePanelLayout.createSequentialGroup()
                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(routeDistanceEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EditRoutePanelLayout.createSequentialGroup()
                        .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(showEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGap(30, 30, 30)
                        .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(routeNameEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(editEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(clearEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)))))
                            .addComponent(routeIDEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditRoutePanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditRoutePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(routeDaysEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 96, Short.MAX_VALUE))
        );
        EditRoutePanelLayout.setVerticalGroup(
            EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditRoutePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeIDEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeDaysEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(routeNameEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(routeDistanceEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(EditRoutePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEditButton)
                    .addComponent(clearEditButton)
                    .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout EditJPanelLayout = new javax.swing.GroupLayout(EditJPanel);
        EditJPanel.setLayout(EditJPanelLayout);
        EditJPanelLayout.setHorizontalGroup(
            EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditRouteTwonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditRoutePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EditJPanelLayout.setVerticalGroup(
            EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(EditRoutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditRouteTwonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RoutePane.addTab("Edit", EditJPanel);

        routeIDDeleteLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        routeIDDeleteLabel.setText("Route ID");

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

        exitDeleteButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        exitDeleteButton.setText("Exit");
        exitDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeleteJPanelLayout = new javax.swing.GroupLayout(DeleteJPanel);
        DeleteJPanel.setLayout(DeleteJPanelLayout);
        DeleteJPanelLayout.setHorizontalGroup(
            DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteJPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(routeIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(routeIDDeleteTextField))
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(clearDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(exitDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
        );
        DeleteJPanelLayout.setVerticalGroup(
            DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteJPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton)
                    .addComponent(exitDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(462, Short.MAX_VALUE))
        );

        RoutePane.addTab("Delete", DeleteJPanel);

        ViewJPanel.setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Route Details\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        routeIDViewLabel.setText("Enter Route ID");

        routeIDViewTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeIDViewTextFieldActionPerformed(evt);
            }
        });

        showRouteVIewButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showRouteVIewButton.setText("Show");
        showRouteVIewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showRouteVIewButtonActionPerformed(evt);
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
                "Route ID", "Route Name", "Days", "Distance"
            }
        ));
        resultTable.setShowHorizontalLines(false);
        resultTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(resultTable);

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(routeIDViewLabel)
                        .addGap(50, 50, 50)
                        .addComponent(routeIDViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(showRouteVIewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeIDViewLabel)
                            .addComponent(routeIDViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showRouteVIewButton)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Route Town Details\n"));

        jLabel9.setText("Enter Route ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Route ID", "Town ID", "Town Name"
            }
        ));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTable1);

        routeTownViewButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        routeTownViewButton.setText("Show");
        routeTownViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeTownViewButtonActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(routeTownViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(routeTownViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout ViewJPanelLayout = new javax.swing.GroupLayout(ViewJPanel);
        ViewJPanel.setLayout(ViewJPanelLayout);
        ViewJPanelLayout.setHorizontalGroup(
            ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewJPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ViewJPanelLayout.setVerticalGroup(
            ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        RoutePane.addTab("View", ViewJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RoutePane, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RoutePane, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
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
        
        if (  routeValidate.nameValidation(routeName)  && routeValidate.daysValidation(days) && routeValidate.distanceValidation(distance)  ){
                routeDAO.updateRoute(new Route(Integer.parseInt(routeID), routeName,Integer.parseInt(days),Integer.parseInt(distance)));
                 JOptionPane.showMessageDialog(this, "Route Data is Successfully Updated", "Success", WIDTH);
         } 
         else {
                    JOptionPane.showMessageDialog(this, "Database Error ", "Error", JOptionPane.ERROR_MESSAGE);
         }          
    }//GEN-LAST:event_editEditButtonActionPerformed

    private void showRouteVIewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showRouteVIewButtonActionPerformed
      displayAllRoute(routeIDViewTextField.getText());
      
    }//GEN-LAST:event_showRouteVIewButtonActionPerformed

    private void routeIDViewTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeIDViewTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routeIDViewTextFieldActionPerformed

    private void showEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEditButtonActionPerformed
        
        routeIDEditTextField.setEditable(false);
        routeNameEditTextField.setEnabled(true);
        routeDaysEditTextField.setEnabled(true);
        routeDistanceEditTextField.setEnabled(true);
        
        if (routeDAO.isExist(routeIDEditTextField.getText()))
        {       
            Route myroute = routeDAO.getRoute( routeIDEditTextField.getText());
            routeNameEditTextField.setText(myroute.getName());
            routeDaysEditTextField.setText(Integer.toString(myroute.getDays()));
            routeDistanceEditTextField.setText(Integer.toString(myroute.getDistance()));
       }
        else
        {
            JOptionPane.showMessageDialog(this, "Id does not exist!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_showEditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       
       JDialog.setDefaultLookAndFeelDecorated(true);
    int response = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
        if(routeDAO.isExist(routeIDDeleteTextField.getText())){
       Route myroute =  routeDAO.getRoute(routeIDDeleteTextField.getText());
       
       boolean response1 = routeDAO.deleteRoute(myroute);
       if(response1)
           JOptionPane.showMessageDialog(this, "Route Detail is Successfully Deleted into Database", "Success", WIDTH);
               else
                   JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
      } 
        else{
            JOptionPane.showMessageDialog(null, "Please enter the existing id!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            routeIDDeleteTextField.setText("");
            routeIDDeleteTextField.requestFocus();
        }   
    }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void clearEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearEditButtonActionPerformed
        routeIDEditTextField.setText("");
        routeNameEditTextField.setText("");
        routeDaysEditTextField.setText("");
        routeDistanceEditTextField.setText("");
        routeIDEditTextField.requestFocus();
    }//GEN-LAST:event_clearEditButtonActionPerformed

    private void exitDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitDeleteButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitDeleteButtonActionPerformed

    private void clearDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDeleteButtonActionPerformed
        routeIDDeleteTextField.setText("");
        routeIDEditTextField.requestFocus();
    }//GEN-LAST:event_clearDeleteButtonActionPerformed

    private void townIDAssignComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townIDAssignComboBoxActionPerformed

    }//GEN-LAST:event_townIDAssignComboBoxActionPerformed

    private void routeTownAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeTownAddButtonActionPerformed
         
        if(routeIDAssignComboBox.getSelectedIndex() == -1){
             JOptionPane.showMessageDialog(null, "Please select the route ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           else  if(townIDAssignComboBox.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Please select the town ID", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
           else{
               
            //   JOptionPane.showMessageDialog(this, new RouteTown(Integer.valueOf(routeIDAssignComboBox.getSelectedItem().toString()),Integer.valueOf((String)townIDAssignComboBox.getSelectedItem().toString())).getRouteId(), "Success", WIDTH);
               boolean response =  routeDAO.addRouteTown(new RouteTown(Integer.valueOf(routeIDAssignComboBox.getSelectedItem().toString()),Integer.valueOf((String)townIDAssignComboBox.getSelectedItem().toString())));
               if (response)
                JOptionPane.showMessageDialog(this, "Route_Town Detail is Successfully Added into Database", "Success", WIDTH);
               else
                   JOptionPane.showMessageDialog(null, "Database Error!!", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
       
        
    }//GEN-LAST:event_routeTownAddButtonActionPerformed

    private void routeTownEditUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeTownEditUpdateButtonActionPerformed
        if(routeIDEditComboBox.getSelectedIndex() == -1){
             JOptionPane.showMessageDialog(null, "Please select the route ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           else  if(townIDEditComboBox.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Please select the town ID", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
           else{
                routeDAO.addRouteTown(new RouteTown((Integer)(routeIDAssignComboBox.getSelectedItem()),(Integer)townIDAssignComboBox.getSelectedItem()));
                JOptionPane.showMessageDialog(this, "Town of a particular route is sucessfully updated in Database", "Success", WIDTH);
           }
       
    }//GEN-LAST:event_routeTownEditUpdateButtonActionPerformed

    private void routeTownEditDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeTownEditDeleteButtonActionPerformed
        if(routeIDEditComboBox.getSelectedIndex() == -1){
             JOptionPane.showMessageDialog(null, "Please select the route ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
           else  if(townIDEditComboBox.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Please select the town ID", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
           else{
                routeDAO.deleteRouteTown(new RouteTownId((Integer)(routeIDAssignComboBox.getSelectedItem()),(Integer)townIDAssignComboBox.getSelectedItem()));
                JOptionPane.showMessageDialog(this, "Town of a particular route is sucessfully updated in Database", "Success", WIDTH);
           }
    }//GEN-LAST:event_routeTownEditDeleteButtonActionPerformed

    private void routeNameEditTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeNameEditTextFieldActionPerformed
        
    }//GEN-LAST:event_routeNameEditTextFieldActionPerformed

    private void routeIDEditComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeIDEditComboBoxActionPerformed
        
    }//GEN-LAST:event_routeIDEditComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        routeIDViewTextField.setText("");
        routeIDViewTextField.requestFocus();
       resultTable.setModel(new javax.swing.table.DefaultTableModel(null, tableHeaders));
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void routeTownViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeTownViewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routeTownViewButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    
    private void addRouteData(){
      if ( routeValidate.IDValidation(routeID)  && routeValidate.nameValidation(routeName) 
               && routeValidate.daysValidation(days) && routeValidate.distanceValidation(distance)  ){
         if( routeValidate.isUnique(routeID) )
         {
                routeDAO.addRoute(new Route(Integer.parseInt(routeID), routeName,Integer.parseInt(days),Integer.parseInt(distance)));
                 JOptionPane.showMessageDialog(this, "Route Data is Successfully Updated", "Success", WIDTH);
         } 
         else {
                    JOptionPane.showMessageDialog(this, "Database Error ", "Error", JOptionPane.ERROR_MESSAGE);
         }          
       }
    }
    
   protected Vector<Integer> addRouteIDComboBoxData(){
         routeIDList = routeDAO.getAllRouteID();
         return new Vector<Integer>(routeIDList);
   
            }
      protected Vector<Integer> addTownIDComboBoxData(){
         townIDList = routeDAO.getAllTownID();
         return new Vector<Integer>(townIDList);    
      }
                    
    
     private void displayAllRoute(String referenceNo) {
        
       
         Vector tableData = new Vector();
        List resultList = routeDAO.searchOnReferenceNo(referenceNo);
      //  JOptionPane.showMessageDialog(null, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        
       // if (resultList.equals(null))
       //     JOptionPane.showMessageDialog(null, "hi","ERROR", JOptionPane.INFORMATION_MESSAGE);
        
        if (!resultList.isEmpty())     {
            
       for(Object o : resultList) {
        Route route = (Route)o;
        Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(route.getId());
        oneRow.add(route.getName());
        oneRow.add(route.getDays());
        oneRow.add(route.getDistance());
        tableData.add(oneRow);
          }
       resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        }
          else {
            JOptionPane.showMessageDialog(null, "No matches found. Please try again", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
       
    
}
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddJPanel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPanel DeleteJPanel;
    private javax.swing.JPanel EditJPanel;
    private javax.swing.JPanel EditRoutePanel;
    private javax.swing.JPanel EditRouteTwonPanel;
    private javax.swing.JTabbedPane RoutePane;
    private javax.swing.JPanel ViewJPanel;
    private javax.swing.JButton addAddButton;
    private javax.swing.JButton cleaAddrButton;
    private javax.swing.JButton clearDeleteButton;
    private javax.swing.JButton clearEditButton;
    private javax.swing.JButton editEditButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitDeleteButton;
    private javax.swing.JButton exitEditButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
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
    private javax.swing.JComboBox routeIDEditComboBox;
    private javax.swing.JTextField routeIDEditTextField;
    private javax.swing.JLabel routeIDLabel;
    private javax.swing.JTextField routeIDTextField;
    private javax.swing.JLabel routeIDViewLabel;
    private javax.swing.JTextField routeIDViewTextField;
    private javax.swing.JTextField routeNameEditTextField;
    private javax.swing.JLabel routeNameLabel;
    private javax.swing.JTextField routeNameTextField;
    private javax.swing.JButton routeTownAddButton;
    private javax.swing.JPanel routeTownAddSaveButton;
    private javax.swing.JButton routeTownEditDeleteButton;
    private javax.swing.JButton routeTownEditUpdateButton;
    private javax.swing.JButton routeTownViewButton;
    private javax.swing.JButton showEditButton;
    private javax.swing.JButton showRouteVIewButton;
    private javax.swing.JComboBox townIDAssignComboBox;
    private javax.swing.JComboBox townIDEditComboBox;
    // End of variables declaration//GEN-END:variables
}
