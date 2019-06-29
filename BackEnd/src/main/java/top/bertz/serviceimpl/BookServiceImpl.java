package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.Book;
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

    @Override
    public Iterable<Book> getAllBooks() {
        return bookdetailrepo.findAll();
    }

    @Override
    public List<Book> getRecommend() {
        int random = (int) (Math.random() * 50 + 1);

        List<Book> books = categoryRepository.findById(random).get().getBooks().subList(0, 8);

        return books;
    }
}
