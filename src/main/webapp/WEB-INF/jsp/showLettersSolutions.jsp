<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Webster Smalley Countdown Solver - Letters Results</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
        <c:if test="${matches != null}">
            <table>
                <c:forEach items="${matches}" var="match">
                    <tr><td><span class="l${match.length}">&nbsp;${match.length}&nbsp;</span> <a href="http://en.wiktionary.org/wiki/${fn:toLowerCase(match)}" target="_blank">${match}</a></td></tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
