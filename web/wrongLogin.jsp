<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<div align="center">
    <h3><%= request.getParameter("error")%>
    </h3>
    <p><a href="/index.html">Try again</a> or <a href="/registration.jsp">register</a> as new user.</p>
</div>

</body>
</html>
