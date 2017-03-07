package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Userbean;

import org.json.JSONArray;

public class registerdao
{
	Connection conn=null;
	JSONArray ja = new JSONArray();
	private  Connection  getConn()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","admin123");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public boolean register(Userbean rs)
	{
		conn=getConn();
		try
		{
		PreparedStatement prepstmt = (PreparedStatement) conn.prepareStatement("insert into userregister values(?,?,?,?,?,?,?)");
		prepstmt.setString(1, rs.getFirstName());
		prepstmt.setString(2, rs.getLastName());
		prepstmt.setString(3, rs.getEmail());
		prepstmt.setString(4, rs.getPassword());
		prepstmt.setString(5, rs.getRepassword());
		prepstmt.setString(6, rs.getConutry());
		prepstmt.setString(7, rs.getGender());
		prepstmt.executeUpdate();
		
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean delete(Userbean rs)
	{
		conn=getConn();
		try
		{
			PreparedStatement prepstmt = (PreparedStatement) conn.prepareStatement("DELETE FROM userregister WHERE firstName='"+rs.getFirstName()+"'");
			prepstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}
		
public ArrayList<Userbean> DisplayDetails()
{
	ArrayList<Userbean> al=new ArrayList<Userbean>();
	
	try
	{
	conn=getConn();
	Statement sm = conn.createStatement();
	ResultSet rt = sm.executeQuery("select * from userregister");
   Userbean bean;
	while (rt.next()) 
	{
		bean=new Userbean();
		
		bean.setFirstName(rt.getString("firstName"));
		bean.setLastName(rt.getString("lastName"));
		bean.setEmail(rt.getString("email"));
		bean.setPassword(rt.getString("password"));
		bean.setRepassword(rt.getString("repassword"));
		bean.setConutry(rt.getString("country"));
		bean.setGender(rt.getString("gender"));
		al.add(bean);
	}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return al;
}

}
