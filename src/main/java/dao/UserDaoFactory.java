package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDaoFactory {

    @Bean
    public UserDao awsUserDao() { // 날개 4개 선풍기
        AWSConnectionImplement implementAWS = new AWSConnectionImplement();
        UserDao userDao = new UserDao(implementAWS);
        return userDao;
    }
    @Bean
    public UserDao localUserDao() { // 날개 5개 선풍기
        LocalUserDaoExtends localConnectionImplement = new LocalUserDaoExtends();
        UserDao userDao = new UserDao();
        return userDao;
    }
}
