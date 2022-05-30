package experiment.ten;

import java.sql.*;

/**
 * @author liyajun
 * @date 2022/5/30 14:46
 */
public class prepareStatement {
    public static void main(String[] args) throws SQLException {
        String driver="com.mysql.cj.jdbc.Driver";
        String URL="jdbc:mysql://localhost:3306/spdb?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        Connection conn = null;
        String name = "root";
        String password = "root";

        try {
            Class.forName(driver); //loading

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            conn = DriverManager.getConnection(URL,name,password); //get connecte
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        query(conn);
        insert(conn);
        query(conn);
        update(conn);
        query(conn);
        delete(conn);
        query(conn);

    }
    static void query(Connection conn) throws SQLException {
        String sql = "select * from account";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet res = pre.executeQuery();
        while(res.next()){
            String id = res.getString("id");
            String na = res.getString("name");
            String money = res.getString("money");
            System.out.println(id + " " + na + " " + money);
        }
    }
    static void insert(Connection conn) throws SQLException {
        String sql = "insert into account values(22,33,44)";
        PreparedStatement pre = conn.prepareStatement(sql);
        int count = pre.executeUpdate();
        System.out.println("插入数据条数" + count);
    }
    static void update(Connection conn) throws SQLException {
        String sql = "update account set money = 114514 where id = 1";
        PreparedStatement pre = conn.prepareStatement(sql);
        int count = pre.executeUpdate();
        System.out.println("修改数据条数" + count);
    }
    static void delete(Connection conn) throws SQLException {
        String sql = "delete from account where id = 22";
        PreparedStatement pre = conn.prepareStatement(sql);
        int count = pre.executeUpdate();
        System.out.println("删除" + count);

    }
}
