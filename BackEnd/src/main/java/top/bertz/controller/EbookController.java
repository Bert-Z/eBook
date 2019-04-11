package top.bertz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.bertz.bean.BookDetailBean;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping(value ={"/ebook"} )
public class EbookController {

    public HashMap<String,String> recommendation(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }

    @RequestMapping(value = {"/booklist"}, produces = "application/json;charset=UTF-8")
    public HashMap<String,String> bookList(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }


    @RequestMapping(value = {"/bookdetails"}, produces = "application/json;charset=UTF-8")
    public BookDetailBean bookDetails(@RequestParam(value = "title", defaultValue = "hello;") String title,
                                 @RequestParam(value = "bookfee", defaultValue = "123") String bookfee,
                                 @RequestParam(value = "image", defaultValue = "hello;") String image,
                                 @RequestParam(value = "description", defaultValue = "hello;") String description,
                                 HttpServletResponse response) {
        BookDetailBean thisbook = new BookDetailBean(title, bookfee, image, description);


        response.addHeader("Access-Control-Allow-Origin", "*");
        return thisbook;
    }

    @RequestMapping(value = {"/shoppingcart"}, produces = "application/json;charset=UTF-8")
    public HashMap<String,String> shoppingcart(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }

    @RequestMapping(value = {"/checkout"}, produces = "application/json;charset=UTF-8")
    public HashMap<String,String> checkout(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }

    @RequestMapping(value = {"/allorders"}, produces = "application/json;charset=UTF-8")
    public HashMap<String,String> allorders(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }

    @RequestMapping(value = {"/admin"}, produces = "application/json;charset=UTF-8")
    public HashMap<String,String> admin(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }

    @RequestMapping(value = {"/admin/editbook"}, produces = "application/json;charset=UTF-8")
    public HashMap<String,String> editbook(HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin", "*");
        HashMap<String,String> ret=new HashMap<String, String>();
        ret.put("23","123");
        return ret;
    }
}