package view;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSlider;

import model.ElectronicsModel;
import model.MainWindowModel;
import model.PasswordModel;

import java.util.LinkedList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeListener;

public class MainWindowView extends JFrame {
	private static final long serialVersionUID = 7643321161033183748L;

	private JPanel mainWindow;
	private JPanel pipDisplay;

	private MainWindowModel model;
	private ElectronicsModel electronics;

	private PasswordModel passwordModel = new PasswordModel();
	private SetPasswordView passwordView = new SetPasswordView(passwordModel);
	private SettingsView settingsView = new SettingsView(passwordModel,
			passwordView);
	private AuthenticateView authView = new AuthenticateView(passwordModel,
			settingsView);

	private List<JComponent> components = new LinkedList<JComponent>();

	// Buttons
	private JButton btnSettings = new JButton("Einstellungen");

	private JButton btnSkipAd = new JButton("Werbung ueberbruecken");

	private JButton btnExit = new JButton("Ende");

	private JButton btnPause = new JButton("Pause");

	private JButton btnPreviousChannel = new JButton("vorheriger sender");

	private JButton btnChannelList = new JButton("Senderliste");

	private JButton btnNextChannel = new JButton("naechster Sender");

	private JButton btnRemoveBorder = new JButton("Balken Entfernen");

	private JButton btnMute = new JButton("stumm");

	private JSlider volumeSlider = new JSlider();

	public MainWindowView(ElectronicsModel electronics) {
		super("Fernseher");
		this.electronics = electronics;
		this.model = new MainWindowModel(); // da sind die Daten
											// gespeichert..lautst�rke ,
											// senderliste..
		initializeFrame();
		initializeButtons();
		setVisible(true);
	}

	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		mainWindow = electronics.getMainDisplay();
		mainWindow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				toggleButtonVisibility();
			}
		});
		mainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainWindow.setLayout(null);

		pipDisplay = new JPanel();

		electronics = ElectronicsModel.createInstance(mainWindow, pipDisplay);

		setContentPane(mainWindow);
	}

	private void initializeButtons() {
		btnSkipAd.setBounds(134, 193, 89, 23);
		btnSkipAd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				skipAd();
			}
		});
		components.add(btnSkipAd);

		btnSettings.setBounds(5, 5, 116, 23);
		btnSettings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showSettings();
			}
		});
		components.add(btnSettings);

		btnExit.setBounds(300, 5, 89, 23);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}

		});
		components.add(btnExit);

		btnPause.setBounds(136, 227, 89, 23);
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				togglePause();
			}
		});
		components.add(btnPause);

		btnPreviousChannel.setBounds(235, 227, 89, 23);
		btnPreviousChannel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zapUp();
			}
		});
		components.add(btnPreviousChannel);

		btnChannelList.setBounds(334, 227, 89, 23);

		btnChannelList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openChannelList();
			}
		});
		components.add(btnChannelList);

		btnNextChannel.setBounds(334, 193, 89, 23);
		btnNextChannel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				zapDown();
			}

		});
		components.add(btnNextChannel);

		btnRemoveBorder.setBounds(334, 155, 89, 23);
		btnRemoveBorder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeBorder();
			}
		});
		btnRemoveBorder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				removeBorder();

			}
		});
		components.add(btnRemoveBorder);

		btnMute.setBounds(334, 125, 89, 23);
		btnMute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mute();
			}
		});
		btnMute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mute();

			}

		});
		components.add(btnMute);

		volumeSlider.setBounds(235, 88, 200, 26);
		volumeSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				JSlider slider = (JSlider) arg0.getSource();
				int volume = slider.getValue();
				setVolume(volume);
			}

		});
		components.add(volumeSlider);

		for (int i = 0; i < components.size(); i++) {
			JComponent component = components.get(i);
			mainWindow.add(component);
			component.setVisible(false);
		}
	}

	public void toggleButtonVisibility() {
		for (int i = 0; i < components.size(); i++) {
			JComponent component = components.get(i);
			component.setVisible(!component.isVisible());
		}
	}

	private void skipAd() {

	}

	private void togglePause() {
		if (electronics.isPaused()) {
			btnPause.setText("Pause");
			electronics.resume();
		} else {
			btnPause.setText("Fortsetzen");
			electronics.pause();
		}
	}

	private void exit() {
		System.exit(0);
	}

	private void showSettings() {
		if (!passwordModel.loggedIn() && passwordModel.isSet()) {
			authView.setVisible(true);
		} else {
			settingsView.setVisible(true);
		}
	}

	private void setVolume(int volume) {
		model.setVolume(volume);
	}

	private void zapUp() {
		// TODO
	}

	private void openChannelList() {
		// TODO
	}

	private void zapDown() {
		// TODO Auto-generated method stub

	}

	private void removeBorder() {
		// TODO Auto-generated method stub

	}

	private void mute() {

		// TODO
	}
}
