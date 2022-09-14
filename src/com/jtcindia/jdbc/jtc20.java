package com.jtcindia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class jtc20 {
	public static void main(String arg[]){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
			con=Util.getOraclConnection();	
		
	PreparedStatement pst=con.prepareStatement("insert into record values(?,?)");
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the name");
	String name=sc.next();
	System.out.println("Enter the dob(dd-MM-yyyy)");
	String dob=sc.next();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date udate=sdf.parse(dob);
	long l=udate.getTime();
	java.sql.Date sdate=new java.sql.Date(l);
    pst.setString(1,name);
	pst.setDate(2,sdate);
	int x=pst.executeUpdate();
	if(x==1) {
	System.out.println("Record inserted");
	}else {
		System.out.println("Record is not inserted");
	}
		}catch(Exception e){
			e.printStackTrace();
			}finally{		
				Util.cleanup(st, con);
			}
}
}
