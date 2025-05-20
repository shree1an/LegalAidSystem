package com.legalaid.service;

import com.legalaid.config.DbConfig;
import com.legalaid.model.clientModel;
import java.sql.*;

public class clientService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Constructor that initializes the database connection.
     * Sets a flag if the connection cannot be established.
     */
    public clientService() {
        try {
            dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            isConnectionError = true;
        }
    }

    /**
     * Fetches a single lawyer by ID.
     * @param id lawyer ID
     * @return lawyerModel or null if not found or on error
     */
    
    public clientModel getClientById(int id) {
        if (isConnectionError) return null;

        String sql =
          "SELECT ClientId, C_Full_Name, C_Email, C_Address, C_Phone, C_Password, Date_Of_Birth, Gender "
        + "FROM client "
        + "WHERE ClientId = ?";

        try (PreparedStatement ps = dbConn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("[Service] Row found for ID=" + id);
                    return new clientModel(
                        rs.getInt("ClientId"),
                        rs.getString("C_Full_Name"),
                        rs.getString("C_Email"),
                        rs.getString("C_Address"),
                        rs.getString("C_Phone"),
                        rs.getString("C_Password"),
                        rs.getDate("Date_Of_Birth").toLocalDate(),
                        rs.getString("Gender")
                    );
                } else {
                    System.out.println("[Service] No row for ID=" + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateClient(clientModel client) {
        if (isConnectionError) return false;

        String sql = 
          "UPDATE client SET " +
          "C_Email = ?, C_Address = ?, C_Phone = ?, " +
          "C_Password = ? " +
          "WHERE ClientId = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(sql)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setString(3, client.getAddress());
            ps.setString(4, client.getPhone());
            ps.setString(5, client.getGender());
            int rows = ps.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
