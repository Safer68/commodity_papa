package by.nenartovich.controller.manager;


import by.nenartovich.service.dto.ManagerDto;
import by.nenartovich.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static by.nenartovich.controller.manager.Constant.*;

@WebServlet(urlPatterns = "/managerPage")
public class ManagerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageName = Optional.ofNullable(req.getParameter(PAGE_NAME))
                .filter(s -> !s.isEmpty())
                .orElse(ORDERS);
        if (req.getParameter(UPDATE) != null) {
            ManagerDto manager = (ManagerDto) req.getSession().getAttribute(USER_NAME);
            manager.setName(req.getParameter(NEW_NAME));
            new ManagerServiceImpl().updateManager(manager);
        }
        CommandEnum command = CommandEnum.selectCommand(pageName);
        HttpSession session = req.getSession();
        session.setAttribute(PAGE_PATH, command.getPagePath());
        command.getCommand().execute(req, resp);
    }
}
