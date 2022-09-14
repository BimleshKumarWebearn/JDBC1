package com.jtcindia.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;

public class jtc18 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		CallableStatement cs=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		cs=con.prepareCall("{?=call getAvg(?,?)}");
		cs.setInt(2,100);
		cs.setInt(3,200);
		cs.registerOutParameter(1,Types.FLOAT);
		cs.execute();
		System.out.println("Average salary..."+cs.getFloat(1));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		Util.cleanup(st, con);
		}
}
}
