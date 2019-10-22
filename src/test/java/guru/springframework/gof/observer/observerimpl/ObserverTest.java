package guru.springframework.gof.observer.observerimpl;

import org.junit.Test;
import java.math.BigDecimal;

public class ObserverTest {
    @Test
    public void testObserver() throws Exception {
    	/* Subject is an interface to attach and detach Observer objects */
    	/* Product is the concrete  subject that implements the Subject interface. A ConcreteSubject sends notification to Observer objects when its state change */
        Subject product=new Product("36 inch LED TV",new BigDecimal(350)); 
        Observer bidder1=new Bidder("Alex Parker"); 
        /* Observer is an interface for objects that should be notified of changes in a Subject */
        /* Bidder is a class that implements Observer to receive notifications from the Subject and keep its state consistent with the state of the Subject */
        Observer bidder2=new Bidder("Henry Smith");
        Observer bidder3=new Bidder("Mary Peterson");
        product.registerObserver(bidder1);
        product.registerObserver(bidder2);
        product.registerObserver(bidder3);
        product.setBidAmount(bidder1, new BigDecimal(375));
        product.removeObserver(bidder2);
        product.setBidAmount(bidder3, new BigDecimal(400));
    }
}
