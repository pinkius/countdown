<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Webster Smalley Countdown Solver - Numbers Results</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
        <c:if test="${solutions != null}">
            <table>
                <c:forEach items="${solutions}" var="solution">
                    <tr><td>${solution}</td></tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
