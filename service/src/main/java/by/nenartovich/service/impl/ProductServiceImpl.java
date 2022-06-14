package by.nenartovich.service.impl;

import by.nenartovich.repository.dao.ProductDao;
import by.nenartovich.repository.dao.impl.ProductDaoImp;
import by.nenartovich.repository.entity.Product;
import by.nenartovich.service.ProductService;
import by.nenartovich.service.converter.ConverterDTO;
import by.nenartovich.service.converter.impl.ProductConverter;
import by.nenartovich.service.dto.ProductDto;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ConverterDTO<ProductDto, Product> converterDTO = new ProductConverter();

    @Override
    public void createProduct(ProductDto productDto) {
        ProductDao productDao = new ProductDaoImp();
        Product product = new Product();
        product = new ProductConverter().convert(product, productDto);
        productDao.save(product);
    }

    @Override
    public ProductDto findById(Integer productId) {
        return converterDTO.convert(new ProductDaoImp().findById(productId));
    }

    @Override
    public List<ProductDto> findAllProductDto() {
        return converterDTO.convert(new ProductDaoImp().findAll());
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        ProductDao productDao = new ProductDaoImp();
        Product product = productDao.findById(productDto.getId());
        product = new ProductConverter().convert(product, productDto);
        productDao.update(product);
    }

    public void removeProduct(Integer productId) {
        new ProductDaoImp().delete(productId);
    }
}
