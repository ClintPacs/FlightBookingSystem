import ui.FlightBookingGUI;
import model.Flight;
import controller.BookingController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Sample data for flights
        Flight[] flights = new Flight[] {
                new Flight("AA123", "New York, USA", 10),
                new Flight("BB456", "Paris, France", 5),
                new Flight("CC789", "London, UK", 0),
                new Flight("DD101", "Tokyo, Japan", 15),
                new Flight("EE202", "Sydney, Australia", 8),
                new Flight("FF303", "Berlin, Germany", 2),
                new Flight("GG404", "Rome, Italy", 0)
        };

        // Create the GUI view
        FlightBookingGUI view = new FlightBookingGUI();

        // Create the controller and pass the view and flight data
        BookingController controller = new BookingController(view, flights);

        // Launch the GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Flight Booking System");
            frame.setContentPane(view.getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);  // Set window size (Width x Height)
            frame.setLocationRelativeTo(null); // Center the window on the screen
            frame.setVisible(true);
        });
    }
}
