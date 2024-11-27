package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.UserDao;
import com.algonquincollege.oop_final_backend.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public UserDTO getUserByEmail(String email) {

        Connection connection;
        UserDTO userDTO = new UserDTO();
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM Users WHERE Email = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    userDTO.setUserID(rs.getInt("UserID"));
                    userDTO.setUserType(rs.getString("UserType"));
                    userDTO.setName(rs.getString("Name"));
                    userDTO.setEmail(rs.getString("Email"));
                    userDTO.setPassword(rs.getString("Password"));
                    userDTO.setCurrentPosition(rs.getString("CurrentPosition"));
                    userDTO.setInstitutionID(rs.getInt("InstitutionID"));
                    userDTO.setEducationBackground(rs.getString("EducationBackground"));
                    userDTO.setAreaOfExpertise(rs.getString("AreaOfExpertise"));
                    userDTO.setAddress(rs.getString("Address"));

                }
            }

            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (userDTO.getEmail() != null) {
            return userDTO;
        }

        return null;
    }

    @Override
    public Boolean insertUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Boolean modifyUser(UserDTO userDTO) {
        return null;
    }
}
