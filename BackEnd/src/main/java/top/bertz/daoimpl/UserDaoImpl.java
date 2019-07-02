package top.bertz.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.bertz.dao.UserDao;
import top.bertz.entity.User;
import top.bertz.repository.UserRepository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void signup(String username, String password, String email) {
        userRepository.save(new User(username, password, email));
    }

    @Override
    public int signin(String username, String password) {
        if (userRepository.existsByNameAndAndPassword(username, password)) {
            User user = userRepository.findByName(username);
            if (user.getIsforbidden()) {
                return 3;
            } else {
                if (user.isIsadmin()) {
                    return 2;
                } else {
                    return 1;
                }
            }
        } else {
            return 0;
        }
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
