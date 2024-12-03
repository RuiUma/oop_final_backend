package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.ProfessionalDao;
import com.algonquincollege.oop_final_backend.vo.CourseFilterVo;
import com.algonquincollege.oop_final_backend.vo.CourseVo;
import com.algonquincollege.oop_final_backend.vo.ProfessionalApplicationVo;
import com.algonquincollege.oop_final_backend.vo.SelectOption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalDaoImpl implements ProfessionalDao {

    @Override
    public List<ProfessionalApplicationVo> getApplicationsByUserId(int id) {
        List<ProfessionalApplicationVo> list = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = """
                    select a.ApplicationID, a.Status, c.Title from Applications a
                    left join Courses c on a.CourseID = c.CourseID
                    where a.ProfessionalID = ?;""";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    ProfessionalApplicationVo vo = new ProfessionalApplicationVo();
                    vo.setStatus(rs.getString("Status"));
                    vo.setCourseTitle(rs.getString("Title"));
                    vo.setApplicationID(rs.getInt("ApplicationID"));
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
    public List<CourseVo> searchCourseByFilters(CourseFilterVo filterVo) {
        List<CourseVo> list = new ArrayList<>();
        String baseSQL = """
            SELECT C.Title, C.Code, T.Name, C.CourseID
            FROM Courses C
            JOIN oop_final_database.Terms T ON C.TermID = T.TermID
            JOIN oop_final_database.Users U ON C.InstitutionID = U.UserID
        """;

        StringBuilder whereClause = new StringBuilder(" WHERE 1=1");
        if (filterVo.getCourseCode() != null && !filterVo.getCourseCode().isEmpty()) {
            whereClause.append(" AND C.Code LIKE ?");
        }
        if (filterVo.getTerm() != null && !filterVo.getTerm().isEmpty()) {
            whereClause.append(" AND T.Name LIKE ?");
        }
        if (filterVo.getInstitution() != null && !filterVo.getInstitution().isEmpty()) {
            whereClause.append(" AND U.Name LIKE ?");
        }

        String finalSQL = baseSQL + whereClause;

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();

            PreparedStatement stmt = connection.prepareStatement(finalSQL);

            int parameterIndex = 1;
            if (filterVo.getCourseCode() != null && !filterVo.getCourseCode().isEmpty()) {
                stmt.setString(parameterIndex++, "%" + filterVo.getCourseCode() + "%");
            }
            if (filterVo.getTerm() != null && !filterVo.getTerm().isEmpty()) {
                stmt.setString(parameterIndex++, "%" + filterVo.getTerm() + "%");
            }
            if (filterVo.getInstitution() != null && !filterVo.getInstitution().isEmpty()) {
                stmt.setString(parameterIndex++, "%" + filterVo.getInstitution() + "%");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    CourseVo courseVo = new CourseVo();
                    courseVo.setCode(rs.getString("Code"));
                    courseVo.setTerm(rs.getString("Name"));
                    courseVo.setTitle(rs.getString("Title"));
                    courseVo.setCourseId(rs.getInt("CourseID"));
                    list.add(courseVo);
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
