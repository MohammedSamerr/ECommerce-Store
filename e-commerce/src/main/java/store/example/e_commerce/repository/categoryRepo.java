package store.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.example.e_commerce.models.Category;

@Repository
public interface categoryRepo extends JpaRepository<Category,Long> {
}
