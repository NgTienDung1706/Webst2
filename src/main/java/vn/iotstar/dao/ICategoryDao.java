package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CategoryModel;

public interface ICategoryDao {
	List<CategoryModel> findAll();
	CategoryModel findById(int id);
	CategoryModel findName(String name);
	List<CategoryModel> searchByName(String keyword);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	void updatestatus(int id,int status);
}
