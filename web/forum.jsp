<%@ page import="entity.Forum" %>
<%@ page import="entity.Person" %>
<%@ page import="entity.Theme" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Person user = (Person) session.getAttribute("user");%>
<% Forum forum = Forum.getForum();%>
<html>
<head>
    <title>Mr.Forum</title>
</head>
<body>
<div>
    <h3>Mr. Forum welcomes you, mr. <%= user.getNick()%>
    </h3>
    <table>
        <tr>
            <td>Themes:</td>
        </tr>
        <% for (Theme theme : forum.getThemes()) {
            out.println("<tr><td><a href = \"theme.jsp?name=" + theme.getName() + "\"><b>" + theme.getName() + "</b></a></td></tr>");
        }%>

    </table>
    <div align="right">
        <p><a href="addTheme.jsp"><input type="submit" value="Add Theme"></a></p>
    </div>
</div>

</body>
</html>
