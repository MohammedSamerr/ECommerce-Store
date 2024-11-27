package store.example.e_commerce.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDTO {

    private Long id;

    private String name ;

    private String description;

    private Double price;

    private MultipartFile image;
}
