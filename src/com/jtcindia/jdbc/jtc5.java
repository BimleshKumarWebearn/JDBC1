package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class jtc5 {
	public static void main(String ar[]){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		String qry="select * from Bimlesh";
		st=con.createStatement();
		rs=st.executeQuery(qry);
		if(rs.next()){do{
		int id=rs.getInt(1);
		String name=rs.getString(2);
		String email=rs.getString(3);
		String phone=rs.getString(4);
		System.out.println(id+"\t"+name+"\t"+email+"\t"+phone);
	    } while(rs.next());
		}else
		System.out.println("Record Not Fetchd");
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		Util.cleanup(st, con);
		}}

}
