<%@ tag import="java.util.Date" import="java.text.DateFormat"%>
<%@ variable name-given="longDate" %>
<%@ variable name-given="shortDate" %>
<%
Date date=new Date();
DateFormat longFormat=DateFormat.getDateInstance(DateFormat.LONG);
DateFormat shortFormat=DateFormat.getDateInstance(DateFormat.SHORT);
jspContext.setAttribute("longDate", longFormat.format(date));
jspContext.setAttribute("shortDate", shortFormat.format(date));
%>
<jsp:doBody></jsp:doBody>