package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.User;
import top.bertz.repository.UserRepository;
import top.bertz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
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
}
