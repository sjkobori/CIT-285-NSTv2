package cit285.project.services;

import cit285.project.domain.Address;
import cit285.project.domain.Email;
import cit285.project.domain.User;

public interface SignUpServicesAPI {

	public void signUp(User user, Email email, Address address);
}
