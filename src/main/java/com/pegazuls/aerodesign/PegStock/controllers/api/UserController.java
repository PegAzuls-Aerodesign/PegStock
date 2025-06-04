package com.pegazuls.aerodesign.PegStock.controllers.api;

import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTOCreateUser;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTOLogin;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTORecoveryJwtToken;
import com.pegazuls.aerodesign.PegStock.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuario", description = "Controller para gerenciar usuários do sistema e fazer autenticação")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary = "Login de usuário", description = "Realiza o login do usuário e retorna um token JWT.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso, token JWT retornado."),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas.")
    })
    public ResponseEntity<DTORecoveryJwtToken> login(@RequestBody @Valid DTOLogin login) {
        DTORecoveryJwtToken token = userService.authenticateUser(login);
        return ResponseEntity.ok(token);
    }

    @PostMapping
    @Operation(summary = "Criação de usuário", description = "Cria um novo usuário no sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso."),
    })
    public ResponseEntity<?> createUser(@RequestBody @Valid DTOCreateUser user, UriComponentsBuilder uriBuilder) {
        var userRegisted = userService.createUser(user);
        var uri = uriBuilder.path("/users").build().toUri();
        return ResponseEntity.created(uri).body(userRegisted);
    }

    @GetMapping("/test")
    @SecurityRequirement(name = "bearer-key")
    @Operation(summary = "Teste de autenticação", description = "Endpoint para testar a autenticação do usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Teste de autenticação bem-sucedido."),
            @ApiResponse(responseCode = "401", description = "Usuário não autenticado.")
    })
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test successful");
    }
}
