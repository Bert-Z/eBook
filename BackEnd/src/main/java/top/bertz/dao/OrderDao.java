package top.bertz.dao;

import top.bertz.entity.Orders;

import java.util.List;

public interface OrderDao {
    public void save(Orders orders);
    public Orders findById(long id);
    public void delete(Orders orders);
    public long getMaxOrderid();
    public List<Orders> findAll();
}
