package invoiceservice;

public class InvoiceGenerator {
    public static final int COST_PER_TIME = 1;
    public static final double MINIMUM_COST_PER_KILOMETER = 10;

    public double calculateFare(double distance, int time) {
        return distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
    }
}
