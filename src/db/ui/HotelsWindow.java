/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db.ui;

import db.dao.HotelDAO;
import db.entity.Bill;
import db.entity.Hotel;
import db.entity.Tour;
import db.entity.Town;
import db.validate.HotelValidate;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class HotelsWindow extends javax.swing.JFrame {
    private HotelDAO hotelDAO = HotelDAO.create();
    private HotelValidate hotelValidate = HotelValidate.create();
    private static HotelsWindow hotelWindow = null;
    private int SINGLE;
    private String editID = "";
    /**
     * Creates new form HotelsWindow
     */
    public HotelsWindow() {
        initComponents();
    }
    
    public static HotelsWindow create()  {
        if (hotelWindow == null) {
             hotelWindow = new HotelsWindow();
        }
            return hotelWindow;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HotelsTab = new javax.swing.JTabbedPane();
        addHotelsTab = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        townIdLabel = new javax.swing.JLabel();
        hotelNameLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        townIdTextField = new javax.swing.JTextField();
        hotelNameTextField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        townScroll = new javax.swing.JScrollPane();
        addTownTable = new javax.swing.JTable();
        editHotelsTab = new javax.swing.JPanel();
        editidLabel1 = new javax.swing.JLabel();
        edittownIdLabel1 = new javax.swing.JLabel();
        edithotelNameLabel1 = new javax.swing.JLabel();
        editidTextField1 = new javax.swing.JTextField();
        edittownIdTextField1 = new javax.swing.JTextField();
        edithotelNameTextField1 = new javax.swing.JTextField();
        editclearButton1 = new javax.swing.JButton();
        editButton1 = new javax.swing.JButton();
        editexitButton1 = new javax.swing.JButton();
        edittownPane = new javax.swing.JScrollPane();
        editTownTable1 = new javax.swing.JTable();
        editGetButton = new javax.swing.JButton();
        deleteHotelsTab = new javax.swing.JPanel();
        deleteIDLabel = new javax.swing.JLabel();
        deleteHotelNameLabel = new javax.swing.JLabel();
        deleteTownNameLabel = new javax.swing.JLabel();
        deleteIDTextField = new javax.swing.JTextField();
        deleteHotelNameTextField = new javax.swing.JTextField();
        deleteTownNameTextField = new javax.swing.JTextField();
        deleteFetchButton = new javax.swing.JButton();
        deleteScroll = new javax.swing.JScrollPane();
        deleteTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        viewHotelsTab = new javax.swing.JPanel();
        viewIDLabel = new javax.swing.JLabel();
        viewHotelNameLabel = new javax.swing.JLabel();
        viewTownNameLabel = new javax.swing.JLabel();
        viewIDTextField = new javax.swing.JTextField();
        viewHotelNameTextField = new javax.swing.JTextField();
        viewTownNameTextField = new javax.swing.JTextField();
        viewButton = new javax.swing.JButton();
        viewScroll = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();

        idLabel.setText("ID");

        townIdLabel.setText("Town ID");

        hotelNameLabel.setText("Hotel Name");

        townIdTextField.setEditable(false);

        hotelNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelNameTextFieldActionPerformed(evt);
            }
        });

        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        addButton.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        addTownTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Town ID", "Town Name"
            }
        ));
        getTowns();
        addTownTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTownTableMouseClicked(evt);
            }
        });
        townScroll.setViewportView(addTownTable);
        addTownTable.setSelectionMode(SINGLE);

        javax.swing.GroupLayout addHotelsTabLayout = new javax.swing.GroupLayout(addHotelsTab);
        addHotelsTab.setLayout(addHotelsTabLayout);
        addHotelsTabLayout.setHorizontalGroup(
            addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addHotelsTabLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(townScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addHotelsTabLayout.createSequentialGroup()
                        .addComponent(townIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(townIdTextField))
                    .addGroup(addHotelsTabLayout.createSequentialGroup()
                        .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hotelNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hotelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        addHotelsTabLayout.setVerticalGroup(
            addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addHotelsTabLayout.createSequentialGroup()
                .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addHotelsTabLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hotelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hotelNameLabel))
                        .addGap(26, 26, 26)
                        .addGroup(addHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(townIdLabel)
                            .addComponent(townIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(townScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addHotelsTabLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        HotelsTab.addTab("ADD", addHotelsTab);

        editidLabel1.setText("ID");

        edittownIdLabel1.setText("Town ID");

        edithotelNameLabel1.setText("Hotel Name");

        edithotelNameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edithotelNameTextField1ActionPerformed(evt);
            }
        });

        editclearButton1.setText("CLEAR");

        editButton1.setFont(new java.awt.Font("Andalus", 1, 18)); // NOI18N
        editButton1.setText("EDIT");

        editexitButton1.setText("EXIT");

        editTownTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Town ID", "Town Name"
            }
        ));
        edittownPane.setViewportView(editTownTable1);

        editGetButton.setText("GET");
        editGetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editGetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editHotelsTabLayout = new javax.swing.GroupLayout(editHotelsTab);
        editHotelsTab.setLayout(editHotelsTabLayout);
        editHotelsTabLayout.setHorizontalGroup(
            editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editHotelsTabLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edittownPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editHotelsTabLayout.createSequentialGroup()
                        .addComponent(edittownIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(edittownIdTextField1))
                    .addGroup(editHotelsTabLayout.createSequentialGroup()
                        .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edithotelNameLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editidLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editidTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edithotelNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(editexitButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editclearButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editGetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        editHotelsTabLayout.setVerticalGroup(
            editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editHotelsTabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editidLabel1)
                    .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editidTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editGetButton)))
                .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editHotelsTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edithotelNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edithotelNameLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edittownIdLabel1)
                            .addComponent(edittownIdTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(editHotelsTabLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(editButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(editHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editHotelsTabLayout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addComponent(editexitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editclearButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edittownPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        HotelsTab.addTab("EDIT", editHotelsTab);

        deleteIDLabel.setText("ID");

        deleteHotelNameLabel.setText("Hotel Name");

        deleteTownNameLabel.setText("Town Name");

        deleteFetchButton.setText("FETCH");

        deleteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        deleteScroll.setViewportView(deleteTable);

        deleteButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        deleteButton.setText("DELETE");

        javax.swing.GroupLayout deleteHotelsTabLayout = new javax.swing.GroupLayout(deleteHotelsTab);
        deleteHotelsTab.setLayout(deleteHotelsTabLayout);
        deleteHotelsTabLayout.setHorizontalGroup(
            deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                        .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteIDLabel)
                            .addComponent(deleteHotelNameLabel)
                            .addComponent(deleteTownNameLabel))
                        .addGap(70, 70, 70)
                        .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteIDTextField)
                            .addComponent(deleteHotelNameTextField)
                            .addComponent(deleteTownNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteFetchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        deleteHotelsTabLayout.setVerticalGroup(
            deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteIDLabel)
                    .addComponent(deleteIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteFetchButton))
                .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteHotelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteHotelNameLabel))
                        .addGroup(deleteHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(deleteTownNameLabel))
                            .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(deleteTownNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(deleteHotelsTabLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(deleteButton)))
                .addGap(18, 18, 18)
                .addComponent(deleteScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HotelsTab.addTab("DELETE", deleteHotelsTab);

        viewIDLabel.setText("ID");

        viewHotelNameLabel.setText("Hotel Name");

        viewTownNameLabel.setText("Town Name");

        viewButton.setFont(new java.awt.Font("Andalus", 1, 14)); // NOI18N
        viewButton.setText("VIEW");

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        viewScroll.setViewportView(viewTable);

        javax.swing.GroupLayout viewHotelsTabLayout = new javax.swing.GroupLayout(viewHotelsTab);
        viewHotelsTab.setLayout(viewHotelsTabLayout);
        viewHotelsTabLayout.setHorizontalGroup(
            viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewHotelsTabLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewHotelsTabLayout.createSequentialGroup()
                        .addGroup(viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewIDLabel)
                            .addComponent(viewHotelNameLabel)
                            .addComponent(viewTownNameLabel))
                        .addGap(70, 70, 70)
                        .addGroup(viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewIDTextField)
                            .addComponent(viewHotelNameTextField)
                            .addComponent(viewTownNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        viewHotelsTabLayout.setVerticalGroup(
            viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewHotelsTabLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewIDLabel)
                    .addComponent(viewIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewHotelNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewHotelNameLabel)
                    .addComponent(viewButton))
                .addGroup(viewHotelsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewHotelsTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(viewTownNameLabel))
                    .addGroup(viewHotelsTabLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(viewTownNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(viewScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HotelsTab.addTab("VIEW", viewHotelsTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HotelsTab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HotelsTab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addData()  {
        String ID = idTextField.getText();
        String hotelName = hotelNameTextField.getText();
        String townID = townIdTextField.getText();
        
        if (!hotelValidate.validatID(ID)) {
            idTextField.setText("");
            ID = "";
        }
        else if(!hotelValidate.validateNotNull(hotelName)) {
            JOptionPane.showMessageDialog(null, "Please type the hotel name", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(!hotelValidate.validateNotNull(townID)){
            JOptionPane.showMessageDialog(null, "Please select a town ID", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else    {
            boolean response = hotelDAO.addHotel(new Hotel(Integer.parseInt(ID), hotelDAO.getTown(townID),hotelName, null));
             
             if (response)  {
                 JOptionPane.showMessageDialog(null, "You have successfully added the hotel", "Confimation", JOptionPane.INFORMATION_MESSAGE);
                 clearAdd();
             }
             else
                 JOptionPane.showMessageDialog(null, "There is error in connection with database. Cannot add tha bill", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private void clearAdd() {
        idTextField.setText("");
        hotelNameTextField.setText("");
        addTownTable.clearSelection();
        townIdTextField.setText("");
    }
     
    private void getTowns() {
        List resultList = hotelDAO.getAllTowns();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        
        tableHeaders.add("Town ID");
        tableHeaders.add("Town Name");
        
        if (resultList != null)     {
            for (Object o : resultList) {
                Town town = (Town) o;
                
                Vector<Object> oneRow = new Vector<Object>();
                oneRow.add(town.getId());
                oneRow.add(town.getName());
                tableData.add(oneRow);
            }
       
            addTownTable.setModel(new DefaultTableModel(tableData, tableHeaders));
 
            }
        else {
             JOptionPane.showMessageDialog(null, "No overnight stops found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    private void edithotelNameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edithotelNameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edithotelNameTextField1ActionPerformed

    private void hotelNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hotelNameTextFieldActionPerformed

    private void addTownTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTownTableMouseClicked
        townIdTextField.setText("");
        if(addTownTable.getSelectedRow() >= 0)   {
            String townID = addTownTable.getValueAt(addTownTable.getSelectedRow(), 0).toString();
            
            /* if (hotelDAO.getTown(townID).getHotel()!= null) {
            JOptionPane.showMessageDialog(null, "This town already have a hotel. Cannot assign new hotel", "ERROR", JOptionPane.ERROR_MESSAGE);
            addTownTable.clearSelection();
            }
            else
            townIdTextField.setText(townID);*/
        }
    }//GEN-LAST:event_addTownTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
       addData();
    }//GEN-LAST:event_addButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
       clearAdd();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void editGetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editGetButtonActionPerformed
        String ID = editidTextField1.getText();
        editID = ID;
        Hotel h = hotelDAO.isUnique(ID);
        
       /* if(h != null)   {
            edithotelNameTextField1.setText(h.getName());
            editTownTable1.setSelectedValue(h.getTown().getId(), rootPaneCheckingEnabled);
            edittourCodeTextField1.setText(edittourCodelist1.getSelectedValue().toString());
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
        }*/
    }//GEN-LAST:event_editGetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane HotelsTab;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addHotelsTab;
    private javax.swing.JTable addTownTable;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteFetchButton;
    private javax.swing.JLabel deleteHotelNameLabel;
    private javax.swing.JTextField deleteHotelNameTextField;
    private javax.swing.JPanel deleteHotelsTab;
    private javax.swing.JLabel deleteIDLabel;
    private javax.swing.JTextField deleteIDTextField;
    private javax.swing.JScrollPane deleteScroll;
    private javax.swing.JTable deleteTable;
    private javax.swing.JLabel deleteTownNameLabel;
    private javax.swing.JTextField deleteTownNameTextField;
    private javax.swing.JButton editButton1;
    private javax.swing.JButton editGetButton;
    private javax.swing.JPanel editHotelsTab;
    private javax.swing.JTable editTownTable1;
    private javax.swing.JButton editclearButton1;
    private javax.swing.JButton editexitButton1;
    private javax.swing.JLabel edithotelNameLabel1;
    private javax.swing.JTextField edithotelNameTextField1;
    private javax.swing.JLabel editidLabel1;
    private javax.swing.JTextField editidTextField1;
    private javax.swing.JLabel edittownIdLabel1;
    private javax.swing.JTextField edittownIdTextField1;
    private javax.swing.JScrollPane edittownPane;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hotelNameLabel;
    private javax.swing.JTextField hotelNameTextField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel townIdLabel;
    private javax.swing.JTextField townIdTextField;
    private javax.swing.JScrollPane townScroll;
    private javax.swing.JButton viewButton;
    private javax.swing.JLabel viewHotelNameLabel;
    private javax.swing.JTextField viewHotelNameTextField;
    private javax.swing.JPanel viewHotelsTab;
    private javax.swing.JLabel viewIDLabel;
    private javax.swing.JTextField viewIDTextField;
    private javax.swing.JScrollPane viewScroll;
    private javax.swing.JTable viewTable;
    private javax.swing.JLabel viewTownNameLabel;
    private javax.swing.JTextField viewTownNameTextField;
    // End of variables declaration//GEN-END:variables
}
