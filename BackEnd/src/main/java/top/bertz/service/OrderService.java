package top.bertz.service;

import top.bertz.entity.Orders;

import java.util.List;

public interface OrderService {
    public int buyOneBook(Long book_id,int number,String username);
    public void deleteBeforePayment(String order_info,String username);
    public List<Orders> getAll(String username);
    public List<Orders> getUnpayOrders(String username);
    public void pay(String order_infos,String username);
}
