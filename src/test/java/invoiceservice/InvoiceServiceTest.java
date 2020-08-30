package invoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

//@RunWith attaches a runner with the test class to initiate the test data
@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {
    @Mock
    private InvoiceGenerator invoiceGenerator;
    @Before
    public void setInvoiceGenerator() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = invoiceGenerator.calculateFare(2, 5);
        Assert.assertEquals(25, totalFare, 0.0);
    }
}
