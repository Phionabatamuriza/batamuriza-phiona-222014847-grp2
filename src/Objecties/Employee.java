package Objecties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Employee {
	private int empid;
	private String depid;
	private String fname;
	private String lname;
	private String email;
	private String position;
	private String gender;
	
	
	public Employee() {
	    // Default constructor
	}
	public Employee(int empid,String depid,String fname,String lname,String email,String position,String gender) {
		super();
		this.empid=empid;
		this.depid=depid;
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.position=position;
		this.gender=gender;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getDepid() {
		return depid;
	}
	public void setDepid(String depid) {
		this.depid = depid;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	    String sql = "INSERT INTO Employee (Department_Id, First_Name,	Last_Name,	Email, Position, Gender) VALUES (?,?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.depid);
	       preparedStatement.setString(2, this.fname);
	       preparedStatement.setString(3, this.lname);
	       preparedStatement.setString(4, this.email);
	       preparedStatement.setString(5, this.position);
	       preparedStatement.setString(6, this.gender);
	
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

		        String sql = "SELECT * FROM Employee";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
	public void update(int inputempid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/company_managemaent_system";
	    String user = "root";
	    String password = "";
	    
          // SQL query to update data
	    String sql = "UPDATE Employee SET Department_Id=?, First_Name=? , Last_Name=?, Email=?, Position=?, Gender=?   WHERE Employee_Id = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	  stm.setString(1, this.getDepid());
	    	  stm.setString(2, this.getFname());
	    	  stm.setString(3, this.getLname());
	          stm.setString(4, this.getEmail());
	          stm.setString(5, this.getPosition());
	          stm.setString(6, this.getGender()); // Assuming there is a column named 'id' for the WHERE clause
	       
	          stm.setInt(7, inputempid);
	       
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
	public void delete(int inputempid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/company_managemaent_system";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM Employee WHERE  Employee_Id = ?";

	    try (
	        // Establish the 
	        Connection con= DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputempid); // Assuming there is a column named 'id' for the WHERE clause

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
