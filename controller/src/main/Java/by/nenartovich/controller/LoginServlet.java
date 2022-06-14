package by.nenartovich.controller;

import by.nenartovich.service.ClientService;
import by.nenartovich.service.ManagerService;
import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.impl.ClientServiceImpl;
import by.nenartovich.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/")
public class LoginServlet extends HttpServlet {

    public static final String MANAGERS = "managers";
    public static final String CLIENTS = "clients";
    public static final String LOGIN_JSP = "WEB-INF/login.jsp";
    public static final String LOG_OUT = "logOut";
    public static final String ROL = "Rol";
    public static final String MANAGER = "manager";
    public static final String LOGIN = "login";
    public static final String USER_NAME = "UserName";
    public static final String MANAGER_PAGE = "managerPage";
    public static final String CLIENT = "client";
    public static final String CLIENT_PAGE = "clientPage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ManagerDto> managers = new ManagerServiceImpl().findAllManagerDto();
        List<ClientDto> clients = new ClientServiceImpl().findAllClientDto();
        req.setAttribute(MANAGERS, managers);
        req.setAttribute(CLIENTS, clients);
        req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(LOG_OUT) != null) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            switch (req.getParameter(ROL)) {
                case MANAGER:
                    ManagerService managerService = new ManagerServiceImpl();
                    Integer userId = Integer.valueOf(req.getParameter(LOGIN));
                    ManagerDto manager = managerService.findById(userId);
                    req.getSession().setAttribute(USER_NAME, manager);
                    resp.sendRedirect(MANAGER_PAGE);
                    break;
                case CLIENT:
                    ClientService clientService = new ClientServiceImpl();
                    Integer clientId = Integer.valueOf(req.getParameter(LOGIN));
                    ClientDto client = clientService.findById(clientId);
                    req.getSession().setAttribute(USER_NAME, client);
                    resp.sendRedirect(CLIENT_PAGE);
                    break;
            }
        }
    }
}
