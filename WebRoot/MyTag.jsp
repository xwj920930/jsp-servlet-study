<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/MyTag.tld"  prefix="my" %>
<%@ taglib uri="http://xwj/functiontag"  prefix="myf" %>
<%@ taglib prefix="ft" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<my:mytag></my:mytag>
<br></br>
<my:mytag2 items="a,s,d" header="A"/>
<br></br>
<my:myselecttag>
<option value="${value}">${text}</option>
</my:myselecttag>
<br></br>
${myf:reverseString("hello world") }
<br></br>
today is <ft:firstTag></ft:firstTag>
<br></br>
<ft:includeTag></ft:includeTag>
<br></br>
<ft:taglibTag></ft:taglibTag>
<br></br>
<ft:attributeTag input="input"></ft:attributeTag>
<br></br>
<ft:variableTag>
long format:${longDate}
short format:${shortDate}
</ft:variableTag>
</body>
</html>