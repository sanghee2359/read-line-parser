package dao;
// 2.Class 생성

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import static java.lang.System.getenv;

public class AWSConnectionMaker {    // 더이상 상속을 이용한 확장방식이 아님.
    public Connection openConnection() throws ClassNotFoundException,SQLException {
        Map<String, String> env = getenv();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD"));
        return c;
    }
}

