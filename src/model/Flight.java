package model;

public class Flight {
    private String flightNumber;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() throws Exception {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            throw new Exception("No seats available.");
        }
    }
}
