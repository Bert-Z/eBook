package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.bertz.entity.BookDetail;
import top.bertz.entity.Categorys;
import top.bertz.repository.BookDetailRepository;
import top.bertz.repository.CategoryRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController {
    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    private BookDetailRepository bookdetailrepo;

    @RequestMapping(value = {"/getCategory2"}, produces = "application/json;charset=UTF-8")
    public List<Categorys> getCategory2(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findCategory2();
    }
    @RequestMapping(value = {"/getAllCategorys"}, produces = "application/json;charset=UTF-8")
    public Iterable<Categorys> getAllCaregorys(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findAll();
    }

    @RequestMapping(value = {"/getAllBooks"}, produces = "application/json;charset=UTF-8")
    public Iterable<BookDetail> getAllBooks(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookdetailrepo.findAll();
    }
}
