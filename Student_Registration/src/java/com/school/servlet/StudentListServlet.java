package com.school.servlet;

import com.school.db.DBConnection;
import com.school.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("age")));
            }
            request.setAttribute("students", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
        }
    }
}
