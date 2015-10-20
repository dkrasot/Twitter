<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Twitter</title>
        <link rel="stylesheet"
              type="text/css"
              href="<c:url value="/resources/style.css"/>">
    </head>
    <body>
        <h1>Welcome to Twitter!</h1>
        <a href="<c:url value="/tweets" />">Tweets</a>
        <a href="<c:url value="/twitter/register" />">Register</a>
    </body>
</html>
