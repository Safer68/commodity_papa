package by.nenartovich.controller;

import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.impl.ManagerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ManagerDto> managers = new ManagerServiceImpl().findAllManagerDto();
        req.setAttribute("managerName", managers);
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("logOut") != null) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            ManagerServiceImpl managerService = new ManagerServiceImpl();
            Integer userId = Integer.valueOf(req.getParameter("login"));
            ManagerDto manager = managerService.findById(userId);
            req.getSession().setAttribute("UserName", manager);
            resp.sendRedirect("managerPage");
        }
    }
}
