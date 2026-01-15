package com.taskmanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.taskmanager.model.Task;

public class TaskDAO {

    /* ===============================
       ADD TASK (returns generated ID)
       =============================== */
    public int addTask(Task task) {
        int generatedId = 0;

        String sql = "INSERT INTO tasks (title, description, status, user_id) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

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

    /* ===============================
       UPDATE TASK
       =============================== */
    public void updateTask(Task task) {

        String sql = "UPDATE tasks SET title=?, description=?, status=? WHERE id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setInt(4, task.getId());
            ps.setInt(5, task.getUserId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ===============================
       DELETE TASK (user-safe)
       =============================== */
    public void deleteTask(int taskId, int userId) {

        String sql = "DELETE FROM tasks WHERE id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, taskId);
            ps.setInt(2, userId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* ===============================
       GET TASK BY ID (for delete/history)
       =============================== */
    public Task getTaskById(int taskId, int userId) {

        Task task = null;
        String sql = "SELECT * FROM tasks WHERE id=? AND user_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, taskId);
            ps.setInt(2, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                task = new Task();
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                task.setUserId(rs.getInt("user_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return task;
    }

    /* ===============================
       GET ALL TASKS (Dashboard)
       =============================== */
    public List<Task> getTasksByUser(int userId) {

        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE user_id=? ORDER BY id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                task.setUserId(rs.getInt("user_id"));
                list.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /* ===============================
       FILTER TASKS BY STATUS
       =============================== */
    public List<Task> getTasksByStatus(int userId, String status) {

        List<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE user_id=? AND status=? ORDER BY id DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, status);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                task.setUserId(rs.getInt("user_id"));
                list.add(task);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
