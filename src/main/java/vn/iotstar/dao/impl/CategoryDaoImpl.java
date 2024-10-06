package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.model.CategotyModel;
import vn.iotstar.model.UserModel;

public class CategoryDaoImpl implements ICategoryDao{

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	@Override
	public List<CategotyModel> findAll() {
		String sql = "SELECT * FROM categories";
		List<CategotyModel> list =new ArrayList<>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategotyModel category =new CategotyModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public CategotyModel findById(int id) {
		String sql = "SELECT * FROM categories where categoryid=?";
		CategotyModel category =new CategotyModel();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public CategotyModel findName(String name) {
		String sql = "SELECT * FROM categories where categoryid=?";
		CategotyModel category =new CategotyModel();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
			}
			conn.close();
			ps.close();
			rs.close();
			return category;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public List<CategotyModel> searchByName(String keyword) {
		String sql = "SELECT * FROM categories like ?";
		List<CategotyModel> list =new ArrayList<>();
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword +"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategotyModel category =new CategotyModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public void insert(CategotyModel category) {
		String sql = "Insert into categories(categoryname,images,status) value(?,?,?)";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void update(CategotyModel category) {
		String sql = "Update categories SET categoryname=?,images=?,status=? where categoryid=?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(CategotyModel category) {
		String sql = "Delete from categories SET where categoryid=?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getCategoryid());
			ps.executeUpdate();			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void updatestatus(int id,int status) {
		String sql = "Update categories SET status=? where categoryid=?";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.executeUpdate();			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
