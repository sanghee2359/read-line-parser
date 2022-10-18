package db_connect;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
//        UserDao userDao = new UserDao();
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id ="11";
        userDao.add(new User(id,"testName","1212"));
        User selectedUser = userDao.findById(id);
        Assertions.assertEquals("testName",selectedUser.getName());
    }
}