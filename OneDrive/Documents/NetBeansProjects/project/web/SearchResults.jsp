<%-- 
    Document   : SearchResults
    Created on : Nov 29, 2024, 1:33:39 p.m.
    Author     : baljo
--%>

<%@page import="java.util.List"%>
<%@ page language="java" import="services.SearchService,models.Course" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String criteria = request.getParameter("criteria");
    SearchService searchService = new SearchService();
    List<Course> courses = searchService.searchCourses(criteria);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <h1>Search Results</h1>
    <%
        if (courses.isEmpty()) {
    %>
        <p>No courses found matching your criteria.</p>
    <%
        } else {
    %>
        <ul>
        <%
            for (Course course : courses) {
                out.println("<li>" + course.toString() + "</li>");
            }
        %>
        </ul>
    <%
        }
    %>
    <a href="SearchCourse.jsp">Back to Search</a>
</body>
</html>
