package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.Statement;
public class jtc4 {
	public static void main(String ar[]){
		Connection con=null;
		Statement st=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		String qry="insert into Bimlesh values(77,'Jacob','som@jtc.co','9990399111')";
		String qry1="insert into Bimlesh values(78,'Jacob','som@jtc.co','9990399111')";
		String qry2="update Bimlesh set name='Bimlesh' where sid=78";
		String qry3="delete from Bimlesh where sid=99";
		st=con.createStatement();
		st.addBatch(qry);
		st.addBatch(qry1);
		st.addBatch(qry2);
		st.addBatch(qry3);
		int x[]=st.executeBatch();
		if(x!=null){
		System.out.println("Record inserted");
		}else{
		System.out.println("Record Not Inserted");
		}
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		 Util.cleanup( st, con);
		}
	}

}
