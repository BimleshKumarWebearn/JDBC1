package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	public static Connection getOraclConnection() throws SQLException,
	ClassNotFoundException{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "system", "bimlesh");
	return con;
	}
	public static void cleanup(Statement st,Connection con){
		try{
		//if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(con!=null) con.close();
		}catch(Exception e){
		System.out.println(e);
		}
		}
}
 