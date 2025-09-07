package com.simplilearn.course.dao;

import com.simplilearn.course.model.Participant;
import com.simplilearn.course.util.DBUtil;

import java.sql.*;
import java.util.*;

public class ParticipantDAO {

    public void addParticipant(Participant p) throws Exception {
        String sql = "INSERT INTO participants(name, age, email, batch_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getName());
            stmt.setInt(2, p.getAge());
            stmt.setString(3, p.getEmail());
            stmt.setInt(4, p.getBatchId());
            stmt.executeUpdate();
        }
    }

    public List<Participant> getAllParticipants() throws Exception {
        List<Participant> list = new ArrayList<>();
        String sql = "SELECT * FROM participants";
        try (Connection conn = DBUtil.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Participant p = new Participant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getInt("batch_id")
                );
                list.add(p);
            }
        }
        return list;
    }

    public Participant getById(int id) throws Exception {
        String sql = "SELECT * FROM participants WHERE id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Participant(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getInt("batch_id")
                );
            }
        }
        return null;
    }

    public void updateParticipant(Participant p) throws Exception {
        String sql = "UPDATE participants SET name=?, age=?, email=?, batch_id=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getName());
            stmt.setInt(2, p.getAge());
            stmt.setString(3, p.getEmail());
            stmt.setInt(4, p.getBatchId());
            stmt.setInt(5, p.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteParticipant(int id) throws Exception {
        String sql = "DELETE FROM participants WHERE id=?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
