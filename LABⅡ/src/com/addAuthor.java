package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import data_structure.Author;
import db.Db;

public class addAuthor extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Author authorAdd = new Author();
	Db db = new Db();
	private String addFlag = null;
	private ArrayList<Author> authors = new ArrayList<Author>();
	
	public String execute() throws SQLException{
		addAuthorToSql();
        getAuthorsFromSql();
		return "success";
	}
	
	private void addAuthorToSql() throws SQLException {
		if(addFlag!=null){
			authorAdd.codeProblemSolving();
			String sql = authorAdd.toInsertSql();
//			System.out.println(sql);
			db.executeSql(sql);
		}
	}
	
	public void getAuthorsFromSql() throws SQLException{
		String sql = "SELECT * FROM author";
        ResultSet result = db.query(sql);
        readResult(result);
	}
	
	public void readResult(ResultSet result) throws SQLException{
		authors = new ArrayList<Author>();
		while(result.next()) {
			 Author au = new Author();
			 au.fromResult(result);
			 authors.add(au);
		 } 
	 }
	
	public ArrayList<Author> getAuthors(){
			return this.authors;
		}
	 
	 public void setBis(ArrayList<Author> authors){
			this.authors=authors;
		}
	 
	 public Author getAuthorAdd(){
			return this.authorAdd;
		}
	 
	 public void setAuthorAdd(Author authorAdd){
			this.authorAdd=authorAdd;
		}
	 
	 public String getAddFlag(){
			return this.addFlag;
		}
	 
	 public void setAddFlag(String addFlag){
			this.addFlag=addFlag;
		}
	 
}


