package top.bertz.dao;

import top.bertz.entity.Carts;

public interface CartDao {
    public Boolean existsByCartid(long cartid);
    public void save(Carts carts);
    public void delete(Carts carts);
    public Carts findById(long id);
}
