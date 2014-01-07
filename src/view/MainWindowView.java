package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;

import javax.swing.JSlider;

import model.ElectronicsModel;
import model.MainWindowModel;
import model.PasswordModel;

import java.util.LinkedList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.beans.PropertyVetoException;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Rectangle;

import java.awt.FlowLayout;
import javax.swing.JLayeredPane;

public class MainWindowView extends JFrame {
	private static final long serialVersionUID = 7643321161033183748L;

	private JPanel mainDisplay;
	private JPanel pipDisplay;
	private JPanel controlPanel;
	
	JLayeredPane layeredPane = new JLayeredPane();

	private MainWindowModel model;
	private ElectronicsModel electronics;

	private PasswordModel passwordModel = new PasswordModel();
	
	//private SetPasswordView passwordView = new SetPasswordView(passwordModel);
	private SettingsView settingsView = new SettingsView(passwordModel);
	private AuthenticateView authView = new AuthenticateView(passwordModel,
			settingsView);
	private ChannelListView channelListView = new ChannelListView();

	private List<JComponent> components = new LinkedList<JComponent>();

	// Buttons
	private JButton btnSettings = new JButton();
	private JButton btnSkipAd = new JButton();
	private JToggleButton btnPause = new JToggleButton();
	private JButton btnPreviousChannel = new JButton();
	private JButton btnChannelList = new JButton();
	private JButton btnNextChannel = new JButton();
	private JButton btnRemoveBorder = new JButton();
	private JToggleButton btnMute = new JToggleButton();
	private JSlider volumeSlider = new JSlider();

	public MainWindowView(ElectronicsModel electronics)
			throws PropertyVetoException {
		super("Fernseher");
		this.electronics = electronics;
		this.model = new MainWindowModel();

		// gespeichert..lautst�rke ,
		// senderliste..
		initializeFrame();
		initializeButtons();
		setVisible(true);
	}

	private void initializeBottomPanel() {
		
		
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		controlPanel = new JPanel();
		panel.add(controlPanel);
		controlPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		
	}

	private void initializeMainPanel() {
		mainDisplay = electronics.getMainDisplay();
		mainDisplay.setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(mainDisplay, 1);
		mainDisplay.addComponentListener(new ComponentListener() {
		
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				Rectangle b = arg0.getComponent().getBounds();
				arg0.getComponent().setBounds(b.x, b.y, b.width, b.height);
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void initializePipPanel() {
		pipDisplay = electronics.getPipDisplay();
		pipDisplay.setBounds(getWidth() - 200, getHeight() - 200, 200, 200);
		pipDisplay.setVisible(false);
		layeredPane.add(pipDisplay, 0);
	}

	private void initializeFrame() throws PropertyVetoException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		getContentPane().setLayout(new BorderLayout(0, 0));
		initializeMainPanel();
		initializePipPanel();
		initializeBottomPanel();
	}

	private void initializeButtons() {
		mainDisplay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				toggleButtonVisibility();
			}
		});

		Icon zahnrad = new ImageIcon(
				ImageIcon.class.getResource("/view/zahnrad.png"));
		btnSettings.setIcon(zahnrad);
		btnSettings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showSettings();
			}
		});
		components.add(btnSettings);
		components.add(new JSeparator());
		Icon pipIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/pip.png"));
		btnSkipAd.setIcon(pipIcon);
		btnSkipAd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				skipAd();
			}
		});
		components.add(btnSkipAd);

		Icon pauseIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/pause.png"));
		btnPause.setIcon(pauseIcon);
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				togglePause();
			}
		});
		components.add(btnPause);

		components.add(new JSeparator());

		Icon upIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/arrow_up.png"));
		btnPreviousChannel.setIcon(upIcon);
		btnPreviousChannel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				zapUp();
			}
		});
		components.add(btnPreviousChannel);

		Icon listIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/list.png"));
		btnChannelList.setIcon(listIcon);
		btnChannelList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openChannelList();
			}
		});
		components.add(btnChannelList);

		Icon downIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/arrow_down.png"));
		btnNextChannel.setIcon(downIcon);
		btnNextChannel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zapDown();
			}

		});
		components.add(btnNextChannel);

		components.add(new JSeparator());

		Icon borderIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/border.png"));
		btnRemoveBorder.setIcon(borderIcon);
		btnRemoveBorder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeBorder();
			}
		});
		components.add(btnRemoveBorder);

		components.add(new JSeparator());

		Icon muteIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/speaker.png"));
		btnMute.setIcon(muteIcon);
		Icon mutedIcon = new ImageIcon(
				ImageIcon.class.getResource("/view/mute.png"));
		btnMute.setSelectedIcon(mutedIcon);
		btnMute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mute();
			}
		});
		components.add(btnMute);

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
			controlPanel.add(component);
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
		pipDisplay.setVisible(!pipDisplay.isVisible());
	}

	private void togglePause() {
		if (electronics.isPaused()) {
			btnPause.setSelected(false);
			electronics.resume();

		} else {
			btnPause.setSelected(true);
			electronics.pause();
		}
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
		channelListView.setVisible(true);
	}

	private void zapDown() {
		// TODO Auto-generated method stub

	}

	private void removeBorder() {
		// TODO Auto-generated method stub

	}

	private void mute() {
		btnMute.setSelected(btnMute.isSelected());

		// TODO
	}
}
