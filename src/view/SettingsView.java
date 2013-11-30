package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

import model.SettingsModel;

public class SettingsView extends JFrame {
	private static final long serialVersionUID = -1344462735704026323L;

	private SettingsModel model;

	private JButton btnPassword = new JButton("Passwort festlegen");

	private JButton btnChannelList = new JButton("Senderliste verwalten");

	private JButton btnClose = new JButton("Schließen");

	/**
	 * Create the frame.
	 * 
	 * @param model
	 */
	public SettingsView(SettingsModel model) {
		super("Einstellungen");
		this.model = model;
		initializeFrame();
		initializeButtons();
	}

	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	}

	private void initializeButtons() {
		add(btnPassword);

		add(btnChannelList);

		add(btnClose);
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
}
