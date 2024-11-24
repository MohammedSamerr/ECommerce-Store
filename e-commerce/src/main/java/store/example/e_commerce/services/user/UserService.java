package store.example.e_commerce.services.user;

import store.example.e_commerce.dto.SignUpDto;
import store.example.e_commerce.dto.UserDto;

public interface UserService {
    UserDto createUser(SignUpDto signUpDto);

    boolean hasUserWithEmail(String email);
}
