package data_structure;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInfo{

	public String isBN = "";
	public String title = "";
	public String authorID="";
	public String publisher="";
	public String publishDate="";
	public String price="";

	public BookInfo(){}
	
	public void fromResult(ResultSet result) throws SQLException{
		
    	isBN=result.getString(1);
    	title=result.getString(2);
    	authorID=result.getString(3);
    	publisher=result.getString(4);
    	publishDate=result.getString(5);
    	price=result.getString(6);
	}
	
	public String toInsertSql()
	{
		 String sql= "INSERT INTO book VALUES";
		 sql+="(";
		 sql+="'"+isBN+"',";
		 sql+="'"+title+"',";
		 sql+="'"+authorID+"',";
		 sql+="'"+publisher+"',";
		 sql+="'"+publishDate+"',";
		 sql+="'"+price+"'";
		 sql+=");";		
		 return sql;
	}
	
	public void show(){
    	System.out.println("ISBN:" + isBN);
    	System.out.println("Title:" + title);
    	System.out.println("AuthorID:" + authorID);
    	System.out.println("Publisher:" + publisher);
    	System.out.println("PublishDate:" + publishDate);
    	System.out.println("Price:" + price);
	 }
	
	public void setIsBN( String isBN){
		this.isBN=isBN;
	}
	public void setTitle( String title){
		this.title=title;
	}
	public void setAuthorID( String authorID){
		this.authorID=authorID;
	}
	public void setPublisher( String publisher){
		this.publisher=publisher;
	}
	public void setPublishDate( String publishDate){
		this.publishDate=publishDate;
	}
	public void setPrice( String price){
		this.price=price;
	}
	
	public String getIsBN(){
		return this.isBN;
	}
	public String getTitle(){
		return this.title;
	}
	public String getAuthorID(){
		return this.authorID;
	}
	public String getPublisher(){
		return this.publisher;
	}
	public String getPublishDate(){
		return this.publishDate;
	}
	public String getPrice(){
		return this.price;
	}

	public void codeProblemSolving() {
//		// TODO Auto-generated method stub
		try {
			title=new String(title.getBytes("ISO-8859-1"),"UTF-8");
			isBN=new String(isBN.getBytes("ISO-8859-1"),"UTF-8");
			authorID=new String(authorID.getBytes("ISO-8859-1"),"UTF-8");
			publisher=new String(publisher.getBytes("ISO-8859-1"),"UTF-8");
			publishDate=new String(publishDate.getBytes("ISO-8859-1"),"UTF-8");
			price=new String(price.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
