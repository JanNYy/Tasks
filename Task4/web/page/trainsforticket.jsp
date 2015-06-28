<%--
  Created by Anna Oliinyk
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />

<fmt:setBundle basename="resources.lang" var="lang" scope="session" />

<jsp:useBean class="model.TrainForTicket" scope="page" id = "train"/>
<jsp:useBean class="model.TypeOfFreeSeats" scope="page" id = "type"/>
<jsp:useBean class="model.FreeWagon" scope="page" id = "wagon"/>

<html>
<head>
    <title><fmt:message key="trains_for_ticket_page_name" bundle="${lang}" /></title>
</head>
<body>

<%@ include file="include/header.jsp" %>

<form name="fmReturnMain" method="post">
  <button name="command" value="main_page" type="submit">
    <fmt:message key="return_main" bundle="${lang}" />
  </button>
</form>

<form name="fmReturnBack" method="post">
  <button name="command" value="buy_ticket" type="submit">
    <fmt:message key="return" bundle="${lang}" />
  </button>
</form>

<table border="2" cellspacing="0">

  <tr >
    <th><fmt:message key="name_train" bundle="${lang}" /></th>
    <th><fmt:message key="datetime_start" bundle="${lang}" /></th>
    <th><fmt:message key="date_time_finish" bundle="${lang}" /></th>
    <th><fmt:message key="num_of_free_seats" bundle="${lang}" /></th>
    <th><fmt:message key="types_os_seats_and_wagons" bundle="${lang}" /></th>
  </tr>

  <c:forEach items="${trainsForTicket}" var="train"  >
    <tr>
      <td>
        <c:out value="${train.trainName}"/>
      </td>
      <td>
        <c:out value="${train.dateTimeDeparture}"/>
      </td>
      <td>
        <c:out value="${train.dateTimeArrival}"/>
      </td>
      <td>
        <c:out value="${train.numOfFreeSeats}"/>
      </td>
      <td>

        <table border="0" rules="rows" cellspacing="0" width="100%">
          <c:forEach items="${train.typeOfFreeSeats}" var="type" >
            <tr>
              <td>
                <c:out value="${type.typeSeatName}"/>
              </td>
              <td>
                (<c:out value="${type.numOfFreeTypeSeats}"/>)
              </td>

              <td>
                <form method="post">

                  <select name = "number_wagon" >
                    <c:forEach items="${type.freeWagons}" var="wagon">
                    <option value = "${wagon.numberWagon}">${wagon.numberWagon} (${wagon.numOfFreeSeats})
                      </c:forEach>
                  </select>

                  <input type="hidden" name="datetime_begin" value="${train.dateTimeDeparture}">
                  <input type="hidden" name="datetime_end" value="${train.dateTimeArrival}">

                  <input type="hidden" name="id_type_seat" value="${type.typeSeatID}">
                  <input type="hidden" name="id_route_fragment" value="${train.routeFragmentID}">

                  <button name="command" value="accept_buy_data" type="submit">
                    <fmt:message key="order_ticket" bundle="${lang}" />
                  </button>

                  </form>
                </td>
              </tr>
            </c:forEach>
          </table>

      </td>
    </tr>
  </c:forEach>

</table>

<%@ include file="include/footer.jsp" %>

</body>

</html>
