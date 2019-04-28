package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import top.bertz.entity.Book;
import top.bertz.entity.Category;
import top.bertz.repository.BookRepository;
import top.bertz.repository.CategoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = {"/api"})
public class ApiController {
    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    private BookRepository bookdetailrepo;

    EntityManagerFactory emf = null;

    @RequestMapping(value = {"/getCategory2"}, produces = "application/json;charset=UTF-8")
    public List<Category> getCategory2(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findCategory2();
    }
    @RequestMapping(value = {"/getAllCategorys"}, produces = "application/json;charset=UTF-8")
    public Iterable<Category> getAllCaregorys(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return categoryRepo.findAll();
    }

    @RequestMapping(value = {"/getAllBooks"}, produces = "application/json;charset=UTF-8")
    public Iterable<Book> getAllBooks(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookdetailrepo.findAll();
    }

    @RequestMapping(value = {"/getRecommend"}, produces = "application/json;charset=UTF-8")
    public List<Book> getRecommend(HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin", "*");
        EntityManager em=emf.createEntityManager();

        Category ca=em.find(Category.class,2);


        return bookdetailrepo.findFirst8ByCategory(ca);
    }

}
