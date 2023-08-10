package com.project.BusFlow.repository;

import com.project.BusFlow.model.Token;
import com.project.BusFlow.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TokenRepository extends CrudRepository<Token, Integer> {

    List<Token> findByUserObj(User user);

    Integer deleteById(long id);
}
