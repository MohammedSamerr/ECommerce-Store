package store.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import store.example.e_commerce.models.Category;

public interface categoryrRepo extends JpaRepository<Category,Long> {
}
