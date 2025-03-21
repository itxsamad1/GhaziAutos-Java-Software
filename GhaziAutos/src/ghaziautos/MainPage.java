/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghaziautos;


import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abdul Samad
 */
public class MainPage extends javax.swing.JFrame {

    private JLabel jLabel4;
    private JLabel jLabel5;

    /**
     * Creates new form InvoicePage
     */
    public MainPage() {
        initComponents();
        // Set application icon with error handling
        try {
            java.net.URL iconURL = getClass().getResource("/ghaziautos/ghazi_autos_logo.png");
            if (iconURL != null) {
                setIconImage(new javax.swing.ImageIcon(iconURL).getImage());
            }
        } catch (Exception e) {
            System.out.println("Error loading application icon: " + e);
        }
        showRefresh();
    }
    
    private void showSearchDialog() {
        javax.swing.JDialog searchDialog = new javax.swing.JDialog(this, "Search Products", true);
        searchDialog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        javax.swing.JPanel panel = new javax.swing.JPanel();
        panel.setBackground(new java.awt.Color(255, 255, 255, 200));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Filters"));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        // Product No
        javax.swing.JLabel noLabel = new javax.swing.JLabel("Product No:");
        noLabel.setFont(new java.awt.Font("Perpetua", 1, 14));
        panel.add(noLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 25));
        
        javax.swing.JTextField productNoField = new javax.swing.JTextField();
        panel.add(productNoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, 25));
        
        // Product Name
        javax.swing.JLabel nameLabel = new javax.swing.JLabel("Product Name:");
        nameLabel.setFont(new java.awt.Font("Perpetua", 1, 14));
        panel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 25));
        
        javax.swing.JTextField productNameField = new javax.swing.JTextField();
        panel.add(productNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, 25));
        
        // Company
        javax.swing.JLabel companyLabel = new javax.swing.JLabel("Company:");
        companyLabel.setFont(new java.awt.Font("Perpetua", 1, 14));
        panel.add(companyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 25));
        
        javax.swing.JTextField companyField = new javax.swing.JTextField();
        panel.add(companyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 200, 25));
        
        // Buttons
        javax.swing.JButton searchButton = new javax.swing.JButton("Search");
        searchButton.setBackground(new java.awt.Color(51, 153, 255));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 100, 30));
        
        javax.swing.JButton resetButton = new javax.swing.JButton("Reset");
        resetButton.setBackground(new java.awt.Color(51, 153, 255));
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        panel.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 90, 30));
        
        searchDialog.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 200));
        
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performSearch(productNoField.getText().trim(), 
                            productNameField.getText().trim(), 
                            companyField.getText().trim());
                searchDialog.dispose();
            }
        });
        
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNoField.setText("");
                productNameField.setText("");
                companyField.setText("");
                showRefresh();
            }
        });
        
        searchDialog.setSize(370, 260);
        searchDialog.setLocationRelativeTo(this);
        searchDialog.setVisible(true);
    }
    
    private void performSearch(String productNo, String productName, String company) {
        if (productNo.isEmpty() && productName.isEmpty() && company.isEmpty()) {
            showRefresh();
            return;
        }

        StringBuilder query = new StringBuilder("SELECT * FROM inventory WHERE 1=1");
        java.util.ArrayList<Object> params = new java.util.ArrayList<>();

        if (!productNo.isEmpty()) {
            query.append(" AND Number LIKE ?");
            params.add("%" + productNo + "%");
        }
        if (!productName.isEmpty()) {
            query.append(" AND Name LIKE ?");
            params.add("%" + productName + "%");
        }
        if (!company.isEmpty()) {
            query.append(" AND Company LIKE ?");
            params.add("%" + company + "%");
        }

        DB_Model_GA db = new DB_Model_GA();
        try {
            ResultSet rs = db.executeQuery(query.toString(), params.toArray());
            DefaultTableModel tb = (DefaultTableModel) inventory.getModel();
            tb.setRowCount(0);

            while (rs.next()) {
                String[] data = {
                    rs.getString("Number"),
                    rs.getString("Name"),
                    rs.getString("Company"),
                    rs.getString("Price"),
                    rs.getString("Quantity")
                };
                tb.addRow(data);
            }

            if (tb.getRowCount() == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "No products found matching the search criteria", 
                    "Search Results", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Error performing search", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showRefresh(){
        DB_Model_GA db=new DB_Model_GA();
        ResultSet rs;
        DefaultTableModel tb= (DefaultTableModel)inventory.getModel();
        tb.setRowCount(0);
        try{
            rs=db.showInventory();
            while(rs.next()){
                String data[]={
                    rs.getString("Number"),
                    rs.getString("Name"),
                    rs.getString("Company"),
                    rs.getString("Price"),
                    rs.getString("Quantity")
                };
                tb.addRow(data);
            }
        }catch(Exception e){
            System.out.println(e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        inventory = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Setup navigation labels with hand cursor
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setToolTipText("Go to Inventory");  // Add tooltip
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 170, 40));

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setToolTipText("Go to Invoice Page");  // Add tooltip
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 170, 50));

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setToolTipText("Go to Sales");  // Add tooltip
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 170, 40));

        // Setup inventory table
        inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Product No.", "Product Name", "Company", "Price", "Quantity"
            }
        ));
        inventory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        inventory.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(inventory);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 690, 410));

        // Setup search button
        searchButton.setBackground(new java.awt.Color(51, 153, 255));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSearchDialog();
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 110, 30));

        // Setup exit button
        exitButton.setBackground(new java.awt.Color(51, 153, 255));
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 110, 30));

        // Setup background
        jLabel1.setIcon(null);
        try {
            java.net.URL bgURL = getClass().getResource("/ghaziautos/Dashboard.png");
            if (bgURL != null) {
                jLabel1.setIcon(new javax.swing.ImageIcon(bgURL));
            }
        } catch (Exception e) {
            System.out.println("Error loading background image: " + e);
        }
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        new Inventory().setVisible(true);
        this.dispose();
    }

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
        new InvoicePage1().setVisible(true);
        this.dispose();
    }

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        new Sales().setVisible(true);
        this.dispose();
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int choice = javax.swing.JOptionPane.showConfirmDialog(this,
            "Are you sure you want to exit?",
            "Confirm Exit",
            javax.swing.JOptionPane.YES_NO_OPTION);
        
        if (choice == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable inventory;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
