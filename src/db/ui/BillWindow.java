/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.ui;

import db.entity.Bill;
import db.dao.BillDAO;
import db.entity.Hotel;
import db.entity.Tour;
import db.validate.BillValidate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DELL
 */
public class BillWindow extends javax.swing.JFrame {

    /**
     * Creates new form BillWindow
     */
    private BillDAO billDAO = BillDAO.create();
    private BillValidate billValidate = BillValidate.create();
    private static BillWindow billWindow = null;
    private String editReference = "";
    
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
        referenceNoTextField = new javax.swing.JTextField();
        exitButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        billDateChooser = new com.toedter.calendar.JDateChooser();
        HotelTownScrollPane = new javax.swing.JScrollPane();
        hotelTownTable = new javax.swing.JTable();
        tourCodeScrollPane = new javax.swing.JScrollPane();
        tourCodelist = new javax.swing.JList();
        paidCheckBox = new javax.swing.JCheckBox();
        editBillsTab = new javax.swing.JPanel();
        edittourCodeLabel1 = new javax.swing.JLabel();
        editreferenceNoLabel1 = new javax.swing.JLabel();
        editamountLabel1 = new javax.swing.JLabel();
        edittownIDTextField1 = new javax.swing.JTextField();
        editnumberOfIndvidualsTextField1 = new javax.swing.JTextField();
        editamountTextField1 = new javax.swing.JTextField();
        edithotelIDLabel1 = new javax.swing.JLabel();
        editbillDateLabel1 = new javax.swing.JLabel();
        editnumberOfIndvidualsLabel1 = new javax.swing.JLabel();
        edittourCodeTextField1 = new javax.swing.JTextField();
        edithotelIDtextField1 = new javax.swing.JTextField();
        editreferenceNoTextField1 = new javax.swing.JTextField();
        editexitButton1 = new javax.swing.JButton();
        fetchButton = new javax.swing.JButton();
        editclearButton1 = new javax.swing.JButton();
        editbillDateChooser1 = new com.toedter.calendar.JDateChooser();
        edithotelTownScrollPane = new javax.swing.JScrollPane();
        edithotelTownTable1 = new javax.swing.JTable();
        edittourCodeScrollPane = new javax.swing.JScrollPane();
        edittourCodelist1 = new javax.swing.JList();
        editButton = new javax.swing.JButton();
        editPaid = new javax.swing.JCheckBox();
        deleteBillsTab = new javax.swing.JPanel();
        deleteReferenceLabel = new javax.swing.JLabel();
        deleteReferenceTextField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        deleteTable = new javax.swing.JTable();
        deleteFetchButton = new javax.swing.JButton();
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
        tourCodeLabel.setBounds(30, 160, 101, 30);

        referenceNoLabel.setText("Reference No");
        addBillsTab.add(referenceNoLabel);
        referenceNoLabel.setBounds(30, 30, 101, 25);

        amountLabel.setText("Amount");
        addBillsTab.add(amountLabel);
        amountLabel.setBounds(30, 80, 101, 38);

        townIDTextField.setEditable(false);
        addBillsTab.add(townIDTextField);
        townIDTextField.setBounds(550, 310, 80, 30);
        addBillsTab.add(numberOfIndvidualsTextField);
        numberOfIndvidualsTextField.setBounds(490, 80, 124, 33);
        addBillsTab.add(amountTextField);
        amountTextField.setBounds(190, 80, 124, 30);

        hotelIDLabel.setText("Hotel ID and Town ID");
        addBillsTab.add(hotelIDLabel);
        hotelIDLabel.setBounds(30, 260, 110, 30);

        billDateLabel.setText("Bill date (dd-MM-yyyy)");
        addBillsTab.add(billDateLabel);
        billDateLabel.setBounds(350, 30, 110, 30);

        numberOfIndvidualsLabel.setText("Number of Individuals");
        addBillsTab.add(numberOfIndvidualsLabel);
        numberOfIndvidualsLabel.setBounds(350, 90, 110, 14);

        tourCodeTextField.setEditable(false);
        addBillsTab.add(tourCodeTextField);
        tourCodeTextField.setBounds(300, 170, 140, 30);

        hotelIDtextField.setEditable(false);
        addBillsTab.add(hotelIDtextField);
        hotelIDtextField.setBounds(440, 310, 80, 30);
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
        exitButton.setBounds(450, 440, 140, 30);

        addButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addBillsTab.add(addButton);
        addButton.setBounds(110, 400, 160, 50);

        clearButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        addBillsTab.add(clearButton);
        clearButton.setBounds(450, 390, 140, 30);
        addBillsTab.add(billDateChooser);
        billDateChooser.setBounds(490, 30, 130, 30);
        billDateChooser.setMaxSelectableDate(new Date());

        hotelTownTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel ID", "Hotel Name", "Town ID", "Town Name"
            }
        ));
        hotelTownTable.setEnabled(false);
        hotelTownTable.setSelectionMode(SINGLE_SELECTION);
        hotelTownTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotelTownTableMouseClicked(evt);
            }
        });
        HotelTownScrollPane.setViewportView(hotelTownTable);

        addBillsTab.add(HotelTownScrollPane);
        HotelTownScrollPane.setBounds(30, 290, 400, 80);

        tourCodelist.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tourCodelist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        getTours();
        tourCodelist.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tourCodelistValueChanged(evt);
            }
        });
        tourCodeScrollPane.setViewportView(tourCodelist);

        addBillsTab.add(tourCodeScrollPane);
        tourCodeScrollPane.setBounds(190, 150, 80, 80);

        paidCheckBox.setText("Paid");
        addBillsTab.add(paidCheckBox);
        paidCheckBox.setBounds(530, 170, 81, 23);

        billsTab.addTab("ADD", addBillsTab);

        editBillsTab.setLayout(null);

        edittourCodeLabel1.setText("Tour Code");
        editBillsTab.add(edittourCodeLabel1);
        edittourCodeLabel1.setBounds(30, 160, 101, 30);

        editreferenceNoLabel1.setText("Reference No");
        editBillsTab.add(editreferenceNoLabel1);
        editreferenceNoLabel1.setBounds(30, 30, 101, 25);

        editamountLabel1.setText("Amount");
        editBillsTab.add(editamountLabel1);
        editamountLabel1.setBounds(30, 80, 101, 38);

        edittownIDTextField1.setEditable(false);
        editBillsTab.add(edittownIDTextField1);
        edittownIDTextField1.setBounds(550, 310, 80, 30);

        editnumberOfIndvidualsTextField1.setEnabled(false);
        editBillsTab.add(editnumberOfIndvidualsTextField1);
        editnumberOfIndvidualsTextField1.setBounds(510, 190, 124, 33);

        editamountTextField1.setEnabled(false);
        editBillsTab.add(editamountTextField1);
        editamountTextField1.setBounds(190, 80, 124, 30);

        edithotelIDLabel1.setText("Hotel ID and Town ID");
        editBillsTab.add(edithotelIDLabel1);
        edithotelIDLabel1.setBounds(30, 260, 110, 30);

        editbillDateLabel1.setText("Bill date (dd-MM-yyyy)");
        editBillsTab.add(editbillDateLabel1);
        editbillDateLabel1.setBounds(360, 130, 110, 30);

        editnumberOfIndvidualsLabel1.setText("Number of Individuals");
        editBillsTab.add(editnumberOfIndvidualsLabel1);
        editnumberOfIndvidualsLabel1.setBounds(360, 190, 110, 14);

        edittourCodeTextField1.setEditable(false);
        editBillsTab.add(edittourCodeTextField1);
        edittourCodeTextField1.setBounds(30, 200, 80, 30);

        edithotelIDtextField1.setEditable(false);
        editBillsTab.add(edithotelIDtextField1);
        edithotelIDtextField1.setBounds(440, 310, 80, 30);
        editBillsTab.add(editreferenceNoTextField1);
        editreferenceNoTextField1.setBounds(190, 30, 124, 28);

        editexitButton1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editexitButton1.setText("EXIT");
        editexitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editexitButton1ActionPerformed(evt);
            }
        });
        editBillsTab.add(editexitButton1);
        editexitButton1.setBounds(450, 440, 140, 30);

        fetchButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        fetchButton.setText("FETCH");
        fetchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchButtonActionPerformed(evt);
            }
        });
        editBillsTab.add(fetchButton);
        fetchButton.setBounds(450, 30, 120, 40);

        editclearButton1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editclearButton1.setText("CLEAR");
        editclearButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editclearButton1ActionPerformed(evt);
            }
        });
        editBillsTab.add(editclearButton1);
        editclearButton1.setBounds(450, 390, 140, 30);

        editbillDateChooser1.setEnabled(false);
        editBillsTab.add(editbillDateChooser1);
        editbillDateChooser1.setBounds(510, 130, 130, 30);
        editbillDateChooser1.setMaxSelectableDate(new Date());

        edithotelTownTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel ID", "Hotel Name", "Town ID", "Town Name"
            }
        ));
        edithotelTownTable1.setEnabled(false);
        edithotelTownTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        edithotelTownTable1.setRowSelectionAllowed(true);
        edithotelTownTable1.setSelectionMode(SINGLE_SELECTION);
        edithotelTownTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edithotelTownTable1MouseClicked(evt);
            }
        });
        edithotelTownScrollPane.setViewportView(edithotelTownTable1);

        editBillsTab.add(edithotelTownScrollPane);
        edithotelTownScrollPane.setBounds(30, 290, 400, 80);

        edittourCodeScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edittourCodeScrollPaneMouseClicked(evt);
            }
        });

        edittourCodelist1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        edittourCodelist1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        edittourCodelist1.setEnabled(false);
        getTours();
        edittourCodelist1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                edittourCodelist1ValueChanged(evt);
            }
        });
        edittourCodeScrollPane.setViewportView(edittourCodelist1);

        editBillsTab.add(edittourCodeScrollPane);
        edittourCodeScrollPane.setBounds(200, 160, 80, 80);

        editButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editButton.setText("EDIT");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        editBillsTab.add(editButton);
        editButton.setBounds(110, 400, 160, 50);

        editPaid.setText("Paid");
        editBillsTab.add(editPaid);
        editPaid.setBounds(370, 240, 110, 23);

        billsTab.addTab("EDIT", editBillsTab);

        deleteReferenceLabel.setText("Reference No");

        deleteButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        deleteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(deleteTable);
        //deleteTable.setSelectionMode(MULTIPLE_INTERVAL);

        deleteFetchButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        deleteFetchButton.setText("Fetch");
        deleteFetchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFetchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteBillsTabLayout = new javax.swing.GroupLayout(deleteBillsTab);
        deleteBillsTab.setLayout(deleteBillsTabLayout);
        deleteBillsTabLayout.setHorizontalGroup(
            deleteBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBillsTabLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(deleteReferenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(deleteReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteFetchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addContainerGap())
            .addGroup(deleteBillsTabLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        deleteBillsTabLayout.setVerticalGroup(
            deleteBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteBillsTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(deleteBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteReferenceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton)
                    .addComponent(deleteFetchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        billsTab.addTab("DELETE", deleteBillsTab);

        viewReferenceLabel.setText("Reference No");

        viewButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(viewTable);

        javax.swing.GroupLayout viewBillsTabLayout = new javax.swing.GroupLayout(viewBillsTab);
        viewBillsTab.setLayout(viewBillsTabLayout);
        viewBillsTabLayout.setHorizontalGroup(
            viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBillsTabLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(viewReferenceLabel)
                .addGap(101, 101, 101)
                .addComponent(viewReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addGap(61, 61, 61))
            .addGroup(viewBillsTabLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewBillsTabLayout.setVerticalGroup(
            viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewBillsTabLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(viewBillsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewReferenceLabel)
                    .addComponent(viewReferenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(22, 22, 22))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(billsTab, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void addData()  {
        String referenceNo = referenceNoTextField.getText();
        String tourCode = tourCodeTextField.getText();
        String townID = townIDTextField.getText();
        String hotelID = hotelIDtextField.getText();
        String numberOfIndividuals = numberOfIndvidualsTextField.getText();
        String amount = amountTextField.getText();
        Boolean paid = paidCheckBox.isSelected();
      
        if (!billValidate.validatReferenceNo(referenceNo)) {
            referenceNoTextField.setText("");
            referenceNo = "";
        }
        else if ( billDateChooser.getDate() == null )   {
             JOptionPane.showMessageDialog(null, "Please Select a date", "ERROR", JOptionPane.ERROR_MESSAGE);
             billDateChooser.cleanup();
        }
        else if (!billValidate.validateAmount(amount)) { 
            amountTextField.setText("");
            amount = "";
        }
        else if (!billValidate.validateIndividuals(numberOfIndividuals))    {
            numberOfIndvidualsTextField.setText("");
            numberOfIndividuals = "";
        }
        else if (!billValidate.validateNotNull(tourCode))   {
             JOptionPane.showMessageDialog(null, "Please select a TourCode", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         else if (!billValidate.validateNotNull(townID))   {
             JOptionPane.showMessageDialog(null, "Please Select a town", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         else if (!billValidate.validateNotNull(hotelID))   {
             JOptionPane.showMessageDialog(null, "Please Select a hotel", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else    {
             boolean response = billDAO.addBill(new Bill(Integer.parseInt(referenceNo),billDAO.getTown(townID), billDAO.getTour(tourCode), billDAO.getHotel(hotelID), billDateChooser.getDate(), Integer.parseInt(numberOfIndividuals), Double.parseDouble(amount), paid));
             
             if (response)  {
                JOptionPane.showMessageDialog(null, "You have successfully added the bill", "Confimation", JOptionPane.INFORMATION_MESSAGE);
                clearAdd();
             }
             else
             JOptionPane.showMessageDialog(null, "There is error in connection with database. Cannot add tha bill", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    private void getTours() {
        List resultList = billDAO.getAllTours();
        DefaultListModel listModel = new DefaultListModel();
        if (resultList != null)     {
            for (Object o : resultList) {
                Tour tour = (Tour) o;
                listModel.addElement(tour.getTourCode());       
            }
        tourCodelist.setModel(listModel);
        edittourCodelist1.setModel(listModel);
        }
        else {
            
        }
    }
   
    private void clearAdd() {
         referenceNoTextField.setText("");
        townIDTextField.setText("");
        tourCodeTextField.setText("");
        numberOfIndvidualsTextField.setText("");
        amountTextField.setText("");
        billDateChooser.setDate(null);
        hotelIDtextField.setText("");
        tourCodelist.clearSelection();
        hotelTownTable.clearSelection();
        billDateChooser.cleanup();
        paidCheckBox.setSelected(false);
    }
    
    private void changeTable(Set<Hotel> hotels, int a) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        
        tableHeaders.add("Hotel ID");
        tableHeaders.add("Hotel Name");
        tableHeaders.add("Town ID");
        tableHeaders.add("Town Name");
      
        
        if (!hotels.isEmpty()) {
            for (Hotel h : hotels) {
               
                Vector<Object> oneRow = new Vector<Object>();
                oneRow.add(h.getId());
                oneRow.add(h.getName());
                oneRow.add(h.getTown().getId());
                oneRow.add(h.getTown().getName());
                tableData.add(oneRow);
            }
       if (a == 1) {
            hotelTownTable.setModel(new DefaultTableModel(tableData, tableHeaders));
            hotelTownTable.setEnabled(true);
       }
       else
           edithotelTownTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
           edithotelTownTable1.setEnabled(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "There are no overnight stops please try again with another tour code", "ERROR", JOptionPane.ERROR_MESSAGE);
            tourCodelist.clearSelection();
            tourCodeTextField.setText("");
        }
        
    }  
    
    private void clearEdit()    {
        editreferenceNoTextField1.setText("");
        edittownIDTextField1.setText("");
        edittourCodeTextField1.setText("");
        editnumberOfIndvidualsTextField1.setText("");
        editnumberOfIndvidualsTextField1.setEnabled(false);
        editamountTextField1.setText("");
        editamountTextField1.setEnabled(false);
        editbillDateChooser1.setDate(null);
        editbillDateChooser1.setEnabled(false);
        edithotelIDtextField1.setText("");
        edittourCodelist1.clearSelection();
        edittourCodelist1.setEnabled(false);
        edithotelTownTable1.clearSelection();
        edithotelTownTable1.setEnabled(false);
    }
    
    private void editEnable()   {
        editamountTextField1.setEnabled(true);
        editnumberOfIndvidualsTextField1.setEnabled(true);
        editbillDateChooser1.setEnabled(true);
        edittourCodelist1.setEnabled(true);
        editButton.setEnabled(true);
        edithotelTownTable1.setEnabled(true);
    }
    
     private void viewBills(String referenceNo, int num) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        
        tableHeaders.add("Reference No");
        tableHeaders.add("Tour Code");
        tableHeaders.add("Town Name");
        tableHeaders.add("Hotel Name");
        tableHeaders.add("Bill date");
        tableHeaders.add("Person Count");
        tableHeaders.add("Amount");
        tableHeaders.add("Paid");
        
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
                oneRow.add(bill.getNumberOfIndividuals());
                oneRow.add(bill.getAmount());
                oneRow.add(bill.getPaid());
                tableData.add(oneRow);
            }
        if (num == 1)   
            viewTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        else 
            deleteTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        }
        else {
            JOptionPane.showMessageDialog(null, "No matches found. Please try again", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addData();
    }//GEN-LAST:event_addButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        viewBills(viewReferenceTextField.getText(),1 );
    }//GEN-LAST:event_viewButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
       clearAdd();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void tourCodelistValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tourCodelistValueChanged
        if (!tourCodelist.isSelectionEmpty()) { 
            tourCodeTextField.setText(tourCodelist.getSelectedValue().toString());
            hotelIDtextField.setText("");
            townIDTextField.setText("");
            hotelTownTable.clearSelection();
            hotelTownTable.setEnabled(false);
            
          //  if (hotelTownTable.getRowCount() > 0)
            //    hotelTownTable.setModel(null);
            Tour tour = billDAO.getTour(tourCodeTextField.getText());
            Set<Hotel> hotels = billDAO.getAllHotels(tour);
            changeTable(hotels, 1);
        }
    }//GEN-LAST:event_tourCodelistValueChanged

    private void hotelTownTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotelTownTableMouseClicked
       if(hotelTownTable.isEnabled()) {
        hotelIDtextField.setText(hotelTownTable.getValueAt(hotelTownTable.getSelectedRow(), 0).toString());
        townIDTextField.setText(hotelTownTable.getValueAt(hotelTownTable.getSelectedRow(), 2).toString());
       }
    }//GEN-LAST:event_hotelTownTableMouseClicked

    private void editexitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editexitButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_editexitButton1ActionPerformed

    private void fetchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchButtonActionPerformed
        String referenceNo = editreferenceNoTextField1.getText();
        editReference = referenceNo;
        Bill b = billDAO.isUnique(referenceNo);
        
        if(b != null)   {
            editamountTextField1.setText(b.getAmount().toString());
            editnumberOfIndvidualsTextField1.setText(String.valueOf(b.getNumberOfIndividuals()));
            editbillDateChooser1.setDate(b.getBillDate());
            edittourCodelist1.setSelectedValue(b.getTour().getTourCode(), rootPaneCheckingEnabled);
            edittourCodeTextField1.setText(edittourCodelist1.getSelectedValue().toString());
            editPaid.setSelected(b.getPaid());
            Tour tour = billDAO.getTour(edittourCodeTextField1.getText());
            Set<Hotel> hotels = billDAO.getAllHotels(tour);
            //changeTable(hotels, 0);
            //edithotelTownTable1.setRowSelectionInterval(edithotelTownTable1.getValueAt(WIDTH, WIDTH).compareToIgnoreCase(String.valueOf(b.getHotel().getId())),0 );
            edithotelIDtextField1.setText(String.valueOf(b.getHotel().getId()));
            edittownIDTextField1.setText(String.valueOf(b.getTown().getId()));
            editEnable();
            
        }
        else    {
             JOptionPane.showMessageDialog(null, "Reference No not exists. Please try again", "ERROR", JOptionPane.ERROR_MESSAGE);
             editreferenceNoTextField1.setText("");
        }
        
    }//GEN-LAST:event_fetchButtonActionPerformed

    private void editclearButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editclearButton1ActionPerformed
        clearEdit();
    }//GEN-LAST:event_editclearButton1ActionPerformed

    private void edithotelTownTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edithotelTownTable1MouseClicked
        if(edithotelTownTable1.isEnabled()) {
            edithotelIDtextField1.setText(edithotelTownTable1.getValueAt(edithotelTownTable1.getSelectedRow(), 0).toString());
            edittownIDTextField1.setText(edithotelTownTable1.getValueAt(edithotelTownTable1.getSelectedRow(), 2).toString());
       }
    }//GEN-LAST:event_edithotelTownTable1MouseClicked

    private void edittourCodelist1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_edittourCodelist1ValueChanged
        if (!edittourCodelist1.isSelectionEmpty()) { 
            edittourCodeTextField1.setText(edittourCodelist1.getSelectedValue().toString());
            edithotelIDtextField1.setText("");
            edittownIDTextField1.setText("");
            edithotelTownTable1.clearSelection();
            edithotelTownTable1.setEnabled(false);
            Tour tour = billDAO.getTour(edittourCodeTextField1.getText());
            Set<Hotel> hotels = billDAO.getAllHotels(tour);
            changeTable(hotels, 0);
        }
    }//GEN-LAST:event_edittourCodelist1ValueChanged

    private void edittourCodeScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edittourCodeScrollPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_edittourCodeScrollPaneMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        String referenceNo = editreferenceNoTextField1.getText();
        String date = editbillDateChooser1.getDateFormatString();
        String tourCode = edittourCodeTextField1.getText();
        String townID = edittownIDTextField1.getText();
        String hotelID = edithotelIDtextField1.getText();
        String numberOfIndividuals = editnumberOfIndvidualsTextField1.getText();
        String amount = editamountTextField1.getText();
        boolean paid = editPaid.isSelected();
        
       if (referenceNo.equalsIgnoreCase(editReference)) {
        if (!billValidate.validateNotNull(date))   {
             JOptionPane.showMessageDialog(null, "Please Select a date", "ERROR", JOptionPane.ERROR_MESSAGE);
             editbillDateChooser1.cleanup();
        }
        else if (!billValidate.validateAmount(amount)) { 
            editamountTextField1.setText("");
            amount = "";
        }
        else if (!billValidate.validateIndividuals(numberOfIndividuals))    {
            editnumberOfIndvidualsTextField1.setText("");
            numberOfIndividuals = "";
        }
        else if (!billValidate.validateNotNull(tourCode))   {
             JOptionPane.showMessageDialog(null, "Please select a TourCode", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         else if (!billValidate.validateNotNull(townID))   {
             JOptionPane.showMessageDialog(null, "Please Select a town", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
         else if (!billValidate.validateNotNull(hotelID))   {
             JOptionPane.showMessageDialog(null, "Please Select a hotel", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else    {
             boolean response = billDAO.editBill(new Bill(Integer.parseInt(referenceNo),billDAO.getTown(townID), billDAO.getTour(tourCode), billDAO.getHotel(hotelID), editbillDateChooser1.getDate(), Integer.parseInt(numberOfIndividuals), Double.parseDouble(amount), paid));
      
             if (response)  {
                JOptionPane.showMessageDialog(null, "You have successfully edited the bill", "Confimation", JOptionPane.INFORMATION_MESSAGE);
                clearEdit();
             }
             else
                JOptionPane.showMessageDialog(null, "There is error in connection with database. Cannot add tha bill", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       }
       else  {
           if (!billValidate.validatReferenceNo(referenceNo))   {
               editreferenceNoTextField1.setText("");
               referenceNo = "";
           }
           else if (!billValidate.validateNotNull(date))   {
             JOptionPane.showMessageDialog(null, "Please Select a date", "ERROR", JOptionPane.ERROR_MESSAGE);
             editbillDateChooser1.cleanup();
            }
            else if (!billValidate.validateAmount(amount)) { 
               editamountTextField1.setText("");
               amount = "";
            }
            else if (!billValidate.validateIndividuals(numberOfIndividuals))    {
                editnumberOfIndvidualsTextField1.setText("");
                numberOfIndividuals = "";
            }
            else if (!billValidate.validateNotNull(tourCode))   {
                 JOptionPane.showMessageDialog(null, "Please select a TourCode", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else if (!billValidate.validateNotNull(townID))   {
                JOptionPane.showMessageDialog(null, "Please Select a town", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else if (!billValidate.validateNotNull(hotelID))   {
                JOptionPane.showMessageDialog(null, "Please Select a hotel", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else    {
                Bill bill = billDAO.isUnique(editReference);
                boolean response = billDAO.deleteBill(bill);
      
             if (response)  {
                 boolean response1 = billDAO.addBill(new Bill(Integer.parseInt(referenceNo),billDAO.getTown(townID), billDAO.getTour(tourCode), billDAO.getHotel(hotelID), editbillDateChooser1.getDate(), Integer.parseInt(numberOfIndividuals), Double.parseDouble(amount), paid));
                 JOptionPane.showMessageDialog(null, "You have successfully edited the bill", "Confimation", JOptionPane.INFORMATION_MESSAGE);
                 
                 
                 if(response1)  {
                 JOptionPane.showMessageDialog(null, "You have successfully edited the bill", "Confimation", JOptionPane.INFORMATION_MESSAGE);
                 clearEdit();
                 }
                 else
                    JOptionPane.showMessageDialog(null, "There is error in connection with database. Cannot add tha bill", "ERROR", JOptionPane.ERROR_MESSAGE);
       
             }
             else
                 JOptionPane.showMessageDialog(null, "There is error in connection with database. Cannot add tha bill", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteFetchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFetchButtonActionPerformed
        viewBills(deleteReferenceTextField.getText(), 0);
    }//GEN-LAST:event_deleteFetchButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(deleteTable.getSelectedRowCount() != 0)  {
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete the selected record(s) ? ", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
           
             if (response == JOptionPane.YES_OPTION) {
                boolean result1 = true;
                int[] count = deleteTable.getSelectedRows();
                for (int i = 0; i < deleteTable.getSelectedRowCount(); i++) {
                   Bill b = billDAO.isUnique(deleteTable.getValueAt(count[i], 0).toString());
                   boolean result = billDAO.deleteBill(b);
                   
                   if(!result)
                       result1 = false;
                }
                 if(result1)
                       JOptionPane.showMessageDialog(null, "Successfully deleted the record(s)", "Confirmation",JOptionPane.INFORMATION_MESSAGE);
                 else
                       JOptionPane.showMessageDialog(null, "Cannot Delete Records. Problem with the database connection ", "ERROR", JOptionPane.ERROR_MESSAGE);
	
            }
        }
            
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane HotelTownScrollPane;
    private javax.swing.JPanel addBillsTab;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel amountLabel;
    private javax.swing.JTextField amountTextField;
    private com.toedter.calendar.JDateChooser billDateChooser;
    private javax.swing.JLabel billDateLabel;
    private javax.swing.JTabbedPane billsTab;
    private javax.swing.JButton clearButton;
    private javax.swing.JPanel deleteBillsTab;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteFetchButton;
    private javax.swing.JLabel deleteReferenceLabel;
    private javax.swing.JTextField deleteReferenceTextField;
    private javax.swing.JTable deleteTable;
    private javax.swing.JPanel editBillsTab;
    private javax.swing.JButton editButton;
    private javax.swing.JCheckBox editPaid;
    private javax.swing.JLabel editamountLabel1;
    private javax.swing.JTextField editamountTextField1;
    private com.toedter.calendar.JDateChooser editbillDateChooser1;
    private javax.swing.JLabel editbillDateLabel1;
    private javax.swing.JButton editclearButton1;
    private javax.swing.JButton editexitButton1;
    private javax.swing.JLabel edithotelIDLabel1;
    private javax.swing.JTextField edithotelIDtextField1;
    private javax.swing.JScrollPane edithotelTownScrollPane;
    private javax.swing.JTable edithotelTownTable1;
    private javax.swing.JLabel editnumberOfIndvidualsLabel1;
    private javax.swing.JTextField editnumberOfIndvidualsTextField1;
    private javax.swing.JLabel editreferenceNoLabel1;
    private javax.swing.JTextField editreferenceNoTextField1;
    private javax.swing.JLabel edittourCodeLabel1;
    private javax.swing.JScrollPane edittourCodeScrollPane;
    private javax.swing.JTextField edittourCodeTextField1;
    private javax.swing.JList edittourCodelist1;
    private javax.swing.JTextField edittownIDTextField1;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton fetchButton;
    private javax.swing.JLabel hotelIDLabel;
    private javax.swing.JTextField hotelIDtextField;
    private javax.swing.JTable hotelTownTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numberOfIndvidualsLabel;
    private javax.swing.JTextField numberOfIndvidualsTextField;
    private javax.swing.JCheckBox paidCheckBox;
    private javax.swing.JLabel referenceNoLabel;
    private javax.swing.JTextField referenceNoTextField;
    private javax.swing.JLabel tourCodeLabel;
    private javax.swing.JScrollPane tourCodeScrollPane;
    private javax.swing.JTextField tourCodeTextField;
    private javax.swing.JList tourCodelist;
    private javax.swing.JTextField townIDTextField;
    private javax.swing.JPanel viewBillsTab;
    private javax.swing.JButton viewButton;
    private javax.swing.JLabel viewReferenceLabel;
    private javax.swing.JTextField viewReferenceTextField;
    private javax.swing.JTable viewTable;
    // End of variables declaration//GEN-END:variables
}
