package br.com.authentication.api.controller;

import br.com.authentication.api.dto.AuthDto;
import br.com.authentication.domain.application.AuthApplication;
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
    private final AuthApplication application;

    @GetMapping
    public ResponseEntity<?> generateToken(@RequestBody AuthDto auth){

        return ResponseEntity.ok(this.application.login(auth));
    }
}
