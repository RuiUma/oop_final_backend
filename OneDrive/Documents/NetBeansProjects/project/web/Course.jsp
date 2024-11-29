<%-- 
    Document   : Course
    Created on : Nov 28, 2024, 1:54:57 p.m.
    Author     : baljo
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Course</title>
</head>
<body>
    <h1>Create Course</h1>
    <form action="CourseServlet" method="post">
        <label for="title">Course Title:</label><br>
        <input type="text" id="title" name="title" required><br><br>

        <label for="code">Course Code:</label><br>
        <input type="text" id="code" name="code" required><br><br>

        <label for="term">Term:</label><br>
        <input type="text" id="term" name="term" required><br><br>

        <button type="submit">Create Course</button>
    </form>
</body>
</html>
