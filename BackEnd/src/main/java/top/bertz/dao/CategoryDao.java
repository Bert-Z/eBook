package top.bertz.dao;

import top.bertz.entity.Category;

import java.util.List;

public interface CategoryDao {
    public Category findById(int id);
    public List<Category> findCategory2();
    public List<String> getAllCategory2();
    public List<Category> getTop10ByCategory2(String cate2);
}
