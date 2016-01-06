<%@page import="com.cwitter.dto.User"%>
<%@page import="com.cwitter.dto.Tweet"%>
<%@page import="java.util.List"%>
<%@page import="com.cwitter.service.TweetLocalServiceImpl"%>
<%@page import="com.cwitter.service.TweetLocalService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

User Id: ${user.userId }


<h2>Tweets</h2>
<%
    User user  = (User)request.getAttribute("user");
    Long userId = user.getUserId();
   TweetLocalService tl = new TweetLocalServiceImpl();
   List<Tweet> tweetList = tl.getAllTweetsByUserID(userId);
   if(tweetList != null && tweetList.size()>0)
   {
	   for(Tweet tweet:tweetList)
	   {
		   %>
		   
		   <h3><%=tweet.getTweetDescription() %></h3><br>
		   <h4><%=tweet.getTweetCreatedBy() %></h4><br><br><br>
		   
		   <% 
	   }
   }


%>

</body>
</html>