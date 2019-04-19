package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Users;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,Long> {
    boolean existsByNameAndAndPassword(String Name,String Password);
}
