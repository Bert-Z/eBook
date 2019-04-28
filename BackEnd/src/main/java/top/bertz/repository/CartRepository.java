package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Carts;

import java.util.List;

public interface CartRepository extends CrudRepository<Carts,Long> {
    boolean existsByCartid(Long cartid);
    List<Carts> findCartsByCartid(Long cartid);
}
