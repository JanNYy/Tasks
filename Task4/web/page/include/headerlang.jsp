<%--
  Created by Anna Oliinyk
--%>

<form name="fmLanguage" method="get" action="language">
  <button name="language" value="en" type="submit">
    <fmt:message key="eng" bundle="${lang}" />
  </button>
  <button name="language" value="ru" type="submit">
    <fmt:message key="rus" bundle="${lang}" />
  </button>
  <button name="language" value="ua" type="submit">
    <fmt:message key="ukr" bundle="${lang}" />
  </button>
</form>
