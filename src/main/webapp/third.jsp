<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Third</title>
</head>
<body>
<p>a: ${empty param.a ? "Brak" : param.a}</p>
<p>b: ${not empty param.b ? param.b : "Brak"}</p>
</body>
</html>
