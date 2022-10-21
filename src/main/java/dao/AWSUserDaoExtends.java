package dao;
// 1. 상속을 이용한 확장(UserDaoAbstract)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import static java.lang.System.getenv;

public class AWSUserDaoExtends extends UserDaoAbstract{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = getenv();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD"));
        return c;
    }
}
