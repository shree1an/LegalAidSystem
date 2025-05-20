package com.legalaid.service;

import com.legalaid.config.DbConfig;
import com.legalaid.model.lawyerModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lawyerProfileService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    /**
     * Constructor that initializes the database connection.
     * Sets a flag if the connection cannot be established.
     */
    public lawyerProfileService() {
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
    
    public lawyerModel getLawyerById(int id) {
        if (isConnectionError) return null;

        String sql =
          "SELECT lawyer_id, lawyer_name, license_number, experience_year, email, dob, gender, phone, address, district, province "
        + "FROM lawyer "
        + "WHERE lawyer_id = ?";

        try (PreparedStatement ps = dbConn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("[Service] Row found for ID=" + id);
                    return new lawyerModel(
                        rs.getInt("lawyer_id"),
                        rs.getString("lawyer_name"),
                        rs.getInt("license_number"),
                        rs.getInt("experience_year"),
                        rs.getString("email"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("district"),
                        rs.getString("province")
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

    public boolean updateLawyer(lawyerModel lawyer) {
        if (isConnectionError) return false;

        String sql = 
          "UPDATE lawyer SET " +
          "lawyer_name = ?, license_number = ?, experience_year = ?, email = ?, " +
          "dob = ?, gender = ?, phone = ?, address = ?, district = ?, province = ? " +
          "WHERE lawyer_id = ?";
        try (PreparedStatement ps = dbConn.prepareStatement(sql)) {
            ps.setString(1, lawyer.getName());
            ps.setInt(2, lawyer.getLicense());
            ps.setInt(3, lawyer.getExpYear());
            ps.setString(4, lawyer.getEmail());
            ps.setDate(5, Date.valueOf(lawyer.getDob()));
            ps.setString(6, lawyer.getGender());
            ps.setString(7, lawyer.getPhone());
            ps.setString(8, lawyer.getAddress());
            ps.setString(9, lawyer.getDistrict());
            ps.setString(10, lawyer.getProvince());
            ps.setInt(11, lawyer.getId());
            int rows = ps.executeUpdate();
            return rows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<lawyerModel> getAllLawyers() {
        if (isConnectionError) return Collections.emptyList();

        String sql = "SELECT lawyer_id, lawyer_name, license_number, experience_year, "
                   + "email, dob, gender, phone, address, district, province "
                   + "FROM lawyer";

        List<lawyerModel> lawyers = new ArrayList<>();
        try (PreparedStatement ps = dbConn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lawyers.add(new lawyerModel(
                    rs.getInt("lawyer_id"),
                    rs.getString("lawyer_name"),
                    rs.getInt("license_number"),
                    rs.getInt("experience_year"),
                    rs.getString("email"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("gender"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("district"),
                    rs.getString("province")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lawyers;
    }
}
