package cit285.project.config;

import java.io.PrintWriter;
import java.io.StringWriter;

import cit285.project.services.BookServices;
import cit285.project.services.BookServicesAPI;
import cit285.project.services.SignUpServices;
import cit285.project.services.SignUpServicesAPI;
import cit285.project.services.UserServices;
import cit285.project.services.UserServicesAPI;

public class BookSystemConfig {

	// the service objects in use, representing all lower layers to the app
	private static SignUpServicesAPI signUpServices;
	private static UserServicesAPI userServices;
	private static BookServicesAPI bookServices;

	// set up service API, data access objects
	public static void configureServices() throws Exception {
		try {
			signUpServices = new SignUpServices();
			userServices = new UserServices();
			bookServices = new BookServices();
		} catch (Exception e) {

			// rethrow to notify caller (caller should print exception details)
			throw new Exception("Exception in configureServices", e);
		}
	}

	public static String exceptionReport(Exception e) {
		String message = e.toString(); // exception name + message
		if (e.getCause() != null) {
			message += "\n  cause: " + e.getCause();
			if (e.getCause().getCause() != null) {
				message += "\n    cause's cause: " + e.getCause().getCause();
			}
		}
		message += "\n Stack Trace: " + exceptionStackTraceString(e);
		return message;
	}

	private static String exceptionStackTraceString(Throwable e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public static SignUpServicesAPI getSignUpServices() {

		return signUpServices;
	}

	public static UserServicesAPI getUserServices() {

		return userServices;
	}

	public static BookServicesAPI getBookServices() {
		// TODO Auto-generated method stub
		return bookServices;
	}

}
