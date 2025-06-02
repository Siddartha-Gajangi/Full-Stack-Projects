package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
	public RegisterBean rb=null;
	public RegisterBean login(String uN,String pW)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bankaccount where uname=? and pwd=?");
			ps.setString(1,uN);
			ps.setString(2, pW);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				rb=new RegisterBean();
				rb.setUname(rs.getString(1));
				rb.setEmail(rs.getString(2));
				rb.setFname(rs.getString(3));
				rb.setPassword(rs.getString(4));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rb;
	}

}