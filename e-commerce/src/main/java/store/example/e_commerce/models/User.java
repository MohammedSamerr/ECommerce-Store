package store.example.e_commerce.models;

import jakarta.persistence.*;
import lombok.Data;
import store.example.e_commerce.dto.UserDto;
import store.example.e_commerce.enums.UserRole;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;

    private byte[] img;

    private UserRole userRole;

    public UserDto mapUsertoDto() {
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setEmail(this.email);
        userDto.setName(this.name);
        userDto.setUserRole(this.userRole);
        return userDto;
    }

}
