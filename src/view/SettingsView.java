package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.SettingsModel;

public class SettingsView extends JFrame {
	private static final long serialVersionUID = -1344462735704026323L;

	JPanel contentPane = new JPanel();

	private SettingsModel model;
	private SetPasswordView passwordView;

	private JButton btnPassword = new JButton("Passwort festlegen");

	private JButton btnChannelList = new JButton("Senderliste verwalten");

	/**
	 * Create the frame.
	 */
	public SettingsView(SetPasswordView passwordView) {
		super("Einstellungen");
		setResizable(false);
		this.model = new SettingsModel();
		this.passwordView = passwordView;
		initializeFrame();
		initializeButtons();
	}

	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 205, 65);
		setContentPane(contentPane);
	}

	private void initializeButtons() {
		btnPassword.setBounds(5, 5, 195, 25);
		btnPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showPasswordView();

			}
		});
		contentPane.setLayout(null);
		getContentPane().add(btnPassword);
		btnChannelList.setBounds(5, 35, 195, 25);

		getContentPane().add(btnChannelList);

	}

	public void setPasswordListener(ActionListener listener) {
		btnPassword.addActionListener(listener);
	}

	public void setChannelListListener(ActionListener listener) {
		btnChannelList.addActionListener(listener);
	}

	public void disableButtons() {
		btnPassword.setEnabled(false);
		btnChannelList.setEnabled(false);
	}

	public void showPasswordView() {
		passwordView.setVisible(true);

	}
}
