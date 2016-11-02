import entity.PersonContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    PersonContainer container = PersonContainer.getContainer();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("nick");
        String pass = req.getParameter("pass");

        HttpSession session = req.getSession();

        if (container.isExist(login)) {
            if (container.checkPass(login, pass)) {
                session.setAttribute("user", container.getPerson(login));
                resp.sendRedirect("/forum.jsp");
            } else resp.sendRedirect("/wrongLogin.jsp?error=Wrong password!");
        } else if (pass.isEmpty()) resp.sendRedirect("/wrongLogin.jsp?error=Password field is empty!");
        else resp.sendRedirect("/wrongLogin.jsp?error=Nickname is not registered!");


    }
}
