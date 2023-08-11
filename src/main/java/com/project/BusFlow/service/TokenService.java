package com.project.BusFlow.service;


import com.project.BusFlow.model.Token;
import com.project.BusFlow.model.User;
import com.project.BusFlow.payload.response.BuyTokensServiceResponse;
import com.project.BusFlow.payload.response.TokenPricesServiceResponse;
import com.project.BusFlow.payload.response.TotalPriceResponse;
import com.project.BusFlow.payload.response.TotalPriceServiceResponse;
import com.project.BusFlow.repository.TokenRepository;
import com.project.BusFlow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;


@Service
public class TokenService {

    @Autowired
    TotalPriceServiceResponse totalPriceServiceResponse;

    @Autowired
    WalletService walletService;

    @Autowired
    TokenPricesServiceResponse tokenPricesServiceResponse;

    @Autowired
    BuyTokensServiceResponse buyTokensServiceResponse;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    Token token;

    HashMap<String, Integer> busStopDistanceValue = new HashMap<String, Integer>();

    public TotalPriceServiceResponse totalPrice(String city, String startPosition, String stopPosition){

        // Bus stops with number values for distance calculation
        busStopDistanceValue.put("A",0);
        busStopDistanceValue.put("B",1);
        busStopDistanceValue.put("C",2);
        busStopDistanceValue.put("D",3);

        int distance = 0;
        // 4 $ price per token for Islamabad
        int islamabadTokenPrice = 4;
        // 2 $ price per token for Lahore
        int lahoreTokenPrice = 2;
        int totalPrice;
        String charges;

        if(busStopDistanceValue.containsKey(startPosition) && busStopDistanceValue.containsKey(startPosition)) {


            if (city.equals("Islamabad") || city.equals("Lahore")) {

                Integer startingPositionVal = busStopDistanceValue.get(startPosition);
                Integer stoppingPositionVal = busStopDistanceValue.get(stopPosition);

                if (startingPositionVal < stoppingPositionVal) {

                    for (int i = startingPositionVal; i < stoppingPositionVal; i++) {
                        distance += 1;
                    }
                } else {

                    for (int i = stoppingPositionVal; i < startingPositionVal; i++) {
                        distance += 1;
                    }
                }
                if (city.equals("Islamabad")) {
                    totalPrice = distance * islamabadTokenPrice;
                    charges = String.valueOf(totalPrice) + " $";
                } else {
                    totalPrice = distance * lahoreTokenPrice;
                    charges = String.valueOf(totalPrice) + " $";
                }

                totalPriceServiceResponse.setTokens(String.valueOf(distance));
                totalPriceServiceResponse.setTotalCharge(charges);

                return totalPriceServiceResponse;
            }
        }


        return totalPriceServiceResponse;
    }

    public TokenPricesServiceResponse tokenPrices(String city){

        if(city.equals("Islamabad")){
            tokenPricesServiceResponse.setOneToken("1 Token for 4$ (code 4) ");
            tokenPricesServiceResponse.setOneMonth("20 Tokens for One Month in 60$ only (code 14) ");
            tokenPricesServiceResponse.setThreeMonth("60 Tokens for Three Month in 150$ only (code 34) ");
            tokenPricesServiceResponse.setSixMonth("150 Tokens for Six Month in 300$ only (code 64) ");
            tokenPricesServiceResponse.setOneYear("300 Tokens for One Year in 450$ only (code 104) ");
            return tokenPricesServiceResponse;
        }
        else if(city.equals("Lahore")){
            tokenPricesServiceResponse.setOneToken("1 Token for 2$ only (code 2) ");
            tokenPricesServiceResponse.setOneMonth("20 Tokens for One Month in 36$ only (code 12) ");
            tokenPricesServiceResponse.setThreeMonth("60 Tokens for Three Month in 90$ only (code 32) ");
            tokenPricesServiceResponse.setSixMonth("150 Tokens for Six Month in 150$ only (code 62) ");
            tokenPricesServiceResponse.setOneYear("300 Tokens for One Year in 240$ only (code 102)) ");
            return tokenPricesServiceResponse;
        }

        return tokenPricesServiceResponse;
    }

    public BuyTokensServiceResponse buyTokens(int code, UUID userId){

        LocalDate localDate = LocalDate.now();
        User userObj = userRepository.findByUsername(userId);

//        LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Karachi"));

        switch (code) {
            case 4:
                token.setId(0);
                token.setTokenCount(1);
                token.setBalance(4.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusYears(2));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 12:
                token.setId(0);
                token.setTokenCount(20);
                token.setBalance(36.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusMonths(1));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 32:
                token.setId(0);
                token.setTokenCount(60);
                token.setBalance(90.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusMonths(3));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 62:
                token.setId(0);
                token.setTokenCount(150);
                token.setBalance(150.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusMonths(6));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 104:
                token.setId(0);
                token.setTokenCount(300);
                token.setBalance(450.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusYears(1));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 2:
                token.setId(0);
                token.setTokenCount(1);
                token.setBalance(2.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusYears(2));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 14:
                token.setId(0);
                token.setTokenCount(20);
                token.setBalance(60.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusMonths(1));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 34:
                token.setId(0);
                token.setTokenCount(60);
                token.setBalance(150.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusMonths(3));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 64:
                token.setId(0);
                token.setTokenCount(150);
                token.setBalance(300.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusMonths(6));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);
                break;
            case 102:
                token.setId(0);
                token.setTokenCount(300);
                token.setBalance(240.00);
                token.setCreateDate(localDate);
                token.setExpireDate(localDate.plusYears(1));
                token.setValid(true);
                token.setUserObj(userObj);
                token.setTokeCode(tokenCodeGeneration(userObj.getUsername()));
                tokenRepository.save(token);

                break;
            default:
                System.out.println("WRONG CODE");
        }
        buyTokensServiceResponse.setCost(token.getBalance());
        buyTokensServiceResponse.setExpiry(token.getExpireDate());
        buyTokensServiceResponse.setTokens(token.getTokenCount());
        return buyTokensServiceResponse;
    }

    private String tokenCodeGeneration(UUID username){
        String uuidString = username.toString();
        Random random = new Random();

        int randomInt = 2000 + random.nextInt(30000);
        int randomInt2 = 4000 + random.nextInt(60000);
        String halfUuidString = uuidString.substring(0,uuidString.length()/2);

        String tokenCode = String.valueOf(randomInt) + halfUuidString + String.valueOf(randomInt2);

        return tokenCode;
    }

    public User deleteToken(UUID username){

        User foundUser = userRepository.findByUsername(username);

        List<Token> foundTokens = tokenRepository.findByUserObj(foundUser);

        // Delete all the tokens for particular username
        for(Token token: foundTokens){
            Integer val = tokenRepository.deleteById(token.getId());
        }
        return foundUser;
    }
}
