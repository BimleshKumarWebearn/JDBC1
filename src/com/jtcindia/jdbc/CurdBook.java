package com.jtcindia.jdbc;

import java.util.List;

public class CurdBook {
	public static void main(String ar[]){
			BookService bs=new BookService();
			//Verify User
			boolean valid=bs.verifyUser("som","jtcindia");
			if(valid){
			System.out.println("Login Success !Redirecting to home page");
			}else{
			System.out.println("Login Success ! try Again");
			}
			//Adding the book
			Book b=new Book("1","Java","som","JTC",250.0,4);
			boolean res=bs.addBook(b);
			if(res){
			System.out.println("Book added successfully");
			}else{
			System.out.println("Error while adding book info");
			}
			//update Book
			Book bk=new Book("2","Jdbc","Sompraksh","Sp",250,5);
			bk.setBid("B-02");
			int a=bs.updateBook(bk);
			System.out.println("Book update:"+a);
			//Delete book
			int c=bs.deleteBook("B-01");
			System.out.println("Book Deleted:"+c);
			//Accessing Book By Bid
			System.out.println("**Book By Bid");
			Book bo=bs.getBookByBid("B-01");
			System.out.println(bo);
			//Accessing Book By Bname
			System.out.println("**Book By Bname");
			List<Book>list=bs.getBooksByBname("java");
			for(Book b1:list){
			System.out.println(b1);
			}
			//Accessing Book by Author
			System.out.println("**Book By Author");
			List<Book>list1=bs.getBooksByAuthor("som");
			for(Book b1:list1){
				System.out.println(b1);
				}
				//Accessing Book By cost
				System.out.println("Book By Cost");
				List<Book>list2=bs.getBooksByCost(250);
				for(Book b1:list2){
				System.out.println(b1);
				}
				//Accessing All Books
				System.out.println("All Books");
				List<Book> list3=bs.getAllBooks();
				for(Book b1:list3){
				System.out.println(b1);
				}
				}
}

