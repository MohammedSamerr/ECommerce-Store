package store.example.e_commerce.dto;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CategoryDTO {

    private Long id;

    private String name;

    private String description;
}
