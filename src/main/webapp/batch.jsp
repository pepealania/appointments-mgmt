<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Batch</title>
</head>
<body>
    <h1>Add New Batch</h1>

    <form action="batch" method="post">
        <input type="hidden" name="action" value="create">

        <label>Batch Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Time Slot:</label><br>
        <input type="text" name="timeSlot" required placeholder="e.g., Morning or Evening"><br><br>

        <input type="submit" value="Add Batch">
    </form>

    <br>
    <a href="view-batches.jsp">View All Batches</a>
    <br>
    <a href="/simplilearn-servlet">Go to Main Menu</a>    
</body>
</html>
