package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Book;
import top.bertz.entity.Category;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findBooksByCategory(Category category);
    List<Book> findFirst8ByCategory(Category category);
}
