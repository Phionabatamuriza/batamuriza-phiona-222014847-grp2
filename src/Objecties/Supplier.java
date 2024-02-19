package Objecties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Supplier {
	private int sid;
	private String pid;
	private String sname;
	private String phne;
	private String email;
	private String gender;
	
	public Supplier() {
	    // Default constructor
	}
	public Supplier(int sid,String pid,String sname,String phne,String email,String gender) {
		super();
		this.sid=sid;
		this.pid=pid;
		this.sname=sname;
		this.phne=phne;
		this.email=email;
		this.gender=gender;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhne() {
		return phne;
	}
	public void setPhne(String phne) {
		this.phne = phne;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	    String sql = "INSERT INTO Supplier (Product_Id, Supplier_Name, Supplier_Phone, Email, Gender) VALUES (?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.pid);
	       preparedStatement.setString(2, this.sname);
	       preparedStatement.setString(3, this.phne);
	       preparedStatement.setString(4, this.email);
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

		        String sql = "SELECT * FROM Supplier";

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
	    String sql = "UPDATE Supplier SET Product_Id=?, Supplier_Name=?, Supplier_Phone=?, Email=?, Gender=?   WHERE Supplier_Id= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getPid());
	    	  stm.setString(2, this.getSname());
	          stm.setString(3, this.getEmail());
	          stm.setString(4, this.getPhne());
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
	    String sql = "DELETE FROM Supplier WHERE  Supplier_Id = ?";

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

	
