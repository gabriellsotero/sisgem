package sisgem;

import sisgem.model.User;

public class Login {
	
	private static User loggedUser;

	public static User getLoggedUser() {
		return loggedUser;
	}

	public static void setLoggedUser(User loggedUser) {
		Login.loggedUser = loggedUser;
	}
	
	

}