<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.course.model.Participant" %>

<!DOCTYPE html>
<html>
<head>
    <title>Participants List</title>
</head>
<body>
    <h1>Participants</h1>

    <%
        List<Participant> participants = (List<Participant>) request.getAttribute("participants");
        if (participants != null && !participants.isEmpty()) {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Batch ID</th>
                <th>Actions</th>
            </tr>
            <%
                for (Participant p : participants) {
            %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getAge() %></td>
                    <td><%= p.getEmail() %></td>
                    <td><%= p.getBatchId() %></td>
                    <td>
                        <a href="participant?action=edit&id=<%= p.getId() %>">Edit</a> |
                        <a href="participant?action=delete&id=<%= p.getId() %>"
                           onclick="return confirm('Are you sure you want to delete this participant?');">Delete</a>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>No participants found.</p>
    <%
        }
    %>

    <br>
    <a href="participant.jsp">Add New Participant</a>
    <br>
    <a href="/simplilearn-servlet">Go to Main Menu</a>    
</body>
</html>
