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
import top.bertz.service.CartService;
import top.bertz.service.OrderService;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController {
    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    private BookRepository bookdetailrepo;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

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

        int random = (int) (Math.random() * 50 + 1);

        List<Book> books = categoryRepo.findById(random).get().getBooks().subList(0, 8);

        return books;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/buynow"}, produces = "application/json;charset=UTF-8")
    public int buyNow(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Long id = Long.parseLong(request.getParameter("id"));
        int buynum = Integer.parseInt(request.getParameter("buynum"));
        String username = request.getParameter("username");

        return orderService.buyOneBook(id, buynum, username);

    }

    @RequestMapping(method = RequestMethod.POST, value = {"/addcart"}, produces = "application/json;charset=UTF-8")
    public int addcart(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        Long id = Long.parseLong(request.getParameter("id"));
        int addnum = Integer.parseInt(request.getParameter("addnum"));
        String username = request.getParameter("username");


        return cartService.add(id, addnum, username);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getcarts"}, produces = "application/json;charset=UTF-8")
    public List<Carts> getCarts(@RequestParam(value = "username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        return cartService.get(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/cartdelete"}, produces = "application/json;charset=UTF-8")
    public void cartdelete(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String selrows = request.getParameter("selrows");

        cartService.delete(selrows, username);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/needPaymentDelete"}, produces = "application/json;charset=UTF-8")
    public void needPaymentDelete(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String selrows = request.getParameter("selrows");


        orderService.deleteBeforePayment(selrows,username);
    }


    @RequestMapping(method = RequestMethod.POST, value = {"/checkout"}, produces = "application/json;charset=UTF-8")
    public int checkout(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String selrows = request.getParameter("selrows");

        return cartService.checkout(selrows, username);

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getAllOrders"}, produces = "application/json;charset=UTF-8")
    public Iterable<Orders> getAllOrders(@RequestParam(value = "username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        return orderService.getAll(username);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/getNeedPaymentOrders"}, produces = "application/json;charset=UTF-8")
    public Iterable<Orders> getNeedPaymentOrders(@RequestParam(value = "username") String username, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        return orderService.getUnpayOrders(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/finalPayment"}, produces = "application/json;charset=UTF-8")
    public void finalPayment(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        String username = request.getParameter("username");
        String selrows = request.getParameter("selrows");

        orderService.pay(selrows,username);
    }
}
