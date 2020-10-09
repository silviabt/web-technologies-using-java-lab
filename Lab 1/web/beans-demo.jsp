<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="webprogramming.lab1.ex6.HelloHelper" %>
<%--<%@ =  directive--%>
<html>
    <head>
        <title>Beans Demo Example</title>
    </head>
    <body>
        <h1>
            <jsp:useBean id="helper" class="webprogramming.lab1.ex6.HelloHelper" scope="application" />
            <%= helper.getGreeting(request.getLocale()) %> ${param.name}
        </h1>
    </body>
</html>
