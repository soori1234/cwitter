<%@page import="com.cwitter.dto.User"%>
<%@page import="com.cwitter.service.TweetLocalServiceImpl"%>
<%@page import="com.cwitter.service.TweetLocalService"%>
<%@page import="com.cwitter.dto.Tweet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome ${user.firstName}
Twitter ID: ${user.emailId}

<a href = "showMyTweets?userId=${user.userId}" >Show MyTweets</a><br>
<a href = "logoutAction">Logout</a>

<form action="postTweetAction" name = "tweetForm" onsubmit="return validateForm()" method = "POST" >
 <input type = "hidden" name = "tweetCreatedBy" value= "${user.userId}">
 <input type = "textarea" name = "tweetDescription"></input>
 <input type = "submit" value = "TWEET">
 
</form> 
</body>
<br>
<h2>Tweets Timeline</h2><br>

<%
   TweetLocalService tl = new TweetLocalServiceImpl();
   List<Tweet> tweetList = tl.getAllTweets();
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



<script>
function validateForm() {
    var x = document.forms["tweetForm"]["tweetDescription"].value;
    if (x == null || x == "") {
        alert("Tweet is  mandatory");
        return false;
    }
}
</script>
</html>