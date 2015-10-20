<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Twitter</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css"/>">
</head>
<body>
  <div class="tweetForm">
      <h1>Tweet this!</h1>
      <form method="POST" name="tweetForm">
          <input type="hidden" name="latitude">
          <input type="hidden" name="longitude">
          <textarea name="message" rows="5" cols="80"></textarea><br/>
          <input type="submit" value="Tweet! (ADD)">
      </form>
  </div>
  <div class="listTitle">
      <h1>Recent tweets</h1>
      <ul class="tweetList">
          <c:forEach items="${tweetList}" var="tweet">
              <li id="tweet_<c:out value="${tweet.id}"/>">
                  <div class="tweetMessage">
                      <c:out value="${tweet.message}"/>
                  </div>
                  <div>
                      <span class="tweetTime"><c:out value="${tweet.time}"/></span>
                      <span class="location">(<c:out value="${tweet.latitude}"/>, <c:out value="${tweet.longitude}"/>)</span>
                  </div>
              </li>
          </c:forEach>
      </ul>
      <c:if test="${fn:length(tweetList) gt 20}">
          <hr/>
          <s:url value="/tweets?count=${nextCount}" var="more_url"/>
          <a href="${more_url}">Show more</a>
      </c:if>
  </div>
</body>
</html>