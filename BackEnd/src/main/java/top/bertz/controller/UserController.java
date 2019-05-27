package top.bertz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.bertz.entity.User;
import top.bertz.repository.UserRepository;
import top.bertz.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"signup"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public void signup(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");


        userService.signup(name,password,email);
    }

    @RequestMapping(value = {"signin"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public int signin(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        return userService.signin(name,password);
    }
}
