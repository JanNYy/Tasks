<%--
  Created by Anna
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="resources.lang" var="lang" scope="session" />

<jsp:useBean class="model.Ticket" scope="page" id = "ticket"/>

<html>

<head>
    <title><fmt:message key="client_history_page_name" bundle="${lang}" /></title>
</head>

<body>

<%@ include file="include/header.jsp" %>

<form name="fmReturnMain" method="post">
    <button name="command" value="main_page" type="submit">
        <fmt:message key="return_main" bundle="${lang}" />
    </button>
</form>

<table border="2" cellspacing="0">
    <tr>
        <th><fmt:message key="number_ticket" bundle="${lang}" /></th>
        <th><fmt:message key="datetime_start" bundle="${lang}" /></th>
        <th><fmt:message key="date_time_finish" bundle="${lang}" /></th>
        <th><fmt:message key="name_train" bundle="${lang}" /></th>
        <th><fmt:message key="number_wagon" bundle="${lang}" /></th>
        <th><fmt:message key="type_seat" bundle="${lang}" /></th>
        <th><fmt:message key="number_seat" bundle="${lang}" /></th>
        <th><fmt:message key="station_start" bundle="${lang}" /></th>
        <th><fmt:message key="station_finish" bundle="${lang}" /></th>
        <th><fmt:message key="price" bundle="${lang}" /></th>
        <th><fmt:message key="status" bundle="${lang}" /></th>

    </tr>
    <c:forEach items="${tickets}" var="ticket"  >
        <tr>
            <td>
                <c:out value="${ticket.ticketID}"/>
            </td>
            <td>
                <c:out value="${ticket.dateTimeBegin}"/>
            </td>
            <td>
                <c:out value="${ticket.dateTimeEnd}"/>
            </td>
            <td>
                <c:out value="${ticket.nameTrain}"/>
            </td>
            <td>
                <c:out value="${ticket.numberWagon}"/>
            </td>
            <td>
                <c:out value="${ticket.nameTypeSeat}"/>
            </td>
            <td>
                <c:out value="${ticket.numberSeat}"/>
            </td>
            <td>
                <c:out value="${ticket.nameStationStart}"/>
            </td>
            <td>
                <c:out value="${ticket.nameStationFinish}"/>
            </td>
            <td>
                <c:out value="${ticket.price}"/>
            </td>
            <td>
                <c:if test="${ticket.status == '0'}">
                    <fmt:message key="status_denied" bundle="${lang}" />
                </c:if>
                <c:if test="${ticket.status == '1'}">
                    <fmt:message key="status_unconfirmed" bundle="${lang}" />
                </c:if>
                <c:if test="${ticket.status == '2'}">
                    <fmt:message key="status_accepted" bundle="${lang}" />
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="include/footer.jsp" %>

</body>

</html>
