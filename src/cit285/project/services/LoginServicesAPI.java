package cit285.project.services;

import javax.security.auth.login.FailedLoginException;

import cit285.project.domain.User;

public interface LoginServicesAPI {
	public User loginUser(String username, String password) throws FailedLoginException;
	//public int loginUser(String username, String password);
}
