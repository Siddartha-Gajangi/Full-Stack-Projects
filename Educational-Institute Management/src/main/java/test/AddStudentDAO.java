package test;
import java.sql.*;
public class AddStudentDAO
{
    public int k = 0;
    public int insert(StudentBean sb)
    {
    	try {
    		Connection con = DBConnection.getCon();//Accessing Connection Object_ref
    		PreparedStatement ps1 = con.prepareStatement
    				("insert into Student71 values(?,?,?,?,?,?)");
    		PreparedStatement ps2 = con.prepareStatement
    				("insert into Marks71 values(?,?,?,?,?,?)");
    		ps1.setString(1, sb.getRollNo());
    		ps1.setString(2, sb.getName());
    		ps1.setString(3, sb.getCourse());
    		ps1.setInt(4, sb.getTotMarks());
    		ps1.setFloat(5, sb.getPer());
    		ps1.setString(6, sb.getResult());
    		int p = ps1.executeUpdate();
    		if(p>0) {
    			ps2.setString(1, sb.getRollNo());
    			ps2.setInt(2, sb.getMk().getCoreJava());
    			ps2.setInt(3, sb.getMk().getAdvJava());
    			ps2.setInt(4, sb.getMk().getUi());
    			ps2.setInt(5, sb.getMk().getDb());
    			ps2.setInt(6, sb.getMk().getTools());
    			k = ps2.executeUpdate();
    		}//end of if
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return k;
    }
}
