  package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jtc1 {
	public static void main(String arg[]) {
		Connection con=null;
		Statement st=null;
		try {  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "system", "bimlesh");
			String sql = "insert into Bimlesh values(01,'som','som@jtc.co','7019586907')";
			String sql1 = "insert into Bimlesh values(02,'sonu','som@jtc.co','7019586907')";
			st = con.createStatement();
			int x=st.executeUpdate(sql);
			int x1=st.executeUpdate(sql1);
			if(x==1) {
			
			if(x1==1) {
				System.out.println("Record inserted");
		
			}}else {
				System.out.println("Record Not Inserted");
				
			}
		}catch(Exception e) {
		System.out.println(e);
	}finally {
		try {
			if(st!=null) {
				st.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch(Exception e) {
				System.out.println(e);
			}
				
		}
	}
 
		
	
}



