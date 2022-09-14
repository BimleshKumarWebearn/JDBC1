package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class jtc8 {
	public static void main(String ar[]){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
		con=Util.getOraclConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Query:");
		String qry=sc.nextLine();
		st=con.createStatement();
		boolean b1=st.execute(qry);
		if(b1){
		rs=st.getResultSet();
		if(rs.next()){
		do{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String email=rs.getString(3);
			String phone=rs.getString(4);
			System.out.println(id+"\t"+name+"\t"+email+"\t"+phone);
			}while(rs.next());
			}
			}else{
			int x=st.getUpdateCount();
			System.out.println("Result:"+x);
			}
			}catch(Exception e){
			e.printStackTrace();
			}finally{
			
			}
			}
		}

