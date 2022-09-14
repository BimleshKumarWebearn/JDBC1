package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class jtc22 {
	public static void main(String[]args) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con=Util.getOraclConnection();
		ps = con.prepareStatement("insert into jtcstudent values(?,?,?)");
		for (int i = 1; i <= 10; i++) {
		int id = 500 + i;
		String name = "Sun" + i;
		String email = "Sun" + i + "@jtc.org";
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.addBatch();
		}
		int res[] = ps.executeBatch();
		for (int i=0; i<res.length; i++) {
		System.out.println("Res :" + res[i]);
		}
	}catch(Exception e){
		e.printStackTrace();
		}finally{		
			Util.cleanup(ps, con);
		}}}

