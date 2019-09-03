package autoservice.app.services;

import autoservice.app.domain.Customer;

public interface CustomersService {
    Customer getCustomerById(Long id);
    Customer save(Customer customer);
}
