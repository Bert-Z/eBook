package top.bertz.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.bertz.dao.CategoryDao;
import top.bertz.entity.Category;
import top.bertz.repository.CategoryRepository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> findCategory2() {
        return categoryRepository.findCategory2();
    }

    @Override
    public List<String> getAllCategory2() {
        return categoryRepository.getAllcate2();
    }

    @Override
    public List<Category> getTop10ByCategory2(String cate2) {
        return categoryRepository.getTop10ByCategory2(cate2);
    }
}
