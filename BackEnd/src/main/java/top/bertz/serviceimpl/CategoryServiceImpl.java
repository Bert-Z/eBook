package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.entity.Category;
import top.bertz.repository.CategoryRepository;
import top.bertz.service.CategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public List<Category> getCategory2() {
        return categoryRepo.findCategory2();
    }

    @Override
    public HashMap<String, List<Category>> getAll() {
        HashMap<String, List<Category>> ret = new HashMap<String, List<Category>>();

        List<String> cate2 = categoryRepo.getAllcate2();

        String thiscate;

        for (int i = 0; i < cate2.size(); i++) {

            if (cate2.get(i) instanceof String) {
                thiscate = cate2.get(i);
            } else {
                thiscate = "";
            }
//            System.out.println(cate2.size());
//            Category thisone=cate2.get(i);
//            System.out.println(cate2.get(i) instanceof String);
//            System.out.println(cate2.get(i));
            ret.put(thiscate, categoryRepo.getTop10ByCategory2(thiscate));
        }

        return ret;
    }
}
