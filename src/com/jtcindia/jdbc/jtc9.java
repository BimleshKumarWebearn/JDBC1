      package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class jtc9 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
		
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name");
		String name=sc.nextLine();
		System.out.println("Enter Email:");
		String email=sc.nextLine();
		System.out.println("Enter Phone:");
		String phone=sc.nextLine();
		String qry1=String.format("insert into Bimlesh values(?,?,?,?)");
		System.out.println(qry1);
		ps=con.prepareStatement(qry1);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setString(3,email);
		ps.setString(4,phone);
		int x=ps.executeUpdate();
		if(x==1){
			System.out.println("Record inserted succesfully");
			}else{
			System.out.println("not inserted");
			}
			/*String qry3=sc.nextLine();
			ps=con.prepareStatement(qry3);
			boolean b1=ps.execute();
			if(b1){
			rs=ps.getResultSet();
			if(rs.next()){
			do{
			int id1=rs.getInt(1);
			String name1=rs.getString(2);
			String email1=rs.getString(3);
			String phone1=rs.getString(4);
			System.out.println(id1+"\t"+name1+"\t"+email1+"\t"+phone1);
			}while(rs.next());
			} }
			else{
			int x1=ps.getUpdateCount();
			System.out.println("Result:"+x1);
			}*/
			}catch(Exception e){
			e.printStackTrace();
			}finally{		
				Util.cleanup(st, con);
			}
}
}
