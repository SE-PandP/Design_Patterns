package guru.springframework.gof.observer.javaapi;


import org.junit.Test;

import java.math.BigDecimal;
public class ObservableJavaAPITest {

    @Test
    public void testObserver() throws Exception {
    	
    	/* Push Based */
    	/* Subject is an interface to attach and detach Observer objects */
    	/* Product is the concrete  subject that implements the Subject interface. A ConcreteSubject sends notification to Observer objects when its state change */
        
        Product product=new Product("L340 Digital Camera",new BigDecimal(325));
        Bidder bidder1=new Bidder("Shally Ferguson");
        Bidder bidder2=new Bidder("Dwayne Bravo");
        Bidder bidder3=new Bidder("Craig Dawson");
        /* Observer is an interface for objects that should be notified of changes in a Subject */
        /* Bidder is a class that implements Observer to receive notifications from the Subject and keep its state consistent with the state of the Subject */
       
        product.addObserver(bidder1);
        product.addObserver(bidder2);
        product.addObserver(bidder3);
        
        /* Now, the Product class doesn’t have the methods to register and remove observer objects; 
         because by extending Observable, Product inherits the addObserver(Observer o) and 
         deleteObserver(Observer o) methods of Observable. 
         Things also changed in the setBidAmount() method. 
         We now made calls to the setChanged() and notifyObservers() methods of the Observable class. 
         The setChanged() method marks this Observable object as having been changed while the notifyObservers() method,
          as its name suggests, notifies all of its observers about the change. For the observers, we need to implement 
          the Observer interface that have a single update(Observable o, Object arg) method. 
          This method gets called whenever the subject (Product) changes. Following is the modified Bidder class implementing 
          the Observer interface.
         */
        product.setBidAmount(bidder1, new BigDecimal(350));
        product.deleteObserver(bidder2);
        product.setBidAmount(bidder3, new BigDecimal(375));
    }
}