package invoiceservice;

public class Ride {
    public final double distance;
    public final int time;
    public CabRide cabRide;

    public Ride(double distance, int time, CabRide cabRide) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }
}
