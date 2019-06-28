package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionAnother {

    public static void main(String[] args) throws SQLException {
        //1、获取连接
        Connection connection = getConnection();
        connection.setAutoCommit(false);

        String plusSql = "update account set money = money-100 where name = ?";
        PreparedStatement ps1 = connection.prepareStatement(plusSql);
        ps1.setString(1, "Superman");
        ps1.execute();

        String lessenSql = "update account set money = money+100 where name = ?";
        PreparedStatement ps2 = connection.prepareStatement(lessenSql);
        ps2.setString(1, "Batman");
        ps2.execute();
        connection.commit();
        ps1.close();
        ps2.close();
        connection.close();
    }

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://118.31.15.106/demo",
                "root",
                "admin");
        return connection;
    }
}
