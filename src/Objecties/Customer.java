package Objecties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Customer {
	private int cid;
	private String fname;
	private String lname;
	private String email;
	private String phn;
	private String gender;
	
	public Customer() {
	    // Default constructor
	}
	public Customer(int cid,String fname,String lname,String email,String phn,String gender) {
		super();
		this.cid=cid;
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.phn=phn;
		this.gender=gender;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhn() {
		return phn;
	}
	public void setPhn(String phn) {
		this.phn = phn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void makeconnection() {
	}
	   public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/company_managemaent_system";
	    String user = "root";
	    String password = "";
	    
		// SQL query to insert data
	    String sql = "INSERT INTO Customer (First_Name,	Last_Name,	Email,	Phone_Number, Gender) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.fname);
	       preparedStatement.setString(2, this.lname);
	       preparedStatement.setString(3, this.email);
	       preparedStatement.setString(4, this.phn);
	       preparedStatement.setString(5, this.gender);
	       
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
	 
	   public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/company_managemaent_system";
	        String user = "root";
	        String password = "";
	        String sql = "SELECT * FROM Customer";
	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/company_managemaent_system";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE Customer SET First_Name=?, Last_Name=?, Email=?, Phone_Number=?, Gender=?   WHERE Customer_Id = ?";
	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getFname());
	    	  stm.setString(2, this.getLname());
	          stm.setString(3, this.getEmail());
	          stm.setString(4, this.getPhn());
	          stm.setString(5, this.getGender()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(6, inputsid);
	       
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputsid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/company_managemaent_system";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Customer WHERE  Customer_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputsid); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	}
}


