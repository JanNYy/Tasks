<%--
  Created by Anna Oliinyk
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="resources.lang" var="lang" scope="session" />

<html>

<head>
    <title><fmt:message key="no_results_page_name" bundle="${lang}" /></title>
</head>

<body>

<%@ include file="include/header.jsp" %>

<fmt:message key="no_results" bundle="${lang}"/>

<br/>

<form name="fmReturnMain" method="post">
  <button name="command" value="main_page" type="submit">
    <fmt:message key="return_main" bundle="${lang}" />
  </button>
</form>

<%@ include file="include/footer.jsp" %>

</body>

</html>
