package by.nenartovich.controller.manager.impl;

import by.nenartovich.controller.manager.Command;
import by.nenartovich.controller.manager.Constant;
import by.nenartovich.service.ManagerService;
import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.dto.OrderDto;
import by.nenartovich.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.nenartovich.controller.manager.Constant.ORDERS;
import static by.nenartovich.controller.manager.Constant.USER_NAME;

public class OrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ManagerService managerService = new ManagerServiceImpl();
        ManagerDto manager = (ManagerDto) req.getSession().getAttribute(USER_NAME);
        List<OrderDto> orders = managerService.getManagerOrders(manager.getId());
        req.setAttribute(ORDERS, orders);
        req.getRequestDispatcher(Constant.TEMPLATE_PAGE).forward(req, resp);
    }
}
