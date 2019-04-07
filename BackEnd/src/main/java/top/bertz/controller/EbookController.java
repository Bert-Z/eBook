package top.bertz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.bertz.bean.BookDetailBean;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class EbookController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/ebook")
    public BookDetailBean result(@RequestParam(value = "title", defaultValue = "hello;") String title,
                                 @RequestParam(value = "bookfee", defaultValue = "123" ) String bookfee,
                                 @RequestParam(value = "image", defaultValue = "hello;") String image,
                                 @RequestParam(value = "description", defaultValue = "hello;") String description)
    {
        BookDetailBean thisbook=new BookDetailBean(title, bookfee, image, description);
//        thisbook.setPropertie("开本","32开");

        return thisbook;
    }
}