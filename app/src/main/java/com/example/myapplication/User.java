package com.example.myapplication;


import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class User extends AppCompatActivity
{
	public ResultSet myRs;
	private String firstName, lastName, address, password, email, userName;
	private int userID;

	Connection myConn;
	String DBurl = "jdbc:mysql://localhost:3306/people";
	String DBusername = "skirk";
	String DBpwd = "43268790";
	String DBip = "127.0.0.1";
	String DBschema = "people";
	String retrieve = "";


	//the method below will return all
		protected ResultSet getEmployee(String filter)
		{
		String stmt = "select * from employees cross join people on employees.employeeID = " +
				"people.userID where(" + filter + ")";

		try
		{
			myConn = DriverManager.getConnection(DBurl, DBusername, DBpwd);
			Statement myStmt = myConn.createStatement();
			 this.myRs = myStmt.executeQuery(stmt);
		}

		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return myRs;
		}




	public User ()
    {

	}

	public void sendToSQL()
	{
	    try
	    {
	    	myConn = DriverManager.getConnection(DBurl, DBusername, DBpwd);
		    Statement myStmt = myConn.createStatement();

		    String sql = "INSERT INTO `people`.`people` (`userID`, `FirstName`, `LastName`, `Address`, `password`, `email`, `userName`) "
				+ "VALUES ('"+ this.userID + "', '" + this.firstName +
				"', '"+ this.lastName +"', '"+ this.address + "', " +
				"'"+ this.password + "', '"+ this.email + "', '"+ this.userName +"')";

		    myStmt.executeUpdate(sql);
	    }
	    catch (SQLException e)
	    {
                e.printStackTrace();
        }

	}

	public void getUserInput()
	{
	//from old setName method
	{TextView nameField = findViewById(R.id.username);
	String temp = nameField.getText().toString();
	this.firstName = temp.split(" ")[0];
	this.lastName = temp.split(" ")[1];}

	//from old getPassword method
	{String passOne;
	String passTwo;
	TextView passwordField = findViewById(R.id.password_one);
	TextView passwordFieldTwo = findViewById(R.id.password_two);

	passOne = passwordField.getText().toString();
	passTwo = passwordFieldTwo.getText().toString();

	if (passOne.equals(passTwo))
	{
		password = passOne;
	}
	else
	{
		passwordField.setText("Passwords do not match");
	}}

	//from old getEmail method
	{TextView emailField = findViewById(R.id.user_email);
	email = emailField.getText().toString();}
	}
}
