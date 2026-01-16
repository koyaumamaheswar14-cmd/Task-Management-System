package com.taskmanager.dao;

import java.sql.*;
import java.util.*;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskHistory;

public class TaskHistoryDAO {

    //  LOG ACTION
    public static void log(int taskId, int userId, String action, String title) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO task_history(task_id,user_id,action,title) VALUES (?,?,?,?)"
            );
            ps.setInt(1, taskId);
            ps.setInt(2, userId);
            ps.setString(3, action);
            ps.setString(4, title);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  FETCH HISTORY BY USER
    public static List<TaskHistory> getByUser(int userId) {
        List<TaskHistory> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM task_history WHERE user_id=? ORDER BY action_time DESC"
            );
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TaskHistory h = new TaskHistory();
                h.setId(rs.getInt("id"));
                h.setTaskId(rs.getInt("task_id"));
                h.setUserId(rs.getInt("user_id"));
                h.setAction(rs.getString("action"));
                h.setTitle(rs.getString("title"));
                h.setActionTime(rs.getTimestamp("action_time"));
                list.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int addTask(Task task) {
        int generatedId = 0;
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tasks(title, description, status, user_id) VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setInt(4, task.getUserId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedId;
    }
}

