package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class jtc21 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
			con=Util.getOraclConnection();	
		
	PreparedStatement pst=con.prepareStatement("select * from record");
	rs=pst.executeQuery();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	while(rs.next()) {
		 String name=rs.getString(1);
		 java.sql.Date sdate=rs.getDate(2);
		 String s=sdf.format(sdate);
		 System.out.println(name+"...."+s);
	}
		}catch(Exception e){
			e.printStackTrace();
			}finally{		
				Util.cleanup(st, con);
			}
}
}
