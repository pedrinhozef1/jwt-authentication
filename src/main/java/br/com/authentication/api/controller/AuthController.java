package br.com.authentication.api.controller;

import br.com.authentication.api.dto.AuthDto;
import br.com.authentication.domain.application.AuthApplication;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final AuthApplication application;

    @PostMapping
    public ResponseEntity<?> generateToken(@RequestBody AuthDto auth){

        return ResponseEntity.ok(this.application.login(auth));
    }
}
