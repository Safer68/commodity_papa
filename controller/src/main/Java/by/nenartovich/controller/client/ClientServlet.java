package by.nenartovich.controller.client;

import by.nenartovich.service.dto.ClientDto;
import by.nenartovich.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static by.nenartovich.controller.client.Constant.*;


@WebServlet(urlPatterns = "/clientPage")
public class ClientServlet extends HttpServlet {


    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageName = Optional.ofNullable(req.getParameter(PAGE_NAME))
                .filter(s -> !s.isEmpty())
                .orElse(PRODUCTS);
        if (req.getParameter(UPDATE) != null) {
            ClientDto client = (ClientDto) req.getSession().getAttribute(USER_NAME);
            client.setName(req.getParameter(NEW_NAME));
            new ClientServiceImpl().updateClient(client);
        }
        CommandEnum command = CommandEnum.selectCommand(pageName);
        HttpSession session = req.getSession();
        session.setAttribute(PAGE_PATH, command.getPagePath());
        command.getCommand().execute(req, resp);
    }
}
