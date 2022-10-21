package dao;

import com.line.domain.User;

import java.sql.*;

import static java.lang.System.getenv;

public abstract class UserDaoAbstract {
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
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

}
