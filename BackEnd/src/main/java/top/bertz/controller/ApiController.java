package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.bertz.entity.BookDetail;
import top.bertz.entity.Categorys;
import top.bertz.repository.BookDetailRepository;
import top.bertz.repository.CategoryRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController {
    @Autowired
    CategoryRepository categoryRepo;

    @RequestMapping(value = {"/getCategories"}, produces = "application/json;charset=UTF-8")
    public Iterable<Categorys> getCategories(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findAll();
    }
}
