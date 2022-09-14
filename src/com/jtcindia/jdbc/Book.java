package com.jtcindia.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Book {
	String bid;
	String bname;
	String Author;
	String publication;
	double cost;
	int edition;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bid, String bname, String author, String publication, double cost, int edition) {
		super();
		this.bid = bid;
		this.bname = bname;
		Author = author;
		this.publication = publication;
		this.cost = cost;
		this.edition = edition;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String toString(){
		return bid+"\t"+bname+"\t"+Author+"\t"+publication+"\t"+cost+"\t"+edition;
		}
	public String getNewBookId() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String bid="B-01";
		try{
			con=Util.getOraclConnection();
		ps=con.prepareStatement("select * from jtcbooks");
		rs=ps.executeQuery();
		if(rs.next()){
			bid=rs.getString(1);
			if(bid!=null){
			String id=bid.substring(2);
			int x=Integer.parseInt(id);
			x++;
			if(x<10)
				bid="B-0"+x;
			else
			bid="B-"+x;
			}else{
			bid="B-01";
			}
			}
			}catch(Exception e){
			e.printStackTrace();
			}
			return bid;
			}
}
