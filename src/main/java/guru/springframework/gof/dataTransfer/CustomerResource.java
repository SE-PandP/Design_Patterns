package guru.springframework.gof.dataTransfer;

import java.util.List;

public class CustomerResource {
	private List < CustomerDto > customers;

    /**
     * @param customers initialize resource with existing customers. Act as database.
     */
    public CustomerResource(List < CustomerDto > customers) {
        this.customers = customers;
    }

    /**
     * @return : all customers in list.
     */
    public List < CustomerDto > getAllCustomers() {
        return customers;
    }

    /**
     * @param customer save new customer to list.
     */
    public void save(CustomerDto customer) {
        customers.add(customer);
    }

    /**
     * @param customerId delete customer with id {@code customerId}
     */
    public void delete(String customerId) {
        customers.removeIf(customer -> customer.getId().equals(customerId));
    }

}
