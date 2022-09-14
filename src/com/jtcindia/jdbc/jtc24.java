package com.jtcindia.jdbc;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class jtc24 {
	public static void main(String arg[]){
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		RowSetFactory rsf=RowSetProvider.newFactory();
		JdbcRowSet jrs=rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:oracle:thin:@localhost:1522:orcl");
		jrs.setUsername("system");
		jrs.setPassword("bimlesh");
		 Connection con=Util.getOraclConnection();
		// RowSet jrs=new JdbcRowSetImpl();
		jrs.setCommand("select id,name,email from jtcstudents");
		jrs.execute();
		while(jrs.next()){
			System.out.println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3));
			}
			jrs.absolute(2);
			jrs.updateString(2,"Sompraksh");
			jrs.updateString(3,"Sompraksh@jtc");
			jrs.updateRow();
			System.out.println("Updated");
			jrs.beforeFirst();
			System.out.println("Serializing JdbcRowSet");
			FileOutputStream fos=new FileOutputStream("D:\\rowset.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(jrs);
			System.out.println("Serialized");
			}catch(Exception e){
			e.printStackTrace();
			}
			}
}
