package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserdetails;
import com.cars24.csms.data.repositories.AppUserRepository;
import com.cars24.csms.data.req.Logindetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Repository
@RequiredArgsConstructor
public class AppUserDaoImpl implements AppUserDao {
    private final AppUserRepository apr;


    public AppUserdetails getAppUser(Logindetails logindetails){
      // String
        //String Password;
        AppUserdetails appUserdetails=apr.findAppUserDetailsByUsernameAndPassword(logindetails.getUsername(),logindetails.getPassword());
        return null;



    }
    @Override
    public boolean userExists(String username) {
        return apr.existsByUsername(username); // username represents email
    }
    @Override
    public void saveUser(AppUserdetails user){
        apr.save(user);
    }

}
