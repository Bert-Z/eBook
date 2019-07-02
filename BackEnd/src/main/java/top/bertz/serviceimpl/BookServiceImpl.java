package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.dao.BookDao;
import top.bertz.dao.CategoryDao;
import top.bertz.entity.Book;
import top.bertz.entity.BookImage;
import top.bertz.entity.Category;
import top.bertz.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Iterable<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> getRecommend() {
        int random = (int) (Math.random() * 10 + 1);

        List<Book> books = categoryDao.findById(random).getBooks().subList(0, 4);

        return books;
    }

    @Override
    public Book getBookByid(Long id) {
        Book book= bookDao.findById(id);
        String title=book.getBooktitle();

        try{
            BookImage bookImage=bookDao.findFirstBookImageByBooktitle(title);
            book.setImage(bookImage.getBookimage());
        }catch (Exception e){

        }

        return book;
    }

    @Override
    public List<Book> getBooksByType(int type) {
        Category category=categoryDao.findById(type);
        return category.getBooks();
    }
}
