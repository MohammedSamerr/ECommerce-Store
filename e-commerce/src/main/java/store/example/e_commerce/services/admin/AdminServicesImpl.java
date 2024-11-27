package store.example.e_commerce.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.example.e_commerce.dto.CategoryDTO;
import store.example.e_commerce.dto.ProductDTO;
import store.example.e_commerce.models.Category;
import store.example.e_commerce.models.Product;
import store.example.e_commerce.repository.categoryRepo;
import store.example.e_commerce.repository.productRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServicesImpl implements AdminServices{

    @Autowired
    private categoryRepo repo;

    @Autowired
    private productRepo pRepo;

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return repo.save(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories(){
        return repo.findAll().stream().map(Category::getCategoryDto).collect(Collectors.toList());
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product createProduct(Long category_Id,ProductDTO productDTO) throws IOException {
        Optional<Category> optionalCategory = repo.findById(category_Id);
        if(optionalCategory.isPresent()){
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setImage(productDTO.getImage().getBytes());
            product.setCategory(optionalCategory.get());
            return pRepo.save(product);
        }
        return null;
    }





}
