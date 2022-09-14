package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
public class jtc6 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		try{
		//con=JdbcUtil.getMySQLConnection();
		con=Util.getOraclConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		int sid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name");
		String name=sc.nextLine();
		System.out.println("Enter Email:");
		String email=sc.nextLine();
		System.out.println("Enter Phone:");
		String phone=sc.nextLine();
		String qry=String.format("insert into students values(%d,'%s','%s','%s')",sid,name,email,phone);
		System.out.println(qry);    
		st=con.createStatement();
		int x=st.executeUpdate(qry);
		if(x==1){
		System.out.println("Record inserted succesfully");
		}else{
		System.out.println("not inserted");
		}
		}catch(Exception e){
		e.printStackTrace();
		}finally{
		Util.cleanup(st, con); 
		}
		}
}