package top.bertz.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.bertz.dao.CartDao;
import top.bertz.entity.Carts;
import top.bertz.repository.CartRepository;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Boolean existsByCartid(long cartid) {
        return cartRepository.existsByCartid(cartid);
    }

    @Override
    public void save(Carts carts) {
        cartRepository.save(carts);
    }

    @Override
    public void delete(Carts carts) {
        cartRepository.delete(carts);
    }

    @Override
    public Carts findById(long id) {
        return cartRepository.findById(id).get();
    }
}
