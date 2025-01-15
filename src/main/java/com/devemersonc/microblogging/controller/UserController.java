package com.devemersonc.microblogging.controller;

import com.devemersonc.microblogging.dto.RegisterUserDTO;
import com.devemersonc.microblogging.dto.UserDTO;
import com.devemersonc.microblogging.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUser(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/normal-user")
    public ResponseEntity<String> saveNormalUser(@Valid @RequestBody RegisterUserDTO registerUserDTO) {
        userService.saveNormalUser(registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito.");
    }

    @PostMapping("/admin-user")
    public ResponseEntity<String> saveAdminUser(@Valid @RequestBody RegisterUserDTO registerUserDTO) {
        userService.saveAdminUser(registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody RegisterUserDTO registerUserDTO, @PathVariable Long id) {
        userService.updateUser(id, registerUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario actualizado con éxito.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Usuario eliminado con éxito");
    }
}
