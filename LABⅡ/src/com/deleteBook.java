package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

import data_structure.BookInfo;
import db.Db;

public class deleteBook extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public ArrayList<BookInfo> bis = new ArrayList<BookInfo>();
	Db db = new Db();
	private String deleteISBN;
	
	public String execute() throws SQLException{
		deleteBookInSql();
        getBookFromSql();
		return "success";
	}
	
	private void deleteBookInSql() {
		if (deleteISBN != null){
			String sql="delete from book where ISBN='"+deleteISBN+"';";
			System.out.println(sql);
			db.executeSql(sql);
		}
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
	 
	 public String getDeleteISBN(){
			return this.deleteISBN;
		}
	 
	 public void setDeleteISBN(String deleteISBN){
			this.deleteISBN=deleteISBN;
		}
}


