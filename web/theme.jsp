<%@ page import="entity.Forum" %>
<%@ page import="entity.Message" %>
<%@ page import="entity.Theme" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Forum forum = Forum.getForum();%>
<% Theme currentTheme = forum.getTheme(request.getParameter("name"));%>
<% session.setAttribute("theme", currentTheme);%>
<html>
<head>
    <title><%= currentTheme.getName()%>
    </title>
</head>
<body>
<h3 align="center"><%= currentTheme.getName()%>
</h3>
<table>
    <tr>
        <td align="center" width="1000px"><em>Messages:</em></td>
        <td align="center"><em>From:</em></td>
    </tr>
    <% for (Message message : currentTheme.getMessages()) {
        out.println("<tr><td align=\"justify\">" + message.getMessage() + "</td>" +
                "<td align=\"center\">by " + message.getUserNick() + "</td></tr>");
    }%>
</table>
<div align="right">
    <p><a href="addMessage.jsp?theme=<%= currentTheme.getName()%>"><input type="submit" value="Add Message"></a><a
            href="forum.jsp"><input type="submit" value="Back to Forum"></a></p>
</div>
</body>
</html>
