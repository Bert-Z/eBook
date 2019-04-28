package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.User;

public interface UserRepository extends CrudRepository<User,Long> {
    boolean existsByNameAndAndPassword(String Name,String Password);
    User findByName(String Name);
}
