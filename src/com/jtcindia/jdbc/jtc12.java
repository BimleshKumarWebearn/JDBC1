package com.jtcindia.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
public class jtc12 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		CallableStatement cs=null;
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
		cs=con.prepareCall("insert into students values(?,?,?,?)");
		cs.setInt(1,id);
		cs.setString(2,name);
		cs.setString(3,email);
		cs.setString(4,phone);
		boolean b=cs.execute();
		if(b=true) {
		System.out.println("Record inserted succesfully");	
		}else {
		System.out.println("not inserted");
		}
		}catch(Exception e){
			e.printStackTrace();
			}finally{
			Util.cleanup(st, con);
			}
			}
}
