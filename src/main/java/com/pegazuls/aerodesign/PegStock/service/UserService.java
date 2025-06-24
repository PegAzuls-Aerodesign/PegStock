package com.pegazuls.aerodesign.PegStock.service;

import com.pegazuls.aerodesign.PegStock.infra.security.JwtTokenService;
import com.pegazuls.aerodesign.PegStock.infra.security.SecurityConfiguration;
import com.pegazuls.aerodesign.PegStock.infra.security.UserDetailsImpl;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTOCreateUser;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTOLogin;
import com.pegazuls.aerodesign.PegStock.model.dto.authentication.DTORecoveryJwtToken;
import com.pegazuls.aerodesign.PegStock.model.entities.User;
import com.pegazuls.aerodesign.PegStock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public DTORecoveryJwtToken authenticateUser(DTOLogin login) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.email(), login.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new DTORecoveryJwtToken(jwtTokenService.generateToken(userDetails));
    }

    public User createUser(DTOCreateUser user){

        User newUser = User.builder()
                .name(user.name())
                .email(user.email())
                .password(securityConfiguration.passwordEncoder().encode(user.password()))
                .build();

        return userRepository.save(newUser);
    }
}
