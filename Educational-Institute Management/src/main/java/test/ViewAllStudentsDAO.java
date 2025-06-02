package test;
import java.util.*;
import java.sql.*;
public class ViewAllStudentsDAO 
{
    public ArrayList<StudentBean> al = new ArrayList<StudentBean>();
    public ArrayList<StudentBean> retrieve()
    {
    	try {
    		Connection con = DBConnection.getCon();//Accessing Connection Object
    		PreparedStatement ps1 = con.prepareStatement
    				("select * from Student71");
    		PreparedStatement ps2 = con.prepareStatement
    				("Select * from Marks71");
    		ResultSet rs1 = ps1.executeQuery();
    		ResultSet rs2 = ps2.executeQuery();
    		while(rs1.next() && rs2.next())
    		{
    			StudentBean sb = new StudentBean();//Bean Object
    			sb.setRollNo(rs1.getString(1));
    			sb.setName(rs1.getString(2));
    			sb.setCourse(rs1.getString(3));
    			sb.setTotMarks(rs1.getInt(4));
    			sb.setPer(rs1.getFloat(5));
    			sb.setResult(rs1.getString(6));
    			sb.getMk().setCoreJava(rs2.getInt(2));
    			sb.getMk().setAdvJava(rs2.getInt(3));
    			sb.getMk().setUi(rs2.getInt(4));
    			sb.getMk().setDb(rs2.getInt(5));
    			sb.getMk().setTools(rs2.getInt(6));
    			al.add(sb);
    		}//end of loop
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return al;
    }
}
