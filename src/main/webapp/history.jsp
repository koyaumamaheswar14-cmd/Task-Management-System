<%@ page import="java.util.*,com.taskmanager.model.TaskHistory" %>
<!DOCTYPE html>
<html>
<head>

<title>Task History</title>


</head>
<style>
/* =====================
   TASK HISTORY CONTAINER
===================== */
.container {
    width: 85%;
    max-width: 900px;
    margin: 40px auto;
    background: rgba(255, 255, 255, 0.7);
    backdrop-filter: blur(12px);
    padding: 30px;
    border-radius: 16px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.18);
    border: 1px solid rgba(255,255,255,0.6);
}

/* =====================
   TITLE
===================== */
.container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #0f172a;
}

/* =====================
   TABLE WRAPPER (SCROLL)
===================== */
.table-wrapper {
    max-height: 380px;          /* scroll inside table */
    overflow-y: auto;
    border-radius: 12px;
}

/* =====================
   TABLE
===================== */
table {
    width: 100%;
    border-collapse: collapse;
    background: rgba(255,255,255,0.95);
}

/* =====================
   TABLE HEADER
===================== */
th {
    position: sticky;
    top: 0;
    background: #2563eb;
    color: white;
    padding: 12px;
    text-align: center;
    font-size: 14px;
}

/* =====================
   TABLE CELLS
===================== */
td {
    padding: 12px;
    border-bottom: 1px solid #e5e7eb;
    text-align: center;
    font-size: 14px;
    color: #0f172a;
}

/* =====================
   ROW HOVER
===================== */
tr:hover {
    background: rgba(37, 99, 235, 0.08);
}

/* =====================
   EMPTY STATE
===================== */
.empty {
    text-align: center;
    padding: 20px;
    color: #64748b;
    font-style: italic;
}

/* =====================
   ACTION COLORS
===================== */
.CREATED {
    color: #16a34a;
    font-weight: bold;
}

.UPDATED {
    color: #f59e0b;
    font-weight: bold;
}

.DELETED {
    color: #dc2626;
    font-weight: bold;
}

</style>
<body>

<div class="container">

    <h2>Task History</h2>

    <div class="table-wrapper">
        <table>
            <tr>
                <th>Action</th>
                <th>Task Title</th>
                <th>Time</th>
            </tr>

            <%
                List<TaskHistory> history =
                    (List<TaskHistory>) request.getAttribute("history");

                if (history != null && !history.isEmpty()) {
                    for (TaskHistory h : history) {
            %>
            <tr>
                <td class="<%=h.getAction()%>"><%=h.getAction()%></td>
                <td><%=h.getTitle()%></td>
                <td><%=h.getActionTime()%></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3" class="empty">No history available</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</div>

</body>
</html>
