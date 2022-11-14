package br.com.authentication.controller;

import br.com.authentication.domain.representation.LoginRepresentation;
import br.com.authentication.domain.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final LoginService loginService;

    @GetMapping
    public ResponseEntity<?> generateToken(@RequestBody LoginRepresentation.Login login){

        return ResponseEntity.ok(this.loginService.login(login));
    }
}
