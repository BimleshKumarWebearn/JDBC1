package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class jtc7 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		try{
		// con=JdbcUtil.getMySQLConnection();
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
		String qry=String.format("select * from bimlesh",id,name,email,phone);
		System.out.println(qry);
		st=con.createStatement();
		ResultSet rs=st.executeQuery(qry);
		if(rs.next()){
		int id1=rs.getInt(1);
		String name1=rs.getString(2);
		String email1=rs.getString(3);
		String phone1=rs.getString(4);
		System.out.println(id1+"\t"+name1+"\t"+email1+"\t"+phone1);
		}else{
			System.out.println("sorry,student not found");
		}
		}catch(Exception e){
		e.printStackTrace();
		}finally{
			Util.cleanup(st, con);
		}
		}
		}

