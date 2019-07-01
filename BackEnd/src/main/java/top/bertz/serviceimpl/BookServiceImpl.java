package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.Book;
import top.bertz.entity.BookImage;
import top.bertz.entity.Category;
import top.bertz.repository.BookImageRepository;
import top.bertz.repository.BookRepository;
import top.bertz.repository.CategoryRepository;
import top.bertz.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookdetailrepo;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookImageRepository bookImageRepository;

    @Override
    public Iterable<Book> getAllBooks() {
        return bookdetailrepo.findAll();
    }

    @Override
    public List<Book> getRecommend() {
        int random = (int) (Math.random() * 10 + 1);

        List<Book> books = categoryRepository.findById(random).get().getBooks().subList(0, 4);

        return books;
    }

    @Override
    public Book getBookByid(Long id) {
        Book book= bookdetailrepo.findById(id).get();
        String title=book.getBooktitle();

        try{
            BookImage bookImage=bookImageRepository.findFirstByBooktitle(title);
            book.setImage(bookImage.getBookimage());
        }catch (Exception e){

        }

        return book;
    }

    @Override
    public List<Book> getBooksByType(int type) {
        Category category=categoryRepository.findById(type).get();
        return category.getBooks();
    }
}
