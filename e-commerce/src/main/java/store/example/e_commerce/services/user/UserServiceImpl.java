package store.example.e_commerce.services.user;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import store.example.e_commerce.dto.SignUpDto;
import store.example.e_commerce.dto.UserDto;
import store.example.e_commerce.enums.UserRole;
import store.example.e_commerce.models.User;
import store.example.e_commerce.repository.userRepo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private userRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createAdminAccount(){
        User AdminAcc = userRepo.findByUserRole(UserRole.ADMIN);
        if(AdminAcc == null){
            User user = new User();
            user.setUserRole(UserRole.ADMIN);
            user.setEmail("Admin@Admin.com");
            user.setName("ADMIN");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepo.save(user);
        }
    }

    @Override
    public UserDto createUser(SignUpDto signUpDto) {
        User user = new User();
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setUserRole(UserRole.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(signUpDto.getPassword()));
        userRepo.save(user);
        return user.mapUsertoDto();
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
