package store.example.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import store.example.e_commerce.dto.SignUpDto;
import store.example.e_commerce.dto.UserDto;
import store.example.e_commerce.services.user.UserService;

@RestController
public class SignupController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignUpDto signUpDto) {
        if(userService.hasUserWithEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("User already exist", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdUser = userService.createUser(signUpDto);
        if(createdUser == null){
            return new ResponseEntity<>("User not Created", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
}
