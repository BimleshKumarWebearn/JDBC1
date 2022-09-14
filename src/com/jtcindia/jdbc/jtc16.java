package com.jtcindia.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import oracle.jdbc.*;

public class jtc16 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		CallableStatement cs=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		cs=con.prepareCall("{call getAllEmployeeInfo(?)}");
		cs.registerOutParameter(1,OracleTypes.CURSOR);
		cs.execute();
		ResultSet rs=(ResultSet)cs.getObject(1);
		boolean flag=false;
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("--------------------------");
		while(rs.next()) {
			flag=true;
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		if(flag==false) {
			System.out.println("No Records Available");
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		Util.cleanup(st, con);
		}
	}
}
