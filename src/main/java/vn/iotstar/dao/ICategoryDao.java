package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.model.CategotyModel;

public interface ICategoryDao {
	List<CategotyModel> findAll();
	CategotyModel findById(int id);
	CategotyModel findName(String name);
	List<CategotyModel> searchByName(String keyword);
	void insert(CategotyModel category);
	void update(CategotyModel category);
	void delete(CategotyModel category);
	void updatestatus(int id,int status);
}
