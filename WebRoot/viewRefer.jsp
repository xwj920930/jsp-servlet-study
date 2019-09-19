<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
page:${sessionScope.refer}
</br>
<jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
today:<%=today %>
</br>
<c:set var="aa" value="c:out"></c:set>
<c:out value="${aa}"></c:out>
</br>
<c:if test="true">C :if</c:if>
</br>
<c:choose>
<c:when test="flase">c:when</c:when>
<c:otherwise>c:oherwise</c:otherwise>
</c:choose>
</br>
<c:forEach var="x" begin="1" end="3">
${x}
</c:forEach></br>
<fmt:formatNumber value="0.12" type="percent"></fmt:formatNumber></br>
<fmt:formatDate value="${today}" type="time"/></br>
<fmt:formatDate value="${today}" type="date"/></br>
<!-- ${fn:contains("abc","a")}</br>
<c:set var="sp" value="${fn:split('my,world',',')}"></c:set>
<c:forEach var="sub" items="${sp}">
<span>${sub}</span></br>
</c:forEach> -->


</body>
</html>