<%--
  Created by IntelliJ IDEA.
  User: broma
  Date: 19.02.2022
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First</title>
</head>
<body>
<p>KM: ${param.get('km')}</p>
<%--Taki kod --%>
<%--
resp.getWriter().println("<p>KM: " + (Object o = param.get('km')).toString() + "</p>")
--%>
<p>KM: ${param['km']}</p>
<p>KM: ${param.km}</p>

<%--Można kod javy osadzić w "skrypletach"--%>
<%--<% try { %>--%>

<p>Mile: ${param.km / 0.62}</p>
<%--Tak też można, ale błędy parsowania--%>
<%--<p>Mile: ${Integer.parseInt(param.km) / 0.62}</p>--%>

<%--<% } catch (NumberFormatException nfe) {} %>--%>
</body>
</html>
