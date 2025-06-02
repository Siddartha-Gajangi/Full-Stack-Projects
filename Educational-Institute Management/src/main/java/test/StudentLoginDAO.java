package test;

import java.sql.*;

public class StudentLoginDAO {
    public StudentBean login(String rollno) {
        StudentBean sb = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Get database connection
            con = DBConnection.getCon();

            // Prepare SQL query
            ps = con.prepareStatement("SELECT * FROM student71 WHERE rollno = ?");
            ps.setString(1, rollno);

            // Execute query
            rs = ps.executeQuery();
            if (rs.next()) {
                // Populate StudentBean with retrieved data
                sb = new StudentBean();
                sb.setRollNo(rs.getString(1));
                sb.setName(rs.getString(2));
                sb.setCourse(rs.getString(3));
                sb.setTotMarks(rs.getInt(4));
                sb.setPer(rs.getInt(5));
                sb.setResult(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log exception
        } finally {
            // Close resources to avoid memory leaks
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return sb; // Return the StudentBean (null if not found)
    }
}


//package test;
//
//import java.sql.*;
//
//import jakarta.servlet.http.HttpServlet;
//
//public class StudentLoginDAO {
//	public StudentBean sb=null;
//	public StudentBean login(String rollno) {
//		try {
//			Connection con=DBConnection.getCon();
//			PreparedStatement ps= con.prepareStatement("select * from student71 where rollno=?");
//			ps.setString(1, rollno);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()) {
//				sb= new StudentBean();
//				sb.setRollNo(rs.getString(1));
//				sb.setName(rs.getString(2));
//				sb.setCourse(rs.getString(3));
//				sb.setTotMarks(rs.getInt(4));
//				sb.setPer(rs.getInt(5));
//				sb.setResult(rs.getString(6));
//				
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return sb;
//	}
//	
//}
