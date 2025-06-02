package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepositDAO 
{
	int k=0;
	AccountBean ab=null;
	public int deposit(String accno,double amt)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement("select * from accountdetails");
			PreparedStatement ps=con.prepareStatement("update accountdetails set amount=amount+? where accno=?");
			ps.setDouble(1,amt);
			ps.setString(2, accno);
			
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{ 
			 String acno=rs.getString(1);
			 if(accno.equals(acno))
			 {
				k=ps.executeUpdate();
				ab=new AccountBean();
				ab.setAccno(rs.getString(1));
				ab.setAmount(rs.getDouble(4));

			 }
		    }	 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}