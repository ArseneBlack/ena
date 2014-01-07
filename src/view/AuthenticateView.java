package view;

import javax.swing.JFrame;

import model.PasswordModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AuthenticateView extends JFrame {
	private PasswordModel passwordModel;
	private SettingsView settingsView;
	private JPasswordField passwordField = new JPasswordField();
	private JButton btnAbbrechen = new JButton("Abbrechen");
	private JButton btnOk = new JButton("OK");
	private JLabel lblStatus = new JLabel();
	private JLabel lblPasswortEingeben = new JLabel("Passwort Eingeben:");

	public AuthenticateView(PasswordModel passwordModel,
			SettingsView settingsView) {
		super("Passwort Eingeben");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationByPlatform(true);
		setBounds(100, 100, 235, 105);
		setResizable(false);
		setAlwaysOnTop(true);
		this.passwordModel = passwordModel;
		getContentPane().setLayout(null);

		this.settingsView = settingsView;

		passwordField.setBounds(5, 25, 225, 20);
		getContentPane().add(passwordField);

		initializeButtons();
	}

	public void initializeButtons() {
		btnOk.setBounds(5, 75, 110, 25);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				showSettings();
			}
		});
		getContentPane().add(btnOk);

		btnAbbrechen.setBounds(120, 75, 110, 25);
		btnAbbrechen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();

			}
		});
		getContentPane().add(btnAbbrechen);

		lblPasswortEingeben.setBounds(5, 5, 142, 15);
		getContentPane().add(lblPasswortEingeben);

		lblStatus = new JLabel("");
		lblStatus.setBounds(5, 50, 225, 15);
		getContentPane().add(lblStatus);
	}

	public void showSettings() {
		String password = new String(passwordField.getPassword());
		boolean loggedIn = passwordModel.login(password);
		if (loggedIn) {
			System.out.println("logged in");
			this.settingsView.setVisible(true);
			this.setVisible(false);
		} else {
			lblStatus.setText("Wrong Password, try again!");
		}
	}

	public void cancel() {
		setVisible(false);
	}
}
