package br.com.authentication.controller;

import br.com.authentication.domain.model.User;
import br.com.authentication.domain.representation.UserRepresentation;
import br.com.authentication.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserRepresentation.CreateOrUpdateUser user){
        this.service.create(user);

        return ResponseEntity.ok().build();
    }
}
