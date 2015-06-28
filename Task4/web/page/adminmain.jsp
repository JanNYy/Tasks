<%--
  Created by Anna Oliinyk
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="resources.lang" var="lang" scope="session" />

<jsp:useBean class="model.User" scope="session" id = "user"/>

<html>

<head>
    <title><fmt:message key="main_page_name" bundle="${lang}" /></title>
</head>

<body>

<%@ include file="include/header.jsp" %>

<%@ include file="include/headerlang.jsp" %>

<fmt:message key="welcome" bundle="${lang}"/>, ${user.login}

<form name="fmLogout" method="post">
    <button name="command" value="logout" type="submit">
        <fmt:message key="logout" bundle="${lang}" />
    </button>
</form>

<form name="fmTicketsUndefined" method="post">
    <button name="command" value="tickets_unconfirmed" type="submit">
        <fmt:message key="tickets_status_unconfirmed" bundle="${lang}" />
    </button>
</form>

<%@ include file="include/footer.jsp" %>

</body>

</html>
