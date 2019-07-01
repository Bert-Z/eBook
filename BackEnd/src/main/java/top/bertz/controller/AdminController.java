package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.bertz.entity.Book;
import top.bertz.entity.Orders;
import top.bertz.entity.User;
import top.bertz.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = {"/admin"})
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = {"/getAllUsers"}, produces = "application/json;charset=UTF-8")
    public List<User> getAllUsers(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return adminService.getAllUsers();
    }

    @RequestMapping(value = {"/getAllBooks"}, produces = "application/json;charset=UTF-8")
    public List<Book> getAllBooks(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return adminService.getAllBooks();
    }

    @RequestMapping(value = {"/getAllOrders"}, produces = "application/json;charset=UTF-8")
    public List<Orders> getAllOrders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return adminService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/forbidden"}, produces = "application/json;charset=UTF-8")
    public int forbidden(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String selrows = request.getParameter("selrows");
        return adminService.forbidden(selrows);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/permit"}, produces = "application/json;charset=UTF-8")
    public int permit(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String selrows = request.getParameter("selrows");
        return adminService.permit(selrows);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/setAdmin"}, produces = "application/json;charset=UTF-8")
    public int setAdmin(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String selrows = request.getParameter("selrows");
        return adminService.setAdmin(selrows);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/setUsers"}, produces = "application/json;charset=UTF-8")
    public int setUsers(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String selrows = request.getParameter("selrows");
        return adminService.setUsers(selrows);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/deleteBook"}, produces = "application/json;charset=UTF-8")
    public int deleteBook(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String bookid = request.getParameter("bookid");
        return adminService.deleteBook(bookid);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/addBook"}, produces = "application/json;charset=UTF-8")
    public int addBook(HttpServletRequest request, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");

//        String bookinfo=request.getParameter("bookinfo");
        String title=request.getParameter("title");

        float price=Float.valueOf(String.valueOf(request.getParameter("price")));
        int number=Integer.valueOf(String.valueOf(request.getParameter("number")));
        int cate_id=Integer.valueOf(String.valueOf(request.getParameter("cate_id")));

        String author=request.getParameter("author");
        String desc=request.getParameter("desc");
        String bookimage=request.getParameter("bookimage");
//        System.out.println());

        return adminService.addBook(title,cate_id,author,price,number,desc,bookimage);
    }
}
