package by.nenartovich.controller.client.impl;

import by.nenartovich.controller.client.Command;
import by.nenartovich.controller.client.Constant;
import by.nenartovich.service.ProductService;
import by.nenartovich.service.dto.ProductDto;
import by.nenartovich.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.nenartovich.controller.client.Constant.PRODUCTS;


public class CatalogCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ProductService productService = new ProductServiceImpl();
        List<ProductDto> products = productService.findAllProductDto();
        req.setAttribute(PRODUCTS, products);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
