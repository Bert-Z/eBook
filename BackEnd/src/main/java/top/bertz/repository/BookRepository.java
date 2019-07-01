package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
    public List<Book> findAll();
    public Book findFirstByBooktitle(String booktitle);
}
