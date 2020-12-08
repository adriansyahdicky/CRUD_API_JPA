package com.dicky.react.ApiReact.service;

import com.dicky.react.ApiReact.model.auth.CustomUserPrincipal;
import com.dicky.react.ApiReact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.dicky.react.ApiReact.model.User user = userRepository.findByUsername(userName);
        //boolean isPasswordMatch = passwordEncoder.matches("yawinpassword", user.getPassword());

        if(user == null){
            throw  new UsernameNotFoundException("Invalid Username Or Password");
        }

        return CustomUserPrincipal.create(user);
        //return new User("foo", "foo", new ArrayList<>());
    }
}
