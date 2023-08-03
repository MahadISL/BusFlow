package com.project.BusFlow.controller;


import com.project.BusFlow.model.User;
import com.project.BusFlow.payload.request.SigninRequest;
import com.project.BusFlow.payload.request.SignupRequest;
import com.project.BusFlow.payload.response.SigninResponse;
import com.project.BusFlow.payload.response.SignupResponse;
import com.project.BusFlow.repository.UserRepository;
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

        User userSaved = userRepo.findByEmail(signinRequest.getEmail());
        User userSaved1 = userRepo.findByPassword(signinRequest.getPassword());
        System.out.println(userSaved);
        System.out.println(userSaved1);

        User userSaved2 = userRepo.findByEmailAndPassword(signinRequest.getEmail(), signinRequest.getPassword());
        System.out.println(userSaved2);


        signinResponse.setResponseCode(String.valueOf(HttpStatus.OK));
        signinResponse.setResponseBody("SUCCESSFULLY SIGNED IN");

        return new ResponseEntity<>(signinResponse, HttpStatus.OK);

    }


}
