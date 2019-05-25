package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Orders;


public interface OrderRepository extends CrudRepository<Orders, Long> {
    public Orders findFirstByOrderByOrderidDesc();
}
