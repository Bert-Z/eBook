package top.bertz.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.bertz.dao.BookDao;
import top.bertz.entity.Book;
import top.bertz.entity.BookImage;
import top.bertz.repository.BookImageRepository;
import top.bertz.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookImageRepository bookImageRepository;


    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public BookImage findFirstBookImageByBooktitle(String booktitle) {
        return bookImageRepository.findFirstByBooktitle(booktitle);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void saveImage(BookImage bookImage) {
        bookImageRepository.save(bookImage);
    }


}
