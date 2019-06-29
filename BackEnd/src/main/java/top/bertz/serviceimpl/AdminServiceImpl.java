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
import top.bertz.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Orders> getAllOrders() {
        return (List<Orders>) orderRepository.findAll();
    }

    @Override
    public int forbidden(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user=userRepository.findById(id).get();
            user.setIsforbidden(true);
            userRepository.save(user);
        }

        return 1;
    }

    @Override
    public int permit(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user=userRepository.findById(id).get();
            user.setIsforbidden(false);
            userRepository.save(user);
        }

        return 1;
    }

    @Override
    public int setAdmin(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user=userRepository.findById(id).get();
            user.setIsadmin(true);
            userRepository.save(user);
        }

        return 1;
    }

    @Override
    public int setUsers(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user=userRepository.findById(id).get();
            user.setIsadmin(false);
            userRepository.save(user);
        }

        return 1;
    }

    @Override
    public int deleteBook(String id) {
        long bookid=Long.valueOf(String.valueOf(id));
        Book book=bookRepository.findById(bookid).get();
        bookRepository.delete(book);
        return 1;
    }

    @Override
    public int addBook() {
        return 1;
    }

}
