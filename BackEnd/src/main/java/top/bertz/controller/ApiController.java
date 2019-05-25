package top.bertz.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import top.bertz.entity.*;
import top.bertz.repository.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController {
    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    private BookRepository bookdetailrepo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    private Long cartid = 0L;

    @RequestMapping(value = {"/getCategory2"}, produces = "application/json;charset=UTF-8")
    public List<Category> getCategory2(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findCategory2();
    }

    @RequestMapping(value = {"/getAllCategorys"}, produces = "application/json;charset=UTF-8")
    public Iterable<Category> getAllCaregorys(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findAll();
    }

    @RequestMapping(value = {"/getAllBooks"}, produces = "application/json;charset=UTF-8")
    public Iterable<Book> getAllBooks(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookdetailrepo.findAll();
    }

    @RequestMapping(value = {"/getRecommend"}, produces = "application/json;charset=UTF-8")
    public List<Book> getRecommend(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        int random = (int)(Math.random() * 50 + 1);

        List<Book> books = categoryRepo.findById(random).get().getBooks().subList(0, 8);

        return books;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/buynow"}, produces = "application/json;charset=UTF-8")
    public int buyNow(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Long id = Long.parseLong(request.getParameter("id"));
        String booktitle=request.getParameter("booktitle");
        Double bookfee = Double.parseDouble(request.getParameter("bookfee"));
        int buynum = Integer.parseInt(request.getParameter("buynum"));
        String username = request.getParameter("username");

        Timestamp time = new Timestamp((new Date()).getTime());

        Book book = bookdetailrepo.findById(id).get();
        book.setNumber(book.getNumber() - buynum);

        bookdetailrepo.save(book);

        User user = userRepository.findByName(username);
        Orders order = new Orders();
        order.setBookid(id);
        order.setBooktitle(booktitle);
        order.setBookfee(bookfee);
        order.setChecked(true);
        order.setBooknum(buynum);
        order.setUser(user);
        order.setCreatetime(time);
        order.setUpdatetime(time);

        orderRepository.save(order);

        return 1;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/addcart"}, produces = "application/json;charset=UTF-8")
    public int addcart(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Long id = Long.parseLong(request.getParameter("id"));
        int addnum = Integer.parseInt(request.getParameter("addnum"));
        String username = request.getParameter("username");

        Carts cart = new Carts();
        User user = userRepository.findByName(username);
        cart.setUser(user);

        cart.setBooknum(addnum);
        cart.setCartid(cartid);

        Book book = bookdetailrepo.findById(id).get();

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

    @RequestMapping(method = RequestMethod.GET, value = {"/getcarts"}, produces = "application/json;charset=UTF-8")
    public List<Carts> getCarts(@RequestParam(value = "username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        User user = userRepository.findByName(username);
        List<Carts> carts = user.getUsercarts();

        return carts;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/cartdelete"}, produces = "application/json;charset=UTF-8")
    public void cartdelete(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String selrows = request.getParameter("selrows");

        User user = userRepository.findByName(username);

        JSONObject sels = JSONObject.fromObject(selrows);

        long id = Long.valueOf(String.valueOf(sels.get("id")));
//        System.out.println(id);
        Carts carts1 = cartRepository.findById(id).get();
        cartRepository.delete(carts1);

    }

    @RequestMapping(method = RequestMethod.POST, value = {"/checkout"}, produces = "application/json;charset=UTF-8")
    public int checkout(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String selrows = request.getParameter("selrows");
//        System.out.println(selrows);

        User user = userRepository.findByName(username);
        Timestamp time = new Timestamp((new Date()).getTime());

        JSONArray sels = JSONArray.fromObject(selrows);
        for (int i = 0; i < sels.size(); i++) {
            JSONObject item = sels.getJSONObject(0);
            long id = Long.valueOf(String.valueOf(item.get("id")));
            String booktitle=String.valueOf(item.get("booktitle"));
            Double bookfee =Double.valueOf(String.valueOf(item.get("bookfee")));
            long bookid = Long.valueOf(String.valueOf(item.get("bookid")));
            int booknum = Integer.valueOf(String.valueOf(item.get("booknum")));
            Carts carts1 = cartRepository.findById(id).get();
            cartRepository.delete(carts1);

            Orders orders1 = new Orders();
            orders1.setBookid(bookid);
            orders1.setBookfee(bookfee);
            orders1.setBooktitle(booktitle);
            orders1.setBooknum(booknum);
            orders1.setUser(user);
            orders1.setCreatetime(time);
            orders1.setUpdatetime(time);

            orderRepository.save(orders1);

            Book b = bookdetailrepo.findById(bookid).get();
            b.setNumber(b.getNumber() - booknum);
            bookdetailrepo.save(b);

        }

        return 1;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getAllOrders"}, produces = "application/json;charset=UTF-8")
    public Iterable<Orders> getAllOrders(@RequestParam(value = "username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        User user = userRepository.findByName(username);

        return user.getUserorders();
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getNeedPaymentOrders"}, produces = "application/json;charset=UTF-8")
    public Iterable<Orders> getNeedPaymentOrders(@RequestParam(value = "username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        User user = userRepository.findByName(username);

        List<Orders> allorders = user.getUserorders();
        List<Orders> retOrders = new ArrayList<Orders>();

        for (Orders i : allorders) {
            if (i.getChecked() == false) {
                retOrders.add(i);
            }
        }
        return retOrders;
    }
}
