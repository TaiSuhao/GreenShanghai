package service;

import dao.UserDao;
import model.User;

public class UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean findUser(User user) {

        User temp=null;

        temp=userDao.findUser(user);

        return temp==null?false:true;
    }

    public boolean addUser(User user) {

        return userDao.addUser(user);

    }

    public User findUserByUsernameReturnUser(User user) {

        return userDao.findUser(user);

    }
}
