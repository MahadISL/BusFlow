package com.project.BusFlow.controller;


import com.project.BusFlow.model.User;
import com.project.BusFlow.payload.request.SigninRequest;
import com.project.BusFlow.payload.request.SignupRequest;
import com.project.BusFlow.payload.response.SigninResponse;
import com.project.BusFlow.payload.response.SignupResponse;
import com.project.BusFlow.repository.UserRepository;
import com.project.BusFlow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("busflow")
public class UserController {


    @Autowired
    UserRepository userRepo;

    @Autowired
    UserService userService;

    @Autowired
    User user;

    @Autowired
    SignupResponse signupResponse;

    @Autowired
    SigninResponse signinResponse;

    @PostMapping("/signup")
    ResponseEntity<SignupResponse> signUp(@RequestBody SignupRequest signupRequest){

        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(signupRequest.getPassword());
        user.setAge(signupRequest.getAge());

        System.out.println(user);

        User userSaved = userRepo.save(user);

        signupResponse.setName(user.getName());
        signupResponse.setEmail(user.getEmail());
        signupResponse.setPassword(user.getPassword());
        signupResponse.setAge(user.getAge());
        signupResponse.setResponseCode(String.valueOf(HttpStatus.OK));
        signupResponse.setResponseBody("SUCCESSFULLY SAVED USER");

        return new ResponseEntity<>(signupResponse,HttpStatus.OK);

    }

    @PostMapping("/signin")
    ResponseEntity<SigninResponse> signIn(@RequestBody SigninRequest signinRequest){

//        System.out.println(signinRequest.getEmail() + " "+ signinRequest.getPassword());
//        User userExists = userRepo.findByEmail(signinRequest.getEmail());
//        User userSaved1 = userRepo.findByPassword(signinRequest.getPassword());
//        System.out.println(userExists);
//        System.out.println(userSaved1);
//
//        User userSaved2 = userRepo.findByEmailAndPassword(signinRequest.getEmail(), signinRequest.getPassword());
//        System.out.println(userSaved2);


        Boolean userExists = userService.checkIfUserExists(signinRequest.getEmail(),signinRequest.getPassword());

        if(userExists){

            signinResponse.setResponseCode(String.valueOf(HttpStatus.OK));
            signinResponse.setResponseBody("SUCCESSFULLY SIGNED IN");
            return new ResponseEntity<>(signinResponse, HttpStatus.OK);
        }
        else {
            signinResponse.setResponseCode(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            signinResponse.setResponseBody("NO ACCOUNT WITH THESE CREDENTIALS");
            return new ResponseEntity<>(signinResponse, HttpStatus.EXPECTATION_FAILED);
        }

    }


}
