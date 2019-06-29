package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.Category;
import top.bertz.repository.CategoryRepository;
import top.bertz.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public List<Category> getCategory2() {
        return categoryRepo.findCategory2();
    }

    @Override
    public Iterable<Category> getAll() {
        return categoryRepo.findAll();
    }
}
