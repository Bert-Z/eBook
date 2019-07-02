package top.bertz.service;

import top.bertz.entity.Book;
import top.bertz.entity.Orders;
import top.bertz.entity.User;

import java.util.List;

public interface AdminService {
    public List<User> getAllUsers();
    public List<Book> getAllBooks();
    public List<Orders> getAllOrders();
    public int forbidden(String users);
    public int permit(String users);
    public int setAdmin(String users);
    public int setUsers(String users);
    public int deleteBook(String id);
    public int addBook(String booktitle,int cate_id,String author,Float price,int number,String desc,String bookimage);
    public int modifyBook(long id,String booktitle,int cate_id,String author,Float price,int number,String desc,String bookimage);
}
