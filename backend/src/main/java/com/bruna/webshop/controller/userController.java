package com.bruna.webshop.controller;

import com.bruna.webshop.dto.UserDataDTO;
import com.bruna.webshop.services.UserDataService;
import com.bruna.webshop.modules.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class userController {
    private UserDataService userDataService;

    public userController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDataDTO> authenticatedUser() {
        UserData userData = userDataService.getUserByToken();

        UserDataDTO userDataDTO = new UserDataDTO(userData.getUserID(), userData.getUserName(), userData.getEmail(), userData.getCity(), userData.getPostalCode(), userData.getStreetName(), userData.getHouseNumber(), userData.getOrderData(), userData.getReviewData());

        return ResponseEntity.ok(userDataDTO);
    }

}

