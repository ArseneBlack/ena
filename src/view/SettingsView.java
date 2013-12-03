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

	private JButton btnClose = new JButton("Schlie\u00DFen");

	/**
	 * Create the frame.
	 */
	public SettingsView() {
		super("Einstellungen");
		this.model = new SettingsModel();
		initializeFrame();
		initializeButtons();
	}

	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
	}

	private void initializeButtons() {
		getContentPane().add(btnPassword);

		getContentPane().add(btnChannelList);

		getContentPane().add(btnClose);
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
}
