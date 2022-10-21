package dao;

import com.line.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.*;

import static java.lang.System.getenv;

public class UserDao {
    private AWSConnectionMaker awsConnectionMaker;
    private ConnectionMaker connectionMaker;
    public UserDao(){
        // 클래스 분리할 때 생성자에서 초기화
         this.awsConnectionMaker = new AWSConnectionMaker();
    }
    public UserDao(ConnectionMaker connectionMaker){

        this.connectionMaker = connectionMaker;
    }
    public void deleteAll() throws ClassNotFoundException {
        Connection c = null;
        PreparedStatement pstmt = null;

        try {
            c = connectionMaker.makeConnection();
            pstmt = c.prepareStatement("DELETE FROM user");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally { // error가 나도 실행되는 블록
            if(pstmt != null) { // pstmt가 null이 아니라면
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            if(c != null){
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    public int getCount() throws ClassNotFoundException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("SELECT count(*) FROM user");
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(c != null){
                try {
                    c.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    public void add(User user) throws ClassNotFoundException{

        //Connection conn = awsConnectionMaker.openConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = connectionMaker.makeConnection();
            ps = conn.prepareStatement("INSERT INTO user(id, name, password) VALUES(?, ?, ?)");
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    public User findById(String id) throws SQLException, ClassNotFoundException{
        // DB접속 (sql workbench실행)
//        Connection conn = awsConnectionMaker.openConnection();
        Connection conn = connectionMaker.makeConnection();
        // Qurey문 작성
        PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM user WHERE id=?");
        ps.setString(1, id);
        // Query문 실행
        ResultSet rs = ps.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
        }
        rs.close();
        ps.close();
        conn.close();

        if(user == null) throw new EmptyResultDataAccessException(1);
        return user;
    }


        // 관계설정 책임이 추가된 UserDao 클라이언트
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDaoFactory().awsUserDao();
        String id ="12";
        dao.add(new User(id, "sanghee", "25345"));

        User user = dao.findById(id);
        System.out.println(user.getName());

    }
}
