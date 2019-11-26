package cit285.project.services;
import java.sql.SQLException;
import java.util.ArrayList;

import cit285.project.dao.UserDao;
import cit285.project.domain.User;

public class UserServices implements UserServicesAPI {
	UserDao userDao;
	
	public UserServices() {
		userDao = new UserDao();
	}
	
	public ArrayList<String> getUsers(){
		ArrayList<User> usersList = null;
		ArrayList<String> users = new ArrayList<>();
		try {
			usersList = userDao.getUsers();
			usersList.forEach(user -> {
				String name = user.getFirstName() + " " + user.getLastName();
				users.add(name);
			});
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		return users;
	}
}
