package top.bertz.dao;

import top.bertz.entity.User;

import java.util.List;

public interface UserDao {
    public void signup(String username, String password, String email);
    public int signin(String username, String password);
    public User findByName(String username);
    public List<User> findAll();
    public User findById(Long id);
    public void save(User user);

}
