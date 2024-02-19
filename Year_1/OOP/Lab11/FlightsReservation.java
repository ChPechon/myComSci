package Lab11;

public class FlightsReservation extends PlaneSeating {
    private Flights flight;
    private PlaneSeating seating;

    
    public FlightsReservation(Flights flights) {
        this.flight = flights;
        seating = new Plane22Seating("xx_xx,xx_x^,^x_xx,x^_xx,xx_^x");
    }

    public void showSeating() {
        System.out.println(flight.toString());
        seating.showSeating();
    }

    public boolean reserveSeat(int row, int col) {
        boolean bl = seating.reserveSeat(row, col);
        this.showSeating();
        return (bl);
    }
}