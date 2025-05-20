package com.eNyaya.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eNyaya.config.DbConfig;
//import com.eNyaya.util.PasswordUtil;

/**
 * Service class for handling login operations.
 */
public class LoginService {

    private static final String ADMIN_EMAIL = "admin@enyaya.com";
    private static final String ADMIN_PASSWORD = "Admin@123";

    private Connection dbConn;
    private boolean isConnectionError = false;

    public LoginService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Returns:
     * - "admin" for successful admin login
     * - "client" for successful client login
     * - "lawyer" for successful lawyer login
     * - "wrong_password" if email found but password does not match
     * - "not_found" if email not registered in any table
     * - "error" for DB connection or other issues
     */
    public String login(String email, String password) {
        if (isConnectionError) {
            return "error";
        }

        // Check in lawyer table
        String result = checkUserInTable(email, password, "Lawyer", "lawyerEmail", "lawyerPassword");
        if ("success".equals(result)) return "lawyer";
        if ("wrong_password".equals(result)) return "wrong_password";

        // Check in client table
        result = checkUserInTable(email, password, "Client", "clientEmail", "clientPassword");
        if ("success".equals(result)) return "client";
        if ("wrong_password".equals(result)) return "wrong_password";

        // Admin login
        if (email.equalsIgnoreCase(ADMIN_EMAIL)) {
            if (password.equals(ADMIN_PASSWORD)) {
                return "admin";
            } else {
                return "wrong_password";
            }
        }

        return "not_found";
    }

    private String checkUserInTable(String email, String password, String table, String emailCol, String passCol) {
        String query = "SELECT " + emailCol + ", " + passCol + " FROM " + table + " WHERE " + emailCol + " = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                String dbEmail = result.getString(emailCol);
                String dbPassword = result.getString(passCol);
                
                System.out.println(email + password + dbEmail + dbPassword  );
                

                //String decryptedPassword = PasswordUtil.decrypt(dbPassword, dbEmail);

                if (dbPassword == null || !dbPassword.equals(password)) {
                    return "wrong_password";
                }

                return "success";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }

        return "not_found";
    }
}
