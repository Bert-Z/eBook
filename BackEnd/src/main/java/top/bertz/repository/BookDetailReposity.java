package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.BookDetail;

public interface BookDetailReposity extends CrudRepository<BookDetail,Long> {

}
