package by.nenartovich.service.converter.impl;

import by.nenartovich.repository.Section;
import by.nenartovich.repository.entity.Product;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.dto.ProductDto;

public class ProductConverter implements ConverterDTO<ProductDto, Product> {
    @Override
    public ProductDto apply(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        //productDto.setSection(product.getSection().name());
        return productDto;
    }

    @Override
    public Product apply(Product product, ProductDto productDto) {
        if (productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        if (productDto.getSection() != null) {
            product.setSection(Section.valueOf(productDto.getSection()));
        }
        return product;
    }
}
