package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.ShoppingCarts;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCarts,Long> {
}
