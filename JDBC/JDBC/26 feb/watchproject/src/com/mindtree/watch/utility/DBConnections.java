package com.mindtree.watch.utility;

import java.sql.*;

import com.mindtree.watch.exception.DAOException;

public class DBConnections {

	public static Connection conMethod() throws DAOException
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
				throw new DAOException(e.getMessage());
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignments","root","Welcome123");
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	return con;	
	}
}
