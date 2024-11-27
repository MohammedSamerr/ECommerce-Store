package store.example.e_commerce.models;

import jakarta.persistence.*;
import lombok.Data;
import store.example.e_commerce.dto.CategoryDTO;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    public CategoryDTO getCategoryDto(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(id);
        categoryDTO.setName(name);
        categoryDTO.setDescription(description);
        return categoryDTO;
    }


}
