package cit285.project.domain;

public class User {
	private int userid; // user id
	private String firstName; // user's first name
	private String lastName; // user's last name
	private String companyName;

	// Set user id
	public void setUserid(int userid) {
		this.userid = userid;
	}

	// Get user id
	public int getUserid() {
		return userid;
	}

	// Set first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Get first name
	public String getFirstName() {
		return firstName;
	}

	// Set last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Get last name name
	public String getLastName() {
		return lastName;
	}

	// Set company name
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	// Get company name
	public String getCompanyName() {
		return companyName;
	}

	public String toString() {
		return "Userid: " + userid + ", First Name: " + firstName + ", Last Name: " + lastName + ", Company Name: "
				+ companyName;

	}
}
