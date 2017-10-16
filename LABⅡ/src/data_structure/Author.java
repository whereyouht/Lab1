package data_structure;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Author{

	public String authorID="";
	public String name = "";
	public String age = "";
	public String country = "";

	public Author(){}
	
	public void fromResult(ResultSet result) throws SQLException{
		
    	authorID=result.getString(1);
    	name=result.getString(2);
    	age=result.getString(3);
    	country=result.getString(4);
	}
	
	public String toInsertSql()
	{
		 String sql= "INSERT INTO author VALUES";
		 sql+="(";
		 sql+="'"+authorID+"',";
		 sql+="'"+name+"',";
		 sql+="'"+age+"',";
		 sql+="'"+country+"'";
		 sql+=");";		
		 return sql;
	}
	
	public void setAuthorID( String authorID){
		this.authorID=authorID;
	}
	public String getAuthorID(){
		return this.authorID;
	}
	public void setName( String name){
		this.name=name;
	}
	public String getName( String name){
		return this.name;
	}
	public void setAge( String age){
		this.age=age;
	}
	public String getAge( String age){
		return this.age;
	}

	public void setCountry( String country){
		this.country=country;
	}
	public String getCountry( String country){
		return this.country;
	}

	public void codeProblemSolving() {
		//TODO Auto-generated method stub
		try {
			name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
			authorID=new String(authorID.getBytes("ISO-8859-1"),"UTF-8");
			age=new String(age.getBytes("ISO-8859-1"),"UTF-8");
			country=new String(country.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void show() {
		// TODO Auto-generated method stub
		System.out.println("name:"+name);
		System.out.println("AuthorID:"+authorID);
		System.out.println("Age:"+age);
		System.out.println("Country:"+country);
	}
	
	
}
