<%@ page import="java.util.ArrayList" %>
<%@ page import="model.datedesc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            padding: 20px 50px;
            background-color: red;
            margin: 10px;
            font-size: 30px;
            width: 235px;
            text-align: center;
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
    <!--<input type="text" name="mydate" id="mydate">-->
<input type="date" name="mydate" id="mydate">
<label for="mydescription">Details:</label>
<input type="text" name="mydescription" id="mydescription">
    <button type="submit">Add</button>
</form>
<%ArrayList<datedesc> list= (ArrayList<datedesc>)request.getAttribute("repo");%>
<table>
    <% for(int i=0;i<list.size();i++){%>
    <tr>
        <td>
           <%=((datedesc)list.get(i)).getData()%>
        </td>
        <td>
            <%=((datedesc)list.get(i)).getVote()%>
        </td>
    </tr>
    <%}%>
    <tr>
        <td>
            <%if(list.size()!=0){%>
            <%=((datedesc)list.get(list.size()-1)).getDescription()%>
            <%}%>
        </td>
    </tr>
</table>
</body>
</html>
