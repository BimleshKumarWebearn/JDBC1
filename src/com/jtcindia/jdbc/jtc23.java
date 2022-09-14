package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class jtc23 {
	public static void main(String arg[]) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con=Util.getOraclConnection();
		st =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs =st.executeQuery("select * from Student");
		System.out.println("**FORWORD DIRECTION**");
		while (rs.next()) {
		System.out.println(rs.getInt(1) + "\t" +rs.getString(2) + "\t"+ rs.getString(3) + "\t" +rs.getString(4));
		System.out.println("**REVERSE DIRECTION**");
				while(rs.previous()) {
				System.out.println(rs.getInt(1) + "\t" +rs.getString(2)+ "\t" + rs.getString(3) + "\t" +rs.getString(4));
				System.out.println("1st record**");
				rs.first();
				System.out.println(rs.getInt(1) + "\t" +rs.getString(2) + "\t"+rs.getString(3) + "\t" + rs.getString(4));
				}
				System.out.println("**4th Record**");
				rs.absolute(4);
				System.out.println(rs.getInt(1) + "\t" +rs.getString(2) + "\t"+rs.getString(3) + "\t" + rs.getString(4));
				System.out.println("**From 4th next 2ndRecord**");
				rs.relative(2);
				System.out.println(rs.getInt(1) + "\t" +rs.getString(2) + "\t"+rs.getString(3) + "\t" + rs.getString(4));
		}
		}catch(Exception e){
			e.printStackTrace();
			}finally{		
				Util.cleanup(st, con);
			}
}
}
