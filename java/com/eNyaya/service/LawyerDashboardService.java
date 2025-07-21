package com.eNyaya.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eNyaya.config.DbConfig;
import com.eNyaya.model.AppointmentModel;



public class LawyerDashboardService {
	private Connection dbConn;

	/**
	 * Constructor initializes the database connection.
	 */
	public LawyerDashboardService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

    public int getTotalAppointment(int lawyerID) {
    	String query = "SELECT COUNT(*) FROM client_lawyer_appointment WHERE lawyerID = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, lawyerID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getOngoingAppointment(int lawyerID) {
    	String query = "SELECT COUNT(*) FROM Appointment a " +
                "JOIN client_lawyer_appointment acl ON a.AppointmentID = acl.AppointmentID " +
                "WHERE acl.lawyerID = ? AND a.Status = 'Ongoing'";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, lawyerID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTodayAppointments(int lawyerID) {
    	String query = "SELECT COUNT(*) FROM Appointment a " +
                "JOIN client_lawyer_appointment acl ON a.AppointmentID = acl.AppointmentID " +
                "WHERE acl.lawyerID = ? AND a.Appointment_Date = CURDATE()";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, lawyerID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private AppointmentModel mapToAppointmentModel(ResultSet rs) throws SQLException {
        AppointmentModel model = new AppointmentModel();
        model.setAppointmentID(rs.getInt("AppointmentID")); 
        model.setClientID(rs.getInt("clientID"));
        model.setClientName(rs.getString("clientName"));
        model.setAppointmentDate(rs.getDate("Appointment_Date").toLocalDate());
        model.setStartTime(rs.getTime("Start_Time").toLocalTime());
        model.setEndTime(rs.getTime("End_Time").toLocalTime());
        model.setMode(rs.getString("Mode"));
        model.setStatus(rs.getString("Status"));
        return model;
    }

    public List<AppointmentModel> getTodayAppointmentsList(int lawyerID) {
        List<AppointmentModel> list = new ArrayList<>();
        String query = "SELECT ap.AppointmentID, ap.Appointment_Date, ap.Start_Time, ap.End_Time, ap.Mode, ap.Status, c.clientID, c.clientName " +
                       "FROM Appointment ap " +
                       "JOIN client_lawyer_appointment a ON ap.AppointmentID = a.AppointmentID " +
                       "JOIN Client c ON a.clientID = c.clientID " +
                       "WHERE a.lawyerID = ? AND ap.Appointment_Date = CURDATE()";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, lawyerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(mapToAppointmentModel(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<AppointmentModel> getOngoingAppointmentList(int lawyerID) {
        List<AppointmentModel> list = new ArrayList<>();
        String query = "SELECT ap.AppointmentID, ap.Appointment_Date, ap.Start_Time, ap.End_Time, ap.Mode, ap.Status, c.clientID, c.clientName " +
                       "FROM Appointment ap " +
                       "JOIN client_lawyer_appointment a ON ap.AppointmentID = a.AppointmentID " +
                       "JOIN Client c ON a.clientID = c.clientID " +
                       "WHERE a.lawyerID = ? AND ap.Status = 'Ongoing'";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, lawyerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(mapToAppointmentModel(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<AppointmentModel> getUpcomingAppointmentList(int lawyerID) {
        List<AppointmentModel> list = new ArrayList<>();
        String query = "SELECT ap.AppointmentID, ap.Appointment_Date, ap.Start_Time, ap.End_Time, ap.Mode, ap.Status, c.clientID, c.clientName " +
                       "FROM Appointment ap " +
                       "JOIN client_lawyer_appointment a ON ap.AppointmentID = a.AppointmentID " +
                       "JOIN Client c ON a.clientID = c.clientID " +
                       "WHERE a.lawyerID = ? AND ap.Appointment_Date > CURDATE() " +
                       "ORDER BY ap.Appointment_Date ASC";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, lawyerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(mapToAppointmentModel(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}