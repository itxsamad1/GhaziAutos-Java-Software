import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GhaziAutosApp {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Ghazi Autos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the card layout container
        JPanel cardPanel = new JPanel(new CardLayout());

        // Create the panels for each page
        JPanel mainPage = createMainPage(cardPanel);
        JPanel addInventoryPage = createAddInventoryPage(cardPanel);
        JPanel invoicePage = createInvoicePage(cardPanel);

        // Add the pages to the card layout container
        cardPanel.add(mainPage, "Main Page");
        cardPanel.add(addInventoryPage, "Add Inventory Page");
        cardPanel.add(invoicePage, "Invoice Page");

        // Show the main page initially
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, "Main Page");

        // Add the card layout container to the frame
        frame.add(cardPanel);
        frame.setVisible(true);
    }

    private static JPanel createMainPage(JPanel cardPanel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Set background color

        // Header
        JLabel header = new JLabel("Ghazi Autos", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(0, 0, 139)); // Set text color to dark blue
        panel.add(header, BorderLayout.NORTH);

        // Navigation buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.WHITE); // Set background color

        JButton addInventoryButton = createStyledButton("Add Inventory");
        addInventoryButton.addActionListener(e -> showCard(cardPanel, "Add Inventory Page"));
        buttonPanel.add(addInventoryButton);

        JButton invoiceButton = createStyledButton("Invoice");
        invoiceButton.addActionListener(e -> showCard(cardPanel, "Invoice Page"));
        buttonPanel.add(invoiceButton);

        JButton totalSalesButton = createStyledButton("Total Sales");
        // You can add an action listener for the total sales page if needed
        buttonPanel.add(totalSalesButton);

        panel.add(buttonPanel, BorderLayout.WEST);

        // Main content area (for example, a search bar and result list)
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE); // Set background color
        contentPanel.add(new JLabel("Main content area"));
        panel.add(contentPanel, BorderLayout.CENTER);

        return panel;
    }

    private static JPanel createAddInventoryPage(JPanel cardPanel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Set background color

        // Header
        JLabel header = new JLabel("Ghazi Autos - Add Inventory", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(0, 0, 139)); // Set text color to dark blue
        panel.add(header, BorderLayout.NORTH);

        // Form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBackground(Color.WHITE); // Set background color

        formPanel.add(createStyledLabel("Date:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Product Name:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Product No.:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Company:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Quantity:"));
        formPanel.add(new JTextField());

        // Save button
        JButton saveButton = createStyledButton("Save");
        formPanel.add(new JLabel());  // Empty label to align the button
        formPanel.add(saveButton);

        panel.add(formPanel, BorderLayout.CENTER);

        // Back button
        JButton backButton = createStyledButton("Back to Main Page");
        backButton.addActionListener(e -> showCard(cardPanel, "Main Page"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private static JPanel createInvoicePage(JPanel cardPanel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE); // Set background color

        // Header
        JLabel header = new JLabel("Ghazi Autos - Invoice", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(new Color(0, 0, 139)); // Set text color to dark blue
        panel.add(header, BorderLayout.NORTH);

        // Form fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBackground(Color.WHITE); // Set background color

        formPanel.add(createStyledLabel("Date:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Product Name:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Product No.:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Company:"));
        formPanel.add(new JTextField());

        formPanel.add(createStyledLabel("Quantity:"));
        formPanel.add(new JTextField());

        // Save button
        JButton saveButton = createStyledButton("Save");
        formPanel.add(new JLabel());  // Empty label to align the button
        formPanel.add(saveButton);

        panel.add(formPanel, BorderLayout.CENTER);

        // Back button
        JButton backButton = createStyledButton("Back to Main Page");
        backButton.addActionListener(e -> showCard(cardPanel, "Main Page"));
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private static void showCard(JPanel cardPanel, String cardName) {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, cardName);
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 0, 139)); // Set background color to dark blue
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFocusPainted(false); // Remove focus border
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font
        return button;
    }

    private static JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(0, 0, 139)); // Set text color to dark blue
        label.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font
        return label;
    }
}
