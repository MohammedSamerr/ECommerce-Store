package store.example.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;
import store.example.e_commerce.enums.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String name;

    private String password;

    private String email;

    private UserRole userRole;



}
