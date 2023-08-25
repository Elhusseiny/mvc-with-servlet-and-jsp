<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="net.qeema.mvc.entity.User" %>

<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>Current number of users</h2>

<table>
    <tr>

        <th>Username</th>
        <th>Email</th>
    </tr>
    <%
        List<User> listUsers = (List)request.getAttribute("users");
        for(int i=0;i<listUsers.size(); i++){
            out.print("<tr>");
            out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
            out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
            out.print("</tr>");
        }

    %>
</table>
<br/>
<br/>
<a href="addUser">Click here to add user again</a>
</body>
</html>

