<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Scriplets Demo Example</title>
    </head>
    <body>
    <%@page import="java.util.Locale" %>
    <%
        String name = request.getParameter("name");
        if (name == null) {
            name = "";
        }

        Locale locale = request.getLocale();
        String languageTag = locale.toLanguageTag().substring(0,2);

        String greeting;
        switch (languageTag) {
            case "fr":
                greeting = "Bonjour";
                break;
            case "en":
                greeting = "Hello";
                break;
            default:
                greeting = "Buna";
                languageTag = "ro";
        }

        response.setHeader("Content-Language", languageTag);
        out.print(String.format("%s %s!", greeting, name));
    %>

    </body>
</html>
