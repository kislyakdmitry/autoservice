package com.autoservice.services.impl;

import com.autoservice.domain.Customer;
import com.autoservice.exceptions.UserNotFoundException;
import com.autoservice.repositories.CustomersRepo;
import com.autoservice.services.UsersService;
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
