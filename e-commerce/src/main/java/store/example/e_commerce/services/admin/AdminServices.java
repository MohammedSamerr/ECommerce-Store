package store.example.e_commerce.services.admin;

import store.example.e_commerce.dto.CategoryDTO;
import store.example.e_commerce.dto.ProductDTO;
import store.example.e_commerce.models.Category;
import store.example.e_commerce.models.Product;

import java.io.IOException;
import java.util.List;

public interface AdminServices {
    Category createCategory(CategoryDTO categoryDTO);
    public List<CategoryDTO> getAllCategories();
    public boolean deleteCategoryById(Long id);
    public Product createProduct(Long category_Id, ProductDTO productDTO) throws IOException;
}
