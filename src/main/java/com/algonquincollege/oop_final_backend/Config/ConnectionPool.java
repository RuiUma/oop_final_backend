/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author mzr_u
 */
public class ConnectionPool {
    private static ConnectionPool instance;
    private final BlockingQueue<Connection> connectionPool;

    private ConnectionPool(String dbUrl, String dbUser, String dbPassword, int poolSize) throws SQLException {
        connectionPool = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            connectionPool.add(connection);
        }
    }

    public static synchronized ConnectionPool getInstance(String dbUrl, String dbUser, String dbPassword, int poolSize) throws SQLException {
        if (instance == null) {
            instance = new ConnectionPool(dbUrl, dbUser, dbPassword, poolSize);
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.offer(connection);
        }
    }

    public void closeAllConnections() {
        while (!connectionPool.isEmpty()) {
            try {
                connectionPool.poll().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
