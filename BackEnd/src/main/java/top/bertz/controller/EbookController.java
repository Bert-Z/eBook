package top.bertz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.bertz.entity.Book;
import top.bertz.entity.Category;
import top.bertz.repository.BookRepository;
import top.bertz.repository.CategoryRepository;
import top.bertz.service.BookService;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = {"/ebook"})
public class EbookController {
    @Autowired
    private BookService bookService;


    @RequestMapping(value = {"/{type}"}, produces = "application/json;charset=UTF-8")
    public List<Book> bookList(@PathVariable(name = "type") int type, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");

        return bookService.getBooksByType(type);
    }


    @RequestMapping(value = {"/bookdetails"}, produces = "application/json;charset=UTF-8")
    public Book bookDetails(@RequestParam(value = "id") Long id, HttpServletResponse response) {

        response.addHeader("Access-Control-Allow-Origin", "*");

        return bookService.getBookByid(id);
    }

}