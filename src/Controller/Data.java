/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BiodataL;
import Model.TBooking;
import Model.TList;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Nadila Mazaya Asriel
 */
public class Data {
    private Connection con;
    private final Koneksi koneksiData = new Koneksi();

    // mengecek apakah username sudah ada atau belum
    public boolean cekUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkNama = false;

        // queri sql untuk mengecek nama
        String query = "SELECT * FROM `users` WHERE `id` =?";

        // melakukan eksepsi untuk mengetahui jika ada error (try & catch)
        try {
            // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
            ps = Koneksi.getConnection().prepareStatement(query);
            ps.setString(1, username);

            // mengeksekusi query
            rs = ps.executeQuery();

            // pengecekan apakah usernamenya sudah ada atau tidak
            if (rs.next()) {
                checkNama = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // mengembalikan nilai untuk pengecekan nama
        return checkNama;
    }
    
    public boolean cekIdBooking(String id) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkId = false;

        // queri sql untuk mengecek nama
        String query = "SELECT * FROM `ticketbooking` WHERE `id` =?";

        // melakukan eksepsi untuk mengetahui jika ada error (try & catch)
        try {
            // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
            ps = Koneksi.getConnection().prepareStatement(query);
            ps.setString(1, id);

            // mengeksekusi query
            rs = ps.executeQuery();

            // pengecekan apakah usernamenya sudah ada atau tidak
            if (rs.next()) {
                checkId = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // mengembalikan nilai untuk pengecekan nama
        return checkId;
    }
    
        public boolean cekIdBiodata(String id) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkId = false;

        // queri sql untuk mengecek nama
        String query = "SELECT * FROM `biodata` WHERE `id` =?";

        // melakukan eksepsi untuk mengetahui jika ada error (try & catch)
        try {
            // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
            ps = Koneksi.getConnection().prepareStatement(query);
            ps.setString(1, id);

            // mengeksekusi query
            rs = ps.executeQuery();

            // pengecekan apakah usernamenya sudah ada atau tidak
            if (rs.next()) {
                checkId = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        // mengembalikan nilai untuk pengecekan nama
        return checkId;
    }
    
    // TAMPIL DATA 
    public ArrayList<TBooking> tampilData() throws SQLException {
        ArrayList<TBooking> tampil = new ArrayList<>();

        // membuka koneksi
        con = koneksiData.getConnection();

        // membuat query untuk tampil data biodata
        String kueri = "SELECT * FROM ticketbooking";
        PreparedStatement ps = con.prepareStatement(kueri);

        // mengeksekusi query
        ResultSet rs = ps.executeQuery();

        // melakukan perulangan untuk menampilkan seluruh data yang ada di tabel data
        while (rs.next()) {
            String id = rs.getString("id");
            String depart = rs.getString("depart");
            String arrive = rs.getString("arrive");
            String airlines = rs.getString("airlines");
            String amount = rs.getString("amount");
            String ticketCode = rs.getString("ticketCode");
            String name = rs.getString("name");
          
            TBooking tb = new TBooking(id, depart, arrive, airlines, amount, ticketCode, name);
            tampil.add(tb);
        }
        
        // menutup result set, preparedstatement dan koneksi
        rs.close();
        ps.close();
        con.close();
        
        // mengembalikan nilai
        return tampil;
    }
         // TAMPIL DATA 
    public ArrayList<TList> tampilDataTicket() throws SQLException {
        ArrayList<TList> tampil = new ArrayList<>();

        // membuka koneksi
        con = koneksiData.getConnection();

        // membuat query untuk tampil data biodata
        String kueri = "SELECT * FROM ticketlist";
        PreparedStatement ps = con.prepareStatement(kueri);

        // mengeksekusi query
        ResultSet rs = ps.executeQuery();

        // melakukan perulangan untuk menampilkan seluruh data yang ada di tabel data
        while (rs.next()) {
            String airlines = rs.getString("airlines");
            String depart = rs.getString("depart");
            String arrive = rs.getString("arrive");
            String available = rs.getString("available");
            String time = rs.getString("time");
            String date = rs.getString("date");
            String price = rs.getString("price");
            String ticketCode = rs.getString("ticketCode");
            
            TList tl = new TList(airlines, depart, arrive, available, time, date, price, ticketCode);
            tampil.add(tl);
        }
        
        
        // menutup result set, preparedstatement dan koneksi
        rs.close();
        ps.close();
        con.close();
        
        // mengembalikan nilai
        return tampil;
    }
    
    // TAMPIL DATA 
    public ArrayList<User> tampilDataUsers() throws SQLException {
        ArrayList<User> tampil = new ArrayList<>();

        // membuka koneksi
        con = koneksiData.getConnection();

        // membuat query untuk tampil data biodata
        String kueri = "SELECT * FROM data";
        PreparedStatement ps = con.prepareStatement(kueri);

        // mengeksekusi query
        ResultSet rs = ps.executeQuery();

        // melakukan perulangan untuk menampilkan seluruh data yang ada di tabel data
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String status = rs.getString("status");
            
            User user = new User(id, name, email, username, password, status);
            tampil.add(user);
        }
        
        
        // menutup result set, preparedstatement dan koneksi
        rs.close();
        ps.close();
        con.close();
        
        // mengembalikan nilai
        return tampil;
    }
        
    
    //tampil biodata
	public ArrayList<BiodataL> tampilDataBiodata() throws SQLException {
        ArrayList<BiodataL> tampil = new ArrayList<>();

        // membuka koneksi
        con = koneksiData.getConnection();

        // membuat query untuk tampil data biodata
        String kueri = "SELECT * FROM biodata";
        PreparedStatement ps = con.prepareStatement(kueri);

        // mengeksekusi query
        ResultSet rs = ps.executeQuery();

        // melakukan perulangan untuk menampilkan seluruh data yang ada di tabel data
        while (rs.next()) {
            String id = rs.getString("id");
            String fullname = rs.getString("fullname");
            String birthdate = rs.getString("birthdate");
            String age = rs.getString("age");
            String address = rs.getString("address");
            String city = rs.getString("city");
            String contact = rs.getString("contact");
            
            BiodataL bio = new BiodataL(id, fullname, birthdate, age, address, city, contact);
            tampil.add(bio);
        }
     // menutup result set, preparedstatement dan koneksi
        rs.close();
        ps.close();
        con.close();
        
        // mengembalikan nilai
        return tampil;
    }
    
    
       // TAMBAH DATA 
        public boolean tambahDataUsers(User data) throws SQLException {

        // membuka koneksi ke database
        con = koneksiData.getConnection();

        // membuat query untuk tambah data akun
        String kueri = "INSERT INTO users (id, name, email, username, password, status) VALUES (?,?,?,?,?,?)";

        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1 , data.getId());
        ps.setString(2 , data.getName());
        ps.setString(3 , data.getEmail());
        ps.setString(4 , data.getUsername());
        ps.setString(5 , data.getPassword());
        ps.setString(6 , data.getStatus());

        // mengeksekusi query
        int rowAffected = ps.executeUpdate();

        // menutup koneksi
        ps.close();
        con.close();

        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
    } 
        
        public boolean tambahDataTicket(TList data) throws SQLException {

        // membuka koneksi ke database
        con = koneksiData.getConnection();

        // membuat query untuk tambah data akun
        String kueri = "INSERT INTO ticketlist (airlines, depart, arrive, available, time, date, price, ticketCode) VALUES (?,?,?,?,?,?,?,?)";

        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1 , data.getAirlines());
        ps.setString(2 , data.getDepart());
        ps.setString(3 , data.getArrive());
        ps.setString(4 , data.getAvailable());
        ps.setString(5 , data.getTime());
        ps.setString(6 , data.getDate());
        ps.setString(7 , data.getPrice());
        ps.setString(8 , data.getTicketCode());

        // mengeksekusi query
        int rowAffected = ps.executeUpdate();

        // menutup koneksi
        ps.close();
        con.close();

        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
    } 
    
