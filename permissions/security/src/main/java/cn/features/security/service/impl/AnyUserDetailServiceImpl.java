package cn.features.security.service.impl;

import cn.features.common.service.UserService;
import cn.features.security.service.AnyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author limouren
 */
@Service
public class AnyUserDetailServiceImpl implements UserDetailsService,AnyUserDetailService {

//    @Autowired
//    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public String encryptPassword(String password) {
        return null;
    }
}
