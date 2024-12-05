package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.ApplicationDao;
import com.algonquincollege.oop_final_backend.dto.ApplicationDTO;
import com.algonquincollege.oop_final_backend.vo.ApplicationVo;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDaoImpl implements ApplicationDao {
    @Override
    public Boolean createApplication(ApplicationDTO applicationDTO) {
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                INSERT INTO Applications (CourseID, ProfessionalID)
                     VALUES ( ?, ?);
                """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, applicationDTO.getCourseID());
            stmt.setInt(2, applicationDTO.getProfessionalID());

            int res = stmt.executeUpdate();
            ConnectionPool.getInstance().releaseConnection(connection);

            if (res > 0) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Boolean modifyApplication(int applicationId, String status) {
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                UPDATE Applications SET Status = ? where ApplicationID = ?;
                """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, applicationId);


            int res = stmt.executeUpdate();
            ConnectionPool.getInstance().releaseConnection(connection);

            if (res > 0) {
                return true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<ApplicationVo> getApplicationsByUserId(int userId) {
        List list = new ArrayList();
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                SELECT
                    Applications.ApplicationID,
                    Courses.Title,
                    Users.Name
                FROM
                    Courses
                    JOIN
                    Applications ON Applications.CourseID = Courses.CourseID
                    JOIN
                     Users ON Users.UserID = Applications.ProfessionalID
                WHERE
                    Applications.Status = 'Pending'
                    AND Courses.InstitutionID = ?;
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ApplicationVo vo = new ApplicationVo();
                    vo.setApplicationId(rs.getInt("ApplicationID"));
                    vo.setCourseTitle(rs.getString("Title"));
                    vo.setProfessionalName(rs.getString("Name"));
                    list.add(vo);
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
