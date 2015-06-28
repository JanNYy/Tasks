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
    <title><fmt:message key="client_new_page_name" bundle="${lang}" /></title>
</head>

<body>

<%@ include file="include/header.jsp" %>

<fmt:message key="enter_personal_data" bundle="${lang}" />
<br/>

<form name="fmLogout" method="post">
  <button name="command" value="logout" type="submit">
    <fmt:message key="logout" bundle="${lang}" />
  </button>
</form>

<form name="fmClientInfo" method="post">

  <table>

    <tr>
      <td colspan = "2">
        <c:if test="${not empty requestScope.error_empty_message}">
          <fmt:message key="empty_fields" bundle="${lang}" />
        </c:if>
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="surname" bundle="${lang}" />
      </td>
      <td>
        <input type="text" size="50" name="surname" value="" required />
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="name" bundle="${lang}" />
      </td>
      <td>
        <input type="text" size="50" name="name" value="" required />
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="patronymic" bundle="${lang}" />
      </td>
      <td>
        <input type="text" size="50" name="patronymic" value="" required />
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="telephone" bundle="${lang}" /> (X-XXX-XXX-XX-XX)
      </td>
      <td>
        <input type="tel" pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}" name="telephone" value="" required />
      </td>
    </tr>

    <tr>
      <td colspan = "2">
        <button name="command" value="add_client_info" type="submit">
          <fmt:message key="accept" bundle="${lang}" />
        </button>

        <input type="reset" class="button" value=<fmt:message key="clear" bundle="${lang}"/> />
      </td>
    </tr>

  </table>

</form>

<%@ include file="include/footer.jsp" %>

</body>

</html>
