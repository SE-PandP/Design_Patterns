package guru.springframework.gof.dataTransfer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/* This class is a customer details consumer i.e. client to request for customer details to server */

public class TransferObjectPatternDemo {
	@Test
    public void testDataTransfer() throws Exception {


	  
	
		/* CustomerDto is a data transfer object POJO (Plain Old Java Object). Instead of sending individual information to the client. 
		  We can send related information together in a single POJO class. 
		  Note that DTO will not have any business logic in it. */
	        List < CustomerDto > customers = new ArrayList < > ();
	        CustomerDto customerOne = new CustomerDto("1", "Kelly", "Brown");
	        CustomerDto customerTwo = new CustomerDto("2", "Alfonso", "Bass");
	        customers.add(customerOne);
	        customers.add(customerTwo);
	        
	        /* CustomerResource is a resource class which serves customer information. This class act as a server for the demo.*/

	        CustomerResource customerResource = new CustomerResource(customers);

	        
	        
	        System.out.println("All customers:-");
	        List < CustomerDto > allCustomers = customerResource.getAllCustomers();
	        printCustomerDetails(allCustomers);

	        System.out.println("----------------------------------------------------------");

	        System.out.println("Deleting customer with id {1}");
	        customerResource.delete(customerOne.getId());
	        allCustomers = customerResource.getAllCustomers();
	        printCustomerDetails(allCustomers);

	        System.out.println("----------------------------------------------------------");

	        System.out.println("Adding customer three");
	        CustomerDto customerThree = new CustomerDto("3", "Lynda", "Blair");
	        customerResource.save(customerThree);
	        allCustomers = customerResource.getAllCustomers();
	        printCustomerDetails(allCustomers);
	    


	}
	
	
    private static void printCustomerDetails(List < CustomerDto > allCustomers) {
        allCustomers.forEach(customer -> System.out.println(customer.getFirstName()));
    }

}
