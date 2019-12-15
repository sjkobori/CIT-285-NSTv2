package cit285.project.services;

import java.sql.SQLException;

import javax.security.auth.login.FailedLoginException;

import cit285.project.dao.LoginDao;
import cit285.project.domain.Login;
import cit285.project.domain.User;

public class LoginServices implements LoginServicesAPI {
	static LoginDao loginDao;

	public LoginServices() {
		loginDao = new LoginDao();
	}

	public User loginUser(String username, String password) throws FailedLoginException {
		Login loginBean = new Login();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		User user = new User();
		try {
			user = loginDao.validate(loginBean);
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		return user;

	}
	
	/*public int loginUser(String username, String password) {
		Login loginBean = new Login();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		int x = 0;
		try {
			x = loginDao.validate(loginBean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return x;

	}*/

}
