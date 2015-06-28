<%--
  Created by Anna Oliinyk
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="resources.lang" var="lang" scope="session" />

<jsp:useBean class="model.Station" scope="page" id = "station"/>

<html>

<head>
    <title><fmt:message key="buy_ticket_page_name" bundle="${lang}" /></title>
</head>

<body>

<%@ include file="include/header.jsp" %>

<form name="fmReturnMain" method="post">
  <button name="command" value="main_page" type="submit">
    <fmt:message key="return_main" bundle="${lang}" />
  </button>
</form>

<form name="fmBuy" method="post">

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
        <fmt:message key="date_arrival" bundle="${lang}" />
      </td>
      <td>
        <input type="date" name="date" required>
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="station_start" bundle="${lang}" />
      </td>
      <td>
        <select name = "station_start">
          <c:forEach items="${stations}" var="station" >
          <option value = "${station.stationID}">${station.name}
            </c:forEach>
        </select>
      </td>
    </tr>

    <tr>
      <td>
        <fmt:message key="station_finish" bundle="${lang}" />
      </td>
      <td>
        <select name = "station_finish" >
          <c:forEach items="${stations}" var="station">
          <option value = "${station.stationID}">${station.name}
            </c:forEach>
        </select>
      </td>
    </tr>

    <tr>
      <td colspan="2" align="center">
        <button name="command" value="get_trains_for_ticket" type="submit">
          <fmt:message key="find_trains" bundle="${lang}" />
        </button>
      </td>
    </tr>

  </table>

</form>

<%@ include file="include/footer.jsp" %>

</body>

</html>
