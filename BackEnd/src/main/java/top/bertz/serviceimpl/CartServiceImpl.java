package top.bertz.serviceimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.Book;
import top.bertz.entity.Carts;
import top.bertz.entity.Orders;
import top.bertz.entity.User;
import top.bertz.repository.BookRepository;
import top.bertz.repository.CartRepository;
import top.bertz.repository.OrderRepository;
import top.bertz.repository.UserRepository;
import top.bertz.service.CartService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookdetailrepo;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    private Long cartid = 0L;

    @Override
    public int add(Long book_id, int number, String username) {
        Carts cart = new Carts();
        User user = userRepository.findByName(username);
        cart.setUser(user);

        cart.setBooknum(number);
        cart.setCartid(cartid);

        Book book = bookdetailrepo.findById(book_id).get();

        if (cartRepository.existsByCartid(cartid)) {
            List<Book> books = cart.getBooks();
            books.add(book);
            cart.setBooks(books);
        } else {
            List<Book> books = new ArrayList<Book>();
            books.add(book);
            cart.setBooks(books);
        }

        cartRepository.save(cart);

        return 1;
    }

    @Override
    public List<Carts> get(String username) {
        User user = userRepository.findByName(username);
        List<Carts> carts = user.getUsercarts();

        return carts;
    }

    @Override
    public void delete(String cart_infos, String username) {
        User user = userRepository.findByName(username);

        JSONObject sels = JSONObject.fromObject(cart_infos);

        long id = Long.valueOf(String.valueOf(sels.get("id")));
//        System.out.println(id);
        Carts carts1 = cartRepository.findById(id).get();
        cartRepository.delete(carts1);
    }

    @Override
    public int checkout(String cart_infos, String username) {
        User user = userRepository.findByName(username);
        Timestamp time = new Timestamp((new Date()).getTime());

        JSONArray sels = JSONArray.fromObject(cart_infos);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            String booktitle = String.valueOf(item.get("booktitle"));
            Double bookfee = Double.valueOf(String.valueOf(item.get("bookfee")));
            long bookid = Long.valueOf(String.valueOf(item.get("bookid")));
            int booknum = Integer.valueOf(String.valueOf(item.get("booknum")));
            Carts carts1 = cartRepository.findById(id).get();
            cartRepository.delete(carts1);

            Orders orders1 = new Orders();
            orders1.setBookid(bookid);
            orders1.setBookfee(bookfee);
            orders1.setBooktitle(booktitle);
            orders1.setBooknum(booknum);
            orders1.setChecked(0);
            orders1.setUser(user);
            orders1.setCreatetime(time);
            orders1.setUpdatetime(time);

            orderRepository.save(orders1);

        }
        return 1;
    }
}
