package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Carts;

public interface CartRepository extends CrudRepository<Carts,Long> {
    boolean existsByCartid(Long cartid);
}
