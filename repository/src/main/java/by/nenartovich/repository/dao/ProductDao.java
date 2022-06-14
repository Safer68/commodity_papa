package by.nenartovich.repository.dao;

import by.nenartovich.repository.Section;
import by.nenartovich.repository.entity.Product;

import java.util.List;

public interface ProductDao extends EntityDao<Product> {
    List<Product> getSectionProducts(Section section);
}
