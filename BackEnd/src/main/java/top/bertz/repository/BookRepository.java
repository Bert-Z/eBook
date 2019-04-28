package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Book;

public interface BookRepository extends CrudRepository<Book,Long> {

}
