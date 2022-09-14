package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jtc3 {
	public static void main(String arg[]) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "system", "bimlesh");
			String sql="select * from Bimlesh";
			st=con.createStatement();
		    ResultSet rs1=st.executeQuery(sql);
			while(rs1.next()){
			int sid=rs1.getInt(1);
			String sn=rs1.getString(2);
			String em=rs1.getString(3);
			String ph=rs1.getString(4);
			System.out.println(sid+"\t"+sn+"\t"+em+"\t"+ph);
			}
			}catch(Exception e){
			e.printStackTrace();
			}finally{
			try{
			if(st!=null) st.close();
			if(con!=null) con.close();
			if(rs!=null) rs .close();
			}catch(Exception e){
			e.printStackTrace();
			}
			}
			}
}
