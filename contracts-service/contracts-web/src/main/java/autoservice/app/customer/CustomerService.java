package autoservice.app.customer;

import autoservice.app.customer.exceptions.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepo customersRepo;

    public Customer save(Customer customer) {
        return customersRepo.save(customer);
    }
}
