package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.bertz.entity.Book;
import top.bertz.entity.Category;
import top.bertz.repository.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = {"/ebook"})
public class EbookController {
    @Autowired
    private BookRepository bookdetailrepo;

    EntityManagerFactory emf = null;

    public HashMap<String, String> recommendation(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("23", "123");
        return ret;
    }

    @RequestMapping(value = {"/{type}"}, produces = "application/json;charset=UTF-8")
    public List<Book> bookList(@PathVariable(name = "type") int type, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");

        EntityManager em=emf.createEntityManager();
        Category ca=em.find(Category.class,2);

        List<Book> books=bookdetailrepo.findBooksByCategory(ca);
        return books;
    }


    @RequestMapping(value = {"/bookdetails"}, produces = "application/json;charset=UTF-8")
    public Book bookDetails(@RequestParam(value = "id") Long id, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        return bookdetailrepo.findById(id).get();
    }

    @RequestMapping(value = {"/shoppingcart"}, produces = "application/json;charset=UTF-8")
    public HashMap<String, String> shoppingcart(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("23", "123");
        return ret;
    }

    @RequestMapping(value = {"/checkout"}, produces = "application/json;charset=UTF-8")
    public HashMap<String, String> checkout(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("23", "123");
        ret.put("24", "123");
        return ret;
    }

    @RequestMapping(value = {"/allorders"}, produces = "application/json;charset=UTF-8")
    public HashMap<String, String> allorders(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("23", "123");
        return ret;
    }

    @RequestMapping(value = {"/admin"}, produces = "application/json;charset=UTF-8")
    public HashMap<String, String> admin(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("23", "123");
        return ret;
    }

    @RequestMapping(value = {"/admin/editbook"}, produces = "application/json;charset=UTF-8")
    public HashMap<String, String> editbook(HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("23", "123");
        return ret;
    }
}