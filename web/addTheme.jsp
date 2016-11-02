<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Theme</title>
    <style>
        textarea {
            width: 80%;
            height: 50px;
        }
    </style>
</head>
<body>
<form action="/addTheme" method="POST">
    <div align="center">
        <h3>Add theme to Mr.Forum:</h3>
        <p><font color="red"><em><%= request.getParameter("error") == null ? " " : request.getParameter("error")%>
        </em></font></p>
        <p><b>Type theme name:</b></p>
        <textarea name="theme"></textarea>
        <p><input type="submit" value="Add Theme"><a href="forum.jsp"><input type="submit" value="Back to Forum"></a>
        </p>
    </div>
</form>
</body>
</html>
