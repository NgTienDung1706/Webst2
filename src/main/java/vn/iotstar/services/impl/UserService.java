package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.model.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService{
	IUserDao userDao =new UserDaoImpl();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		return userDao.findByUserName(username);
	}
	public static void main(String[] args) {
		try {
			IUserService userS =new UserService();
			System.out.println(userS.login("td", "1234"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
