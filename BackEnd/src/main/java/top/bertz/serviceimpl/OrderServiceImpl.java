package top.bertz.serviceimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.Book;
import top.bertz.entity.Orders;
import top.bertz.entity.User;
import top.bertz.repository.BookRepository;
import top.bertz.repository.OrderRepository;
import top.bertz.repository.UserRepository;
import top.bertz.service.OrderService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BookRepository bookdetailrepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public int buyOneBook(Long book_id, int number, String username) {

        Timestamp time = new Timestamp((new Date()).getTime());

        Book book = bookdetailrepo.findById(book_id).get();
        book.setNumber(book.getNumber() - number);

        bookdetailrepo.save(book);

        User user = userRepository.findByName(username);
        Orders order = new Orders();
        order.setBookid(book_id);
        order.setBooktitle(book.getBooktitle());
        order.setBookfee(book.getBookfee());
        order.setChecked(0);
        order.setBooknum(number);
        order.setUser(user);
        order.setCreatetime(time);
        order.setUpdatetime(time);

        orderRepository.save(order);

        return 1;
    }

    @Override
    public void deleteBeforePayment(String order_info, String username) {
        User user = userRepository.findByName(username);

        JSONObject sels = JSONObject.fromObject(order_info);
        long id = Long.valueOf(String.valueOf(sels.get("id")));
        Orders orders = orderRepository.findById(id).get();
        orderRepository.delete(orders);
    }

    @Override
    public List<Orders> getAll(String username) {
        User user = userRepository.findByName(username);

        return user.getUserorders();
    }

    @Override
    public List<Orders> getUnpayOrders(String username) {
        User user = userRepository.findByName(username);

        List<Orders> allorders = user.getUserorders();
        List<Orders> retOrders = new ArrayList<Orders>();

        for (Orders i : allorders) {
            if (i.getChecked() == 0) {
                retOrders.add(i);
            }
//            System.out.println(i.getBookid());
//            System.out.println(i.getChecked());
        }
        return retOrders;
    }

    @Override
    public void pay(String order_infos, String username) {

        Long max_orderid = orderRepository.findFirstByOrderByOrderidDesc().getOrderid();
//        System.out.println(max_orderid);
        if (max_orderid == null) {
            max_orderid = 0L;
        }
//        System.out.println(max_orderid);
        User user = userRepository.findByName(username);

        Timestamp time = new Timestamp((new Date()).getTime());

        JSONArray sels = JSONArray.fromObject(order_infos);

        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            long bookid = Long.valueOf(String.valueOf(item.get("bookid")));
            int booknum = Integer.valueOf(String.valueOf(item.get("booknum")));
//            System.out.println(id);
//            System.out.println(bookid);
//            System.out.println(booknum);

            Orders orders = orderRepository.findById(id).get();
            orders.setOrderid(max_orderid + 1);
            orders.setChecked(1);
            orders.setUpdatetime(time);
            orderRepository.save(orders);

            Book b = bookdetailrepo.findById(bookid).get();
            b.setNumber(b.getNumber() - booknum);
            bookdetailrepo.save(b);

        }

    }
}
