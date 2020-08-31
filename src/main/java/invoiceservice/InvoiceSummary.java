package invoiceservice;

import lombok.EqualsAndHashCode;

//@EqualsAndHashCode annotation is used to generate both equals and hashCode methods
@EqualsAndHashCode
public class InvoiceSummary {
    private final int noOfRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int noOfRides, double totalFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.noOfRides;
    }
}
