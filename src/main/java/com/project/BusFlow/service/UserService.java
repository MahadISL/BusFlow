package com.project.BusFlow.service;

import com.project.BusFlow.model.User;
import com.project.BusFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;


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
}
