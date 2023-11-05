package ru.netology.springboot_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.springboot_rest.exception.InvalidCredentials;
import ru.netology.springboot_rest.exception.UnauthorizedUser;
import ru.netology.springboot_rest.service.Authorities;
import ru.netology.springboot_rest.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials (InvalidCredentials e){
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e){
        System.out.println("Exception: " + e.getMessage());
        return new ResponseEntity<>("Exception: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}