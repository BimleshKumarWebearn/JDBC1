package com.jtcindia.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;

public class jtc14 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		CallableStatement cs=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		cs=con.prepareCall("{call addprocedure(?,?,?)}");
		cs.setInt(1,100);
		cs.setInt(2,200);
		cs.registerOutParameter(3,Types.INTEGER);
		cs.executeQuery();
		System.out.println("Result..."+cs.getInt(3));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		Util.cleanup(st, con);
		}
}
	}


