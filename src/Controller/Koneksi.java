/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;

/**
 *
 * @author Nadila Mazaya Asriel
 */
public class Koneksi {
    public static Connection getConnection(){
        Connection koneksi = null;
        String DB_NAME = "jdbc:mysql://localhost:3306/ngefly";
        String DB_USER = "root";
        String DB_PASS = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection
        (DB_NAME,DB_USER,DB_PASS);
        } catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return koneksi;
    }
}


