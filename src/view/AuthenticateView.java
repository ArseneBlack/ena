package view;

import javax.swing.JFrame;

import model.PasswordModel;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Window.Type;

public class AuthenticateView extends JFrame {
	private PasswordModel passwordModel;
	private JPasswordField passwordField;
	private SettingsView settingsView;
	private JButton btnAbbrechen = new JButton("Abbrechen");
	private JButton btnOk = new JButton("OK");

	public AuthenticateView(PasswordModel passwordModel,
			SettingsView settingsView) {
		super("Passwort Eingeben");
		setResizable(false);
		setAlwaysOnTop(true);
		this.passwordModel = passwordModel;
		getContentPane().setLayout(null);

		this.settingsView = settingsView;

		passwordField = new JPasswordField();
		passwordField.setBounds(5, 25, 208, 20);
		getContentPane().add(passwordField);

		setBounds(100, 100, 220, 80);
		initializeButtons();

	}

	public void initializeButtons() {
		btnOk.setBounds(5, 50, 95, 25);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showSettings();
			}
		});
		getContentPane().add(btnOk);

		btnAbbrechen.setBounds(103, 50, 110, 25);
		btnAbbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();

			}
		});
		getContentPane().add(btnAbbrechen);
		
		JLabel lblPasswortEingeben = new JLabel("Passwort Eingeben:");
		lblPasswortEingeben.setBounds(5, 5, 142, 15);
		getContentPane().add(lblPasswortEingeben);
	}

	public void showSettings() {
		String password = new String(passwordField.getPassword());
		boolean loggedIn = passwordModel.login(password);
		if (loggedIn) {
			System.out.println("logged in");
			this.settingsView.setVisible(true);
			this.setVisible(false);
		} else {
			System.out.println("failed");
			// TODO: Fehlermeldung
		}
	}

	public void cancel() {
		setVisible(false);
	}
}
