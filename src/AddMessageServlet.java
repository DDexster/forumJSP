import entity.Forum;
import entity.Message;
import entity.Person;
import entity.Theme;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddMessageServlet extends HttpServlet {
    Forum forum = Forum.getForum();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Theme theme = (Theme) session.getAttribute("theme");
        Person user = (Person) session.getAttribute("user");
        String text = req.getParameter("message");

        if (text.isEmpty()) resp.sendRedirect("/addMessage.jsp?error=Text field is empty!");
        else {
            Message message = new Message(user, text);
            theme.add(message);
            forum.setTheme(theme);
            Forum.writeToFile(forum);
            resp.sendRedirect("/theme.jsp?name=" + theme.getName());
        }

    }
}
