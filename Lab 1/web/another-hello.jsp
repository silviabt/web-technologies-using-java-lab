<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Another Hello Example</title>
    </head>
    <body>
<%--        <h1>Hello <%= request.getParameter("name") %></h1>--%>
        <h1>Hello ${param.name} </h1>
    </body>
</html>
