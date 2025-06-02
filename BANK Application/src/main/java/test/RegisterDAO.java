package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {
    public RegisterBean rb = null;
    int k = 0;

    public int insert(RegisterBean rb) {
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement("INSERT INTO bankaccount VALUES(?,?,?,?)")) {

            ps.setString(1, rb.getFname());
            ps.setString(2, rb.getEmail());
            ps.setString(3, rb.getUname());
            ps.setString(4, rb.getPassword());

            k = ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return k;
    }
}
