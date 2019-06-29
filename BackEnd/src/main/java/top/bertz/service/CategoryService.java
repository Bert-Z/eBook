package top.bertz.service;

import top.bertz.entity.Category;

import java.util.HashMap;
import java.util.List;

public interface CategoryService {
    public List<Category> getCategory2();
    public HashMap<String, List<Category>> getAll();
}
