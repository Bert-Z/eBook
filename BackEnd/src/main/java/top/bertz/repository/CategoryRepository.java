package top.bertz.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import top.bertz.entity.Categorys;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Categorys, Integer> {
    @Query("select distinct category2 from Categorys")
    public List<Categorys> findCategory2();

}
