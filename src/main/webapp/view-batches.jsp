<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.course.model.Batch" %>

<!DOCTYPE html>
<html>
<head>
    <title>Batch List</title>
</head>
<body>
    <h1>All Batches</h1>

    <%
        List<Batch> batches = (List<Batch>) request.getAttribute("batches");

        if (batches != null && !batches.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Time Slot</th>
                <th>Actions</th>
            </tr>
            <%
                for (Batch b : batches) {
            %>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getName() %></td>
                <td><%= b.getTimeSlot() %></td>
                <td>
                    <a href="batch?action=edit&id=<%= b.getId() %>">Edit</a> |
                    <a href="batch?action=delete&id=<%= b.getId() %>"
                       onclick="return confirm('Are you sure you want to delete this batch?');">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No batches available.</p>
    <%
        }
    %>

    <br>
    <a href="batch.jsp">Add New Batch</a>
    <br>
    <a href="/simplilearn-servlet">Go to Main Menu</a>        
</body>
</html>
