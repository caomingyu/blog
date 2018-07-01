import java.sql.*;

public class TestSQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        String sql = "insert into review values(null,?,?,?,?)";

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                "blog?characterEncoding=UTF-8", "root", "admin"); PreparedStatement ps = c.prepareStatement(sql);) {
            for (int i = 0; i < 20; i++) {
                ps.setInt(1, 6);
                ps.setInt(2, 36);
                ps.setString(3, "测试文章 " + i);
                ps.setDate(4,new Date(new java.util.Date().getTime()));
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
