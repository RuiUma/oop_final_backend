/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquincollege.oop_final_backend.config;


/**
 *
 * @author mzr_u
 */
public class DatabaseConfig {
    public static final String DB_URL = "jdbc:mysql://155.248.228.201:3306/oop_final_database?" +
                 "useSSL=true&verifyServerCertificate=true&" +
                 "trustCertificateKeyStoreUrl=file:/D:/Course/Code/OOP_FINAL/oop_final_backend/keystore.jks&" +
                 "trustCertificateKeyStorePassword=keystore";
    public static final String USER = "oop_user";
    public static final String PASSWORD = "DevPass123!";
    public static final int POOL_SIZE = 10;
    
//    public static final String DB_URL = "jdbc:mysql://localhost:3306/oop_final";
//    public static final String USER = "root";
//    public static final String PASSWORD = "1234";
//    public static final int POOL_SIZE = 10;
}
