<%@ page import="com.simplilearn.course.model.Batch" %>
<%
    Batch b = (Batch) request.getAttribute("batch");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Batch</title>
</head>
<body>
    <h1>Edit Batch</h1>

    <form action="batch" method="post">
        <input type="hidden" name="id" value="<%= b.getId() %>">

        Name: <input type="text" name="name" value="<%= b.getName() %>" required><br><br>
        Time Slot: <input type="text" name="timeSlot" value="<%= b.getTimeSlot() %>" required><br><br>

        <input type="submit" value="Update Batch">
    </form>

    <br>
    <a href="batch">Back to Batch List</a>
    <br>
    <a href="/simplilearn-servlet">Go to Main Menu</a>        
</body>
</html>
