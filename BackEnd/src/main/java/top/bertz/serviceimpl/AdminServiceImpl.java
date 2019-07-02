package top.bertz.serviceimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.*;
import top.bertz.repository.*;
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

    @Autowired
    private BookImageRepository bookImageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
            User user = userRepository.findById(id).get();
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
            User user = userRepository.findById(id).get();
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
            User user = userRepository.findById(id).get();
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
            User user = userRepository.findById(id).get();
            user.setIsadmin(false);
            userRepository.save(user);
        }

        return 1;
    }

    @Override
    public int deleteBook(String id) {
        long bookid = Long.valueOf(String.valueOf(id));
        Book book = bookRepository.findById(bookid).get();
        bookRepository.delete(book);
        return 1;
    }

    @Override
    public int addBook(String booktitle, int cate_id, String author, Float price, int number, String desc, String bookimage) {

        Book book = new Book(booktitle, price, desc);
        book.setAuther(author);
        book.setNumber(number);
        Category category = categoryRepository.findById(cate_id).get();
        book.setCategory(category);
        bookRepository.save(book);

        BookImage bookImage = new BookImage();
        bookImage.setBooktitle(booktitle);
        bookImage.setBookimage(bookimage);
        bookImageRepository.save(bookImage);

        return 1;
    }

    @Override
    public int modifyBook( long id,String booktitle, int cate_id, String author, Float price, int number, String desc, String bookimage) {
        Book book = bookRepository.findById(id).get();
        Category category = categoryRepository.findById(cate_id).get();
        book.setBooktitle(booktitle);
        book.setCategory(category);
        book.setAuther(author);
        book.setNumber(number);
        book.setBookfee(price);
        book.setDescription(desc);
        bookRepository.save(book);

        try{
            BookImage bookImage = bookImageRepository.findFirstByBooktitle(booktitle);
            bookImage.setBookimage(bookimage);
            bookImageRepository.save(bookImage);
        }catch (Exception e){

        }


        return 1;
    }


}
