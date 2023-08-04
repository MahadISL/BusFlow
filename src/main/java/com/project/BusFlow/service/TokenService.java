package com.project.BusFlow.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TokenService {


    public String tokenPrices(String city, String startPosition, String stopPosition){
        HashMap<String, Integer> busStopDistanceValue = new HashMap<String, Integer>();

        busStopDistanceValue.put("A",0);
        busStopDistanceValue.put("B",1);
        busStopDistanceValue.put("C",2);
        busStopDistanceValue.put("D",3);


        if(city.equals("Islamabad")){
            Integer startingPositionVal = busStopDistanceValue.get(startPosition);
            Integer stopingPositionVal = busStopDistanceValue.get(stopPosition);
            for(int i=stopingPositionVal; i<stopingPositionVal; i++){

            }
        }
    }
}
