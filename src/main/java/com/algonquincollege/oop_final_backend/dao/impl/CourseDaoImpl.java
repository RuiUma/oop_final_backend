package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.CourseDao;
import com.algonquincollege.oop_final_backend.vo.CourseDetailVo;
import com.algonquincollege.oop_final_backend.vo.SelectOption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CourseDaoImpl implements CourseDao {

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
}
