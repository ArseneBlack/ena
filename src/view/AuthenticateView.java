package view;

import javax.swing.JFrame;

import model.PasswordModel;

public class AuthenticateView extends JFrame {
	private PasswordModel model;

	public AuthenticateView(PasswordModel model) {
		super("Passwort Eingeben");
		this.model = model;
	}
}
