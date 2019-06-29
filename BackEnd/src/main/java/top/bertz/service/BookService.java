package top.bertz.service;

import top.bertz.entity.Book;

import java.util.List;

public interface BookService {
    public Iterable<Book> getAllBooks();
    public List<Book> getRecommend();
}
