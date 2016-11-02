<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/register" method="POST">
    <div align="center">
        <h2><b>Mr. Forum</b></h2>
        <h3>Registration:</h3>
        <p><font color="red"><em><%= (request.getParameter("error") == null) ? " " : request.getParameter("error")%>
        </em></font></p>
        <table>
            <tr>
                <td width="200px"><b>Nick:</b></td>
                <td><input type="text" name="nick"></td>
            </tr>
            <tr>
                <td><b>First Name:</b></td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td><b>Last Name:</b></td>
                <td><input type="text" name="surname"></td>
            </tr>
            <tr>
                <td><b>Password:</b></td>
                <td><input type="password" name="pass"></td>
            </tr>
            <tr>
                <td><b>Password again:</b></td>
                <td><input type="password" name="passCheck"></td>
            </tr>
            <tr>
                <td><b>Date of birth (dd.mm.yyyy):</b></td>
                <td><input type="text" name="birthDate"></td>
            </tr>
            <tr>
                <td><b>Email:</b></td>
                <td><input type="text" name="email"></td>
            </tr>
        </table>
        <p><input type="submit" value="Register"></p>
    </div>
</form>
</body>
</html>
