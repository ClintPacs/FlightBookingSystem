package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightBookingGUI {
    private JPanel mainPanel;
    private JComboBox<String> countryComboBox;
    private JLabel countryImageLabel;
    private JTextArea touristSpotsArea;
    private JButton bookButton;
    private JLabel messageLabel;

    public FlightBookingGUI() {
        // Initialize the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a header label
        JLabel headerLabel = new JLabel("Flight Booking System", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.BLUE);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Create a combo box for country selection
        JPanel topPanel = new JPanel();
        JLabel countryLabel = new JLabel("Select Destination:");
        countryComboBox = new JComboBox<>();
        countryComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        countryComboBox.addItem("Select a Country");
        countryComboBox.addItem("USA");
        countryComboBox.addItem("France");
        countryComboBox.addItem("Japan");
        countryComboBox.addItem("Australia");
        countryComboBox.addItem("Italy");

        // Add action listener to update the display when a country is selected
        countryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCountryInfo();
            }
        });

        topPanel.add(countryLabel);
        topPanel.add(countryComboBox);
        mainPanel.add(topPanel, BorderLayout.CENTER);

        // Country image label
        countryImageLabel = new JLabel();
        countryImageLabel.setHorizontalAlignment(JLabel.CENTER);
        countryImageLabel.setPreferredSize(new Dimension(400, 250));
        mainPanel.add(countryImageLabel, BorderLayout.SOUTH);

        // Tourist spots display area
        touristSpotsArea = new JTextArea(5, 20);
        touristSpotsArea.setEditable(false);
        touristSpotsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(touristSpotsArea);
        mainPanel.add(scrollPane, BorderLayout.EAST);

        // Add a book button for booking a flight (though no passport number required)
        JPanel bottomPanel = new JPanel();
        bookButton = new JButton("Book Flight");
        bookButton.setFont(new Font("Arial", Font.BOLD, 16));
        bookButton.setBackground(new Color(0, 122, 255));
        bookButton.setForeground(Color.WHITE);
        bookButton.setPreferredSize(new Dimension(200, 40));
        bottomPanel.add(bookButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    // Method to update country info when a selection is made
    private void updateCountryInfo() {
        String selectedCountry = (String) countryComboBox.getSelectedItem();

        // If no valid country is selected, clear the image and tourist spots
        if (selectedCountry == null || selectedCountry.equals("Select a Country")) {
            countryImageLabel.setIcon(null);
            touristSpotsArea.setText("");
            return;
        }

        // Update country image and tourist spots based on the selection
        switch (selectedCountry) {
            case "USA":
                countryImageLabel.setIcon(new ImageIcon("images/usa.jpg"));
                touristSpotsArea.setText("1. Statue of Liberty\n2. Grand Canyon\n3. Times Square\n4. Yellowstone National Park");
                break;
            case "France":
                countryImageLabel.setIcon(new ImageIcon("images/france.jpg"));
                touristSpotsArea.setText("1. Eiffel Tower\n2. Louvre Museum\n3. Mont Saint-Michel\n4. Palace of Versailles");
                break;
            case "Japan":
                countryImageLabel.setIcon(new ImageIcon("images/japan.jpg"));
                touristSpotsArea.setText("1. Mount Fuji\n2. Tokyo Tower\n3. Kyoto Temples\n4. Hiroshima Peace Memorial");
                break;
            case "Australia":
                countryImageLabel.setIcon(new ImageIcon("images/australia.jpg"));
                touristSpotsArea.setText("1. Sydney Opera House\n2. Great Barrier Reef\n3. Uluru\n4. Bondi Beach");
                break;
            case "Italy":
                countryImageLabel.setIcon(new ImageIcon("images/italy.jpg"));
                touristSpotsArea.setText("1. Colosseum\n2. Venice Canals\n3. Leaning Tower of Pisa\n4. Roman Forum");
                break;
            default:
                countryImageLabel.setIcon(null);
                touristSpotsArea.setText("");
                break;
        }
    }

    // Getter for the main panel
    public JPanel getMainPanel() {
        return mainPanel;
    }
}
