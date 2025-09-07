<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Participant</title>
</head>
<body>
    <h1>Add New Participant</h1>

    <form action="participant" method="post">
        <input type="hidden" name="action" value="create">

        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Age:</label><br>
        <input type="number" name="age" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Batch ID:</label><br>
        <input type="number" name="batchId" required><br><br>

        <input type="submit" value="Add Participant">
    </form>

    <br>
    <a href="view-participants.jsp">View All Participants</a>
    <br>
    <a href="/simplilearn-servlet">Go to Main Menu</a>        
</body>
</html>
