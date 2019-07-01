package top.bertz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.bertz.entity.BookImage;

public interface BookImageRepository extends MongoRepository<BookImage,String> {
}
