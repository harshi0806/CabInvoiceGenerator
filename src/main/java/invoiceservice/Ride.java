package invoiceservice;

import lombok.Data;

//@Data annotation is used here to generate constructor keeping in consideration of final property
@Data
public class Ride {
    public final double distance;
    public final int time;
}
