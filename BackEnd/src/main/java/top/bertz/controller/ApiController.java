package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import top.bertz.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

import top.bertz.service.BookService;
import top.bertz.service.CartService;
import top.bertz.service.CategoryService;
import top.bertz.service.OrderService;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = {"/getCategory2"}, produces = "application/json;charset=UTF-8")
    public List<Category> getCategory2(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryService.getCategory2();
    }

    @RequestMapping(value = {"/getAllCategorys"}, produces = "application/json;charset=UTF-8")
    public HashMap<String, List<Category>> getAllCaregorys(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryService.getAll();
    }

    @RequestMapping(value = {"/getAllBooks"}, produces = "application/json;charset=UTF-8")
    public Iterable<Book> getAllBooks(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookService.getAllBooks();
    }

    @RequestMapping(value = {"/getRecommend"}, produces = "application/json;charset=UTF-8")
    public List<Book> getRecommend(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        return bookService.getRecommend();
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
