package com.cars24.csms.services.Impl;

import com.cars24.csms.Exception.UserServiceException;
import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserdetails;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.response.ApiResponse;
import com.cars24.csms.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserDao appUserDao;

    @Override
    public ApiResponse createUser(SignUpReq signUpReq) {
        log.info("[createUser] Checking if user exists: {}", signUpReq.getUsername());

        if (appUserDao.userExists(signUpReq.getUsername())) {
            throw new UserServiceException("User already exists. Please log in.");
        }

        log.info("[createUser] Creating new user: {}", signUpReq.getUsername());
        AppUserdetails newUser = new AppUserdetails();
        newUser.setUsername(signUpReq.getUsername());
        newUser.setPassword(signUpReq.getPassword());
        newUser.setEnabled(true);

        appUserDao.saveUser(newUser);

        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.CREATED.value());
        response.setSuccess(true);
        response.setMessage("User signed up successfully.");
        response.setData(newUser);
        response.setService("appUserSignup");

        return response;
    }
}