    // TAMBAH DATA 
    public boolean tambahData(TBooking data) throws SQLException {

        // membuka koneksi ke database
        con = koneksiData.getConnection();

        // membuat query untuk tambah data akun
        String kueri = "INSERT INTO ticketbooking (id, depart, arrive, airlines, amount, ticketcode, name) VALUES (?,?,?,?,?,?,?)";

        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1 , data.getId());
        ps.setString(2 , data.getDepart());
        ps.setString(3 , data.getArrive());
        ps.setString(4 , data.getAirlines());
        ps.setString(5 , data.getAmount());
        ps.setString(6 , data.getTicketCode());
        ps.setString(7 , data.getName());

        // mengeksekusi query
        int rowAffected = ps.executeUpdate();

        // menutup koneksi
        ps.close();
        con.close();

        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
    }
    
    public boolean tambahDataBiodata(BiodataL data) throws SQLException {

        // membuka koneksi ke database
        con = koneksiData.getConnection();

        // membuat query untuk tambah data 
        String kueri = "INSERT INTO biodata(id, fullname, birthdate, age, address,city, contact) VALUES (?,?,?,?,?,?,?)";

        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1 , data.getId());
        ps.setString(2 , data.getFullname());
        ps.setString(3 , data.getBirthdate());
        ps.setString(4 , data.getAge());
        ps.setString(5 , data.getAddress()); 
        ps.setString(6 , data.getCity());
        ps.setString(7 , data.getContact());

        // mengeksekusi query
        int rowAffected = ps.executeUpdate();

        // menutup koneksi
        ps.close();
        con.close();

        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
    }
    
 
    public boolean ubahData(TBooking data) throws SQLException{
        
        // membuka koneksi ke database
        con = koneksiData.getConnection();
        
        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        String kueri = "UPDATE ticketbooking SET depart=?, arrive=?, airlines=?, amount=?, ticketcode=?, name=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(7, data.getId());
        ps.setString(1, data.getDepart());
        ps.setString(2, data.getArrive());
        ps.setString(3, data.getAirlines());
        ps.setString(4, data.getAmount());
        ps.setString(5, data.getTicketCode());
        ps.setString(6, data.getName());
        
        // mengeksekusi query
        int rowAffected = ps.executeUpdate();
        
        // menutup preparedstatement & koneksi
        ps.close(); con.close();
        
        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
    }
    
     public boolean ubahDataTiket(TList data) throws SQLException{
        
        // membuka koneksi ke database
        con = koneksiData.getConnection();
        
        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        String kueri = "UPDATE ticketlist SET airlines=?, depart=?, arrive=?, available=?, time=?, date=?, price=? WHERE ticketCode=? ";
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(8, data.getTicketCode());
        ps.setString(1, data.getAirlines());
        ps.setString(2, data.getDepart());
        ps.setString(3, data.getArrive());
        ps.setString(4, data.getAvailable());
        ps.setString(5, data.getTime());
        ps.setString(6, data.getDate());
        ps.setString(7, data.getPrice());
        
        
        // mengeksekusi query
        int rowAffected = ps.executeUpdate();
        
        // menutup preparedstatement & koneksi
        ps.close(); con.close();
        
        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
    }
    
    public boolean hapusData(String id) throws SQLException{
        
        // membuka koneksi ke database
        con = koneksiData.getConnection();
        
        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        String kueri = "DELETE FROM ticketbooking WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1, id); 
        
        // mengeksekusi query
        int rowAffected = ps.executeUpdate();
        
        // menutup preparedstatement & koneksi
        ps.close(); con.close();
        
        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
        
    }
    public boolean hapusDataBiodata(String id) throws SQLException{
        
        // membuka koneksi ke database
        con = koneksiData.getConnection();
        
        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        String kueri = "DELETE FROM biodata WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1, id); 
        
        // mengeksekusi query
        int rowAffected = ps.executeUpdate();
        
        // menutup preparedstatement & koneksi
        ps.close(); con.close();
        
        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
        
    }
    
    public boolean hapusDataTicket(String ticketCode) throws SQLException{
        
        // membuka koneksi ke database
        con = koneksiData.getConnection();
        
        // Menyiapkan database / memanipulasi data untuk dikiirm kedatabase untuk dieksekusi
        String kueri = "DELETE FROM tickelist WHERE ticketCode = ?";
        PreparedStatement ps = con.prepareStatement(kueri);
        ps.setString(1, ticketCode); 
        
        // mengeksekusi query
        int rowAffected = ps.executeUpdate();
        
        // menutup preparedstatement & koneksi
        ps.close(); con.close();
        
        // mengembalikan nilai data untuk dirubah ke database mysql
        return rowAffected == 1;
        
    }
}

