package controller;

import model.PasswordModel;
import view.AuthenticateView;
import view.SetPasswordView;

public class PasswordController {
	private SetPasswordView view;
	private AuthenticateView authView;

	private PasswordModel model;
	
	public PasswordController() {
		model = new PasswordModel();
		view = new SetPasswordView(model);
	}

	public void showView() {
		view.setVisible(true);
	}
	
	public void authenticate() {
		authView.setVisible(true);
	}
	
	public Boolean isSet() {
		return model.isSet();
	}
}
