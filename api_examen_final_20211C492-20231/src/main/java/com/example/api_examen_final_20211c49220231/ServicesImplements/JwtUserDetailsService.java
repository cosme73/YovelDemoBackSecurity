package com.example.api_examen_final_20211c49220231.ServicesImplements;

import com.example.api_examen_final_20211c49220231.Entities.Users;
import com.example.api_examen_final_20211c49220231.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository ycqtRepo;

    @Override
    public UserDetails loadUserByUsername(String ycqtusername) throws UsernameNotFoundException {
        Users ycqtUser  = ycqtRepo.findByYcqtusername(ycqtusername);

        if(ycqtUser  == null) {
            throw new UsernameNotFoundException(String.format("User not exists", ycqtusername));
        }

        List<GrantedAuthority> ycqtRoles  = new ArrayList<>();

        ycqtUser .getYcqtroles().forEach(rol -> {
            ycqtRoles .add(new SimpleGrantedAuthority(rol.getYcqtrol()));
        });

        UserDetails ycqtUd  = new org.springframework.security.core.userdetails.User(ycqtUser .getYcqtusername(), ycqtUser .getYcqtpassword(), ycqtUser .getYcqtenabled(), true, true, true, ycqtRoles );

        return ycqtUd ;
    }
}