package by.nenartovich.service.dto;

import by.nenartovich.repository.Section;
import by.nenartovich.repository.entity.Manager;
import by.nenartovich.repository.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Integer id;
    private String description;
    private Double price;
    private String section;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.section = product.getSection().name();
    }
}
