package com.project.BusFlow.controller;


import com.project.BusFlow.model.Token;
import com.project.BusFlow.model.User;
import com.project.BusFlow.payload.request.*;
import com.project.BusFlow.payload.response.*;
import com.project.BusFlow.repository.TokenRepository;
import com.project.BusFlow.repository.UserRepository;
import com.project.BusFlow.service.TokenService;
import com.project.BusFlow.service.UserService;
import com.project.BusFlow.service.WalletService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("busflow")
public class UserController {


    @Autowired
    UserRepository userRepo;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @Autowired
    WalletService walletService;

    @Autowired
    User user;

    @Autowired
    SignupResponse signupResponse;

    @Autowired
    SigninResponse signinResponse;

    @Autowired
    TotalPriceResponse totalPriceResponse;

    @Autowired
    TokenPricesResponse tokenPricesResponse;

    @Autowired
    BuyTokensResponse buyTokensResponse;

    @Autowired
    FetchUsernameResponse fetchUsernameResponse;

    @Autowired
    DeleteUserResponse deleteUserResponse;

    @Autowired
    AddBalanceResponse addBalanceResponse;

    @PostMapping("/signup")
    ResponseEntity<SignupResponse> signUp(@RequestBody SignupRequest signupRequest){

        userService.saveUser(signupRequest);

//        user.setName(signupRequest.getName());
//        user.setEmail(signupRequest.getEmail());
//        user.setPassword(signupRequest.getPassword());
//        user.setAge(signupRequest.getAge());

        System.out.println(user);

//        if(!userRepo.existsByEmail(signupRequest.getEmail())) {
//            User userSaved = userRepo.save(user);
//        }

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

//        System.out.println(signinRequest.getEmail() + " "+ signinRequest.getPassword());
//        User userExists = userRepo.findByEmail(signinRequest.getEmail());
//        User userSaved1 = userRepo.findByPassword(signinRequest.getPassword());
//        System.out.println(userExists);
//        System.out.println(userSaved1);
//
//        User userSaved2 = userRepo.findByEmailAndPassword(signinRequest.getEmail(), signinRequest.getPassword());
//        System.out.println(userSaved2);


        Boolean userExists = userService.checkIfUserExists(signinRequest.getEmail(),signinRequest.getPassword());

        if(userExists){

            signinResponse.setResponseCode(String.valueOf(HttpStatus.OK));
            signinResponse.setResponseBody("SUCCESSFULLY SIGNED IN");
            return new ResponseEntity<>(signinResponse, HttpStatus.OK);
        }
        else {
            signinResponse.setResponseCode(String.valueOf(HttpStatus.EXPECTATION_FAILED));
            signinResponse.setResponseBody("NO ACCOUNT WITH THESE CREDENTIALS");
            return new ResponseEntity<>(signinResponse, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/totalprice")
    ResponseEntity<TotalPriceResponse> totalPrice(@RequestBody TotalPriceRequest totalPriceRequest){

        TotalPriceServiceResponse priceResponse = tokenService.totalPrice(totalPriceRequest.getCity(),
                totalPriceRequest.getStartPosition(),
                totalPriceRequest.getStopPosition());

        if (priceResponse.getTokens() == null){
            totalPriceResponse.setTokensRequired("0");
            totalPriceResponse.setTotalCharges("0 $");
            totalPriceResponse.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST));
            totalPriceResponse.setResponseBody("NO SUCH CITY OR BUS STOPS EXIST");
            return new ResponseEntity<>(totalPriceResponse, HttpStatus.BAD_REQUEST);
        }
        else {
            totalPriceResponse.setTokensRequired(priceResponse.getTokens());
            totalPriceResponse.setTotalCharges(priceResponse.getTotalCharge());
            totalPriceResponse.setResponseCode(String.valueOf(HttpStatus.OK));
            totalPriceResponse.setResponseBody("SUCCESSFULLY CALCULATED TOTAL CHARGES");
            return new ResponseEntity<>(totalPriceResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/tokenprices")
    ResponseEntity<TokenPricesResponse> tokenPrices(@RequestBody TokenPricesRequest tokenPricesRequest){

        TokenPricesServiceResponse prices = tokenService.tokenPrices(tokenPricesRequest.getCity());

        if(prices.getOneToken() == null){

            tokenPricesResponse.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST));
            tokenPricesResponse.setResponseBody("NO SUCH CITY AVAILABLE");

        }
        else{
            tokenPricesResponse.setOneToken(prices.getOneToken());
            tokenPricesResponse.setOneMonth(prices.getOneMonth());
            tokenPricesResponse.setThreeMonth(prices.getThreeMonth());
            tokenPricesResponse.setSixMonth(prices.getSixMonth());
            tokenPricesResponse.setOneYear(prices.getOneYear());
            tokenPricesResponse.setResponseCode(String.valueOf(HttpStatus.OK));
            tokenPricesResponse.setResponseBody("SUCCESSFULLY DISPLAYED TOKEN PRICES");
        }
        return new ResponseEntity<>(tokenPricesResponse, HttpStatus.OK);
    }

    @PostMapping("/buytokens")
    ResponseEntity<BuyTokensResponse> buyTokens(@RequestBody BuyTokensRequest buyTokensRequest){

        BuyTokensServiceResponse buyTokensService = tokenService.buyTokens(buyTokensRequest.getCode(), buyTokensRequest.getUserId());

        User user = userRepo.findByUsername(buyTokensRequest.getUserId());
        Boolean bought = walletService.calculateBalance(user,
                buyTokensService.getTokens(),
                buyTokensService.getCost(),
                buyTokensRequest.getUserId());
        if(buyTokensService.getCost() == null && !bought ){

            buyTokensResponse.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST));
            buyTokensResponse.setResponseBody(String.valueOf("PURCHASE OF TOKENS FAILED"));
            return new ResponseEntity<>(buyTokensResponse, HttpStatus.BAD_REQUEST);

        }
        else{

            buyTokensResponse.setCost(String.valueOf(buyTokensService.getCost()));
            buyTokensResponse.setTokens(String.valueOf(buyTokensService.getTokens()));
            buyTokensResponse.setExpiryTime(String.valueOf(buyTokensService.getExpiry()));
            buyTokensResponse.setResponseCode(String.valueOf(HttpStatus.OK));
            buyTokensResponse.setResponseBody(String.valueOf("SUCCESSFULLY PURCHASED TOKENS"));
            return new ResponseEntity<>(buyTokensResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/fetchusername")
    ResponseEntity<FetchUsernameResponse> fetchUsername(@RequestBody FetchUsernameRequest fetchUsernameRequest){

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        getPrincipal()

        //Principal principal
//        principal.getName()
        User user1 = userRepo.findByEmail(fetchUsernameRequest.getEmail());
        System.out.println(user1);
        fetchUsernameResponse.setUsername(user1.getUsername());
        fetchUsernameResponse.setResponseCode(String.valueOf(HttpStatus.OK));
        fetchUsernameResponse.setResponseBody("SUCCESSFULLY FETCHED USERNAME");

        return new ResponseEntity<>(fetchUsernameResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser")
    @Transactional
    ResponseEntity<DeleteUserResponse> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest){

        User deletedTokensUser = tokenService.deleteToken(deleteUserRequest.getUsername());

        //Integer deletedTokenUsername = tokenRepository.deleteByUserObj(deleteUserRequest.getUsername());

        Integer deletedUser = userRepo.deleteByUsername(deleteUserRequest.getUsername());

        deleteUserResponse.setName(deletedTokensUser.getName());
        deleteUserResponse.setResponseCode(String.valueOf(HttpStatus.OK));
        deleteUserResponse.setResponseBody("SUCCESSFULLY DELETED USER");

        return new ResponseEntity<>(deleteUserResponse, HttpStatus.OK);
    }

    @PostMapping("/createWallet")
    ResponseEntity<?> createWallet(@RequestBody AddBalanceRequest addBalanceRequest){

        walletService.createWallet(addBalanceRequest.getBalance(), addBalanceRequest.getUsername());

        addBalanceResponse.setBalance(addBalanceRequest.getBalance());
        addBalanceResponse.setResponseCode(String.valueOf(HttpStatus.OK));
        addBalanceResponse.setResponseBody("SUCCESSFULLY ADDED BALANCE");

        return  new ResponseEntity<>(addBalanceResponse,HttpStatus.OK);
    }

}
