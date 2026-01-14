package com.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginApp {

    static final String URL = "jdbc:mysql://localhost:3306/mini_jdbc";
    static final String USER = "root";
    static final String PASS = "venky@sql"; 

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String uname = sc.nextLine();

        System.out.print("Enter password: ");
        String upass = sc.nextLine();

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection con = DBConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, uname);
            ps.setString(2, upass);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("✅ Login Successful!");
                } else {
                    System.out.println("❌ Invalid Username or Password!");
                }
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        sc.close();
    }
}
