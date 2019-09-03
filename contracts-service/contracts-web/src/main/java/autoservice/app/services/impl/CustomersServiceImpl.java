package autoservice.app.services.impl;

import autoservice.app.domain.Customer;
import autoservice.app.exceptions.CustomerNotFoundException;
import autoservice.app.repositories.CustomersRepo;
import autoservice.app.services.CustomersService;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements CustomersService {
    private CustomersRepo customersRepo;

    public CustomersServiceImpl(CustomersRepo customersRepo) {
        this.customersRepo = customersRepo;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customersRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer " + id + " not found"));
    }

    @Override
    public Customer save(Customer customer) {
        return customersRepo.save(customer);
    }
}
