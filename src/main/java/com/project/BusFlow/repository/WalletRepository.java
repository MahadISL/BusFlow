package com.project.BusFlow.repository;

import com.project.BusFlow.model.User;
import com.project.BusFlow.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {

    Wallet findByUserObj(User user);
}
