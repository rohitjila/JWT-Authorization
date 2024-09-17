package com.authorization.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username) {
        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndPoint(@RequestHeader(value = "Authorization", required = false) String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Missing or malformed Authorization header");
        }
        token = token.substring(7);

        String username = jwtUtil.validateToken(token);
        if (username != null) {
            return ResponseEntity.ok("Hello " + username + ", you are authorized successfully");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
    }
}
