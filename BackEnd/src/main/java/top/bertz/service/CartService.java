package top.bertz.service;

import top.bertz.entity.Carts;

import java.util.List;

public interface CartService {
    public int add(Long book_id,int number,String username);
    public List<Carts> get(String username);
    public void delete(String cart_infos,String username);
    public int checkout(String cart_infos,String username);
}
