<%@ page import="com.school.model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Student> students = (List<Student>) request.getAttribute("students");
                for (Student student : students) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getEmail() %></td>
                <td><%= student.getAge() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <a href="registerStudent.jsp">Register New Student</a>
</body>
</html>
