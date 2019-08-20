package autoservice.app.services.impl;

import autoservice.app.domain.Customer;
import autoservice.app.repositories.CustomersRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private CustomersRepo customersRepo;

    public UserDetailServiceImpl(CustomersRepo customersRepo) {
        this.customersRepo = customersRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customersRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));
        return new org.springframework.security.core.userdetails.User(
                customer.getUsername(), customer.getPassword(), getAuthorities(customer));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Customer customer) {
        String[] userRoles = customer.getAuthorities().stream()
                .map(Enum::name).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }

}
