package view;

import javax.swing.JFrame;

import model.PasswordModel;

public class SetPasswordView  extends JFrame {
	private PasswordModel model;

	public SetPasswordView(PasswordModel model) {
		super("Passwort Festlegen");
		this.model = model;
	}

}
