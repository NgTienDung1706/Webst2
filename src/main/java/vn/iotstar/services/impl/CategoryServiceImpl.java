package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.model.CategotyModel;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.IUserService;

public class CategoryServiceImpl implements CategoryService{
	ICategoryDao cateDao=new CategoryDaoImpl();
	@Override
	public List<CategotyModel> findAll() {
		return cateDao.findAll();	}

	@Override
	public CategotyModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public CategotyModel findName(String name) {
		return cateDao.findName(name);
	}

	@Override
	public List<CategotyModel> searchByName(String keyword) {
		return cateDao.searchByName(keyword);
	}

	@Override
	public void insert(CategotyModel category) {
		CategotyModel cate = this.findName(category.getCategoryname());
		if(cate!=null)
		{
			cateDao.insert(category);
		}
		
	}

	@Override
	public void update(CategotyModel category) {
		CategotyModel cate = this.findName(category.getCategoryname());
		if(cate!=null)
		{
			cateDao.update(category);
		}
		
	}

	@Override
	public void delete(CategotyModel category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatestatus(int id, int status) {
		// TODO Auto-generated method stub
		
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
