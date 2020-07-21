package com.example.fjob.service.service.account;

import com.example.fjob.lib.component.account.ApplicationUserComponent;
import com.example.fjob.lib.dataset.account.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private ApplicationUserComponent applicationUserComponent;

    @Autowired
    public UserDetailsServiceImpl(ApplicationUserComponent applicationUserComponent) {
        this.applicationUserComponent = applicationUserComponent;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser applicationUser = applicationUserComponent.findByUsername(username);
        System.out.println(applicationUser.getEmail());
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
