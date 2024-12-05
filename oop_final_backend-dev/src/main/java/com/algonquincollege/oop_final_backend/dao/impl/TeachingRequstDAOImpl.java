package com.algonquincollege.oop_final_backend.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.TeachingRequestDAO;
import com.algonquincollege.oop_final_backend.dto.TeachingRequestDTO;

public class TeachingRequstDAOImpl implements TeachingRequestDAO {
    @Override
    public boolean createTeachingRequest(TeachingRequestDTO request) {
        String sql = "INSERT INTO teaching_requests (course_id, professional_id, expertise) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, request.getCourseID());
            stmt.setInt(2, request.getProfessionalID());
            stmt.setString(3, request.getExpertise());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create teaching request: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateTeachingRequestStatus(int requestID, String status) {
        String sql = "UPDATE teaching_requests SET status = ? WHERE request_id = ?";
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, requestID);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("Failed to update teaching request status: " + e.getMessage(), e);
        }
    }

    @Override
    public List<TeachingRequestDTO> getTeachingRequestsByCourseID(int courseID) {
        String sql = "SELECT * FROM teaching_requests WHERE course_id = ?";
        List<TeachingRequestDTO> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, courseID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TeachingRequestDTO request = new TeachingRequestDTO();
                    request.setRequestID(rs.getInt("request_id"));
                    request.setCourseID(rs.getInt("course_id"));
                    request.setProfessionalID(rs.getInt("professional_id"));
                    request.setStatus(rs.getString("status"));
                    request.setExpertise(rs.getString("expertise"));
                    request.setRequestDate(rs.getTimestamp("request_date").toLocalDateTime());
                    requests.add(request);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve teaching requests: " + e.getMessage(), e);
        }
        return requests;
    }
}
