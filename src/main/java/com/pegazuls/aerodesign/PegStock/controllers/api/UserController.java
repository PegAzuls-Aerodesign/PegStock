package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTOCreateUser;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTOLogin;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTORecoveryJwtToken;
import com.pegazuls.aerodesign.PegStock.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<DTORecoveryJwtToken> login(@RequestBody @Valid DTOLogin login) {
        DTORecoveryJwtToken token = userService.authenticateUser(login);
        return ResponseEntity.ok(token);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid DTOCreateUser user, UriComponentsBuilder uriBuilder) {
        var userRegisted = userService.createUser(user);
        var uri = uriBuilder.path("/users").build().toUri();
        return ResponseEntity.created(uri).body(userRegisted);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test successful");
    }
}
