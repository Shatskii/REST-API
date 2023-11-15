package com.rest.maximTehnology.service;

import com.rest.maximTehnology.adapter.MyUserDetails;
import com.rest.maximTehnology.entity.User;
import com.rest.maximTehnology.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByName = userRepository.findUserByName(username);
        if (userByName == null) {
            throw new UsernameNotFoundException("User with name " + username + "not found!");
        }
        return new MyUserDetails(userByName);
    }
}
