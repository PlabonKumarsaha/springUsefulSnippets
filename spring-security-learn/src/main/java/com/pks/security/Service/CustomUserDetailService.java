package com.pks.security.Service;

import com.pks.security.Model.CustomerDetailService;
import com.pks.security.Model.User;
import com.pks.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findById(userName).get();
        if(user !=null) {
            throw  new UsernameNotFoundException("NO USER");
        }
        return new CustomerDetailService(user);
    }
}
