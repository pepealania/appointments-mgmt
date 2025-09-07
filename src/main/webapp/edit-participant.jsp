<%@ page import="com.simplilearn.course.model.Participant" %>
<%
    Participant p = (Participant) request.getAttribute("participant");
%>
<html>
<head><title>Edit Participant</title></head>
<body>
    <h1>Edit Participant</h1>
    <form action="participant" method="post">
        <input type="hidden" name="id" value="<%= p.getId() %>">
        Name: <input type="text" name="name" value="<%= p.getName() %>" required><br><br>
        Age: <input type="number" name="age" value="<%= p.getAge() %>" required><br><br>
        Email: <input type="email" name="email" value="<%= p.getEmail() %>" required><br><br>
        Batch ID: <input type="number" name="batchId" value="<%= p.getBatchId() %>" required><br><br>

        <input type="submit" value="Update Participant">
    </form>

    <br>
    <a href="participant">Back to Participants</a>
    <br>
    <a href="/simplilearn-servlet">Go to Main Menu</a>        
</body>
</html>