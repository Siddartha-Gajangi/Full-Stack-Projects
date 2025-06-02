package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceDAO 
{
	public AccountBean ab=null;
	public AccountBean retrieveBal(String accno)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from accountdetails where accno=?");
			ps.setString(1, accno);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				ab=new AccountBean();
				ab.setAccno(rs.getString(1));
				ab.setIfsc(rs.getString(2));
				ab.setBranch(rs.getString(3));
				ab.setAmount(rs.getDouble(4));
			}		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ab;
	}

}