package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;

import model.MainWindowModel;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.awt.event.MouseAdapter;

public class MainWindowView extends JFrame {

	private JPanel contentPane;

	private MainWindowModel model;

	private List<JComponent> components = new LinkedList<JComponent>();

	// Buttons
	private JButton btnSettings = new JButton("Einstellungen");

	private JButton btnSkipAd = new JButton("Werbung ueberbruecken");

	private JButton btnExit = new JButton("Ende");

	private JButton btnPause = new JButton("Pause");

	private JButton btnVorherigeSender = new JButton("vorheriger sender");

	private JButton btnSenderliste = new JButton("Senderliste");

	private JButton btnNchsteSender = new JButton("naechster Sender");

	private JButton btnBalkenEntfernen = new JButton("Balken Entfernen");

	private JButton btnStumm = new JButton("stumm");

	private JSlider volumeSlider = new JSlider();

	/**
	 * Create the frame.
	 */
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

		btnVorherigeSender.setBounds(235, 227, 89, 23);
		components.add(btnVorherigeSender);

		btnSenderliste.setBounds(334, 227, 89, 23);
		components.add(btnSenderliste);

		btnNchsteSender.setBounds(334, 193, 89, 23);
		components.add(btnNchsteSender);

		btnBalkenEntfernen.setBounds(334, 155, 89, 23);
		components.add(btnBalkenEntfernen);

		btnStumm.setBounds(334, 125, 89, 23);
		components.add(btnStumm);

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

}