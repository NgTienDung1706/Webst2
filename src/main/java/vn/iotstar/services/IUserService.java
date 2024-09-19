package vn.iotstar.services;

import vn.iotstar.model.UserModel;

public interface IUserService {
	UserModel login(String username,String password);
	UserModel FindByUserName(String username);
	
	void insert(UserModel user);
	boolean register(String username, String password, String fullname,String email, String phone,int roleid);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);
	void updatePasswordByEmail(String email, String newpassword);
}
