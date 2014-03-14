/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.ui;
//import db.validate.RouteVallidate;
import db.dao.RouteDAO;
import db.entity.Route;
import db.validate.RouteVallidate;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.hibernate.type.YesNoType;
/**
 *
 * @author userr
 */
public class RouteWindow extends javax.swing.JFrame {

    private RouteVallidate routeValidate = RouteVallidate.createInstance();
    private RouteDAO routeDAO = RouteDAO.create();
    private static RouteWindow routeWindow = null;
    private String routeID, routeName, days, distance;
    /**
     * Creates new form RouteWindow
     */
    public RouteWindow() {
        
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex){
            }
        initComponents();
        
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
        EditJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        routeIDEditTextField = new javax.swing.JTextField();
        routeNameEditTextField = new javax.swing.JTextField();
        routeDaysEditTextField = new javax.swing.JTextField();
        routeDistanceEditTextField = new javax.swing.JTextField();
        editEditButton = new javax.swing.JButton();
        clearEditButton = new javax.swing.JButton();
        exitEditButton = new javax.swing.JButton();
        showEditButton = new javax.swing.JButton();
        DeleteJPanel = new javax.swing.JPanel();
        routeIDDeleteLabel = new javax.swing.JLabel();
        routeIDDeleteTextField = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        exitDeleteButton = new javax.swing.JButton();
        ViewJPanel = new javax.swing.JPanel();
        routeIDViewLabel = new javax.swing.JLabel();
        showVIewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        routeIDViewTextField = new javax.swing.JTextField();
        showAllRouteViewTextField = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout AddJPanelLayout = new javax.swing.GroupLayout(AddJPanel);
        AddJPanel.setLayout(AddJPanelLayout);
        AddJPanelLayout.setHorizontalGroup(
            AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(18, 18, 18)
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(cleaAddrButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addAddButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        AddJPanelLayout.setVerticalGroup(
            AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(routeDaysLabel)))
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cleaAddrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(AddJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(routeDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(routeDistanceLabel)))
                    .addGroup(AddJPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        RoutePane.addTab("Add", AddJPanel);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Route ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Route Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Days");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Distances");

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

        showEditButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        showEditButton.setText("Show");
        showEditButton.setToolTipText("Show the route details");
        showEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditJPanelLayout = new javax.swing.GroupLayout(EditJPanel);
        EditJPanel.setLayout(EditJPanelLayout);
        EditJPanelLayout.setHorizontalGroup(
            EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditJPanelLayout.createSequentialGroup()
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditJPanelLayout.createSequentialGroup()
                        .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditJPanelLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditJPanelLayout.createSequentialGroup()
                                .addContainerGap(33, Short.MAX_VALUE)
                                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(showEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(editEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addGap(22, 22, 22)
                        .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(routeDistanceEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(routeDaysEditTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(routeNameEditTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(routeIDEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );
        EditJPanelLayout.setVerticalGroup(
            EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditJPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(routeIDEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeNameEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeDaysEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routeDistanceEditTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(55, 55, 55)
                .addGroup(EditJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitEditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
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

        jButton1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(routeIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DeleteJPanelLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitDeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeIDDeleteTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        DeleteJPanelLayout.setVerticalGroup(
            DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteJPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(routeIDDeleteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routeIDDeleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(DeleteJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        RoutePane.addTab("Delete", DeleteJPanel);

        routeIDViewLabel.setText("Route ID");

        showVIewButton.setFont(new java.awt.Font("Andalus", 1, 12)); // NOI18N
        showVIewButton.setText("Show");
        showVIewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showVIewButtonActionPerformed(evt);
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(resultTable);

        routeIDViewTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routeIDViewTextFieldActionPerformed(evt);
            }
        });

        showAllRouteViewTextField.setFont(new java.awt.Font("Andalus", 1, 12)); // NOI18N
        showAllRouteViewTextField.setText("Show All Route");

        javax.swing.GroupLayout ViewJPanelLayout = new javax.swing.GroupLayout(ViewJPanel);
        ViewJPanel.setLayout(ViewJPanelLayout);
        ViewJPanelLayout.setHorizontalGroup(
            ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(routeIDViewLabel)
                .addGap(32, 32, 32)
                .addComponent(routeIDViewTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showVIewButton)
                .addGap(33, 33, 33)
                .addComponent(showAllRouteViewTextField)
                .addGap(58, 58, 58))
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewJPanelLayout.setVerticalGroup(
            ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewJPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showVIewButton)
                        .addComponent(showAllRouteViewTextField))
                    .addGroup(ViewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(routeIDViewLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(routeIDViewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        RoutePane.addTab("View", ViewJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RoutePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RoutePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        routeName = routeNameTextField.getText().trim();
        days = routeDaysTextField.getText().trim();
        distance = routeDistanceTextField.getText().trim();
        
    }//GEN-LAST:event_editEditButtonActionPerformed

    private void showVIewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showVIewButtonActionPerformed
      displayResult( (List)routeDAO.getRoute(routeIDViewTextField.getText()));
    }//GEN-LAST:event_showVIewButtonActionPerformed

    private void routeIDViewTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routeIDViewTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routeIDViewTextFieldActionPerformed

    private void showEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEditButtonActionPerformed
     
        if (routeDAO.isExist(routeIDEditTextField.getText()))
        {       
            Route myroute = routeDAO.getRoute( routeIDEditTextField.getText());
            routeNameEditTextField.setText(myroute.getName());
            routeDaysEditTextField.setText(Integer.toString(myroute.getDays()));
            routeDistanceEditTextField.setText(Integer.toString(myroute.getDistance()));
       }
        
    }//GEN-LAST:event_showEditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       
       JDialog.setDefaultLookAndFeelDecorated(true);
    int response = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
       Route myroute =  routeDAO.getRoute(routeIDDeleteTextField.getText());
       routeDAO.deleteRoute(myroute);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        routeIDDeleteTextField.setText("");
        routeIDEditTextField.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addRouteData(){
      if ( routeValidate.IDValidation(routeID)  && routeValidate.nameValidation(routeName) 
               && routeValidate.daysValidation(days) && routeValidate.distanceValidation(distance)  ){
         if( routeValidate.isUnique(routeID) )
         {
                routeDAO.addRoute(new Route(Integer.parseInt(routeID), routeName,Integer.parseInt(days),Integer.parseInt(distance)));
                 JOptionPane.showMessageDialog(this, "Route Data is Successfully Updated", "Success", WIDTH);
         } 
         else {
                    JOptionPane.showMessageDialog(this, "Database Error", "Error", JOptionPane.ERROR_MESSAGE);
         }          
       }
    }
    
     private void displayResult(List resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("RouteID"); 
        tableHeaders.add("RouteName");
        tableHeaders.add("Days");
        tableHeaders.add("Distance");

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
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddJPanel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPanel DeleteJPanel;
    private javax.swing.JPanel EditJPanel;
    private javax.swing.JTabbedPane RoutePane;
    private javax.swing.JPanel ViewJPanel;
    private javax.swing.JButton addAddButton;
    private javax.swing.JButton cleaAddrButton;
    private javax.swing.JButton clearEditButton;
    private javax.swing.JButton editEditButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitDeleteButton;
    private javax.swing.JButton exitEditButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField routeDaysEditTextField;
    private javax.swing.JLabel routeDaysLabel;
    private javax.swing.JTextField routeDaysTextField;
    private javax.swing.JTextField routeDistanceEditTextField;
    private javax.swing.JLabel routeDistanceLabel;
    private javax.swing.JTextField routeDistanceTextField;
    private javax.swing.JLabel routeIDDeleteLabel;
    private javax.swing.JTextField routeIDDeleteTextField;
    private javax.swing.JTextField routeIDEditTextField;
    private javax.swing.JLabel routeIDLabel;
    private javax.swing.JTextField routeIDTextField;
    private javax.swing.JLabel routeIDViewLabel;
    private javax.swing.JTextField routeIDViewTextField;
    private javax.swing.JTextField routeNameEditTextField;
    private javax.swing.JLabel routeNameLabel;
    private javax.swing.JTextField routeNameTextField;
    private javax.swing.JButton showAllRouteViewTextField;
    private javax.swing.JButton showEditButton;
    private javax.swing.JButton showVIewButton;
    // End of variables declaration//GEN-END:variables
}
