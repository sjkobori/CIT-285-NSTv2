package cit285.project.domain;

public class User {
	private int userid; // user id
	private String userName;
	private String password;
	private String firstName; // user's first name
	private String lastName; // user's last name
	private String companyName;
	private boolean isAdmin;

	// Set user id
	public void setUserid(int userid) {
		this.userid = userid;
	}

	// Get user id
	public int getUserid() {
		return userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		String s = userName;

		boolean hasNonAlpha = s.matches("^.*[^a-zA-Z0-9 ].*$"); // Check if userName has alphanumeric if yes, return

		if (!hasNonAlpha) {
			if (userName.length() <= 30) { //Check if userName has more than 30 characters, if not then set userName
				this.userName = userName;
			} else {
				this.userName = userName.substring(0, 30); //If userName is more than characters, take the first 30 characters.
				
			}
		} else {
			throw new IllegalArgumentException("Username cannot have non-alphanumeric.");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Set first name
	public void setFirstName(String firstName) {
		boolean hasNumbers = firstName.matches(".*\\d.*");
		if(!hasNumbers) {
		this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("First name cannot have digits.");
		}
	}

	// Get first name
	public String getFirstName() {
		return firstName;
	}

	// Set last name
	public void setLastName(String lastName) {
		boolean hasNumbers = lastName.matches(".*\\d.*");
		if(!hasNumbers) {
		this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException("Last name cannot have digits.");
		}
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String toString() {
		return "Userid: " + userid + ", First Name: " + firstName + ", Last Name: " + lastName + ", Company Name: "
				+ companyName;

	}

}
