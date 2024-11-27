package store.example.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.example.e_commerce.dto.CategoryDTO;
import store.example.e_commerce.dto.ProductDTO;
import store.example.e_commerce.models.Category;
import store.example.e_commerce.models.Product;
import store.example.e_commerce.repository.categoryRepo;
import store.example.e_commerce.services.admin.AdminServices;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices ;

    @Autowired
    private categoryRepo repo;

    @PostMapping("/createcategory")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = adminServices.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> allCategories = adminServices.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        boolean isRemoved = adminServices.deleteCategoryById(id);
        if (!isRemoved) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/creteproduct/{category_id}")
    public ResponseEntity<Product> creteProduct(@PathVariable Long category_id,@ModelAttribute ProductDTO productDTO)throws IOException {
        Product createdproduct = adminServices.createProduct(category_id, productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdproduct);
    }
}
