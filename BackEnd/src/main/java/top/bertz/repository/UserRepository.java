package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Users;

public interface UserRepository extends CrudRepository<Users,Long> {

}
