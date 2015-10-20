<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Twitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css"/>">
</head>
<body>
    <div class="tweetView">
        <div class="tweetMessage"><c:out value="${tweet.message}"/></div>
        <div>
            <span class="tweetTime"><c:out value="${tweet.time}"/></span>
        </div>
    </div>
</body>
</html>
