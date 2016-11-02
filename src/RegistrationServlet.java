import entity.Person;
import entity.PersonContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationServlet extends HttpServlet {

    PersonContainer container = PersonContainer.getContainer();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String pass1 = req.getParameter("pass");
        String pass2 = req.getParameter("passCheck");
        String dateBirth = req.getParameter("birthDate");
        String email = req.getParameter("email");

        String isOk;
        if (!nick.isEmpty() && !container.isExist(nick)) {
            isOk = getCheckParams(nick, name, surname, pass1, pass2, dateBirth, email);
        } else if (nick.isEmpty()) isOk = "Login field is empty";
        else isOk = "This login is already exist!";

        if (isOk == null) {
            Person newUser = new Person(nick, pass1, name, surname, dateBirth, email);
            container.add(newUser);
            PersonContainer.writeToFile(container);
            resp.sendRedirect("/index.html");
        } else resp.sendRedirect("/registration.jsp?error=" + isOk);

    }

    private String getCheckParams(String nick, String name, String surname, String pass1, String pass2, String dateBirth, String email) {
        if (pass1.isEmpty() || !pass1.equals(pass2)) return "Passwords doesn't match!";
        if (name.isEmpty() || !checkWithNameRegEx(name)) return "Wrong name!";
        if (surname.isEmpty() || !checkWithNameRegEx(surname)) return "Wrong surname!";
        if (dateBirth.isEmpty() || !checkDate(dateBirth)) return "Wrong type of date!";
        if (email.isEmpty() || !checkWithEmailRegEx(email)) return "Wrong email!";
        return null;
    }

    private boolean checkWithEmailRegEx(String email) {
        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private boolean checkDate(String dateBirth) {
        String[] tokens = dateBirth.split("\\.");
        if (Integer.parseInt(tokens[0]) < 0 && Integer.parseInt(tokens[0]) > 31) return false;
        if (Integer.parseInt(tokens[1]) < 0 && Integer.parseInt(tokens[1]) > 12) return false;
        if (Integer.parseInt(tokens[2]) < 1900 && Integer.parseInt(tokens[2]) > (Calendar.getInstance().get(Calendar.YEAR) - 7))
            return false;
        return true;
    }

    private boolean checkWithNameRegEx(String name) {
        Pattern p = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
