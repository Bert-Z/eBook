package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
