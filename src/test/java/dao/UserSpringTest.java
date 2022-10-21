package dao;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserSpringTest {
    @Autowired
    ApplicationContext context;
    UserDao userDao;
    User user1;
    User user2;
    User user3;

    @BeforeEach
    void setup() {
        userDao = context.getBean("awsUserDao", UserDao.class);
        user1 = new User("1", "정상희", "1106");
        user2 = new User("2", "신지원", "0129");
        user3 = new User("3", "박정현", "0308");
    }
    @Test
    void addAndSelect() throws SQLException, ClassNotFoundException {
//        userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        Assertions.assertEquals(0, userDao.getCount());

        userDao.add(user1);
        Assertions.assertEquals(1, userDao.getCount());

        User user = userDao.findById(user1.getId());
        Assertions.assertEquals(user1.getName(), user.getName());
        Assertions.assertEquals(user1.getPassword(), user.getPassword());
    }
    @Test
    void count() throws SQLException, ClassNotFoundException {
        userDao.deleteAll();
        Assertions.assertEquals(0, userDao.getCount());

        userDao.add(user2);
        Assertions.assertEquals(1, userDao.getCount());
        userDao.add(user3);
        Assertions.assertEquals(2, userDao.getCount());
    }
    @Test
    void findById() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, ()->{
            userDao.findById("15"); //id로 select하기
        });
    }
}
