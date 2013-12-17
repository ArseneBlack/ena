package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.text.PasswordView;

import model.PasswordModel;
import model.SettingsModel;

public class SettingsView extends JFrame {
	private static final long serialVersionUID = -1344462735704026323L;

	JPanel contentPane = new JPanel();

	private SettingsModel model;
	private PasswordModel passwordModel;
	private SetPasswordView passwordView;

	private JButton btnPassword = new JButton("Passwort festlegen");

	private JButton btnChannelList = new JButton("Senderliste verwalten");

	private JButton btnClose = new JButton("Schlie\u00DFen");

	/**
	 * Create the frame.
	 */
	public SettingsView(PasswordModel passwordModel,
			SetPasswordView passwordView) {
		super("Einstellungen");
		setResizable(false);
		this.model = new SettingsModel();
		this.passwordModel = passwordModel;
		this.passwordView = passwordView;
		initializeFrame();
		initializeButtons();
	}

	private void initializeFrame() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setPreferredSize(new Dimension(500, 500));
		setContentPane(contentPane);
	}

	private void initializeButtons() {
		btnPassword.setBounds(20, 5, 145, 26);
		btnPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showPasswordView();

			}
		});
		contentPane.setLayout(null);
		getContentPane().add(btnPassword);
		btnChannelList.setBounds(170, 5, 158, 26);

		getContentPane().add(btnChannelList);
		btnClose.setBounds(333, 5, 90, 26);

		getContentPane().add(btnClose);

		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				close();
			}
		});

	}

	public void setPasswordListener(ActionListener listener) {
		btnPassword.addActionListener(listener);
	}

	public void setChannelListListener(ActionListener listener) {
		btnChannelList.addActionListener(listener);
	}

	public void setCloseListener(ActionListener listener) {
		btnClose.addActionListener(listener);
	}

	public void disableButtons() {
		btnPassword.setEnabled(false);
		btnChannelList.setEnabled(false);
	}

	public void showPasswordView() {
		passwordView.setVisible(true);

	}

	public void close() {
		setVisible(false);
	}
}
