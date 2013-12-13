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

public class AuthenticateView extends JFrame {
	private PasswordModel passwordModel;
	private JPasswordField passwordField;
	private SettingsView settingsView;
	private JButton btnAbbrechen = new JButton("Abbrechen");
	private JButton btnOk = new JButton("OK");

	public AuthenticateView(PasswordModel passwordModel, SettingsView settingsView) {
		super("Passwort Eingeben");
		this.passwordModel = passwordModel;
		getContentPane().setLayout(null);

		this.settingsView = settingsView;
        
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 12, 208, 20);
		getContentPane().add(passwordField);
		
		setBounds(100,100,400,200);
		initializeButtons();
		
	}

	public void initializeButtons() {
		btnOk.setBounds(12, 44, 98, 26);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showSettings();
			}
		});
		getContentPane().add(btnOk);

		btnAbbrechen.setBounds(122, 44, 98, 26);
		btnAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
				
			}
		});
		getContentPane().add(btnAbbrechen);
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
