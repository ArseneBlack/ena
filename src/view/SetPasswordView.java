package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JFrame;

import model.PasswordModel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Dimension;
import java.awt.Rectangle;

public class SetPasswordView extends JFrame {
	private PasswordModel model;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JButton btnSpeichern = new JButton("speichern");
	private JButton btnCancel = new JButton("Abbrechen");
	private JLabel lblNewLabel = new JLabel("Neues Passwort");
	private JLabel lblNeuesPasswort = new JLabel("Altes Passwort");
	private JLabel lblPasswortBesttigen = new JLabel("Passwort best\u00E4tigen");
	private final JLabel lblMessage = new JLabel("");

	public SetPasswordView(PasswordModel model) {
		super("Passwort Festlegen");

		this.model = model;

		initializeFrame();
		getContentPane().setLayout(null);

		lblNeuesPasswort.setBounds(5, 10, 107, 20);
		getContentPane().add(lblNeuesPasswort);

		btnSpeichern.setBounds(5, 80, 110, 25);
		btnSpeichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();

			}
		});
		getContentPane().add(btnSpeichern);

		btnCancel.setBounds(120, 80, 110, 25);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancel();

			}

		});
		getContentPane().add(btnCancel);

		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(160, 5, 139, 20);
		getContentPane().add(oldPasswordField);

		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(160, 30, 140, 20);
		getContentPane().add(newPasswordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(160, 55, 140, 20);
		getContentPane().add(confirmPasswordField);

		lblNewLabel.setBounds(5, 30, 116, 20);
		getContentPane().add(lblNewLabel);

		lblPasswortBesttigen.setBounds(5, 55, 149, 20);
		getContentPane().add(lblPasswortBesttigen);
		lblMessage.setBounds(133, 184, 248, 14);

		getContentPane().add(lblMessage);
	}

	protected void cancel() {
		setVisible(false);

	}

	private void initializeFrame() {
		setBounds(new Rectangle(200, 200, 305, 115));
		setResizable(false);
		setAlwaysOnTop(true);
	}

	private void save() {
		if (new String(newPasswordField.getPassword()).equals(new String(
				confirmPasswordField.getPassword()))) {
			String pwd = new String(oldPasswordField.getPassword());
			boolean success = model.changePassword(pwd, new String(
					newPasswordField.getPassword()));
			if (success) {
				setVisible(false);
			} else {
				lblMessage.setText("Wrong Password");
			}
		} else {
			lblMessage.setText("Password is not Matching");
		}
	}
}
