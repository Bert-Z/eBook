package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import top.bertz.entity.*;
import top.bertz.repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

        List<Book> books = categoryRepo.findById(15).get().getBooks().subList(0, 8);

        return books;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/buynow"}, produces = "application/json;charset=UTF-8")
    public int buyNow(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Long id = Long.parseLong(request.getParameter("id"));
        int buynum = Integer.parseInt(request.getParameter("buynum"));
        String username = request.getParameter("username");

        Timestamp time = new Timestamp((new Date()).getTime());

        Book book = bookdetailrepo.findById(id).get();
        book.setNumber(book.getNumber() - buynum);

        bookdetailrepo.save(book);

        User user = userRepository.findByName(username);
        Orders order = new Orders();
        order.setBookid(id);
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

        Carts cart=new Carts();
        User user = userRepository.findByName(username);
        cart.setUser(user);

        cart.setBooknum(addnum);
        cart.setCartid(cartid);

        Book book = bookdetailrepo.findById(id).get();

        if(cartRepository.existsByCartid(cartid)){
            List<Book> books=cart.getBooks();
            books.add(book);
            cart.setBooks(books);
        }
        else {
            List<Book> books=new ArrayList<Book>();
            books.add(book);
            cart.setBooks(books);
        }

        cartRepository.save(cart);

        return 1;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getcarts"}, produces = "application/json;charset=UTF-8")
    public List<Carts> getCarts(@RequestParam(value = "username") String username,HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");

        User user=userRepository.findByName(username);
        List<Carts> carts=user.getUsercarts();

        return carts;
    }
}
