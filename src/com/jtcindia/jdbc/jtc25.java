package com.jtcindia.jdbc;

import java.sql.Connection;

import javax.sql.rowset.*;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class jtc25 {
	public static void main(String arg[])throws Exception{
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		jrs.setUrl("jdbc:oracle:thin:@localhost:1522:orcl");
		jrs.setUsername("system");
		jrs.setPassword("bimlesh");
		// Connection con=Util.getOraclConnection();
		jrs.setCommand("select * from employees");
		jrs.execute();
		System.out.println("Employess Details in Forward direction");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------------");
		while(jrs.next()) {
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getString(4));
		}
		System.out.println("Employees Details in Backward Direction");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------------------------");
		while(jrs.previous()) {
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getString(4));
			}
		System.out.println("Accessing Randomly.........");
	     jrs.absolute(3);
	     System.out.println(jrs.getRow()+"------->"+jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getString(4));
	     jrs.first();
	     System.out.println(jrs.getRow()+"------->"+jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getString(4));
	     jrs.last();
	     System.out.println(jrs.getRow()+"------->"+jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getString(4));
	     jrs.close();
		
}
}

