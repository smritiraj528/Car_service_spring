package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.AppUserdetails;
import com.cars24.csms.data.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserdetails,Integer> {
    public AppUserdetails findAppUserDetailsByUsernameAndPassword(String Username,String password);

    //@Override
    boolean existsByUsername(String username);
}
