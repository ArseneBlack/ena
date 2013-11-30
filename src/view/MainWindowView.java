package view;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

import java.awt.event.ActionListener;

import javax.swing.JSlider;

import model.MainWindowModel;

import java.util.LinkedList;
import java.util.List;
import java.awt.event.MouseAdapter;

public class MainWindowView extends JFrame {
	private static final long serialVersionUID = 7643321161033183748L;

	private JPanel contentPane;

	private MainWindowModel model;

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

	public MainWindowView(MainWindowModel model) {
		super("Fernseher");
		this.model = model;
		initializeFrame();

		initializeButtons();
	}

	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
	}

	private void initializeButtons() {
		btnSkipAd.setBounds(134, 193, 89, 23);
		components.add(btnSkipAd);

		btnSettings.setBounds(5, 5, 116, 23);
		components.add(btnSettings);

		btnExit.setBounds(300, 5, 89, 23);
		components.add(btnExit);

		btnPause.setBounds(136, 227, 89, 23);
		components.add(btnPause);

		btnPreviousChannel.setBounds(235, 227, 89, 23);
		components.add(btnPreviousChannel);

		btnChannelList.setBounds(334, 227, 89, 23);
		components.add(btnChannelList);

		btnNextChannel.setBounds(334, 193, 89, 23);
		components.add(btnNextChannel);

		btnRemoveBorder.setBounds(334, 155, 89, 23);
		components.add(btnRemoveBorder);

		btnMute.setBounds(334, 125, 89, 23);
		components.add(btnMute);

		volumeSlider.setBounds(235, 88, 200, 26);
		components.add(volumeSlider);

		for (int i = 0; i < components.size(); i++) {
			JComponent component = components.get(i);
			contentPane.add(component);
			component.setVisible(false);
		}
	}

	public void toggleButtonVisibility() {
		for (int i = 0; i < components.size(); i++) {
			JComponent component = components.get(i);
			component.setVisible(!component.isVisible());
		}
	}

	public void setExitListener(ActionListener listener) {
		btnExit.addActionListener(listener);
	}

	public void setSkipAdListener(ActionListener listener) {
		btnSkipAd.addActionListener(listener);
	}

	public void setSettingsListener(ActionListener listener) {
		btnSettings.addActionListener(listener);
	}

	public void setClickListener(MouseAdapter listener) {
		contentPane.addMouseListener(listener);
	}

	public void setVolumeListener(ChangeListener listener) {
		volumeSlider.addChangeListener(listener);
	}
	
	public void setPauseListener(ActionListener listener) {
		btnPause.addActionListener(listener);
	}

}
