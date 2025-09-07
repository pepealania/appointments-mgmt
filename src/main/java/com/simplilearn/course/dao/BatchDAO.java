package com.simplilearn.course.dao;

import com.simplilearn.course.model.Batch;
import com.simplilearn.course.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {

    public void addBatch(Batch batch) throws Exception {
        String sql = "INSERT INTO batches(name, time_slot) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, batch.getName());
            stmt.setString(2, batch.getTimeSlot());
            stmt.executeUpdate();
        }
    }

    public List<Batch> getAllBatches() throws Exception {
        List<Batch> list = new ArrayList<>();
        String sql = "SELECT * FROM batches";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Batch batch = new Batch(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("time_slot")
                );
                list.add(batch);
            }
        }
        return list;
    }

    public Batch getById(int id) throws Exception {
        String sql = "SELECT * FROM batches WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Batch(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("time_slot")
                );
            }
        }
        return null;
    }

    public void updateBatch(Batch batch) throws Exception {
        String sql = "UPDATE batches SET name=?, time_slot=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, batch.getName());
            stmt.setString(2, batch.getTimeSlot());
            stmt.setInt(3, batch.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteBatch(int id) throws Exception {
        String sql = "DELETE FROM batches WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
