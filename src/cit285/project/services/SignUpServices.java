package cit285.project.services;
import java.sql.SQLException;

import cit285.project.dao.UserDao;
import cit285.project.domain.Address;
import cit285.project.domain.Email;
import cit285.project.domain.User;

public class SignUpServices implements SignUpServicesAPI {
	UserDao userDao;
	
	public SignUpServices() {
		userDao = new UserDao();
	}

	@Override
	public void signUp(User user, Email email, Address address) {
		// TODO Auto-generated method stub
		try {
			userDao.signUp(user, email, address);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
