<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            background-color: red;
            font-size: 30px;
        }
    </style>
</head>
<body>
<%
    String error = (String) request.getAttribute("error");
    if (error != null && !error.isEmpty()) {
%>
<div class="error">
    <%= error %>
</div>
<%}%>
<form action="<%=request.getContextPath()%>/register" method="post">
    <label for="mydate">Date:</label>
    <input type="text" name="mydate" id="mydate">
    <!--<input type="datetime-local" name="mydate" id="mydate">-->
    <label for="mydescription">Details:</label>
    <input type="text" name="mydescription" id="mydescription">
    <button type="submit">Add</button>
</form>
<table>
    <%-- for(int i=0;i<){--%>
    <tr>
        <td>
            <%--=mydates[i]--%>
        </td>
    </tr>
    <%--}--%>
</table>
</body>
</html>