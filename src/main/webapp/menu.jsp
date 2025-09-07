<%@ page import="java.util.List" %>
<%@ page import="com.simplilearn.course.model.Batch" %>

<!DOCTYPE html>
<html>
<head>
    <title>Zumba Management App</title>
</head>
<body>
    <h1>Welcome to Zumba Participant & Batch Manager</h1>

<%
    List<Batch> batches = (List<Batch>) request.getAttribute("batches");
    boolean hasBatches = (batches != null && !batches.isEmpty());
%>

<!-- Conditionally show the link -->
<% if (hasBatches) { %>
    <a href="participant">Manage Participants</a>
<% } else { %>
    <p style="color: gray;">No batches available. Manage Participants is disabled.</p>
<% } %><br>
    <a href="batch">Manage Batches</a>
</body>
</html>