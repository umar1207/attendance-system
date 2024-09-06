package system.attendance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.attendance.backend.dto.user.UserRequestDto;
import system.attendance.backend.dto.user.UserUpdateDto;
import system.attendance.backend.service.user.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto){
        userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserUpdateDto userUpdateDto){
        userService.updateUser(userId, userUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body("User Details Updated");
    }
}
