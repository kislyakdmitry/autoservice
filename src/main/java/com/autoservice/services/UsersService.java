package com.autoservice.services;

import com.autoservice.domain.Customer;

import java.security.Principal;

public interface UsersService {
    Customer getCurrentUser();
}
