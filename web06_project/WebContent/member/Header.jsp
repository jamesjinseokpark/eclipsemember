<%@page import="com.hk.member.dto.Member" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 

Member member = (Member)session.getAttribute("member");

%>
    
<div style="background-color:#00008b;color:#ffffff;height:30px;padding:5px;">
SPMS (Simple Project Management System)

<% if (member !=null) { %>


<span style="float:right;">

<%=member.getMname() %>
<a style="color:white;"
	href="<%=request.getContextPath()%>/auth/logout">님 로그아웃</a>
</span>
<% } else { %>
<span style="float:right;">
	<a style="color:white;" href="<%=request.getContextPath() %>/auth/logout">로그아웃</a>
		
	</span>
<% } %>

</div>