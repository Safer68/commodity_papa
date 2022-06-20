package by.nenartovich.controller.client.impl;

import by.nenartovich.controller.client.Command;
import by.nenartovich.controller.client.Constant;
import by.nenartovich.service.ClientService;
import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.dto.OrderDto;
import by.nenartovich.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.nenartovich.controller.client.Constant.ORDERS;
import static by.nenartovich.controller.client.Constant.USER_NAME;


public class OrdersCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ClientService clientService = new ClientServiceImpl();
        ClientDto client = (ClientDto) req.getSession().getAttribute(USER_NAME);
        List<OrderDto> orders = clientService.getClientOrders(client.getId());
        req.setAttribute(ORDERS, orders);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
