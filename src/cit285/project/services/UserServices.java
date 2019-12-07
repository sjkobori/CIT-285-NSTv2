package cit285.project.services;
import java.sql.SQLException;
import java.util.ArrayList;

import cit285.project.dao.UserDao;
import cit285.project.domain.User;

public class UserServices implements UserServicesAPI {
	private UserDao userDao;
	
	public UserServices() {
		userDao = new UserDao();
	}
	
	public ArrayList<User> getUsers(){
		ArrayList<User> userList = null;
		try {
			userList = userDao.getUsers();
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		return userList;
	}
}