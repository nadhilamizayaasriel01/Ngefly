/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Menu;
import View.Welcome;
import View.TicketListAdd;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author Nadila Mazaya Asriel
 */
public class Auth {
    private Connection con;
    private Koneksi koneksiAuth = new Koneksi();
    
    // mengecek apakah username sudah ada atau belum
    public boolean cekUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUsername = false;

        // queri sql untuk mengecek nama
        String query = "SELECT * FROM `users` WHERE `username` =? ";

        // melakukan eksepsi untuk mengetahui jika ada error (try & catch)
        try {
            // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
            ps = Koneksi.getConnection().prepareStatement(query);
            ps.setString(1, username);

            // mengeksekusi query
            rs = ps.executeQuery();

            // pengecekan apakah usernamenya sudah ada atau tidak
            if (rs.next()) {
                checkUsername = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // mengembalikan nilai untuk pengecekan nama
        return checkUsername;
    }
    
   public boolean LoginAkun(String username, String password) {
        PreparedStatement ps;
        ResultSet rs;

        boolean cekLogin = false;

        // queri untuk mengecek apakah username & password ada di database di table user
        String query = "SELECT * FROM `users` WHERE `username` =? AND `password` =?";

        // kodingan untuk pengecekan (jika user tidak mengisi field)
        if (username.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Masukan Username!");
        } else if (password.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Masukan Kata Sandi!");
        } else {
            try {
                ps = Koneksi.getConnection().prepareStatement(query);

                ps.setString(1, username);
                ps.setString(2, password);

                // mengeksekusi queri
                rs = ps.executeQuery();

                // jika ada & dicek, maka akan berhasil login dan masuk ke halaman selanjutnya
                if (rs.next()) {

                    if (rs.getString("status").equals("Admin")) {
                        TicketListAdd lt = new TicketListAdd();
                        lt.setVisible(true);
                        cekLogin = true;
                        // jika tidak berhasil / tidak terdaftar maka akan muncul dialog jika user belom terdaftar & salah
                    } else if (rs.getString("status").equals("User")) {
                        Menu wel = new Menu();
                        wel.setVisible(true);
                        cekLogin = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Akun Belum Terdaftar / Nama Pengguna atau Kata Sandi Salah!", "Login Gagal!", 2);
                        cekLogin = false;
                    }
                }

            } catch (SQLException ex) {
                System.out.println("Error : " + ex.getMessage());
            }
        }
        return cekLogin;
    }
}
        
 
