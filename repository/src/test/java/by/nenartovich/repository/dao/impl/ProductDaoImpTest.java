package by.nenartovich.repository.dao.impl;

import by.nenartovich.repository.Section;
import by.nenartovich.repository.dao.ProductDao;
import by.nenartovich.repository.entity.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoImpTest {
    private final ProductDao productDao = new ProductDaoImp();

    /*@Test*/
    public void testGetSectionProducts() {
        List<Product> productList = productDao.getSectionProducts(Section.SPORT);
        assertNotNull(productList);
        Integer actual = productList.get(0).getId();
        Integer expected = 1;
        assertEquals(expected, actual);
        List<Product> productListNull = productDao.getSectionProducts(Section.TECHNOLOGY);
        assertNull(productListNull);
    }
}