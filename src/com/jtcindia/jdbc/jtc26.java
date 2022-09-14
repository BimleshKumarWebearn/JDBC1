package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class jtc26 {
	public static void main(String arg[])throws Exception {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "bimlesh");
			String sql="select * from ";
			st=con.createStatement();
		    ResultSet rs1=st.executeQuery(sql);
		    RowSetFactory rsf=RowSetProvider.newFactory();
		    CachedRowSet crs=rsf.createCachedRowSet();
		    crs.populate(rs1);
		    con.close();
		    System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("------------------------------------");
			while(crs.next()) {
				System.out.println(crs.getInt(1)+"\t"+crs.getString(2)+"\t"+crs.getFloat(3)+"\t"+crs.getString(4));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
	
