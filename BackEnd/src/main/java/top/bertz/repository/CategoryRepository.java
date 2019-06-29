package top.bertz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query("select distinct category2 from Category")
    public List<Category> findCategory2();

    @Query("select distinct category2 from Category")
    public List<String> getAllcate2();

    @Query(value = "select distinct category1,id from Category where category2=?1")
    public List<Category> getTop10ByCategory2(String cate2);
    public List<Category> findAll();
}
