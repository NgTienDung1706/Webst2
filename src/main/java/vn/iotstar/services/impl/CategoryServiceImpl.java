package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.IUserService;

public class CategoryServiceImpl implements CategoryService{
	public ICategoryDao cateDao=new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findName(String name) {
		return cateDao.findName(name);
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		return cateDao.searchByName(keyword);
	}

	@Override
	public void insert(CategoryModel category) {
//		CategoryModel cate = this.findName(category.getCategoryname());
//		if(cate!=null)
//		{
//			cateDao.insert(category);
//		}
		CategoryModel categoryModel = this.findName(category.getCategoryname());
        if (categoryModel.getCategoryname() == null) {
            cateDao.insert(category);
        }
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if(cate!=null)
		{
			cateDao.update(category);
		}
		
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if(cate!=null)
		{
			cateDao.delete(id);
		}
	}

	@Override
	public void updatestatus(int id, int status) {
		cateDao.updatestatus(id, status);
		
	}
	public static void main(String[] args) {
		try {
			CategoryService userS =new CategoryServiceImpl();
			System.out.println(userS.findAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
