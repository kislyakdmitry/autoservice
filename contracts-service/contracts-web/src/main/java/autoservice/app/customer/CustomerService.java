package autoservice.app.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepo customersRepo;

    public CustomerService(CustomerRepo customersRepo) {
        this.customersRepo = customersRepo;
    }

    public Customer getCustomerById(Long id) {
        return customersRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer " + id + " not found"));
    }

    public Customer save(Customer customer) {
        return customersRepo.save(customer);
    }
}
