package model;

public class PasswordModel {
	private String password;
	
	public Boolean setPassword(String newPassword, String oldPassword) {
		if (!isSet() || oldPassword == this.password) {
			this.password = newPassword;
			return true;

		} else {
			return false;
		}
	}
	
	public Boolean authenticate(String password) {
		return password == this.password;
	}
	
	public Boolean isSet() {
		return password != null;
	}
	
	public boolean changePassword(String old , String newPasswort )
	{
		if(authenticate(old))
		{
			this.password = newPasswort;
			return true;
		}
		else
		{
			return false;
		}	
		
	}
}  
