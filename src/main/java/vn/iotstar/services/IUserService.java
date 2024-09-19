package vn.iotstar.services;

import vn.iotstar.model.UserModel;

public interface IUserService {
	UserModel login(String username,String password);
	UserModel FindByUserName(String username);
}
