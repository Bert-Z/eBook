package top.bertz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.bertz.bean.BookDetailBean;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value ={"/ebook"} )
public class EbookController {


    @RequestMapping(value = {"/bookdetails"}, produces = "application/json;charset=UTF-8")
    public BookDetailBean result(@RequestParam(value = "title", defaultValue = "hello;") String title,
                                 @RequestParam(value = "bookfee", defaultValue = "123") String bookfee,
                                 @RequestParam(value = "image", defaultValue = "hello;") String image,
                                 @RequestParam(value = "description", defaultValue = "hello;") String description,
                                 HttpServletResponse rsp) {
        BookDetailBean thisbook = new BookDetailBean(title, bookfee, image, description);


        rsp.addHeader("Access-Control-Allow-Origin", "*");
        return thisbook;
    }
}