package db_connect;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        User user = new User("3","testName","1212");
        userDao.add(user);

        User selectedUser = userDao.findById("3");
        Assertions.assertEquals("testName",selectedUser.getName());
    }
}