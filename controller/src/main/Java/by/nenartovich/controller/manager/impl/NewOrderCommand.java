package by.nenartovich.controller.manager.impl;


import by.nenartovich.controller.manager.Command;
import by.nenartovich.controller.manager.Constant;
import by.nenartovich.service.OrderService;
import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.dto.OrderDto;
import by.nenartovich.service.impl.ClientServiceImpl;
import by.nenartovich.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.nenartovich.controller.manager.Constant.ORDER;
public class NewOrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        OrderDto order = new OrderDto();
        req.setAttribute(ORDER, order);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
