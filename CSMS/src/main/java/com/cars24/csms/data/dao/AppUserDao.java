package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.AppUserdetails;
import com.cars24.csms.data.req.Logindetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface AppUserDao {
    public AppUserdetails getAppUser(Logindetails logindetails);
    //public boolean findUserByUsername(String username);
    boolean userExists(String username);
    void saveUser(AppUserdetails user);


}

