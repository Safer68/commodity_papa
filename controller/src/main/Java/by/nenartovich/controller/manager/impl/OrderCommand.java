package by.nenartovich.controller.manager.impl;


import by.nenartovich.controller.manager.Command;
import by.nenartovich.controller.manager.Constant;
import by.nenartovich.service.OrderService;
import by.nenartovich.service.dto.OrderDto;
import by.nenartovich.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.nenartovich.controller.manager.Constant.ORDER;

public class OrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        OrderService orderService = new OrderServiceImpl();
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        OrderDto order = orderService.findById(orderId);
        req.setAttribute(ORDER, order);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
