<%@ page import="entity.Forum" %>
<%@ page import="entity.Theme" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Forum forum = Forum.getForum();%>
<% Theme theme = forum.getTheme(request.getParameter("theme"));%>
<html>
<head>
    <title>Add message:</title>
    <style>
        textarea {
            width: 80%;
            height: 150px;
        }
    </style>
</head>
<body>
<form action="/addMessage" method="POST">
    <div align="center">
        <h3>Add message to "<%= theme.getName()%>":</h3>
        <p><font color="red"><em><%= request.getParameter("error") == null ? " " : request.getParameter("error")%>
        </em></font></p>
        <p><b>Type message:</b></p>
        <textarea name="message"></textarea>
        <p><input type="submit" value="Add Message"><a href="theme.jsp?name=<%= theme.getName()%>"><input type="submit"
                                                                                                          value="Back"></a>
        </p>
    </div>
</form>
</body>
</html>
