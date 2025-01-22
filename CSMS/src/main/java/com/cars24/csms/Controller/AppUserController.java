package com.cars24.csms.Controller;

import com.cars24.csms.Exception.UserServiceException;
import com.cars24.csms.data.dao.AppUserDao;
import com.cars24.csms.data.entities.AppUserdetails;
import com.cars24.csms.data.req.Logindetails;
import com.cars24.csms.data.req.SignUpReq;
import com.cars24.csms.data.response.ApiResponse;
import com.cars24.csms.data.response.LoginResponse;
import com.cars24.csms.services.AppUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Service
public class AppUserController {
    private final AppUserDao appUserDao;
    private final AppUserService appUserService;

   /* @PostMapping
    public ResponseEntity<LoginResponse> getAppUser(@RequestBody Logindetails logindetails) {
        log.info("[getAppUser] Logindetails: {}", logindetails);

        // Fetch the user details
        AppUserdetails userDetails = appUserDao.getAppUser(logindetails);

        // Map to LoginResponse
        LoginResponse response = new LoginResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());

        return ResponseEntity.ok(response);
    }*/
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> appUserSignup(@Valid @RequestBody SignUpReq signUpReq){
        log.info("[appUserSignup] SignUp Request: {}", signUpReq);
        try{
            ApiResponse response= appUserService.createUser(signUpReq);
            return  ResponseEntity.status(response.getStatus()).body(response);
        }
        catch(UserServiceException e){
            throw new UserServiceException("signup failed"+e.getMessage());
        }

    }

}
