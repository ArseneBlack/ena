package model;

public class PasswordModel {
	private boolean loggedIn = false;
	private String password = "1234";

	public Boolean setPassword(String newPassword, String oldPassword) {
		if (!isSet() || (oldPassword.equals(this.password))) {
			this.password = newPassword;
			return true;

		} else {
			return false;
		}
	}

	public boolean login(String password) {
		if (password.equals(this.password)) {
			loggedIn = true;
			return true;
		} else {
			return false;
		}
	}

	public void logout() {
		this.loggedIn = false;
	}

	public Boolean isSet() {
		return password != null;
	}

	public boolean changePassword(String old, String newPasswort) {
		if (login(old)) {
			this.password = newPasswort;
			return true;
		} else {
			return false;
		}

	}

	public boolean loggedIn() {
		return loggedIn;
	}
}
