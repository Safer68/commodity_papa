package by.nenartovich.controller.manager.impl;

import by.nenartovich.controller.manager.Command;
import by.nenartovich.controller.manager.Constant;
import by.nenartovich.service.ProductService;
import by.nenartovich.service.dto.ProductDto;
import by.nenartovich.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.nenartovich.controller.manager.Constant.*;

public class CatalogCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Optional.ofNullable(req.getParameter(ACTION))
                .ifPresent(action -> {
                    ProductDto productDto = new ProductDto();
                    switch (action) {
                        case SAVE_PRODUCT:
                            productDto.setDescription(req.getParameter(DESCRIPTION));
                            productDto.setPrice(Double.valueOf(req.getParameter(PRICE)));
                            new ProductServiceImpl().createProduct(productDto);
                            break;
                        case UPDATE:
                            productDto.setId(Integer.valueOf(req.getParameter(PRODUCT_ID)));
                            productDto.setDescription(req.getParameter(DESCRIPTION));
                            productDto.setPrice(Double.valueOf(req.getParameter(PRICE)));
                            new ProductServiceImpl().updateProduct(productDto);
                            break;
                        case DELETE_PRODUCT:
                            Integer taskId = Integer.valueOf(req.getParameter(PRODUCT_ID));
                            new ProductServiceImpl().removeProduct(taskId);
                            break;
                    }
                });
        ProductService productService = new ProductServiceImpl();
        List<ProductDto> products = productService.findAllProductDto();
        req.setAttribute(PRODUCTS, products);
        if (req.getParameter(ACTION) == null) {
            req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
        } else resp.sendRedirect(req.getContextPath() + "/managerPage?pageName=Catalog");
    }
}

