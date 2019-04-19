package top.bertz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.bertz.entity.Users;
import top.bertz.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"signup"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String signup(HttpServletRequest request, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        userRepository.save(new Users(name, password, email));

        return request.getParameter("name");

    }
}
