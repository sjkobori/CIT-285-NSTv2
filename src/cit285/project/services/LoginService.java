package cit285.project.services;

import cit285.project.dao.LoginDao;
import cit285.project.domain.Login;

public class LoginService implements LoginServiceAPI {
	static LoginDao loginDao;
	
	public LoginService() {
		loginDao = new LoginDao();
	}
	
	public int loginUser(String username,String password) {
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
    
	}
	
}
