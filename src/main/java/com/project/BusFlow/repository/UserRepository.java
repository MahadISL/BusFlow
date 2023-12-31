package com.project.BusFlow.repository;

import com.project.BusFlow.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User findByPassword(String password);
    Boolean existsByEmail(String email);
    Boolean existsByPassword(String password);

    User findByUsername(UUID userId);

    UUID findUsernameByEmail(String email);

    Integer deleteByUsername(UUID username);


}
