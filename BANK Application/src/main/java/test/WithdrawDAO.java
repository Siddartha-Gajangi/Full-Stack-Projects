package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WithdrawDAO 
{
	public int k=0;
	public AccountBean ab=null;
	public int withdraw(String accno,Double amt)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select amount from accountdetails where accno=?");
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{ 	
			  double currentbal=rs.getDouble("amount");  
			 if(currentbal>=amt)
			 {
			    PreparedStatement ps1=con.prepareStatement("update accountdetails set amount=amount-? where accno=?");
				ps1.setDouble(1,amt);
				ps1.setString(2, accno);		
				k=ps1.executeUpdate();
				ab=new AccountBean();
				ab.setAccno(rs.getString(1));
				ab.setAmount(currentbal-amt);
			 }
			 else
			 {
				 k=-1;
			 }
		    }	
			else
			{
				k=-2;
			}
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
	}

}
