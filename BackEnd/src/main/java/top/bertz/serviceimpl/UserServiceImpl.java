package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.dao.UserDao;
import top.bertz.entity.User;
import top.bertz.repository.UserRepository;
import top.bertz.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void signup(String username, String password, String email) {
        userDao.signup(username, password, email);
    }

    @Override
    public int signin(String username, String password) {
        return userDao.signin(username, password);
    }
}
