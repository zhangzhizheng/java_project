<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  欢迎各位
  <%
  out.print("now date:");
  Date date=new Date();
  out.print(date.toLocaleString());
   %>
    This is my JSP page,you	are	great. <br>
    <%!
    public static int  add(int num)
    {
    int sum=0;
    for(int i=0;i<=num;i++)
    {
    sum=sum+i;
    }
    return sum;
    }
     %>
     <%
     int num=100;
     int a=add(num); %>
  </body>
</html>
