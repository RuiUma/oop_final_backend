package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.Exception.BusinessException;
import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.dto.CourseDTO;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;
import com.algonquincollege.oop_final_backend.vo.CourseVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public String getCourseTitleByCourseId(int courseId) {
        String res = null;
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                select Title from Courses where CourseID = ?;
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    res = rs.getString("Title");
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    @Override
    public int getInstitutionByCourseId(int courseId) {
        int res = -1;
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                select InstitutionID from Courses where CourseID = ?;
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    res = rs.getInt("InstitutionID");
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(res == -1) {
            throw new BusinessException("Course is not linked to an institution");
        }
        return res;
    }

    @Override
    public List<CourseVo> getAllCourseByUserId(int userId) {
        List<CourseVo> list = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                select Code, Title, CourseID from Courses where InstitutionID = ?;
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    CourseVo vo = new CourseVo();
                    vo.setTitle(rs.getString("Title"));
                    vo.setCode(rs.getString("Code"));
                    vo.setCourseId(rs.getInt("CourseId"));
                    list.add(vo);
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public CourseDetailVo getCourseDetailById(int courseId) {
        CourseDetailVo vo = new CourseDetailVo();
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                select C.Code, C.Title, T.Name, C.Compensation, C.Schedule, C.DeliveryMethod, C.PreferredQualifications, C.Outline
                from Courses C join Terms T on C.TermID = T.TermID
                where C.CourseID = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vo.setTitle(rs.getString("Title"));
                    vo.setCode(rs.getString("Code"));
                    vo.setTermName(rs.getString("Name"));
                    vo.setSchedule(rs.getString("Schedule"));
                    vo.setDeliveryMethod(rs.getString("DeliveryMethod"));
                    vo.setCompensation(rs.getString("Compensation"));
                    vo.setPreferredQualifications(rs.getString("PreferredQualifications"));
                    vo.setOutline(rs.getString("Outline"));
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return vo;
    }

    @Override
    public Boolean createCourse(CourseDTO courseDTO) {
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                INSERT INTO Courses (InstitutionID, TermID, Title, Code, Schedule, DeliveryMethod, Outline, PreferredQualifications, Compensation)
                     VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseDTO.getInstitutionId());
            stmt.setInt(2, courseDTO.getTermId());
            stmt.setString(3, courseDTO.getTitle());
            stmt.setString(4, courseDTO.getCode());
            stmt.setString(5, courseDTO.getSchedule());
            stmt.setString(6, courseDTO.getDeliveryMethod());
            stmt.setString(7, courseDTO.getOutline());
            stmt.setString(8, courseDTO.getPreferredQualifications());
            stmt.setDouble(9, courseDTO.getCompensation());


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
    public Boolean modifyCourse(CourseDTO courseDTO) {
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                UPDATE Courses SET InstitutionID=?, TermID=?, Title=?, Code=?, Schedule=?,
                DeliveryMethod = ?, Outline = ?, PreferredQualifications = ?, Compensation = ? where CourseID = ?;
                """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseDTO.getInstitutionId());
            stmt.setInt(2, courseDTO.getTermId());
            stmt.setString(3, courseDTO.getTitle());
            stmt.setString(4, courseDTO.getCode());
            stmt.setString(5, courseDTO.getSchedule());
            stmt.setString(6, courseDTO.getDeliveryMethod());
            stmt.setString(7, courseDTO.getOutline());
            stmt.setString(8, courseDTO.getPreferredQualifications());
            stmt.setDouble(9, courseDTO.getCompensation());
            stmt.setInt(10, courseDTO.getCourseId());


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
    public CourseDTO getInstitutionCourseDetail(int courseId){
        CourseDTO courseDTO = new CourseDTO();
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                select * from Courses where CourseID = ?
            """;
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    courseDTO.setTitle(rs.getString("Title"));
                    courseDTO.setCode(rs.getString("Code"));
                    courseDTO.setTermId(rs.getInt("TermID"));
                    courseDTO.setSchedule(rs.getString("Schedule"));
                    courseDTO.setDeliveryMethod(rs.getString("DeliveryMethod"));
                    courseDTO.setCompensation(rs.getDouble("Compensation"));
                    courseDTO.setPreferredQualifications(rs.getString("PreferredQualifications"));
                    courseDTO.setOutline(rs.getString("Outline"));
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return courseDTO;
    }
}
