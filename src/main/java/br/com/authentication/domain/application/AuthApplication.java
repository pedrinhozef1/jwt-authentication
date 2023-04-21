package br.com.authentication.domain.application;

import br.com.authentication.api.dto.AuthDto;
import br.com.authentication.domain.model.Login;
import br.com.authentication.domain.model.UserToken;
import br.com.authentication.domain.model.User;
import br.com.authentication.domain.service.CryptographyService;
import br.com.authentication.domain.service.TokenService;
import br.com.authentication.domain.service.UserService;
import br.com.authentication.domain.model.exception.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthApplication {
    private UserService userService;
    private TokenService tokenService;
    private CryptographyService cryptographyService;

    public Login login(AuthDto login){
        User user = this.userService.findAccountByUsername(login.getUsername());

        if (!this.cryptographyService.decrypt(user.getPassword()).equals(login.getPassword())) {
            throw new UnauthorizedException("Incorrect password for user " + login.getUsername());
        }

        var role = user.getRole().getName();
        var token = this.tokenService.generateToken(new UserToken(user.getId(), user.getUsername()), role);

        return Login.builder()
                .user(UserToken.builder()
                        .id(user.getId())
                        .userName(user.getUsername())
                        .build())
                .tokenType("Bearer")
                .token(token)
                .role(role)
                .build();
    }
}