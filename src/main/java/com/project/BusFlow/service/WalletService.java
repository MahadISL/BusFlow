package com.project.BusFlow.service;

import com.project.BusFlow.model.User;
import com.project.BusFlow.model.Wallet;
import com.project.BusFlow.repository.UserRepository;
import com.project.BusFlow.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepo;

    @Autowired
    UserRepository userRepo;

    public Boolean calculateBalance(User user, Integer tokenCount,Double tokenBalance, UUID userID){

        Wallet wallet = walletRepo.findByUserObj(user);
        // sender balance (user)
        Double currentBalance = wallet.getBalance();
        Integer currentTokens = wallet.getTokens();

        Double amountTransferred = tokenBalance;
        Integer tokensBought = tokenCount;

        // receiver balance
//        User user1 = userRepo.findByAccountNo(request.getReceiverAccountNo());
//        Double currentBalance1 = user1.getBalance();

        // Calculating and updating new balance in user account
        currentBalance = currentBalance + amountTransferred;
        wallet.setBalance(currentBalance);

        currentTokens = currentTokens + tokensBought;
        wallet.setTokens(currentTokens);

        User userObj = userRepo.findByUsername(userID);
        wallet.setUserObj(userObj);

        walletRepo.save(wallet);

        // Calculating and updating new balance in receiver account
//            currentBalance1 = currentBalance1 + amountTransferred;
//            user1.setBalance(currentBalance1);
//            userRepo.save(user1);

        return true;

    }
}
