package top.bertz.repository;

import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.BookDetail;

import java.util.List;

public interface BookDetailRepository extends CrudRepository<BookDetail,Long> {
    List<BookDetail> findBookDetailsByType(int type);
    List<BookDetail> findFirst8ByType(int type);
}
