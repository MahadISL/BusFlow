package com.project.BusFlow.service;

import com.project.BusFlow.model.User;
import com.project.BusFlow.payload.request.SignupRequest;
import com.project.BusFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    User user;


    public Boolean checkIfUserExists(String email, String password){
        Boolean emailExists = userRepo.existsByEmail(email);

        if(emailExists) {
            User userObject = userRepo.findByEmail(email);

            if(userObject.getPassword().equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public User saveUser(SignupRequest signupRequest) {
        User user1 = userRepo.findByEmail(signupRequest.getEmail());

        if(user1 == null) {
//            User user2 = new User();
            user.setUsername(null);
            user.setName(signupRequest.getName());
            user.setEmail(signupRequest.getEmail());
            user.setPassword(signupRequest.getPassword());
            user.setAge(signupRequest.getAge());
            return userRepo.save(user);

        } else {

            System.out.println("NOT NULL");
        }
        return user;
    }
}
