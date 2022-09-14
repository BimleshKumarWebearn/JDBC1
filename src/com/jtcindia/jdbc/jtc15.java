package com.jtcindia.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;

public class jtc15 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		CallableStatement cs=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		cs=con.prepareCall("{call getEmpInfo(?,?,?)}");
		cs.setInt(1,100);
		cs.registerOutParameter(2,Types.VARCHAR);
		cs.registerOutParameter(3,Types.FLOAT);
		cs.execute();
		System.out.println("Employee Name :"+cs.getString(2));
		System.out.println("Employee salary :"+cs.getFloat(3));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		Util.cleanup(st, con);
		}
}
}
