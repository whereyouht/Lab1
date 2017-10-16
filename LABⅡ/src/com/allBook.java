package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data_structure.Author;
import data_structure.BookInfo;
import db.Db;

public class allBook extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private BookInfo book = null;
	private BookInfo bookInDetail = null;
	private Author author = null;
	public ArrayList<BookInfo> bis = new ArrayList<BookInfo>();
	Db db = new Db();
	private String addFlag;
	private String bookname;
	
	public String execute() throws SQLException{
		if (addBookToSql()==false){
			return "add_author";
		}
		if (bookname!=null){
			getBookInDetailFromSql();
			getAuthorInDetailFromSql();
			return "book_detail";
		}
        getBookFromSql();
		return "success";
	}
	
	private void getAuthorInDetailFromSql() throws SQLException {
		// TODO Auto-generated method stub
		String sql= "select * from author where AuthorID="+"'"+bookInDetail.authorID+"'";
        ResultSet result = db.query(sql);
        readResultForAuthor(result);
	}

	public void readResultForAuthor(ResultSet result) throws SQLException{
		author = new Author();
		while(result.next()) {
			author.fromResult(result);
			author.show();
		 } 
	 }
	
	private void getBookInDetailFromSql() throws SQLException {
		// TODO Auto-generated method stub
		String sql= "select * from book where Title="+"'"+bookname+"'";
        ResultSet result = db.query(sql);
        readResultForBook(result);
	}

	public void readResultForBook(ResultSet result) throws SQLException{
		bookInDetail = new BookInfo();
		while(result.next()) {
			bookInDetail.fromResult(result);
			//bookInDetail.show();
		 } 
	 }
	
	
	
	
	private boolean addBookToSql() throws SQLException {
		if(addFlag!=null){
			if (authorExist(book)==true){
				
				book.codeProblemSolving();
				String sql = book.toInsertSql();
				System.out.println(sql);
				db.executeSql(sql);
				return true;
			}
			else{
				return false;
			}
		}
		return true;
	}

	private boolean authorExist(BookInfo book2) throws SQLException {
		String sql= "select * from author where AuthorID="+"'"+book.authorID+"'";
        ResultSet result = db.query(sql);
        boolean authorExistFlag=authorExist(result);
		return authorExistFlag;
	}
	
	public boolean authorExist(ResultSet result) throws SQLException{
		while(result.next()) {
			 return true;
		 } 
		return false;
	 }
	
	public void getBookFromSql() throws SQLException{
		String sql = "SELECT * FROM book";
        ResultSet result = db.query(sql);
        readResult(result);
	}
	
	public void readResult(ResultSet result) throws SQLException{
		bis = new ArrayList<BookInfo>();
		while(result.next()) {
			 BookInfo bi = new BookInfo();
			 bi.fromResult(result);
			 bis.add(bi);
		 } 
	 }
	
	public ArrayList<BookInfo> getBis(){
			return this.bis;
		}
	 
	 public void setBis(ArrayList<BookInfo> bis){
			this.bis=bis;
		}
	 
	 public BookInfo getBook(){
			return this.book;
		}
	 
	 public void setBook(BookInfo book){
			this.book=book;
		}
	 
	 public BookInfo getBookInDetail(){
			return this.bookInDetail;
		}
	 
	 public void setBookInDetail(BookInfo bookInDetail){
			this.bookInDetail=bookInDetail;
		}
	 
	 public String getAddFlag(){
			return this.addFlag;
		}
	 
	 public void setAddFlag(String addFlag){
			this.addFlag=addFlag;
		}
	 
	 public String getBookname(){
			return this.bookname;
		}
	 
	 public void setBookname(String bookname){
			this.bookname=bookname;
		}
	 public Author getAuthor(){
			return this.author;
		}
	 public void setAuthor(Author author){
			this.author=author;
		}

}


