package com;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data_structure.BookInfo;
import db.Db;

public class book_search extends ActionSupport{

	private static final long serialVersionUID = 1L;
	Db db = new Db();
	public String searchFlag = null;
	public ArrayList<String> books = new ArrayList<String>();
	private String author_search = null;
    ArrayList<BookInfo> bis =  new ArrayList<BookInfo>();
    
	public String execute() throws SQLException{
		System.out.println("author_search:"+author_search);
		if(author_search!=null){
			getBooksFromSql();
			System.out.println("size:"+bis.size());
			System.out.println(author_search);
			//bis.get(0).show();
			return "result";
		}
		return "no_result";
	}
	
	public void getBooksFromSql() throws SQLException{
		if (author_search != null){
			//author_search =new String(author_search.getBytes("ISO-8859-1"),"UTF-8");
			String sql = "SELECT * FROM author where Name="+"'"+author_search+"'";
			ArrayList<String> authorIDs = getAuthorIDs(sql);
			for(int i=0;i<authorIDs.size();i++){
				sql = "SELECT * FROM book where AuthorID="+"'"+authorIDs.get(i)+"'";
				bis.addAll(getBooks(sql));
			}
		}
	}
	
	public ArrayList<String> getAuthorIDs(String sql) throws SQLException{
		ResultSet result = db.query(sql);
		ArrayList<String> authorIDs = new ArrayList<String>();
		while(result.next()) {
			
			 String authorID=result.getString(1);
			 authorIDs.add(authorID);
		} 
		return authorIDs;
	 }
	
	public ArrayList<BookInfo> getBooks(String sql) throws SQLException{
		ResultSet result = db.query(sql);
		ArrayList<BookInfo>  bis = new ArrayList<BookInfo>();
		while(result.next()) {
			BookInfo bi = new BookInfo();
			bi.fromResult(result);
			bis.add(bi);
		} 
		return bis;
	 }

	public void setSearchFlag(String searchFlag){
		this.searchFlag=searchFlag;
	}
	
	public String getSearchFlag(){
		return this.searchFlag;
	}
	
	public void setAuthor_search(String author_search){
		this.author_search=author_search;
	}
	
	public String getAuthor_search(){
		return this.author_search;
	}
	
	public ArrayList<BookInfo> getBis(){
		return this.bis;
	}
 
	public void setBis(ArrayList<BookInfo> bis){
		this.bis=bis;
	}
	
}


