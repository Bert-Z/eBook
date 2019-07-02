package top.bertz.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.bertz.dao.CategoryDao;
import top.bertz.entity.Category;
import top.bertz.service.CategoryService;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategory2() {
        return categoryDao.findCategory2();
    }

    @Override
    public HashMap<String, List<Category>> getAll() {
        HashMap<String, List<Category>> ret = new HashMap<String, List<Category>>();

        List<String> cate2 = categoryDao.getAllCategory2();

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
            ret.put(thiscate, categoryDao.getTop10ByCategory2(thiscate));
        }

        return ret;
    }
}
