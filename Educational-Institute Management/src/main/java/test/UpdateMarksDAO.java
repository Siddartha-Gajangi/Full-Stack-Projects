package test;
import java.sql.*;
public class UpdateMarksDAO {
    public int k=0;
    public int update(StudentBean sb) {
    	try {
    		Connection con = DBConnection.getCon();
    		PreparedStatement ps = con.prepareStatement
    	   ("update Marks71 set CoreJava=?,AdvJava=?,ui=?,db=?,tools=? where rollno=?");
    		ps.setInt(1, sb.getMk().getCoreJava());
    		ps.setInt(2, sb.getMk().getAdvJava());
    		ps.setInt(3, sb.getMk().getUi());
    		ps.setInt(4, sb.getMk().getDb());
    		ps.setInt(5, sb.getMk().getTools());
    		ps.setString(6, sb.getRollNo());
    		k = ps.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return k;
    }
}
