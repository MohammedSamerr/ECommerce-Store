package store.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.example.e_commerce.models.Product;

@Repository
public interface productRepo extends JpaRepository<Product,Long> {
}
