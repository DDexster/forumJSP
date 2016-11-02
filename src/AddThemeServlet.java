import entity.Forum;
import entity.Theme;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddThemeServlet extends HttpServlet {
    Forum forum = Forum.getForum();
    List<Theme> themes = forum.getThemes();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String themeName = req.getParameter("theme");
        if (themeName.isEmpty()) resp.sendRedirect("/addTheme.jsp?error=Text field is empty!");
        else {
            Theme newTheme = new Theme(themeName);
            themes.add(newTheme);
            forum.setThemes(themes);
            Forum.writeToFile(forum);
            resp.sendRedirect("/forum.jsp");
        }
    }
}
