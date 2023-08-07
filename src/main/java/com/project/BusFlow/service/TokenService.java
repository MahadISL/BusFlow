package com.project.BusFlow.service;


import com.project.BusFlow.payload.response.TokenPricesServiceResponse;
import com.project.BusFlow.payload.response.TotalPriceResponse;
import com.project.BusFlow.payload.response.TotalPriceServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;



@Service
public class TokenService {

    @Autowired
    TotalPriceServiceResponse totalPriceServiceResponse;

    @Autowired
    TokenPricesServiceResponse tokenPricesServiceResponse;

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
            tokenPricesServiceResponse.setOneToken("1 Token for 4$");
            tokenPricesServiceResponse.setOneMonth("20 Tokens for One Month in 60$ only");
            tokenPricesServiceResponse.setThreeMonth("60 Tokens for Three Month in 150$ only");
            tokenPricesServiceResponse.setSixMonth("150 Tokens for Six Month in 300$ only");
            tokenPricesServiceResponse.setOneYear("300 Tokens for One Year in 450$ only");
            return tokenPricesServiceResponse;
        }
        else if(city.equals("Lahore")){
            tokenPricesServiceResponse.setOneToken("1 Token for 2$ only");
            tokenPricesServiceResponse.setOneMonth("20 Tokens for One Month in 36$ only");
            tokenPricesServiceResponse.setThreeMonth("60 Tokens for Three Month in 90$ only");
            tokenPricesServiceResponse.setSixMonth("150 Tokens for Six Month in 150$ only");
            tokenPricesServiceResponse.setOneYear("300 Tokens for One Year in 240$ only");
            return tokenPricesServiceResponse;
        }

        return tokenPricesServiceResponse;
    }
}
