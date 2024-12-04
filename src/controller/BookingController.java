package controller;

import model.Flight;
import model.Passenger;
import model.Booking;
import ui.FlightBookingGUI;

public class BookingController {

    private Flight[] flights;  // Array to hold the flight data
    private FlightBookingGUI view;  // The view that the controller will interact with

    public BookingController(FlightBookingGUI view, Flight[] flights) {
        this.view = view;
        this.flights = flights;

        // Connect the view's book button action to the controller's booking logic
        this.view.setBookButtonAction(e -> handleBooking());
    }

    // Method to handle the booking process
    public void handleBooking() {
        try {
            // Get selected flight from the view
            String selectedFlight = view.getSelectedFlight();
            String[] flightDetails = selectedFlight.split(" - ");
            String flightNumber = flightDetails[0];
            String destination = flightDetails[1];

            // Find the corresponding Flight object based on the flight number
            Flight selectedFlightObj = null;
            for (Flight flight : flights) {
                if (flight.getFlightNumber().equals(flightNumber)) {
                    selectedFlightObj = flight;
                    break;
                }
            }

            // Get passenger details from the view
            String name = view.getPassengerName();
            String passportNumber = view.getPassportNumber();
            Passenger passenger = new Passenger(name, passportNumber);

            // Attempt to book the flight
            if (selectedFlightObj != null) {
                selectedFlightObj.bookSeat();  // Decrement available seats
                Booking booking = new Booking(passenger, selectedFlightObj);
                view.displayMessage("Booking successful!");
            } else {
                view.displayMessage("Flight not found!");
            }

        } catch (Exception ex) {
            view.displayMessage("Error: " + ex.getMessage());
        }
    }
}
