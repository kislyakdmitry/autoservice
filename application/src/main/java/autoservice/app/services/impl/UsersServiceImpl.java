package autoservice.app.services.impl;

import autoservice.app.exceptions.UserNotFoundException;
import autoservice.app.services.UsersService;
import autoservice.data.domain.Customer;
import autoservice.data.repositories.CustomersRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UsersServiceImpl implements UsersService {
    private CustomersRepo customersRepo;

    public UsersServiceImpl(CustomersRepo customersRepo) {
        this.customersRepo = customersRepo;
    }

    @Override
    public Customer getCurrentUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return customersRepo.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException("User " + principal.getName() + " not found"));
    }
}
