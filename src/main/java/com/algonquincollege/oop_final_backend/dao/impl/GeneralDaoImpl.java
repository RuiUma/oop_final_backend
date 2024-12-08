package com.algonquincollege.oop_final_backend.dao.impl;

import com.algonquincollege.oop_final_backend.config.ConnectionPool;
import com.algonquincollege.oop_final_backend.dao.GeneralDao;
import com.algonquincollege.oop_final_backend.vo.SelectOption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GeneralDaoImpl implements GeneralDao {
    @Override
    public List<SelectOption> getInstitutionSelections() {
        List<SelectOption> resList = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT * FROM Users WHERE UserType = 'Institution'";
            PreparedStatement stmt = connection.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    SelectOption so = new SelectOption();
                    so.setLabel(rs.getString("Name"));
                    so.setValue(rs.getString("UserID"));
                    resList.add(so);
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resList;
    }

    @Override
    public List<SelectOption> getTermSelections() {
        List<SelectOption> resList = new ArrayList<>();

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            String sql = "SELECT TermID, Name FROM Terms group by TermID, Name";
            PreparedStatement stmt = connection.prepareStatement(sql);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    SelectOption so = new SelectOption();
                    so.setLabel(rs.getString("Name"));
                    so.setValue(rs.getString("TermID"));
                    resList.add(so);
                }
            }
            ConnectionPool.getInstance().releaseConnection(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resList;
    }

}
