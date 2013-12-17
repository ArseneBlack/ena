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
		getContentPane().setMinimumSize(new Dimension(500, 300));
		getContentPane().setPreferredSize(new Dimension(500, 350));
		setResizable(false);
		setAlwaysOnTop(true);
		this.model = model;

		initializeFrame();
		getContentPane().setLayout(null);

		lblNeuesPasswort.setBounds(115, 36, 92, 14);
		getContentPane().add(lblNeuesPasswort);

		btnSpeichern.setBounds(133, 216, 114, 23);
		btnSpeichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();

			}
		});
		getContentPane().add(btnSpeichern);

		btnCancel.setBounds(257, 216, 121, 23);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancel();

			}

		});
		getContentPane().add(btnCancel);

		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(239, 33, 139, 20);
		getContentPane().add(oldPasswordField);

		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(239, 80, 139, 20);
		getContentPane().add(newPasswordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(239, 130, 139, 20);
		getContentPane().add(confirmPasswordField);

		lblNewLabel.setBounds(117, 86, 97, 14);
		getContentPane().add(lblNewLabel);

		lblPasswortBesttigen.setBounds(90, 136, 139, 14);
		getContentPane().add(lblPasswortBesttigen);
		lblMessage.setBounds(133, 184, 248, 14);

		getContentPane().add(lblMessage);
	}

	protected void cancel() {
		setVisible(false);

	}

	private void initializeFrame() {
		setBounds(200, 200, 500, 350);

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
