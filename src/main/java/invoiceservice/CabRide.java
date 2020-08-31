package invoiceservice;

public enum CabRide {
    NORMAL(10, 1, 5),
    PREMIUM(15, 2, 20);

    private double costPerKm;
    private double costPerMin;
    private int minFarePerRide;

    CabRide(double costPerKm, double costPerMin, int minFarePerRide) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minFarePerRide = minFarePerRide;
    }

    public double calcCostOfCabRide(Ride ride) {
        double rideCost = ride.distance * costPerKm + ride.time * costPerMin;
        return Math.max(rideCost, minFarePerRide);
    }
}
