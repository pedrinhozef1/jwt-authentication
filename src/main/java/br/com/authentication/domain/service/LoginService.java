package br.com.authentication.domain.service;

import antlr.Token;
import br.com.authentication.config.Auth.TokenService;
import br.com.authentication.domain.model.User;
import br.com.authentication.domain.representation.LoginRepresentation;
import br.com.authentication.domain.representation.UserRepresentation;
import br.com.authentication.exception.UnauthorizedException;
import br.com.authentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private TokenService tokenService;
    private UserRepository userRepository;
    private UserService userService;
    private CryptographyService cryptographyService;

    public LoginRepresentation.LoginResponse login(LoginRepresentation.Login login){
        User user = this.userService.findAccountByUsername(login.getUsername());

        if (this.cryptographyService.decrypt(user.getPassword()).equals(login.getPassword())) {
            return this.login(user);
        } else {
            throw new UnauthorizedException("Incorrect password for user " + login.getPassword());
        }
    }

    public LoginRepresentation.LoginResponse login(User user){

        String token = this.tokenService.generateToken(UserRepresentation.UserToken.from(user));

        return LoginRepresentation.LoginResponse.builder()
                .user(UserRepresentation.UserToken.from(user))
                .tokenType("Bearer")
                .token(token)
//                .expirationDate(token)
                .build();
    }
}
