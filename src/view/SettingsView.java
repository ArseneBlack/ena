package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.PasswordModel;
import model.SettingsModel;

public class SettingsView extends JFrame {
	private static final long serialVersionUID = -1344462735704026323L;

	JPanel contentPane = new JPanel();

	private SettingsModel model = new SettingsModel();
	private SetPasswordView passwordView; 
	private EditChannelListView editChannelListView = new EditChannelListView();

	private JButton btnPassword = new JButton("Passwort festlegen");

	private JButton btnChannelList = new JButton("Senderliste verwalten");

	/**
	 * Create the frame.
	 */
	public SettingsView(PasswordModel passwordModel) {
		super("Einstellungen");
		setResizable(false);
		passwordView = new SetPasswordView(passwordModel);
		
		initializeFrame();
		initializeButtons();
	}

	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnChannelList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editChannelListView.setVisible(true);
			}
		});
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
