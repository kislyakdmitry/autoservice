package autoservice.app.services.impl;

import autoservice.app.domain.Employee;
import autoservice.app.repositories.EmployeeRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private EmployeeRepo employeeRepo;

    public UserDetailsServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findByUsername(username).get();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return new User(employee.getUsername(), passwordEncoder.encode(employee.getPassword()), getAuthority());
    }

    public Employee getCurrentUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return employeeRepo.findByUsername(principal.getName()).orElseThrow(EntityNotFoundException::new);
    }

    private List getAuthority() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
