<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<%@ page session="false" %>
<html>
<head>
    <title>Twitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css"/>" >
</head>
<body>
    <h1>Register</h1>
    <form method="POST">
        First Name: <input type="text" name="firstName" /><br/>
        Last Name: <input type="text" name="lastName" /><br/>
        Email: <input type="email" name="email" /><br/>
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        <input type="submit" value="Register" />
    </form>
</body>
</html>
