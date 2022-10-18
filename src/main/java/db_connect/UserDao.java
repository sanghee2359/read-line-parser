package db_connect;

import com.line.domain.User;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

import static java.lang.System.getenv;

public class UserDao {
    //public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = getenv();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD"));
        return c;
    }
    public void add(User user) throws SQLException, ClassNotFoundException{

        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        conn.close();

    }
    public User findById(String id) throws SQLException, ClassNotFoundException{
        // DB접속 (sql workbench실행)
        Connection conn = getConnection();
        // Qurey문 작성
        PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM users WHERE id=?");
        ps.setString(1, id);
        // Query문 실행
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

        rs.close();
        ps.close();
        conn.close();

        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        /* User 추가
        userDao.add(new User("4", "junghyen", "0308"));
         */
        User user = userDao.findById("1");
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }

}
