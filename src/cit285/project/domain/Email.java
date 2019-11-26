package cit285.project.domain;

public class Email {
	private int emailId;
	private int userId;
	private String emailAddress;
	
	// Set email id
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	
	// Get phone id
	public int getEmailId() {
		return emailId;
	}
	
	// Set user id
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	// Get user id
	public int getUserId() {
		return userId;
	}
	
	// Set email addresse
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	// Get author last name
	public String getEmailAddress() {
		return emailAddress;
	}
}
