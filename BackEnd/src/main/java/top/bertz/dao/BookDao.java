package top.bertz.dao;

import top.bertz.entity.Book;
import top.bertz.entity.BookImage;

public interface BookDao {
    public Iterable<Book> findAll();
    public Book findById(long id);
    public BookImage findFirstBookImageByBooktitle(String booktitle);
    public void delete(Book book);
    public void save(Book book);
    public void saveImage(BookImage bookImage);
}
