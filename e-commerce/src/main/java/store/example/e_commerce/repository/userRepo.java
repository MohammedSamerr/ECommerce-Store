package store.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.example.e_commerce.enums.UserRole;
import store.example.e_commerce.models.User;

@Repository
public interface userRepo extends JpaRepository<User,Long> {

     User findByEmail(String username);
     boolean existsByEmail(String email);


    User findByUserRole(UserRole userRole);
}
