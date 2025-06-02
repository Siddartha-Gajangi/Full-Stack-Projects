package test;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransferMoneyDAO 
{
	
	public TransferMoneyBean tb=null;
	public TransferMoneyBean transferMoney(String saccno,String raccno,Double amt)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from accountdetails where accno=?");
			ps.setString(1,saccno);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				double amount=rs.getDouble(4);
			   if(amount<amt)
			   {
				return null;
			   }
			  else
			  {
				PreparedStatement ps1=con.prepareStatement("update accountdetails set amount=amount-? where accno=?");
				ps1.setDouble(1, amt);
				ps1.setString(2, saccno);
				ps1.executeUpdate();
				
				PreparedStatement ps2=con.prepareStatement("update accountdetails set amount=amount+? where accno=?");
				ps2.setDouble(1, amt);
				ps2.setString(2, raccno);
				ps2.executeUpdate();
				
				tb=new TransferMoneyBean();
				tb.setSenderaccount(saccno);
				tb.setReceiveraccount(raccno);
				tb.setAmount(amt);	
			  }
			}
			else
			{
				System.out.println("Sender account doesn't exist");	
            }			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return tb;	
	}
}
