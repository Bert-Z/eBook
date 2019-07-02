package top.bertz.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.bertz.dao.OrderDao;
import top.bertz.entity.Orders;
import top.bertz.repository.OrderRepository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(Orders orders) {
        orderRepository.save(orders);
    }

    @Override
    public Orders findById(long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void delete(Orders orders) {
        orderRepository.delete(orders);
    }

    @Override
    public long getMaxOrderid() {
        return orderRepository.findFirstByOrderByOrderidDesc().getOrderid();
    }

    @Override
    public List<Orders> findAll() {
        return (List<Orders>) orderRepository.findAll();
    }
}
