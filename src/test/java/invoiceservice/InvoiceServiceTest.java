package invoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith attaches a runner with the test class to initiate the test data
@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

    @Mock
    InvoiceService invoiceService;
    InvoiceSummary expectedInvoiceSummary;
    RideRepository rideRepository;
    private String userId = "a@b.com";
    Ride[] rides;

    //Expected Exception object is created as a Rule that expects none exception
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setInvoiceService() {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]
                {new Ride(2.0, 5, CabRide.NORMAL),
                 new Ride(0.1, 1, CabRide.PREMIUM)
        };
        expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = invoiceService.calculateFare(2, 5);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceOrTime_WhenLess_ShouldReturnMinimumFare() {
        double totalFare = invoiceService.calculateFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenCalculatedFare_ShouldReturnMinimumFare() {
        double totalFare = invoiceService.calculateFare(0, 0);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test(expected = NullPointerException.class)
    public void givenMultipleRides_WhenReturnsNull_ShouldReturnNull() {
        InvoiceSummary summary = invoiceService.calculateFare(null);
        Mockito.when(invoiceService.calculateFare(null)).thenReturn(null);
        Assert.assertEquals(null, summary);
    }

    @Test
    public void givenUserIdAndRides_WhenGiveRightInvoiceSummary_ShouldReturnEqual() {
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test(expected = AssertionError.class)
    public void givenUserIdAndRides_WhenGiveWrongInvoiceSummary_ShouldReturnNotEqual() {
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        Assert.assertNotEquals(expectedInvoiceSummary, summary);
    }

    @Test(expected = AssertionError.class)
    public void givenUserIdAndRides_WhenUserIdIsNull_ShouldReturnNull() {
        invoiceService.addRides(null, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(null);
        Assert.assertEquals(null, summary);
    }
}
