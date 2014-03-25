package db.ui;

import db.ui.panels.TownEditPanel;
import db.ui.panels.TownSearchPanel;
import java.awt.Toolkit;

/**
 *
 * @author Gobinath
 */
public class TownWindow extends javax.swing.JFrame {
    private final TownEditPanel townEditPanel;
    private final TownSearchPanel townSearchPanel;
    
    /**
     * Creates new form TownWindow
     */
    public TownWindow() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/db/Image/Bus.png")));
        townEditPanel = TownEditPanel.getInstance();
        townSearchPanel = TownSearchPanel.getInstance();
        panelAdd.add(townEditPanel);
        panelSearch.add(townSearchPanel);
        //setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanelMain = new javax.swing.JTabbedPane();
        panelAdd = new javax.swing.JPanel();
        panelSearch = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Town Management");
        setMinimumSize(new java.awt.Dimension(700, 550));
        setPreferredSize(new java.awt.Dimension(700, 550));

        panelAdd.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelAddComponentShown(evt);
            }
        });
        panelAdd.setLayout(new javax.swing.BoxLayout(panelAdd, javax.swing.BoxLayout.LINE_AXIS));
        tabbedPanelMain.addTab("Add New Town", new javax.swing.ImageIcon(getClass().getResource("/db/Image/add.png")), panelAdd); // NOI18N

        panelSearch.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                panelSearchComponentShown(evt);
            }
        });
        panelSearch.setLayout(new javax.swing.BoxLayout(panelSearch, javax.swing.BoxLayout.LINE_AXIS));
        tabbedPanelMain.addTab("Search & Edit", new javax.swing.ImageIcon(getClass().getResource("/db/Image/view.png")), panelSearch); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tabbedPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tabbedPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tabbedPanelMain.getAccessibleContext().setAccessibleName("Add");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelAddComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelAddComponentShown
        townEditPanel.refresh(null);
        panelAdd.removeAll();
        panelAdd.add(townEditPanel.getInstance());
        panelAdd.repaint();
        panelAdd.validate();
    }//GEN-LAST:event_panelAddComponentShown

    private void panelSearchComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelSearchComponentShown
        TownSearchPanel.getInstance().refresh();
        panelSearch.removeAll();
        panelSearch.add(TownSearchPanel.getInstance());
        panelSearch.repaint();
        panelSearch.validate();
    }//GEN-LAST:event_panelSearchComponentShown

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JTabbedPane tabbedPanelMain;
    // End of variables declaration//GEN-END:variables
}
