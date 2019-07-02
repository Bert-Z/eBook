package top.bertz.serviceimpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.dao.BookDao;
import top.bertz.dao.CategoryDao;
import top.bertz.dao.OrderDao;
import top.bertz.dao.UserDao;
import top.bertz.entity.*;
import top.bertz.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookDao.findAll();
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public int forbidden(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user = userDao.findById(id);
            user.setIsforbidden(true);
            userDao.save(user);
        }

        return 1;
    }

    @Override
    public int permit(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user = userDao.findById(id);
            user.setIsforbidden(false);
            userDao.save(user);
        }

        return 1;
    }

    @Override
    public int setAdmin(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user = userDao.findById(id);
            user.setIsadmin(true);
            userDao.save(user);
        }

        return 1;
    }

    @Override
    public int setUsers(String users) {
        JSONArray sels = JSONArray.fromObject(users);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(i);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            User user = userDao.findById(id);
            user.setIsadmin(false);
            userDao.save(user);
        }

        return 1;
    }

    @Override
    public int deleteBook(String id) {
        long bookid = Long.valueOf(String.valueOf(id));
        Book book = bookDao.findById(bookid);
        bookDao.delete(book);
        return 1;
    }

    @Override
    public int addBook(String booktitle, int cate_id, String author, Float price, int number, String desc, String bookimage) {

        Book book = new Book(booktitle, price, desc);
        book.setAuther(author);
        book.setNumber(number);
        Category category = categoryDao.findById(cate_id);
        book.setCategory(category);
        bookDao.save(book);

        BookImage bookImage = new BookImage();
        bookImage.setBooktitle(booktitle);
        bookImage.setBookimage(bookimage);
        bookDao.saveImage(bookImage);

        return 1;
    }

    @Override
    public int modifyBook( long id,String booktitle, int cate_id, String author, Float price, int number, String desc, String bookimage) {
        Book book = bookDao.findById(id);
        Category category = categoryDao.findById(cate_id);
        book.setBooktitle(booktitle);
        book.setCategory(category);
        book.setAuther(author);
        book.setNumber(number);
        book.setBookfee(price);
        book.setDescription(desc);
        bookDao.save(book);

        try{
            BookImage bookImage = bookDao.findFirstBookImageByBooktitle(booktitle);
            bookImage.setBookimage(bookimage);
            bookDao.saveImage(bookImage);
        }catch (Exception e){

        }


        return 1;
    }


}
