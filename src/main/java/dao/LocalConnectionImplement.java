package dao;
// 1. 상속을 이용한 확장(UserDaoAbstract)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import static java.lang.System.getenv;

public class LocalConnectionImplement implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = getenv();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/like-lion-db",
                "root",
                "25345");
        return c;
    }
}
