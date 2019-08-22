package autoservice.app.services.impl;

import autoservice.app.domain.Customer;
import autoservice.app.repositories.CustomersRepo;
import autoservice.app.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private CustomersRepo customersRepo;

    @Override
    public Customer getCurrentUser() {
        //Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return customersRepo.findByUsername("user1").get();
        /*return customersRepo.findByUsername(principal.getName())
                .orElseThrow(() -> new UserNotFoundException("User " + principal.getName() + " not found"));*/
    }
}
