package by.nenartovich.service;

import by.nenartovich.service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDto productDto);

    ProductDto findById(Integer productId);

    List<ProductDto> findAllProductDto();

    void updateProduct(ProductDto productDto);

    void removeProduct(Integer productId);
}
