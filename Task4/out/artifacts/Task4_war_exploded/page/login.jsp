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
    <title><fmt:message key="login_page_name" bundle="${lang}" /></title>
</head>

<body>

<%@ include file="include/header.jsp" %>

<%@ include file="include/headerlang.jsp" %>

<form name="fmLogin" method="post">

  <table>

    <tr>

      <td colspan = "2">
        <c:if test="${not empty requestScope.error_message}">
          <fmt:message key="login_password_error_message" bundle="${lang}" />
        </c:if>

        <c:if test="${not empty requestScope.error_empty_message}">
          <fmt:message key="empty_fields" bundle="${lang}" />
        </c:if>

        <c:if test="${not empty requestScope.reg_ok_message}">
          <fmt:message key="reg_ok" bundle="${lang}" />
        </c:if>
      </td>

    </tr>

    <tr>

      <td width = "80">
        <label><fmt:message key="login" bundle="${lang}" /></label>
      </td>
      <td>
        <input type="text" size="30" name="login" value="" required />
      </td>

    </tr>

    <tr>

      <td width = "80">
        <label><fmt:message key="pass" bundle="${lang}" /></label>
      </td>
      <td>
        <input type="password" size="30" name="password" value="" required />
      </td>

    </tr>

    <tr align = "center">

      <td colspan = "2">
        <button name="command" value="login" type="submit">
          <fmt:message key="enter" bundle="${lang}" />
        </button>

        <input type="reset" class="button" value=<fmt:message key="clear" bundle="${lang}"/> />
      </td>

    </tr>

  </table>

</form>


<form name="fmReg" method="post">
  <button name="command" value="registration" type="submit">
    <fmt:message key="reg" bundle="${lang}" />
  </button>
</form>

<%@ include file="include/footer.jsp" %>

</body>

</html>

